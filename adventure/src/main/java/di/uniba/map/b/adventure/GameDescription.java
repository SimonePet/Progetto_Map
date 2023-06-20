/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public abstract class GameDescription {

    
    private String username;
    private String nameGame;   
    private boolean finish=false;
    private int numMinutes=0;
    private int numSeconds=0;
    private int numMoves=0;
    private final List<Stanza> rooms = new ArrayList<>();
    private final List<Comando> commands = new ArrayList<>();
    private final List<Oggetto> inventory = new ArrayList<>();
    private Stanza currentRoom;

    
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

    
    public void setNameGame(String name){
        this.nameGame = name;
    }
    
    public String getNameGame(){
        return nameGame;
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

    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, PrintStream out);
    
    public abstract void nextMove(ParserOutput p, PrintStream out, JFrameApp frame);

}
