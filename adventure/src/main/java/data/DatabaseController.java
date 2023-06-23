/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.GameDescription;
import java.sql.*;

/**
 *  CLASSE CHE ESTENDE LA CLASSE ASTRATTA DATABASE
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
    public boolean salvaPartita(String nomePartita, String username, boolean finish, int numSeconds, int numMin, int numMoves, GameDescription game) {
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
            pstm.setString(1, game.getNomePartita());
            pstm.setString(2, game.getUsername());
            pstm.setInt(3,punteggio);
            pstm.setInt(4, game.getNumMinutes());
            pstm.setInt(5, game.getNumSeconds());
            pstm.setBoolean(6, finish);
            pstm.setInt(7, game.getNumMoves());
            pstm.executeUpdate();
            System.out.println("PARTITA SALVATA");
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("PARTITA NON SALVATA");
            System.err.println(ex.getMessage());
        }
        return true;
    }
    
    /* recupera punteggio della partita con id*/
    @Override
    public int getPunteggio(int id) {
        try {
            PreparedStatement pstm = conn.prepareStatement(RECUPERA_PUNTEGGIO_CON_ID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println("\npunteggio:"+rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
        return 0;
    }
    
    /* recupera punteggio della partita con nome della partita */
    @Override
    public int getPunteggio(String nomePartita) {
        try {
            PreparedStatement pstm = conn.prepareStatement(RECUPERA_PUNTEGGIO_CON_NOME_PARTITA);
            pstm.setString(1, nomePartita);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println("\npunteggio:"+rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
        return 0;
    }
    
    public void stampaPartite(){
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(STAMPA_PARTITE);
            while(rs.next()){
                System.out.println("\nid: "+rs.getInt(1));
                System.out.println("\nnome partita: "+rs.getString(2));
                System.out.println("\nusername: "+rs.getString(3));
                System.out.println("\npunteggio: "+rs.getInt(4));
                System.out.println("\nDurata partita: "+rs.getInt(5)+" minuti e "+rs.getInt(6)+" secondi");
                System.out.println("\nTerminata: "+rs.getBoolean(7));
                System.out.println("\nNumero mosse: "+rs.getInt(8));
                System.out.println("-------------------------------------------------------");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
    }
    
    
}
