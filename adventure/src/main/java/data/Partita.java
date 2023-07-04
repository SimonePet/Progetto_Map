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
     * @param idCorr
     * @param nomeCorr
     * @param nomeUtenteCorr
     * @param punteggioCorr
     * @param numMinutiCorr
     * @param numSecondiCorr
     * @param terminataCprr
     * @param numMosseCorr
     */
    public Partita(final int idCorr, final String nomeCorr, final String nomeUtenteCorr, final int punteggioCorr, final int numMinutiCorr, final int numSecondiCorr, final boolean terminataCprr, final int numMosseCorr) {
        this.id = idCorr;
        this.nome = nomeCorr;
        this.numSecondi = numSecondiCorr;
        this.numMinuti = numMinutiCorr;
        this.nomeUtente = nomeUtenteCorr;
        this.numMosse = numMosseCorr;
        this.punteggio = punteggioCorr;
        this.terminata = terminataCprr;
    }
    /**
     *
     */
    public void setId(final int idCorr) {
        this.id = idCorr;
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
     * @param nomeCorr
     */
    public void setNome(final String nomeCorr) {
        this.nome = nomeCorr;
    }
    /**
     *
     * @param numSecondiCorr
     */
    public void setNumSecondi(final int numSecondiCorr) {
        this.numSecondi = numSecondiCorr;
    }
    /**
     *
     * @param numMinutiCorr
     */
    public void setNumMinuti(final int numMinutiCorr) {
        this.numMinuti = numMinutiCorr;
    }
    /**
     *
     * @param nomeUtenteCorr
     */
    public void setNuomeUtente(final String nomeUtenteCorr) {
        this.nomeUtente = nomeUtenteCorr;
    }
    /**
     *
     * @param numMosseCorr
     */
    public void setNumMosse(final int numMosseCorr) {
        this.numMosse = numMosseCorr;
    }

    /**
     *
     * @param punteggioCorr
     */
    public void setPunteggio(final int punteggioCorr) {
        this.punteggio = punteggioCorr;
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
}
