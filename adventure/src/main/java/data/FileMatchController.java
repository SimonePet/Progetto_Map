/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;
import java.io.File;
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
     * @throws java.lang.ClassNotFoundException
     */
    public boolean addMatch(final GiocoNaufragioIsola game) throws IOException, ClassNotFoundException {       
        try {   
            // prendiamo percorso relativo ed eliminiamo la sottostringa /adventure e tutti i caratteri successivi(tramite il .*) //
            /*
            String percorsoRelFile = System.getProperty("user.dir").replaceAll("adventure"+".*","");
            String percorsoAss = "adventure"+File.separator+directory+File.separator+nomeFile;
            String percorso = percorsoRelFile+percorsoAss;
            */
            String percorso="";
            File progettoDir = new File(System.getProperty("user.dir"));
            if(progettoDir.getName().contains("adventure")){
                File fileDir = new File(progettoDir, File.separator+directory+File.separator+"salvataggioPartita");
                percorso = fileDir.getAbsolutePath();
            }else if(!progettoDir.getName().contains("Progetto_Map")){
                File fileDir = new File(progettoDir, File.separator+"Progetto_Map"+File.separator+"adventure"+File.separator+directory+File.separator+"salvataggioPartita");
                percorso = fileDir.getAbsolutePath();
            }else if(progettoDir.getName().contains("Progetto_Map") && !progettoDir.getName().contains("adventure")){
                File fileDir = new File(progettoDir, File.separator+"adventure"+File.separator+directory+File.separator+"salvataggioPartita");
                percorso = fileDir.getAbsolutePath();              
            }
            ObjectOutputStream out=null;
            if(file.exists() && file.length()==0){
                out = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            }else{           
                out = new ObjectOutputStream(new FileOutputStream(percorso,true)) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }
            
            out.writeObject(game);
            out.close();
            System.out.println("PARTITA SALVATA SU FILE\n");
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
        File outputFile = new File(nomeFile);
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
    public GiocoNaufragioIsola getMatch(final String nomePart) throws IOException, ClassNotFoundException {
        GiocoNaufragioIsola game;
        /*
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);*/
        String percorsoRelFile = System.getProperty("user.dir").replaceAll("adventure"+".*","");
        String percorsoAss = "adventure"+File.separator+directory+File.separator+nomeFile;
        String percorso = percorsoRelFile+percorsoAss;
        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(percorso));
        try {
            while (true) {
                game = (GiocoNaufragioIsola) objectIn.readObject();
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
    
    public List<GiocoNaufragioIsola>  getMatch() throws FileNotFoundException, IOException{
        List<GiocoNaufragioIsola> lista = new ArrayList<>();
        GiocoNaufragioIsola game;
        
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        try {
            while (true) {
                game = (GiocoNaufragioIsola) objectIn.readObject();
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
