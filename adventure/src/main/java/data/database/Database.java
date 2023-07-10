/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.database;


import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *  CLASSE ASTRATTA.
 *
 *  SET/GET di username e password.
 */
public abstract class Database {
    protected static final String CREA_TABELLA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (Id INT PRIMARY KEY AUTO_INCREMENT, nomePartita VARCHAR(1024) UNIQUE, username VARCHAR(1024), punteggio INT DEFAULT 0, numOre int DEFAULT 0,numMinuti int DEFAULT 0, numSecondi "
            + "int DEFAULT 0, terminata boolean DEFAULT FALSE, numMosse INT DEFAULT 0)";
    protected static final String INSERISCI_PARTITA = "INSERT INTO partita (nomePartita,username,punteggio,numOre,numMinuti,numSecondi,terminata,numMosse) VALUES(?,?,?,?,?,?,?,?)";
    protected static final String RECUPERA_PUNTEGGIO_CON_ID = "SELECT punteggio, FROM partita WHERE id=?";
    protected static final String RECUPERA_PUNTEGGIO_CON_NOME_PARTITA = "SELECT punteggio FROM partita WHERE nomePartita=?";
    protected static final String STAMPA_PARTITE = "SELECT id,nomePartita, username,punteggio,numOre,numMinuti,numSecondi,terminata,numMosse FROM partita";
    protected static final String STAMPA_PARTITE_UTENTE = "SELECT id,nomePartita,username,punteggio,numOre,numMinuti,numSecondi,terminata,numMosse FROM partita WHERE username=?";
    protected static final String STAMPA_PUNTEGGIO_MEDIO = "SELECT avg(punteggio) FROM partita";
    protected static final String STAMPA_PUNTEGGIO_MEDIO_UTENTE = "SELECT avg(punteggio) FROM partita WHERE username=?";
    protected static final String STAMPA_PARTITA_SPECIFICA = "SELECT nomePartita FROM partita WHERE nomePartita=?";

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:" + Utils.PERCORSO_DATABASE);
        return conn;
    }

    /* controlla se esiste una tabella con nome partita, se esiste non crearla, altrimenti crea tabella partita*/
    /**
     *
     * @return
     */
    public abstract boolean creaTabellaPartita();
    /* salva nuova partita nella tabella */

    /**
     *
     * @param game
     * @return
     */
    public abstract boolean salvaPartita(GameDescription game);
    /* recupera punteggio partita con id*/
    /**
     *
     * @param id
     * @return
     */
    public abstract int getPunteggio(int id);
    /* recupera punteggio partita con il nome della partita */
    /**
     *
     * @param nomePartita
     * @return
     */
    public abstract int getPunteggio(String nomePartita);
    /**
     *
     */
    public abstract void stampaPartite();

}
