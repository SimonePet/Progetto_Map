/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.GameDescription;
import java.sql.*;

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
    
    private Connection conn;
    
    public DatabaseController(String username, String password) throws SQLException{
        super.setUsername(username);
        super.setPassword(password);
        Connection connessione = super.connect();
        this.conn = connessione;
    }
       
    @Override
    public boolean creaTabellaPartita() {
        try {
            Statement stm = conn.createStatement();
            //crea tabella solo se non esiste
            stm.executeUpdate(CREA_TABELLA_PARTITA);
            stm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return true;
    }
    
    /* salva nuova partita alla tabella */   
    @Override
    public boolean salvaPartita(String username, boolean finish, int numSeconds, int numMin, int numMoves, GameDescription game) {
        //calcola punteggio con formula 
        int punteggio = 100;
        int penalizzazioneMosse = 1*game.getNumMoves();
        int penalizzazioneMin = 5*game.getNumMinutes();
        int bonusPartitaVinta = 15;
        punteggio = punteggio - penalizzazioneMosse - penalizzazioneMin;
        
        if (game.isFinished()){
            punteggio += bonusPartitaVinta;
        }
        if(punteggio>100){
            punteggio = 100;
        }else if(punteggio<0){
            punteggio = 0;
        }           
        try {
            //inserimento completo con punteggio
            PreparedStatement pstm = conn.prepareStatement(INSERISCI_PARTITA);
            pstm.setString(1, game.getUsername());
            pstm.setInt(2,punteggio);
            pstm.setInt(3, game.getNumMinutes());
            pstm.setInt(4, game.getNumSeconds());
            pstm.setBoolean(5, finish);
            pstm.setInt(6, game.getNumMoves());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println("PARTITA SALVATA");
        return true;
    }
    
    /* recupera punteggio della partita */
    @Override
    public int getPunteggio(int id) {
        return 0;
    }
    
}
