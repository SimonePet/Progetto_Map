/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.type;

import di.uniba.map.b.adventure.Engine;

/**
 *
 * @author Giannantonio
 */
public class FileController extends StoreData{

    private final String path;

    public FileController(String path) {
        this.path = path;
    }

    /*aggiunge l'oggetto Engine(partita) alla fine del file prendendo il path*/
    @Override   
    public boolean add(Engine e){
        return false;
    }

    /* per recuperare una partita da file (oggetto Engine) prende come parametro il nome della partita, 
    la cerca nel DB, se viene trovata prende l'ID e utilizza l'ID per cercare nel file la partita da restituire.
    */
    @Override
    public Engine fetch(String nameGame) {
        Engine e = null;
        
        return e;
    }
}
