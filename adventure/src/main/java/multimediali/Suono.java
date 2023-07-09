package multimediali;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 *
 */
public class Suono {
    private static volatile boolean suonoAttivo = false;
    private static Optional<SourceDataLine> lineOptional = Optional.empty();
    //private static ReentrantLock lock = new ReentrantLock();
    private static Thread thread;
    private static final int BYTETRACCIA = 4096;

    /**
     *
     * @param percorsoRel
     * @param loop
     */
    public static void riproduciTraccia(final String percorsoRel, final boolean loop) {
        if (suonoAttivo) {
            stopRiproduzione();
        }

        //lock.lock();
        Thread audioThread = new Thread(() -> {
            try {
                String estensione = ".wav";
                String percorso = percorsoRel + estensione;
                System.out.println(percorso);
                File audioFile = new File(percorso);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                AudioFormat audioFormat = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

                line.open(audioFormat);
                line.start();
                lineOptional = Optional.of(line);
                suonoAttivo = true;

                byte[] buffer = new byte[BYTETRACCIA];
                int bytesRead;

                do {
                    while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                        line.write(buffer, 0, bytesRead);
                    }
                    audioInputStream.close();
                    audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                } while (loop && suonoAttivo);

                line.drain();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                System.err.println(e.getMessage());
            } finally {
                if (lineOptional.isPresent()) {
                    SourceDataLine line = lineOptional.get();
                    line.stop();
                    line.close();
                    lineOptional = Optional.empty();
                    suonoAttivo = false;
                    //lock.unlock();
                }
            }
        });
        audioThread.start();
        thread = audioThread;
    }

    /**
     *
     */
    public static void stopRiproduzione() {
        //lock.lock();
        thread.interrupt();
        if (suonoAttivo && lineOptional.isPresent()) {
            SourceDataLine line = lineOptional.get();
            line.stop();
            line.close();
            lineOptional = Optional.empty();
            suonoAttivo = false;
        }
    }
}
