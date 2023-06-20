/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.Engine;

import java.io.*;

/**
 *  CLASSE PER LA GESTIONE DEL FILE CONTENENTE GLI ENGINE (partite)
 * 
 *  AGGIUNGERE PARTITA AL FILE "match.tx"
 *  RIMUOVERE PARTITA DAL FILE "match.txt"
 *  RECUPERARE PARTITA DAL FILE "match.txt"
 *  RINOMINARE PARTITA NEL FILE "match.txt"
 *
 */
public class FileMatchController extends FileController implements Serializable{

    public FileMatchController(String nameFile, String Directory, File file){
        super();
        this.file = file;
        this.nameFile = nameFile;
        this.directory = Directory;
    }

    /* aggiunge l'oggetto Engine(partita) alla fine del file */
    public boolean addMatch(Engine engine){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(engine);
            out.close();
        }catch(IOException e){
            System.out.println("Ciao sono un errore.");
        }
        return false;
    }
    
    public File removeMatch(int id) throws IOException {
        File outputFile = new File(nameFile);
        Engine en;
        FileInputStream fileInput = new FileInputStream(this.file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        FileOutputStream fileOutput = new FileOutputStream(outputFile);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        try{
            while(true){
                en = (Engine) objectInput.readObject();
                if (en.getID() != id) {
                    objectOutput.writeObject(en);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
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
    
    /* per recuperare la partita leggere da file mediante l'id dell'Engine recuperato dal DB
    */
    public Engine getMatch(int id) throws IOException {
        Engine en;
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        try {
            while(true) {
                en = (Engine) objectIn.readObject();
                if (en.getID() == id) {
                    return en;
                }
            }
        }catch(IOException e){
            System.out.println("Ciao sono un errore.");
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
