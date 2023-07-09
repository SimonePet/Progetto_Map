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

    /**
     *
     */
    public Partita() {
        this.id = 0;
        this.nome = "";
        this.numSecondi = 0;
        this.numMinuti = 0;
        this.numMosse = 0;
        this.punteggio = 0;
        this.terminata = false;
    }
    /**
     *
     * @param id
     * @param nome
     * @param nomeUtente
     * @param punteggio
     * @param numMinuti
     * @param numSecondi
     * @param terminataCprr
     * @param numMosse
     */
    public Partita(final int id, final String nome, final String nomeUtente, final int punteggio, final int numMinuti, final int numSecondi, final boolean terminata, final int numMosse) {
        this.id = id;
        this.nome = nome;
        this.numSecondi = numSecondi;
        this.numMinuti = numMinuti;
        this.nomeUtente = nomeUtente;
        this.numMosse = numMosse;
        this.punteggio = punteggio;
        this.terminata = terminata;
    }
    /**
     *
     */
    public void setId(final int id) {
        this.id = id;
    }
    /**
     *
     * @return
     */
    public int getId() {
        return this.id;
    }
    /**
     *
     * @param nome
     */
    public void setNome(final String nome) {
        this.nome = nome;
    }
    /**
     *
     * @param numSecondi
     */
    public void setNumSecondi(final int numSecondi) {
        this.numSecondi = numSecondi;
    }
    /**
     *
     * @param numMinuti
     */
    public void setNumMinuti(final int numMinuti) {
        this.numMinuti = numMinuti;
    }
    /**
     *
     * @param nomeUtente
     */
    public void setNuomeUtente(final String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }
    /**
     *
     * @param numMosse
     */
    public void setNumMosse(final int numMosse) {
        this.numMosse = numMosse;
    }

    /**
     *
     * @param punteggio
     */
    public void setPunteggio(final int punteggio) {
        this.punteggio = punteggio;
    }
    /**
     *
     * @return
     */
    public String getNome() {
        return this.nome;
    }
    /**
     *
     * @return
     */
    public int getNumSecondi() {
        return this.numSecondi;
    }
    /**
     *
     * @return
     */
    public int getNumMinuti() {
        return this.numMinuti;
    }
    /**
     *
     * @return
     */
    public String getNomeUtente() {
        return this.nomeUtente;
    }
    /**
     *
     * @return
     */
    public int getNumMosse() {
        return this.numMosse;
    }
    /**
     *
     * @return
     */
    public int getPunteggio() {
        return this.punteggio;
    }
    /**
     *
     * @param b
     */
    public void setTerminata(final boolean b) {
        this.terminata = b;
    }
    /**
     *
     * @return
     */
    public boolean terminata() {
        return this.terminata;
    }

    public void stampaPartita(){
        System.out.println("Id: "+this.id);
        System.out.println("Nome partita: "+this.nome);
        System.out.println("Numero minuti: "+this.numMinuti);
        System.out.println("Numero secondi: "+this.numSecondi);
        System.out.println("Numero mosse: "+this.numMosse);
        System.out.println("Punteggio: "+this.punteggio);
        System.out.println("Terminata: "+this.terminata);
    }   
}
