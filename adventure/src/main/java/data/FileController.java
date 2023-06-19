/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;

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
    protected File file;
    
    @Override
    public boolean create() { 
        //
        return false;       
    }
    
    public void setNameFile(String name){
        //
    }
    
    public String getNameFile(){
        return nameFile;
    }
    
    public File getFile(){      
        return null;
    }
}
