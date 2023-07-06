/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.Utils;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 *  CLASSE ASTRATTA.
 *
 *  SET/GET di username e password.
 */
public abstract class Database {
    protected static final String CREA_TABELLA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (Id INT PRIMARY KEY AUTO_INCREMENT, nomePartita VARCHAR(1024) UNIQUE, username VARCHAR(1024), punteggio INT DEFAULT 0, numMinuti int DEFAULT 0, numSecondi "
            + "int DEFAULT 0, terminata boolean DEFAULT FALSE, numMosse INT DEFAULT 0)";
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
    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection connect() throws SQLException {
        String percorsoDb = "adventure"+File.separator+"resources"+File.separator+"db";
        String percorso = PercorsoFileSystem.trovaPercorso(percorsoDb);
        System.out.println("PERCORSO DB: "+percorso);
        
        Connection conn = DriverManager.getConnection("jdbc:h2:" + percorso);
        System.out.println("connessione al DB effettuata correttamente");
        return conn;
    }

    /**
     *
     * @param usernameCorrente
     */
    public void setUsername(final String usernameCorrente) {
        this.username = usernameCorrente;
    }
    /**
     *
     * @param passwordCorrente
     */
    public void setPassword(final String passwordCorrente) {
        this.password = passwordCorrente;
    }
    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }
    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
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
     * @param nomePartita
     * @param usernameCorr
     * @param terminata
     * @param numSecondi
     * @param numMinuti
     * @param numMosse
     * @param game
     * @return
     */
    public abstract boolean salvaPartita(String nomePartita, String usernameCorr, boolean terminata, int numSecondi, int numMinuti, int numMosse, GameDescription game);
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
    /**
     *
     * @return
     */
    public abstract ResultSet getPartite();
    /**
     *
     * @param usernameCorr
     * @return
     */
    public abstract ResultSet getPartiteUtente(String usernameCorr);
    /**
     *
     * @return
     */
    public abstract double getPunteggioMedio();
    /**
     *
     * @param usernameCorr
     * @return
     */
    public abstract double getPunteggioMedioUtente(String usernameCorr);
    /**
     *
     * @param nomePartita
     * @return
     */
    public abstract boolean partitaEsistente(String nomePartita);
    /**
     *
     * @return
     */
    public abstract List<Partita> ottieniListaPartite();
    /**
     *
     * @param partite
     * @return
     */
}
