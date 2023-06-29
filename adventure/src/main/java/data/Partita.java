/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Giannantonio
 */
public class Partita {
    private int id;
    private String nome;
    private String nomeUtente;
    private int punteggio;
    private int numMinuti;
    private int numSecondi;
    private boolean terminata;
    private int numMosse;
      
    public Partita(){
        this.id = 0;
        this.nome = "";
        this.numSecondi = 0;
        this.numMinuti = 0;
        this.numMosse = 0;
        this.punteggio = 0;
        this.terminata = false;
    }
    
    public Partita(int id, String nome, String nomeUtente, int punteggio, int numMinuti, int numSecondi, boolean terminata, int numMosse){
        this.id = id;
        this.nome = nome;
        this.numSecondi = numSecondi;
        this.numMinuti = numMinuti;
        this.nomeUtente = nomeUtente;
        this.numMosse = numMosse;
        this.punteggio = punteggio;
        this.terminata = terminata;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNumSecondi(int numSecondi){
        this.numSecondi = numSecondi;
    }
    
    public void setNumMinuti(int numMinuti){
        this.numMinuti = numMinuti;
    }
    
    public void setNuomeUtente(String nomeUtente){
        this.nomeUtente = nomeUtente;
    }
    
    public void setNumMosse(int numMosse){
        this.numMosse = numMosse;
    }
    
    public void setPunteggio(int punteggio){
        this.punteggio = punteggio;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getNumSecondi(){
        return this.numSecondi;
    }
    
    public int getNumMinuti(){
        return this.numMinuti;
    }
        
    public String getNomeUtente(){
        return this.nomeUtente;
    }
    
    public int getNumMosse(){
        return this.numMosse;
    }
    
    public int getPunteggio(){
        return this.punteggio;
    }
        
    public void setTerminata(boolean b){
        this.terminata = b;
    }
    
    public boolean terminata(){
        return this.terminata;
    }
        
}
