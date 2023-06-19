/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.Engine;

/**
 *  CLASSE CHE IMPLEMENTA LA CLASSE ASTRATTA DATABASE
 * 
 *  QUANDO ABBANDONIAMO LA PARTITA SALVA PARTITA SU DATABASE CON PUNTEGGIO
 *  
 *  SALVA PARTITA CON PUNTEGGIO
 *  RECUPERA PUNTEGGIO DELLA PARTITA
 * 
 */
public class DatabaseController extends Database{
    
    public DatabaseController(String username, String password){
        super.setUsername(username);
        super.setPassword(password);
    }
    
    
    @Override
    public boolean create_table_match() {
        //utilizza l'attributo ereditato CREATE_TABLE_MATCH
        return false;
    }
    
    /* salva nuova partita alla tabella */   
    @Override
    public boolean saveMatch(String username, boolean terminata, int numSecondi, int num_mosse) {
        if(terminata){
            //calcola punteggio con formula legata a tempo e numero mosse
            //inserimento completo con punteggio   
        }else{
            //inserimento senza punteggio  
        }
        return false;
    }
    
    /* recupera punteggio della partita */
    @Override
    public int fetchScore(int id) {
        return 0;
    }
    
}
