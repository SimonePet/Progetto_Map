/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.Engine;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            Connection conn = super.connect();
            Statement stm = conn.createStatement();
            //crea tabella solo se non esiste
            stm.executeUpdate(CREATE_TABLE_MATCH);
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    /* salva nuova partita alla tabella */   
    @Override
    public boolean saveMatch(String username, boolean finish, int numSeconds, int numMin, int numMoves) {
        if(finish){
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
