/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import java.io.Serializable;

import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pierpaolo
 */
public abstract class GameDescription implements Serializable {
    private String nomePartita;
    private String username;
    private boolean finita = false;
    private int numOre = 0;
    private int numMinuti = 0;
    private int numSecondi = 0;
    private int numMosse = 0;
    private int punteggio = 100;
    private boolean abbandonata = false;
    private final List<Stanza> stanze = new ArrayList<>();
    private final List<Comando> comandi = new ArrayList<>();
    private final List<Oggetto> inventario = new ArrayList<>();
    private final List<Oggetto> oggettiGioco = new ArrayList<>();
    private Stanza stanzaCorrente;

    /**
     * Calcola il punteggio finale del giocatore in base al numero di mosse effettuate,
     * al tempo trascorso e al flag che indica se la partita è stata terminata.
     *
     * @param numMosseCorr     Numero di mosse effettuate.
     * @param numMinutiCorr    Numero di minuti trascorsi.
     * @param terminataCorr    Flag che indica se la partita è stata terminata.
     * @return                 Il punteggio finale calcolato.
     */
    public int calcoloPunteggio(final int numMosseCorr, final int numMinutiCorr, final boolean terminataCorr) {
        int punteggioCorr = 100;
        if (this.abbandonata) {
            punteggioCorr = 0;
        } else {
            double penalizzazioneMosse = 0.3  * numMosseCorr;
            int bonusPartitaVinta = 30;
            punteggioCorr = punteggioCorr - (int) penalizzazioneMosse - numMinutiCorr;
            if (terminataCorr) {
                punteggioCorr += bonusPartitaVinta;
            }
            if (punteggioCorr > 100) {
                punteggioCorr = 100;
            } else if (punteggioCorr < 0) {
                punteggioCorr = 0;
            }
        }
        this.punteggio = punteggioCorr;
        return punteggioCorr;
    }

    /**
     * Imposta lo stato di abbandono della partita.
     *
     * @param abbandonataCorr Stato di abbandono della partita da impostare.
     */
    public void setAbbandonata(final boolean abbandonataCorr) {
        this.abbandonata = abbandonataCorr;
    }

    /**
     * Restituisce il punteggio della partita.
     *
     * @return Il punteggio della partita.
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * Restituisce il nome della partita.
     *
     * @return Il nome della partita.
     */
    public String getNomePartita() {
        return nomePartita;
    }

    /**
     * Imposta il nome della partita.
     *
     * @param nomePartitaCorr Il nome della partita da impostare.
     */
    public void setNomePartita(final String nomePartitaCorr) {
        this.nomePartita = nomePartitaCorr;
    }

    /**
     * Restituisce il numero di mosse effettuate.
     *
     * @return Il numero di mosse effettuate.
     */
    public int getNumMosse() {
        return numMosse;
    }

    /**
     * Imposta il numero di mosse effettuate.
     *
     * @param movesCorr Il numero di mosse da impostare.
     */
    public void setNumMosse(final int movesCorr) {
        this.numMosse = movesCorr;
    }

    /**
     * Restituisce il numero di minuti trascorsi.
     *
     * @return Il numero di minuti trascorsi.
     */
    public int getNumMinuti() {
        return numMinuti;
    }

    /**
     * Imposta il numero di minuti trascorsi.
     *
     * @param minCorr Il numero di minuti da impostare.
     */
    public void setNumMinuti(final int minCorr) {
        this.numMinuti = minCorr;
    }

    /**
     * Restituisce il numero di secondi trascorsi.
     *
     * @return Il numero di secondi trascorsi.
     */
    public int getNumSecondi() {
        return numSecondi;
    }

    /**
     * Imposta il numero di secondi trascorsi.
     *
     * @param secCor Il numero di secondi da impostare.
     */
    public void setNumSecondi(final int secCor) {
        this.numSecondi = secCor;
    }

    /**
     * Restituisce il numero di ore trascorse.
     *
     * @return Il numero di ore trascorse.
     */
    public int getNumOre() {
        return numOre;
    }

    /**
     * Imposta il numero di ore trascorse.
     *
     * @param oreCorr Il numero di ore da impostare.
     */
    public void setNumOre(final int oreCorr) {
        this.numOre = oreCorr;
    }

