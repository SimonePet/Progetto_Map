package data;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class Suono {
    private static volatile boolean isPlaying = false;
    private static Optional<SourceDataLine> lineOptional = Optional.empty();
    private static ReentrantLock lock = new ReentrantLock();

    public static void riproduciTraccia(String trackName, boolean loop) {
        if (isPlaying) {
            stopRiproduzione();
        }

        lock.lock();

        Thread audioThread = new Thread(() -> {
            try {
                String estensione = ".wav";
                String percorso = System.getProperty("user.dir") + File.separator + "adventure" + File.separator + "resources" + File.separator + "suoni" + File.separator + "stanze" + File.separator + trackName + estensione;

                File audioFile = new File(percorso);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                AudioFormat audioFormat = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

                line.open(audioFormat);
                line.start();
                lineOptional = Optional.of(line);
                isPlaying = true;

                byte[] buffer = new byte[4096];
                int bytesRead;

                do {
                    while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                        line.write(buffer, 0, bytesRead);
                    }
                    audioInputStream.close();
                    audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                } while (loop && isPlaying);

                line.drain();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lineOptional.isPresent()) {
                    SourceDataLine line = lineOptional.get();
                    line.stop();
                    line.close();
                    lineOptional = Optional.empty();
                    isPlaying = false;
                    lock.unlock();
                }
            }
        });

        audioThread.start();
    }

    public static void stopRiproduzione() {
        lock.lock();
        try {
            if (isPlaying && lineOptional.isPresent()) {
                SourceDataLine line = lineOptional.get();
                line.stop();
                line.close();
                lineOptional = Optional.empty();
                isPlaying = false;
            }
        } finally {
            lock.unlock();
        }
    }
}