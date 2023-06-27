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
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public abstract class GameDescription implements Serializable{
    
    private String nomePartita;
    private String username;  
    private boolean finish=false;
    private int numMinutes=0;
    private int numSeconds=0;
    private int numMoves=0;
    private int punteggio=100;
    private final List<Stanza> rooms = new ArrayList<>();
    private final List<Comando> commands = new ArrayList<>();
    private final List<Oggetto> inventory = new ArrayList<>();
    private final List<Oggetto> oggettiGioco = new ArrayList<>();
    private Stanza currentRoom;
    
    public void setPunteggio(){
        int penalizzazioneMosse = 1*this.getNumMoves();
        int penalizzazioneMin = 5*this.getNumMinutes();
        int bonusPartitaVinta = 15;
        this.punteggio = this.punteggio - penalizzazioneMosse - penalizzazioneMin;
        if (this.isFinished()){
            punteggio += bonusPartitaVinta;
        }
        if(punteggio>100){
            this.punteggio = 100;
        }else if(punteggio<0){
            this.punteggio = 0;
        } 
    }
    
    public int getPunteggio(){
        return punteggio;
    }
    
    public String getNomePartita(){
        return nomePartita;
    }
    
    public void setNomePartita(String nomePartita){
        this.nomePartita = nomePartita;
    }
    
    public int getNumMoves(){
        return numMoves;
    }

    public void setNumMoves(int moves){
        this.numMoves = moves;
    }

    public int getNumMinutes(){
        return numMinutes;
    }

    public void setNumMinutes(int min){
        this.numMinutes = min;
    }

    public int getNumSeconds(){
        return numSeconds;
    }

    public void setNumSeconds(int sec){
        this.numSeconds = sec;
    }

    public boolean isFinished(){
        return finish;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
    
    public List<Stanza> getRooms() {
        return rooms;
    }

    public List<Comando> getCommands() {
        return commands;
    }

    public Stanza getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Stanza currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Oggetto> getInventory() {
        return inventory;
    }

    public List<Oggetto> getOggettiGioco() {
        return oggettiGioco;
    }
    //Provare ad usare lambda expression
    public Oggetto getOggettoGioco(String nome){
        Oggetto prossimo = null;
        Iterator<Oggetto> iteratore = oggettiGioco.iterator();
        while (iteratore.hasNext()) {
            prossimo =iteratore.next();
            if(prossimo.getNomeOggetto().equalsIgnoreCase(nome)){
                return prossimo;
            }
        }
        return prossimo;
    }

    public Stanza getStanza(String nome){
        Stanza prossimo = null;
        Iterator<Stanza> iteratore = rooms.iterator();
        while (iteratore.hasNext()) {
            prossimo =iteratore.next();
            if(prossimo.getNomeStanza().equalsIgnoreCase(nome)){
                return prossimo;
            }
        }
        return prossimo;
    }


    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, PrintStream out, JFrameApp frame);

}
