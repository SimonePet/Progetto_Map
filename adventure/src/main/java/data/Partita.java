/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 * Classe che rappresenta una partita.
 * Una partita è caratterizzata da un identificatore, un nome, un nome utente associato, un punteggio, una durata espressa
 * in ore, minuti e secondi, un numero di mosse effettuate e uno stato di terminazione.
 */
public class Partita {
    private int id;
    private String nome;
    private String nomeUtente;
    private int punteggio;
    private int numOre;
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
        this.numOre = 0;
        this.numSecondi = 0;
        this.numMinuti = 0;
        this.numMosse = 0;
        this.punteggio = 0;
        this.terminata = false;
    }

    /**
     * Crea un oggetto Partita con i dati specificati.
     *
     * @param idCorr         Identificatore della partita.
     * @param nomeCorr       Nome della partita.
     * @param nomeUtenteCorr Username dell'utente associato alla partita.
     * @param punteggioCorr  Punteggio della partita.
     * @param numOreCorr     Numero di ore di durata della partita.
     * @param numMinutiCorr  Numero di minuti di durata della partita.
     * @param numSecondiCorr Numero di secondi di durata della partita.
     * @param terminataCorr  Indica se la partita è terminata o in corso.
     * @param numMosseCorr   Numero di mosse effettuate nella partita.
     */
    public Partita(final int idCorr, final String nomeCorr, final String nomeUtenteCorr, final int punteggioCorr,
                   final int numOreCorr, final int numMinutiCorr, final int numSecondiCorr, final boolean terminataCorr,
                   final int numMosseCorr) {
        this.id = idCorr;
        this.nome = nomeCorr;
        this.numOre = numOreCorr;
        this.numSecondi = numSecondiCorr;
        this.numMinuti = numMinutiCorr;
        this.nomeUtente = nomeUtenteCorr;
        this.numMosse = numMosseCorr;
        this.punteggio = punteggioCorr;
        this.terminata = terminataCorr;
    }

    /**
     * Imposta l'identificatore della partita.
     *
     * @param idCorr Identificatore della partita.
     */
    public void setId(final int idCorr) {
        this.id = idCorr;
    }

    /**
     * Restituisce l'identificatore della partita.
     *
     * @return Identificatore della partita.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Imposta il nome della partita.
     *
     * @param nomeCorr Nome della partita.
     */
    public void setNome(final String nomeCorr) {
        this.nome = nomeCorr;
    }

    /**
     * Imposta il numero di secondi di durata della partita.
     *
     * @param numSecondiCorr Numero di secondi di durata della partita.
     */
    public void setNumSecondi(final int numSecondiCorr) {
        this.numSecondi = numSecondiCorr;
    }

    /**
     * Imposta il numero di minuti di durata della partita.
     *
     * @param numMinutiCorr Numero di minuti di durata della partita.
     */
    public void setNumMinuti(final int numMinutiCorr) {
        this.numMinuti = numMinutiCorr;
    }

    /**
     * Imposta il nome utente associato alla partita.
     *
     * @param nomeUtenteCorr Username dell'utente associato alla partita.
     */
    public void setNuomeUtente(final String nomeUtenteCorr) {
        this.nomeUtente = nomeUtenteCorr;
    }

    /**
     * Imposta il numero di mosse effettuate nella partita.
     *
     * @param numMosseCorr Numero di mosse effettuate nella partita.
     */
    public void setNumMosse(final int numMosseCorr) {
        this.numMosse = numMosseCorr;
    }

    /**
     * Imposta il punteggio della partita.
     *
     * @param punteggioCorr Punteggio della partita.
     */
    public void setPunteggio(final int punteggioCorr) {
        this.punteggio = punteggioCorr;
    }

    /**
     * Restituisce il nome della partita.
     *
     * @return Nome della partita.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Imposta il numero di ore di durata della partita.
     *
     * @param oreCorr Numero di ore di durata della partita.
     */
    public void setNumOre(final int oreCorr) {
        this.numOre = oreCorr;
    }

    /**
     * Restituisce il numero di ore di durata della partita.
     *
     * @return Numero di ore di durata della partita.
     */
    public int getNumOre() {
        return this.numOre;
    }

    /**
     * Restituisce il numero di secondi di durata della partita.
     *
     * @return Numero di secondi di durata della partita.
     */
    public int getNumSecondi() {
        return this.numSecondi;
    }

    /**
     * Restituisce il numero di minuti di durata della partita.
     *
     * @return Numero di minuti di durata della partita.
     */
    public int getNumMinuti() {
        return this.numMinuti;
    }

    /**
     * Restituisce il nome utente associato alla partita.
     *
     * @return Nome utente associato alla partita.
     */
    public String getNomeUtente() {
        return this.nomeUtente;
    }

    /**
     * Restituisce il numero di mosse effettuate nella partita.
     *
     * @return Numero di mosse effettuate nella partita.
     */
    public int getNumMosse() {
        return this.numMosse;
    }

    /**
     * Restituisce il punteggio della partita.
     *
     * @return Punteggio della partita.
     */
    public int getPunteggio() {
        return this.punteggio;
    }

    /**
     * Imposta lo stato di terminazione della partita.
     *
     * @param terminataCorr Indica se la partita è terminata o in corso.
     */
    public void setTerminata(final boolean terminataCorr) {
        this.terminata = terminataCorr;
    }

    /**
     * Verifica se la partita è terminata.
     *
     * @return true se la partita è terminata, false altrimenti.
     */
    public boolean terminata() {
        return this.terminata;
    }

    /**
     * Stampa le informazioni della partita.
     * Le informazioni stampate includono l'identificatore, il nome della partita, il numero di ore, minuti e secondi di durata,
     * il numero di mosse effettuate, il punteggio ottenuto e lo stato di terminazione della partita.
     */
    public void stampaPartita() {
        System.out.println("Id: " + this.id);
        System.out.println("Nome partita: " + this.nome);
        System.out.println("Numero Ore: " + this.numOre);
        System.out.println("Numero minuti: " + this.numMinuti);
        System.out.println("Numero secondi: " + this.numSecondi);
        System.out.println("Numero mosse: " + this.numMosse);
        System.out.println("Punteggio: " + this.punteggio);
        System.out.println("Terminata: " + this.terminata);
    }

}
