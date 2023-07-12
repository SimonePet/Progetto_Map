/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.database;

import data.Partita;
import data.StampaListe;
import di.uniba.map.b.adventure.GameDescription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 * La classe DatabaseController estende la classe astratta Database e fornisce un'implementazione dei metodi astratti per gestire le operazioni
 * di accesso al database e manipolazione dei dati delle partite.
 * Utilizza una connessione al database per eseguire le operazioni richieste.
 */
public class DatabaseController extends Database {
    private Connection conn;

    /**
     * Crea un'istanza di DatabaseController e stabilisce una connessione al database.
     * Se la connessione non può essere stabilita, viene visualizzato un messaggio di errore.
     */
    public DatabaseController() {
        Connection connessione = null;
        try {
            connessione = super.connect();
        } catch (SQLException ex) {
            System.out.println("Errore di connessione al database.");
        }
        this.conn = connessione;
    }


    /**
     * Crea la tabella "partita" nel database se non esiste già.
     *
     * @return true se la tabella è stata creata con successo o se esiste già, altrimenti false.
     */
    @Override
    public boolean creaTabellaPartita() {
        try {
            // Crea la tabella solo se non esiste
            try (Statement stm = conn.createStatement()) {
                stm.executeUpdate(CREA_TABELLA_PARTITA);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return true;
    }

    /**
     * Salva i dati della partita nel sistema, inclusi il nome della partita, l'username del giocatore,
     * il punteggio calcolato, il tempo di gioco e il numero di mosse.
     *
     * @param partita Oggetto GameDescription che contiene i dati della partita da salvare.
     * @return true se i dati della partita sono stati salvati con successo, altrimenti false.
     */
    @Override
    public boolean salvaPartita(final GameDescription partita) {
        // Calcola il punteggio utilizzando la formula specifica
        int punteggio = partita.calcoloPunteggio(partita.getNumMosse(), partita.getNumMinuti(), partita.getFinita());
        try {
            // Inserimento completo con punteggio
            PreparedStatement pstm = conn.prepareStatement(INSERISCI_PARTITA);
            pstm.setString(1, partita.getNomePartita());
            pstm.setString(2, partita.getUsername());
            pstm.setInt(3, punteggio);
            pstm.setInt(4, partita.getNumOre());
            pstm.setInt(5, partita.getNumMinuti());
            pstm.setInt(6, partita.getNumSecondi());
            pstm.setBoolean(7, partita.getFinita());
            pstm.setInt(8, partita.getNumMosse());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("PARTITA NON SALVATA SU DB");
            System.err.println(ex.getMessage());
        }
        return true;
    }

    /**
     * Ottiene il punteggio associato all'identificatore specificato dalla tabella "partita" nel database.
     *
     * @param id Identificatore della registrazione del punteggio.
     * @return Punteggio corrispondente all'identificatore specificato.
     */
    @Override
    public int getPunteggio(final int id) {
        try {
            PreparedStatement pstm = conn.prepareStatement(RECUPERA_PUNTEGGIO_CON_ID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("\nPunteggio: " + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    /**
     * Ottiene il punteggio associato al nome specificato della partita dalla tabella "partita" nel database.
     *
     * @param nomePartita Nome della partita per la quale si desidera ottenere il punteggio.
     * @return Punteggio corrispondente al nome specificato della partita.
     */
    @Override
    public int getPunteggio(final String nomePartita) {
        int punteggio = 0;
        try {
            PreparedStatement pstm = conn.prepareStatement(RECUPERA_PUNTEGGIO_CON_NOME_PARTITA);
            pstm.setString(1, nomePartita);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                punteggio = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return punteggio;
    }

    /**
     * Chiude la connessione al database corrente.
     * Se si verifica un'eccezione durante la chiusura della connessione, viene visualizzato un messaggio di errore.
     */
    public void chiudiConnessione() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Stampa le informazioni delle partite registrate dalla tabella "partita" nel database.
     * Questo metodo non restituisce alcun valore, ma visualizza le informazioni delle partite nel modo desiderato (ad esempio, su console o su un file di output).
     */
    @Override
    public void stampaPartite() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(STAMPA_PARTITE);
            while (rs.next()) {
                System.out.println("\nid: " + rs.getInt(1));
                System.out.println("\nnome partita: " + rs.getString(2));
                System.out.println("\nusername: " + rs.getString(3));
                System.out.println("\npunteggio: " + rs.getInt(4));
                System.out.println("\nDurata partita: " + rs.getInt(5) + " ore e " + rs.getInt(6) + " minuti e " + rs.getInt(7) + " secondi");
                System.out.println("\nTerminata: " + rs.getBoolean(8));
                System.out.println("\nNumero mosse: " + rs.getInt(9));
                System.out.println("-------------------------------------------------------");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Ottiene un oggetto ResultSet contenente le informazioni delle partite registrate dalla tabella "partita" nel database.
     *
     * @return Oggetto ResultSet contenente le informazioni delle partite registrate, oppure null se si verifica un'eccezione.
     */
    public ResultSet getPartite() {
        try {
            Statement stm = conn.createStatement();
            return stm.executeQuery(STAMPA_PARTITE);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    /**
     * Ottiene un oggetto ResultSet contenente le informazioni delle partite associate a un determinato utente dalla tabella "partita" nel database.
     *
     * @param username Username dell'utente per il quale si desidera ottenere le partite.
     * @return Oggetto ResultSet contenente le informazioni delle partite dell'utente, oppure null se si verifica un'eccezione.
     */
    public ResultSet getPartiteUtente(final String username) {
        try {
            PreparedStatement pstm = conn.prepareStatement(STAMPA_PARTITE_UTENTE);
            pstm.setString(1, username);
            return pstm.executeQuery();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    /**
     * Ottiene il punteggio medio di tutte le partite registrate nella tabella "partita" nel database.
     *
     * @return Punteggio medio di tutte le partite registrate, oppure 0 se si verifica un'eccezione.
     */
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

    /**
     * Ottiene il punteggio medio delle partite associate a un determinato utente dalla tabella "partita" nel database.
     *
     * @param username Username dell'utente per il quale si desidera ottenere il punteggio medio delle partite.
     * @return Punteggio medio delle partite dell'utente, oppure 0 se si verifica un'eccezione.
     */
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

    /**
     * Ottiene il punteggio medio delle partite terminate dalla tabella "partita" nel database.
     *
     * @return Punteggio medio delle partite terminate, oppure 0 se si verifica un'eccezione.
     */
    public double getPunteggioTerminate() {
        double punteggioMedio = 0;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(STAMPA_PUNTEGGIO_MEDIO_TERMINATE);
            rs.next();
            punteggioMedio = rs.getDouble(1);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return punteggioMedio;
    }

    /**
     * Verifica se esiste una partita con il nome specificato nella tabella "partita" nel database.
     *
     * @param nomePartita Nome della partita da verificare.
     * @return true se esiste una partita con il nome specificato, altrimenti false.
     */
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

    /**
     * Ottiene una lista di oggetti Partita contenenti le informazioni delle partite registrate dalla tabella "partita" nel database.
     * Prende tutte le partite dal Database, crea un oggetto Partita e lo aggiunge alla lista da restituire.
     *
     * @return Lista di oggetti Partita contenente le informazioni delle partite registrate.
     */
    public List<Partita> ottieniListaPartite() {
        List<Partita> partite = new ArrayList<>();
        ResultSet rs = this.getPartite();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String nomeUtente = rs.getString(3);
                int punteggio = rs.getInt(4);
                int numOre = rs.getInt(5);
                int numMinuti = rs.getInt(6);
                int numSecondi = rs.getInt(7);
                boolean terminata = rs.getBoolean(8);
                int numMosse = rs.getInt(9);
                Partita partita = new Partita(id, nome, nomeUtente, punteggio, numOre, numMinuti, numSecondi, terminata, numMosse);
                partite.add(partita);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("LISTA PARTITE:");
        StampaListe<Partita> stampaLista = new StampaListe<>(partite);
        stampaLista.stampa();

        return partite;
    }

}
