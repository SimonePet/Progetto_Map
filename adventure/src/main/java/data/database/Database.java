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
 * Classe astratta che rappresenta un database per il salvataggio e il recupero dei dati di gioco.
 * Fornisce metodi astratti per la gestione delle tabelle di partite e l'accesso ai dati delle partite.
 * L'implementazione concreta deve fornire l'implementazione dei metodi astratti per un database specifico.
 */
public abstract class Database {
    protected static final String CREA_TABELLA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (Id INT PRIMARY KEY AUTO_INCREMENT, nomePartita VARCHAR(1024) UNIQUE, username VARCHAR(1024), punteggio INT DEFAULT 0,"
            + " numOre int DEFAULT 0,numMinuti int DEFAULT 0, numSecondi int DEFAULT 0, terminata boolean DEFAULT FALSE, numMosse INT DEFAULT 0)";
    protected static final String INSERISCI_PARTITA = "INSERT INTO partita (nomePartita,username,punteggio,numOre,numMinuti,numSecondi,terminata,numMosse) VALUES(?,?,?,?,?,?,?,?)";
    protected static final String RECUPERA_PUNTEGGIO_CON_ID = "SELECT punteggio, FROM partita WHERE id=?";
    protected static final String RECUPERA_PUNTEGGIO_CON_NOME_PARTITA = "SELECT punteggio FROM partita WHERE nomePartita=?";
    protected static final String STAMPA_PARTITE = "SELECT id,nomePartita, username,punteggio,numOre,numMinuti,numSecondi,terminata,numMosse FROM partita";
    protected static final String STAMPA_PARTITE_UTENTE = "SELECT id,nomePartita,username,punteggio,numOre,numMinuti,numSecondi,terminata,numMosse FROM partita WHERE username=?";
    protected static final String STAMPA_PUNTEGGIO_MEDIO = "SELECT avg(punteggio) FROM partita";
    protected static final String STAMPA_PUNTEGGIO_MEDIO_UTENTE = "SELECT avg(punteggio) FROM partita WHERE username=?";
    protected static final String STAMPA_PARTITA_SPECIFICA = "SELECT nomePartita FROM partita WHERE nomePartita=?";
    protected static final String STAMPA_PUNTEGGIO_MEDIO_TERMINATE = "SELECT avg(punteggio) FROM partita WHERE terminata=true";

    /**
     * Crea una connessione al database H2.
     *
     * @return Connessione stabilita al database.
     * @throws SQLException Se si verifica un errore durante la connessione al database.
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:" + Utils.PERCORSO_DATABASE);
    }

    /**
     * Crea una tabella per la partita nel database.
     *
     * @return true se la tabella è stata creata con successo, altrimenti false.
     */
    public abstract boolean creaTabellaPartita();

    /**
     * Salva i dati di una partita nel sistema.
     *
     * @param game Oggetto GameDescription che contiene i dati della partita da salvare.
     * @return true se i dati della partita sono stati salvati con successo, altrimenti false.
     */
    public abstract boolean salvaPartita(GameDescription game);

    /**
     * Ottiene il punteggio associato all'identificatore specificato.
     *
     * @param id Identificatore della registrazione del punteggio.
     * @return Punteggio corrispondente all'identificatore specificato.
     */
    public abstract int getPunteggio(int id);

    /**
     * Ottiene il punteggio associato al nome specificato della partita.
     *
     * @param nomePartita Nome della partita per la quale si desidera ottenere il punteggio.
     * @return Punteggio corrispondente al nome specificato della partita.
     */
    public abstract int getPunteggio(String nomePartita);

    /**
     * Stampa le informazioni delle partite registrate.
     * Questo metodo non restituisce alcun valore, ma visualizza le informazioni delle partite nel modo desiderato (ad esempio, su console o su un file di output).
     *
     * @throws UnsupportedOperationException se la funzionalità non è supportata dall'implementazione concreta.
     */
    public abstract void stampaPartite();


}