    /**
     * Imposta il nome utente associato alla partita.
     *
     * @param usernameCorr Il nome utente da impostare.
     */
    public void setUsername(final String usernameCorr) {
        this.username = usernameCorr;
    }

    /**
     * Restituisce il nome utente associato alla partita.
     *
     * @return Il nome utente associato alla partita.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Restituisce la lista delle stanze del gioco.
     *
     * @return La lista delle stanze del gioco.
     */
    public List<Stanza> getStanze() {
        return stanze;
    }

    /**
     * Restituisce la lista dei comandi disponibili nel gioco.
     *
     * @return La lista dei comandi disponibili nel gioco.
     */
    public List<Comando> getComandi() {
        return comandi;
    }

    /**
     * Restituisce la stanza corrente in cui si trova il giocatore.
     *
     * @return La stanza corrente.
     */
    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }

    /**
     * Imposta la stanza corrente in cui si trova il giocatore.
     *
     * @param currentRoomCorr La stanza corrente da impostare.
     */
    public void setStanzaCorrente(final Stanza currentRoomCorr) {
        this.stanzaCorrente = currentRoomCorr;
    }

    /**
     * Restituisce la lista degli oggetti presenti nell'inventario del giocatore.
     *
     * @return La lista degli oggetti nell'inventario.
     */
    public List<Oggetto> getInventario() {
        return inventario;
    }

    /**
     * Restituisce la lista degli oggetti disponibili nel gioco.
     *
     * @return La lista degli oggetti disponibili nel gioco.
     */
    public List<Oggetto> getOggettiGioco() {
        return oggettiGioco;
    }


    /**
     * Restituisce l'oggetto di gioco corrispondente al nome specificato.
     *
     * @param nome Il nome dell'oggetto da cercare.
     * @return L'oggetto di gioco corrispondente al nome specificato, null se non trovato.
     */
    public Oggetto getOggettoGioco(final String nome) {
        Oggetto prossimo = null;
        for (Oggetto oggetto : oggettiGioco) {
            prossimo = oggetto;
            if (prossimo.getNomeOggetto().equalsIgnoreCase(nome)) {
                return prossimo;
            }
        }
        return prossimo;
    }

    /**
     * Restituisce la stanza corrispondente al nome specificato.
     *
     * @param nome Il nome della stanza da cercare.
     * @return La stanza corrispondente al nome specificato, null se non trovata.
     */
    public Stanza getStanza(final String nome) {
        Stanza prossimo = null;
        for (Stanza stanza : stanze) {
            prossimo = stanza;
            if (prossimo.getNomeStanza().equalsIgnoreCase(nome)) {
                return prossimo;
            }
        }
        return prossimo;
    }

    /**
     * Restituisce il comando corrispondente al nome specificato.
     *
     * @param nome Il nome del comando da cercare.
     * @return Il comando corrispondente al nome specificato, null se non trovato.
     */
    public Comando getComando(final String nome) {
        Comando prossimo = null;
        for (Comando comando : comandi) {
            prossimo = comando;
            if (prossimo.getNomeComando().equalsIgnoreCase(nome)) {
                return prossimo;
            }
        }
        return prossimo;
    }

    /**
     * Imposta lo stato di conclusione del gioco.
     *
     * @param finitaCorr Stato di conclusione del gioco da impostare.
     */
    public void setFinita(final boolean finitaCorr) {
        finita = finitaCorr;
    }

    /**
     * Restituisce lo stato di conclusione del gioco.
     *
     * @return True se il gioco è concluso, false altrimenti.
     */
    public boolean getFinita() {
        return finita;
    }

    /**
     * Metodo astratto per inizializzare il gioco.
     *
     * @throws Exception Se si verifica un errore durante l'inizializzazione del gioco.
     */
    public abstract void init() throws Exception;

    /**
     * Metodo astratto per eseguire la prossima mossa del gioco.
     *
     * @param p     Output del parser contenente il comando inserito dall'utente.
     * @param out   Stream di output per la visualizzazione del risultato della mossa.
     * @param frame Frame principale dell'applicazione.
     * @param panel Pannello di gioco.
     * @param label Etichetta di stato del gioco.
     * @throws BadLocationException Se si verifica un errore nella gestione delle posizioni del testo.
     */
    public abstract void nextMove(ParserOutput p, PrintStream out, JFrameApp frame, JPanel panel, JLabel jlabel) throws BadLocationException;


}
