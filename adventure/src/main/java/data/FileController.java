/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.IOException;

/**
 *
 * CLASSE PER LA GESTIONE DEI FILE
 * 
 * CREA FILE

 * RESTITUZIONE DI UN FILE CON UN DETERMINATO NOME
 * 
 */
public class FileController implements FileInterface{
    //nome del file da creare
    protected String nameFile;
    protected String directory;
    protected File file;

    public FileController(String nome, String dir){
        this.nameFile=nome;
        this.directory=dir;
    }

    public FileController(){
    }
    
    @Override
    public boolean create() {
        try{
            this.file = new File(directory+nameFile);
            if (file.createNewFile()) {
                System.out.println("File creato con successo." );
            } else {
                System.out.println("File esistente.");
            }
            return true;
        } catch(IOException e){
            System.out.println("Ciao sono un errore");
        }
        return false;
    }
    
    public void setNameFile(String name){
        this.nameFile=name;
    }
    
    public String getNameFile(){
        return nameFile;
    }
    
    public File getFile(){
        return file;
    }
}
