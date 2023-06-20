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
    protected static final String CREA_TABELLA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (Id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(1024), punteggio INT DEFAULT 0, numMinuti int DEFAULT 0, numSecondi int DEFAULT 0, TERMINATA boolean DEFAULT FALSE, num_mosse INT DEFAULT 0)";
    protected static final String INSERISCI_PARTITA = "INSERT INTO partita (username,punteggio,numMinuti,numSecondi,TERMINATA,num_mosse) VALUES(?,?,?,?,?,?)";
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
    public abstract boolean salvaPartita(String username, boolean terminata, int numSecondi, int numMinuti, int num_mosse, GameDescription game);
    
    /* recupera punteggio partita */
    public abstract int getPunteggio(int id);
}
