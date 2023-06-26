/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import di.uniba.map.b.adventure.GameDescription;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


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
     * @param game
     * @return Vero se salva l'engine sul file, Falso altrimenti.
     * @throws java.io.IOException
     */
    public boolean addMatch(final GameDescription game) throws IOException, ClassNotFoundException {
        try {
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./"+directory+"/"+nameFile,true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
            
            //ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            out.writeObject(game);
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
    public GameDescription getMatch(final String nomePart) throws IOException, ClassNotFoundException {
        GameDescription game;
        /*
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);*/
        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("./"+directory+"/"+nameFile));
        try {
            while (true) {
                game = (GameDescription) objectIn.readObject();
                if (game.getNomePartita().equalsIgnoreCase(nomePart)) {
                    return game;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectIn.close();
                //fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public List<GameDescription>  getMatch() throws FileNotFoundException, IOException{
        List<GameDescription> lista = new ArrayList<>();
        GameDescription game;
        
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        try {
            while (true) {
                game = (GameDescription) objectIn.readObject();
                lista.add(game);
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectIn.close();
                //fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
