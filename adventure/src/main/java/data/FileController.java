/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.IOException;

/**
 * Classe per la gestione dei file.
 */
public class FileController implements FileInterface {
    //nome del file da creare
    //verificare se sono private!!!
    protected String nameFile;
    protected String directory;
    protected File file;
    /**
     * Costruttore della Classe FileController.
     * @param nomeFileCorrente nome del file.
     * @param directoryCorrente percorso della cartella del file
     */
    public FileController(final String nomeFileCorrente, final String directoryCorrente) {
        this.nameFile = nomeFileCorrente;
        this.directory = directoryCorrente;
    }

    /**
     * Costruttore della Classe FileController.
     */
    public FileController() {
    }

    /**
     * Metodo booleano che crea il file: Restituisce vero se lo crea.
     * Falso altrimenti.
     */
    @Override
    public boolean create() {
        try {
            this.file = new File("./"+directory+"/"+nameFile);
            if (file.createNewFile()) {
                System.out.println("File creato con successo.");
            } else {
                System.out.println("File esistente.");
            }
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Metodo set che imposta il nome del file.
     */
    public void setNameFile(final String name) {
        this.nameFile = name;
    }

    /**
     * Metodo get che restituisce il nome del file.
     */
    public String getNameFile() {
        return nameFile;
    }

    /**
     * Metodo get che restituisce il file.
     */
    public File getFile() {
        return file;
    }
}
