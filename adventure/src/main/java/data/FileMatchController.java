/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;


/**
 *  Classe per la gestione dei file per memorizzare gli engine (partite).
 */
public class FileMatchController extends FileController implements Serializable {
    /**
     * Costruttore della Classe FileController.
     * @param nomeFileCorrente nome del file.
     * @param directoryCorrente percorso della cartella del file.
     */
    public FileMatchController(final String nomeFileCorrente, final String directoryCorrente) {
        super(nomeFileCorrente,directoryCorrente);
        boolean creato = super.create() ;
        System.out.println(creato);
    }
    /**
     *
     * @param engine engine di una partita.
     * @return Vero se salva l'engine sul file, Falso altrimenti.
     */
    public boolean addMatch(final GiocoNaufragioIsola GNI) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            out.writeObject(GNI);
            out.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     * @throws IOException
     */
   /* public File removeMatch(final int id) throws IOException {
        File outputFile = new File(nameFile);
        Engine en;
        FileInputStream fileInput = new FileInputStream(this.file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        FileOutputStream fileOutput = new FileOutputStream(outputFile);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        try {
            while (true) {
                en = (Engine) objectInput.readObject();
                if (en.getIdEngine() != id) {
                    objectOutput.writeObject(en);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInput.close();
                fileInput.close();
                objectOutput.close();
                fileOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputFile;
    }
    */
    /**
     *
     * @param id
     * @return
     * @throws IOException
     */
    public GiocoNaufragioIsola getMatch(final String nomePart) throws IOException {
        GiocoNaufragioIsola GNI;
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        try {
            while (true) {
                GNI = (GiocoNaufragioIsola) objectIn.readObject();
                if (GNI.getNomePartita().equalsIgnoreCase(nomePart)) {
                    return GNI;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectIn.close();
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
