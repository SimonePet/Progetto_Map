/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.Engine;

/**
 *  CLASSE PER LA GESTIONE DEL FILE CONTENENTE GLI ENGINE (partite)
 * 
 *  AGGIUNGERE PARTITA AL FILE "match.txt"
 *  RIMUOVERE PARTITA DAL FILE "match.txt"
 *  RECUPERARE PARTITA DAL FILE "match.txt"
 *  RINOMINARE PARTITA NEL NILE "match.txt"
 *  
 */
public class FileMatchController extends FileController{
    
    public FileMatchController(String nameFile){
        //file su cui aggiungere/rimuovere partite
        super.nameFile = nameFile;
        super.file = super.getFile();
    }
    
    /* aggiunge l'oggetto Engine(partita) alla fine del file */
    public boolean addMatch(){
        //
        return false;      
    }
    
    
    public boolean removeMatch(){
        //
        return false;        
    }
    
    /* per recuperare la partita leggere da file mediante l'id dell'Engine recuperato dal DB
    */
    public Engine getMatch(String nameMatch){
        //
        return null;  
    }
    
}
