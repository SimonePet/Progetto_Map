/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.Utils;

import java.io.File;
import java.io.IOException;

/**
 * Classe per la gestione dei file.
 */
public class FileController implements FileInterface {
    private String nomeFile;
    private String directory;
    private File file;
    private final String percorso;

    /**
     * Costruttore della classe FileController.
     *
     * @param nomeFileCorrente  Nome del file.
     * @param directoryCorrente Percorso della cartella del file.
     */
    public FileController(final String nomeFileCorrente, final String directoryCorrente) {
        this.nomeFile = nomeFileCorrente;
        this.directory = directoryCorrente;
        Utils.calcolaPercorsoFile(this.nomeFile, this.directory);
        this.percorso = Utils.PERCORSO_FILES;
        this.setFile();
        /*
        Il costruttore della classe FileController prende come parametri il nome del file nomeFileCorrente e il percorso della cartella directoryCorrente.
        Vengono inizializzati i campi nomeFile e directory con i valori specificati.
        Viene utilizzato il metodo calcolaPercorsoFile della classe Utils per calcolare il percorso completo del file.
        Infine, viene inizializzato il campo percorso con il percorso completo calcolato e viene chiamato il metodo setFile per creare l'oggetto File.
         */
    }

    /**
     * Crea il file specificato.
     *
     * @return true se il file è stato creato con successo o se esiste già, altrimenti false.
     */
    @Override
    public boolean create() {
        this.setFile();
        try {
            if (file.createNewFile()) {
                System.out.println("File " + nomeFile + " creato con successo.");
            } else {
                System.out.println("File " + nomeFile + " esistente.");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return true;
            /*
    Il metodo create() viene utilizzato per creare il file specificato.
    Viene chiamato il metodo setFile() per inizializzare l'oggetto File.
    Successivamente, viene eseguito il tentativo di creazione del file utilizzando il metodo createNewFile().
    Se il file viene creato con successo, viene stampato il messaggio "File <nomeFile> creato con successo.".
    Se il file esiste già, viene stampato il messaggio "File <nomeFile> esistente.".
    In caso di eccezione durante la creazione del file, viene stampato il messaggio di errore.
    Il metodo restituisce sempre true.
     */
    }

    /**
     * Imposta il nome del file.
     *
     * @param name Nome del file da impostare.
     */
    public void setNomeFile(final String name) {
        this.nomeFile = name;
    }

    /**
     * Ottiene il nome del file.
     *
     * @return Nome del file.
     */
    public String getNomeFile() {
        return nomeFile;
    }

    /**
     * Ottiene l'oggetto File associato.
     *
     * @return Oggetto File associato.
     */
    public File getFile() {
        return file;
    }

    /**
     * Imposta l'oggetto File utilizzando il percorso specificato.
     */
    public final void setFile() {
        this.file = new File(percorso);
    }

    /**
     * Ottiene il percorso del file.
     *
     * @return Percorso del file.
     */
    public String getPercorso() {
        return percorso;
    }

}
