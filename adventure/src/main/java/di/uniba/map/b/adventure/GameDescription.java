/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.AdvObject;
import di.uniba.map.b.adventure.type.Command;
import di.uniba.map.b.adventure.type.Room;
import swing.JFrameApp;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public abstract class GameDescription {

    private String nameGame;
    
    private String username;
    
    private boolean finish;
    
    private int numSeconds;
    
    private int numMinutes;
    
    private int numMoves;
    
    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private final List<AdvObject> inventory = new ArrayList<>();

    private Room currentRoom;

    
    
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
    
    public List<Room> getRooms() {
        return rooms;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<AdvObject> getInventory() {
        return inventory;
    }

    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, PrintStream out);
    
    public abstract void nextMove(ParserOutput p, PrintStream out, JFrameApp frame);

}
