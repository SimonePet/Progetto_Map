/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.database;

import data.Partita;
import di.uniba.map.b.adventure.GameDescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *  CLASSE CHE ESTENDE LA CLASSE ASTRATTA DATABASE.
 *  QUANDO ABBANDONIAMO LA PARTITA SALVA PARTITA SU DATABASE CON PUNTEGGIO.
 *  SALVA PARTITA CON PUNTEGGIO.
 *  RECUPERA PUNTEGGIO DELLA PARTITA.
 *
 */
public class DatabaseController extends Database {
    private Connection conn;

    /**
     *
     * @param username
     * @param password
     * @throws SQLException
     */
    public DatabaseController(){
        Connection connessione=null;
        try {
            connessione = super.connect();
        } catch (SQLException ex) {
            System.out.println("errore di connessione al DB");
        }
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
    public boolean salvaPartita(final GameDescription partita) {
        //calcola punteggio con formula
        int punteggio = 100;
        int penalizzazioneMosse = 1 * partita.getNumMosse();
        int penalizzazioneMin = 5 * partita.getNumMinuti();
        int bonusPartitaVinta = 100;
        punteggio = punteggio - penalizzazioneMosse - penalizzazioneMin;
        if (partita.getFinita()) {
            punteggio += bonusPartitaVinta;
        }
        if (punteggio > 100) {
            punteggio = 100;
        } else if (punteggio < 0) {
            punteggio = 0;
        }
        try {
            //inserimento completo con punteggio
            PreparedStatement pstm = conn.prepareStatement(INSERISCI_PARTITA);
            pstm.setString(1, partita.getNomePartita());
            pstm.setString(2, partita.getUsername());
            pstm.setInt(3, punteggio);
            pstm.setInt(4, partita.getNumMinuti());
            pstm.setInt(5, partita.getNumSecondi());
            pstm.setBoolean(6, partita.getFinita());
            pstm.setInt(7, partita.getNumMosse());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("PARTITA NON SALVATA SU DB");
            System.err.println(ex.getMessage());
        }
        return true;
    }
    /* recupera punteggio della partita con id*/
    @Override
    public int getPunteggio(final int id) {
        try {
            PreparedStatement pstm = conn.prepareStatement(RECUPERA_PUNTEGGIO_CON_ID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("\npunteggio:" + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return 0;
    }
    /* recupera punteggio della partita con nome della partita */
    @Override
    public int getPunteggio(final String nomePartita) {
        try {
            PreparedStatement pstm = conn.prepareStatement(RECUPERA_PUNTEGGIO_CON_NOME_PARTITA);
            pstm.setString(1, nomePartita);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("\npunteggio:" + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    public void chiudiConnessione(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public void stampaPartite() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(STAMPA_PARTITE);
            while (rs.next()) {
                System.out.println("\nid: " + rs .getInt(1));
                System.out.println("\nnome partita: " + rs.getString(2));
                System.out.println("\nusername: " + rs.getString(3));
                System.out.println("\npunteggio: " + rs.getInt(4));
                System.out.println("\nDurata partita: " + rs.getInt(5) + " minuti e " + rs.getInt(6) + " secondi");
                System.out.println("\nTerminata: " + rs.getBoolean(7));
                System.out.println("\nNumero mosse: " + rs.getInt(8));
                System.out.println("-------------------------------------------------------");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ResultSet getPartite() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(STAMPA_PARTITE);
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public ResultSet getPartiteUtente(final String username) {
        try {
            PreparedStatement pstm = conn.prepareStatement(STAMPA_PARTITE_UTENTE);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    public double getPunteggioMedio() {
        double punteggioMedio = 0;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(STAMPA_PUNTEGGIO_MEDIO);
            rs.next();
            punteggioMedio = rs.getDouble(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return punteggioMedio;
    }
    
    public double getPunteggioMedioUtente(final String username) {
        double punteggioMedio = 0;
        try {
            PreparedStatement pstm = conn.prepareStatement(STAMPA_PUNTEGGIO_MEDIO_UTENTE);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            punteggioMedio = rs.getDouble(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return punteggioMedio;
    }
    
    public boolean partitaEsistente(final String nomePartita) {
        boolean partitaEsistente = false;
        try {
            PreparedStatement pstm = conn.prepareStatement(STAMPA_PARTITA_SPECIFICA);
            pstm.setString(1, nomePartita);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                partitaEsistente = true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return partitaEsistente;
    }
    /* prende tutte le partite dal DB, crea oggetto Partita, lo aggiunge alla lista e la restituisce*/
    
    public List<Partita> ottieniListaPartite() {
        List<Partita> partite = new ArrayList<>();
        ResultSet rs = this.getPartite();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String nomeUtente = rs.getString(3);
                int punteggio = rs.getInt(4);
                int numMinuti = rs.getInt(5);
                int numSecondi = rs.getInt(6);
                boolean terminata = rs.getBoolean(7);
                int numMosse = rs.getInt(8);
                Partita partita = new Partita(id, nome, nomeUtente, punteggio, numMinuti, numSecondi, terminata, numMosse);
                partite.add(partita);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return partite;
    }
    /* prende in input la lista delle partite, le raggruppa per nome_utente e punteggio,
       prende il punteggio massimo per ogni utente e restituisce un HashMap con nomeUtente e punteggio massimo
    */
}
