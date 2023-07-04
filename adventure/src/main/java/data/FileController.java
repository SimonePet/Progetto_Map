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
    protected String nomeFile;
    protected String directory;
    protected File file;
    /**
     * Costruttore della Classe FileController.
     * @param nomeFileCorrente nome del file.
     * @param directoryCorrente percorso della cartella del file
     */
    public FileController(final String nomeFileCorrente, final String directoryCorrente) {
        this.nomeFile = nomeFileCorrente;
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
            File progettoDir = new File(System.getProperty("user.dir"));
            String path = "";
            if (progettoDir.getName().contains("adventure")) {
                path = File.separator + directory + File.separator + nomeFile;
            } else if (!progettoDir.getName().contains("Progetto_Map")) {
                path = File.separator + "Progetto_Map" + File.separator + "adventure" + File.separator + directory + File.separator + nomeFile;
            } else if (progettoDir.getName().contains("Progetto_Map") && !progettoDir.getName().contains("adventure")) {
                path = File.separator + "adventure" + File.separator + directory + File.separator + nomeFile;
            }
            this.file = new File(progettoDir + path);
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
    public void setNomeFile(final String name) {
        this.nomeFile = name;
    }

    /**
     * Metodo get che restituisce il nome del file.
     */
    public String getNomeFile() {
        return nomeFile;
    }

    /**
     * Metodo get che restituisce il file.
     */
    public File getFile() {
        return file;
    }
}
