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
    //nome del file da creare
    //verificare se sono private!!!
    protected String nomeFile;
    protected String directory;
    protected File file;
    protected final String percorso;
    /**
     * Costruttore della Classe FileController.
     * @param nomeFileCorrente nome del file.
     * @param directoryCorrente percorso della cartella del file
     */
    public FileController(final String nomeFileCorrente, final String directoryCorrente) {
        this.nomeFile = nomeFileCorrente;
        this.directory = directoryCorrente;
        Utils.calcolaPercorsoFile(this.nomeFile, this.directory);
        this.percorso = Utils.PERCORSO_FILES;
        this.setFile();
    }
    
    /**
     * Metodo booleano che crea il file: Restituisce vero se lo crea.Falso altrimenti.
     * @return
     */
    @Override
    public boolean create() {
        this.setFile();
        try {
            if (file.createNewFile()) {
                System.out.println("File "+nomeFile+" creato con successo.");
            } else {
                System.out.println("File "+nomeFile+" esistente.");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return true;
    }
    /**
     * Metodo set che imposta il nome del file.
     * @param name
     */
    public void setNomeFile(final String name) {
        this.nomeFile = name;
    }

    /**
     * Metodo get che restituisce il nome del file.
     * @return 
     */
    public String getNomeFile() {
        return nomeFile;
    }

    /**
     * Metodo get che restituisce il file.
     * @return 
     */
    public File getFile() {
        return file;
    }
    
    public final void setFile(){
        this.file = new File(percorso);
    }

}
