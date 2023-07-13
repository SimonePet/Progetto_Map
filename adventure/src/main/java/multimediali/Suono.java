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
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Classe di utilità per la gestione del suono.
 * Questa classe fornisce metodi per la riproduzione e l'interruzione del suono.
 */
public final class Suono {
    private static volatile boolean suonoAttivo = false;
    private static Optional<SourceDataLine> lineOptional = Optional.empty();
    //private static ReentrantLock lock = new ReentrantLock();
    private static Thread thread;
    private static final int BYTETRACCIA = 4096;

    /**
     * Classe di utilità per la gestione del suono.
     * Questa classe fornisce metodi per la riproduzione e l'interruzione del suono.
     */
    private Suono() {
        // Il costruttore è dichiarato privato per evitare l'istanziazione di oggetti Suono.
    }

    /**
     * Riproduce una traccia audio specificata dal percorso relativo.
     *
     * @param percorsoRel Percorso relativo della traccia audio.
     * @param loop        Flag che indica se la traccia audio deve essere riprodotta in loop.
     */
    public static void riproduciTraccia(final String percorsoRel, final boolean loop) {
        if (suonoAttivo) {
            stopRiproduzione();
        }
        // Crea un nuovo thread per la riproduzione audio
        Thread audioThread = new Thread(() -> {
            try {
                String estensione = ".wav";
                String percorso = percorsoRel + estensione;
                System.out.println(percorso);
                File audioFile = new File(percorso);
                // Ottiene l'input stream audio dalla traccia audio
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

                // Riproduce la traccia audio finché il flag di loop è true e il suono è attivo
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
                // Chiude la linea di riproduzione audio e imposta il flag di suono attivo a false
                if (lineOptional.isPresent()) {
                    SourceDataLine line = lineOptional.get();
                    line.stop();
                    line.close();
                    lineOptional = Optional.empty();
                    suonoAttivo = false;
                }
            }
        });
        // Avvia il thread di riproduzione audio
        audioThread.start();
        thread = audioThread;
        /*
        Il metodo riproduciTraccia permette di riprodurre una traccia audio specificata dal percorso relativo.
        La traccia audio viene riprodotta utilizzando un nuovo thread per non bloccare l'esecuzione principale del programma.
        Viene creato un oggetto AudioInputStream per ottenere l'input stream audio dalla traccia audio.
        Successivamente, viene creato un oggetto SourceDataLine per gestire la riproduzione audio.
        La traccia audio viene letta e scritta nella linea di riproduzione finché il flag di loop è true e il suono è attivo.
        Una volta terminata la riproduzione, la linea di riproduzione viene chiusa e il flag di suono attivo viene impostato a false.
         */
    }

    /**
     * Interrompe la riproduzione audio in corso e chiude la linea di riproduzione.
     */
    public static void stopRiproduzione() {
        // Interrompe il thread di riproduzione audio
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
