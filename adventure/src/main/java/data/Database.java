/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.Engine;
import di.uniba.map.b.adventure.GameDescription;
import java.beans.Statement;
import java.sql.*;
/**
 *  CLASSE ASTRATTA 
 * 
 *  SET/GET di username e password
 */
public abstract class Database {
    protected static final String CREA_TABELLA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (Id INT PRIMARY KEY AUTO_INCREMENT, nomePartita VARCHAR(1024) UNIQUE, username VARCHAR(1024), punteggio INT DEFAULT 0, numMinuti int DEFAULT 0, numSecondi int DEFAULT 0, terminata boolean DEFAULT FALSE, numMosse INT DEFAULT 0)";
    protected static final String INSERISCI_PARTITA = "INSERT INTO partita (nomePartita,username,punteggio,numMinuti,numSecondi,terminata,numMosse) VALUES(?,?,?,?,?,?,?)";
    protected static final String RECUPERA_PUNTEGGIO_CON_ID = "SELECT punteggio, FROM partita WHERE id=?";
    protected static final String RECUPERA_PUNTEGGIO_CON_NOME_PARTITA = "SELECT punteggio FROM partita WHERE nomePartita=?";
    protected static final String STAMPA_PARTITE = "SELECT id,nomePartita, username,punteggio,numMinuti,numSecondi,terminata,numMosse FROM partita";
    protected static final String STAMPA_PARTITE_UTENTE = "SELECT id,nomePartita,username,punteggio,numMinuti,numSecondi,terminata,numMosse FROM partita WHERE username=?";
    protected static final String STAMPA_PUNTEGGIO_MEDIO = "SELECT avg(punteggio) FROM partita";
    protected static final String STAMPA_PUNTEGGIO_MEDIO_UTENTE = "SELECT avg(punteggio) FROM partita WHERE username=?";
    protected static final String STAMPA_PARTITA_SPECIFICA = "SELECT nomePartita FROM partita WHERE nomePartita=?";
    private String username;
    private String password;
    
    public Connection connect() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:h2:/home/user/test/db");
        return conn;
    }

    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    /* controlla se esiste una tabella con nome partita, se esiste non crearla, altrimenti crea tabella partita*/
    public abstract boolean creaTabellaPartita();
    
    /* salva nuova partita nella tabella */
    public abstract boolean salvaPartita(String nomePartita, String username, boolean terminata, int numSecondi, int numMinuti, int num_mosse, GameDescription game);
    
    /* recupera punteggio partita con id*/
    public abstract int getPunteggio(int id);
    
    /* recupera punteggio partita con il nome della partita */
    public abstract int getPunteggio(String nomePartita);
    
    public abstract void stampaPartite();

    public abstract ResultSet getPartite();

    public abstract ResultSet getPartiteUtente(String username);
    
    public abstract double getPunteggioMedio();
    
    public abstract double getPunteggioMedioUtente(String username);
    
    public abstract boolean partitaEsistente(String nomePartita);
    
}
