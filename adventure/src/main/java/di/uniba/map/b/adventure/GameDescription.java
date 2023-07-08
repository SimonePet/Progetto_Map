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
import java.util.Iterator;
import java.util.List;

/**
 * @author pierpaolo
 */
public abstract class GameDescription implements Serializable {
    private String nomePartita;
    private String username;
    private boolean finita = false;
    private int numMinuti = 0;
    private int numSecondi = 0;
    private int numMosse = 0;
    private int punteggio = 100;
    private final List<Stanza> stanze = new ArrayList<>();
    private final List<Comando> comandi = new ArrayList<>();
    private final List<Oggetto> inventario = new ArrayList<>();
    private final List<Oggetto> oggettiGioco = new ArrayList<>();
    private Stanza stanzaCorrente;

    public void setPunteggio() {
        int penalizzazioneMosse = 1 * this.getNumMosse();
        int penalizzazioneMin = 5 * this.getNumMinuti();
        int bonusPartitaVinta = 15;
        this.punteggio = this.punteggio - penalizzazioneMosse - penalizzazioneMin;
        if (this.getFinita()) {
            punteggio += bonusPartitaVinta;
        }
        if (punteggio > 100) {
            this.punteggio = 100;
        } else if (punteggio < 0) {
            this.punteggio = 0;
        }
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getNomePartita() {
        return nomePartita;
    }

    public void setNomePartita(final String nomePartitaCorr) {
        this.nomePartita = nomePartitaCorr;
    }

    public int getNumMosse() {
        return numMosse;
    }

    public void setNumMosse(final int movesCorr) {
        this.numMosse = movesCorr;
    }

    public int getNumMinuti() {
        return numMinuti;
    }

    public void setNumMinuti(final int minCorr) {
        this.numMinuti = minCorr;
    }

    public int getNumSecondi() {
        return numSecondi;
    }

    public void setNumSecondi(final int secCor) {
        this.numSecondi = secCor;
    }

    public void setUsername(final String usernameCorr) {
        this.username = usernameCorr;
    }

    public String getUsername() {
        return username;
    }

    public List<Stanza> getStanze() {
        return stanze;
    }

    public List<Comando> getComandi() {
        return comandi;
    }

    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }

    public void setStanzaCorrente(final Stanza currentRoomCorr) {
        this.stanzaCorrente = currentRoomCorr;
    }

    public List<Oggetto> getInventario() {
        return inventario;
    }

    public List<Oggetto> getOggettiGioco() {
        return oggettiGioco;
    }

    //Provare ad usare lambda expression
    public Oggetto getOggettoGioco(final String nome) {
        Oggetto prossimo = null;
        Iterator<Oggetto> iteratore = oggettiGioco.iterator();
        while (iteratore.hasNext()) {
            prossimo = iteratore.next();
            if (prossimo.getNomeOggetto().equalsIgnoreCase(nome)) {
                return prossimo;
            }
        }
        return prossimo;
    }

    public Stanza getStanza(final String nome) {
        Stanza prossimo = null;
        Iterator<Stanza> iteratore = stanze.iterator();
        while (iteratore.hasNext()) {
            prossimo = iteratore.next();
            if (prossimo.getNomeStanza().equalsIgnoreCase(nome)) {
                return prossimo;
            }
        }
        return prossimo;
    }

    public Comando getComando(final String nome) {
        Comando prossimo = null;
        Iterator<Comando> iteratore = comandi.iterator();
        while (iteratore.hasNext()) {
            prossimo = iteratore.next();
            if (prossimo.getNomeComando().equalsIgnoreCase(nome)) {
                return prossimo;
            }
        }
        return prossimo;
    }

    public void setFinita(boolean b){
        finita = b;
    }
    
    public boolean getFinita(){
        return finita;
    }
    
    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, PrintStream out, JFrameApp frame, JPanel panel, JLabel label) throws BadLocationException;

}
