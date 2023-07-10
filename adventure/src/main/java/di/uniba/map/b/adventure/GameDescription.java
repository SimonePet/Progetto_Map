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

    public int calcoloPunteggio(int numMosse, int numMinuti, boolean terminata){
        int punteggio = 100;
        if(this.abbandonata){
            punteggio = 0;
        }else{
            double penalizzazioneMosse = 0.25 * numMosse;
            int penalizzazioneMin = numMinuti;
            int bonusPartitaVinta = 50;
            punteggio = punteggio - (int) penalizzazioneMosse - penalizzazioneMin;
            if (terminata){
                punteggio += bonusPartitaVinta;
            }
            if (punteggio > 100) {
                punteggio = 100;
            } else if (punteggio < 0) {
                punteggio = 0;
            }    
        }
        return punteggio;
    }
    
    public void setAbbandonata(boolean b){
        this.abbandonata = b;
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

    public int getNumOre() {
        return numOre;
    }

    public void setNumOre(final int oreCorr) {
        this.numOre = oreCorr;
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
