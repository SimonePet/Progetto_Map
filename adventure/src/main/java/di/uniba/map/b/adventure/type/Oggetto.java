/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe che serve per rappresentare un oggetto nel gioco.
 */
public class Oggetto implements Serializable {
    private static final int HASH_1 = 7;
    private static final int HASH_2 = 37;
    private final int idOggetto;
    private String nomeOggetto;
    private String descrizioneOggetto;
    private Set<String> aliasOggetto;
    private boolean apribile = false;
    private boolean raccogglibile = true;
    private boolean premibile = false;
    private boolean aperto = false;
    private boolean premuto = false;
    private boolean visibile = false;
    private boolean lasciato=false;

    /**
     * Costruttore classe Oggetto.
     * @param id id univoco dell'oggetto.
     */
    public Oggetto(final int id) {
        this.idOggetto = id;
    }

    /**
     * Costruttore classe Oggetto.
     * @param id id univoco dell'oggetto.
     * @param nome nome dell'oggetto
     */
    public Oggetto(final int id, final String nome) {
        this.idOggetto = id;
        this.nomeOggetto = nome;
    }

    /**
     * Costruttore classe Oggetto.
     * @param id id univoco dell'oggetto.
     * @param nome nome dell'oggetto.
     * @param descrizione descrizione dell'oggetto.
     */
    public Oggetto(final int id, final String nome, final String descrizione) {
        this.idOggetto = id;
        this.nomeOggetto = nome;
        this.descrizioneOggetto = descrizione;
    }

    /**
     * Costruttore classe Oggetto.
     * @param id id univoco dell'oggetto.
     * @param nome nome dell'oggetto.
     * @param descrizione descrizione dell'oggetto.
     * @param alias alias dell'oggetto.
     */
    public Oggetto(final int id, final String nome, final String descrizione, final Set<String> alias) {
        this.idOggetto = id;
        this.nomeOggetto = nome;
        this.descrizioneOggetto = descrizione;
        this.aliasOggetto = alias;
    }

    /**
     * Metodo get per il nome dell'oggetto.
     * @return nome dell'oggetto.
     */
    public String getNomeOggetto() {
        return this.nomeOggetto;
    }

    /**
     * Metodo set per impostare il nome dell'oggetto.
     * @param nome nome da impostare
     */
    public void setNome(final String nome) {
        this.nomeOggetto = nome;
    }

    /**
     * Metodo get per la descrizione dell'oggetto.
     * @return descrizione dell'oggetto.
     */
    public String getDescrizioneOggetto() {
        return this.descrizioneOggetto;
    }

    /**
     * Metodo set per impostare la descrizione dell'oggetto.
     * @param descrizione descrizione dell'oggetto.
     */
    public void setDescrizioneOggetto(final String descrizione) {
        this.descrizioneOggetto = descrizione;
    }

    /**
     * Metodo per verificare se un oggetto può essere aperto.
     * @return Vero se un oggetto puo' essere aperto, Falso altrimenti
     */
    public boolean isApribile() {
        return this.apribile;
    }

    /**
     * Metodo set per dare la possibilita' ad un oggetto di essere aperto.
     * @param openable variabile booleana che indica se l'oggetto può essere aperto.
     */
    public void setApribile(final boolean openable) {
        this.apribile = openable;
    }

    /**
     * Metodo per verificare se un oggetto può essere raccolto.
     * @return Vero se un oggetto puo' essere raccolto, Falso altrimenti
     */
    public boolean isRaccogglibile() {
        return this.raccogglibile;
    }

    /**
     * Metodo set per dare la possibilita' ad un oggetto di essere raccolto.
     * @param raccogglibileCorr variabile booleana che indica se l'oggetto può essere raccolto.
     */
    public void setRaccogglibile(final boolean raccogglibileCorr) {
        this.raccogglibile = raccogglibileCorr;
    }

    /**
     * Metodo per verificare se un oggetto può essere premuto.
     * @return Vero se un oggetto puo' essere premuto, Falso altrimenti
     */
    public boolean isPremibile() {
        return this.premibile;
    }

    /**
     * Metodo set per dare la possibilita' ad un oggetto di essere aperto.
     * @param premibileCorr variabile booleana che indica se l'oggetto può essere premuto.
     */
    public void setPremibile(final boolean premibileCorr) {
        this.premibile = premibile;
    }

    /**
     * Metodo booleano per verificare se l'oggetto è aperto.
     * @return Vero se l'oggetto è aperto, Falso altrimenti.
     */
    public boolean isAperto() {
        return this.aperto;
    }

    /**
     * Metodo set per rendere un oggetto aperto.
     * @param apertoCorr variabile booleana che indica se l'oggetto deve essere aperto o chiuso.
     */
    public void setAperto(final boolean apertoCorr) {
        this.aperto = apertoCorr;
    }

    /**
     * Metodo booleano per verificare se l'oggetto è premuto.
     * @return Vero se l'oggetto è premuto, Falso altrimenti.
     */
    public boolean isPremuto() {
        return this.premuto;
    }

    /**
     * Metodo set per rendere un oggetto premuto.
     * @param premutoCorr variabile booleana che indica se l'oggetto deve essere premuto o depremuto.
     */
    public void setPremuto(final boolean premutoCorr) {
        this.premuto = premutoCorr;
    }

    /**
     * Metodo che restituisce l'alias dell'oggetto.
     * @return alias del comando.
     */
    public Set<String> getAliasOggetto() {
        return this.aliasOggetto;
    }
    /**
     * Metodo set per impostare un insieme di alias di un comando.
     * @param aliasOgg set di alias di comandi.
     */
    public void setAlias(final Set<String> aliasOgg) {
        this.aliasOggetto = aliasOgg;
    }
    /**
     * Metodo set per impostare un vettore alias di un oggetto.
     * @param alias vettori di alias.
     */
    public void setAlias(final String[] alias) {
        this.aliasOggetto = new HashSet<>(Arrays.asList(alias));
    }

    /**
     * Metodo get che restituisce l'id dell'oggetto.
     * @return id dell'oggetto.
     */
    public int getIdOggetto() {
        return this.idOggetto;
    }

    /**
     * Metodo che calcola un id univoco all'oggetto.
     * @return id univoco.
     */
    @Override
    public int hashCode() {
        int hash = HASH_1;
        hash = HASH_2 * hash + this.idOggetto;
        return hash;
    }

    /**
     * @param oggetto oggetto da confrontare
     * @return Vero se l'oggetto passato come parametro e' uguale a quello sul quale e chiamato il metodo.
     */
    @Override
    public boolean equals(final Object oggetto) {
        if (this == oggetto) {
            return true;
        }
        if (oggetto == null) {
            return false;
        }
        if (getClass() != oggetto.getClass()) {
            return false;
        }
        final Oggetto other = (Oggetto) oggetto;
        if (this.idOggetto != other.idOggetto) {
            return false;
        }
        return true;
    }

    public boolean isVisibile() {
        return this.visibile;
    }

    public void setVisibile(boolean visibileCorr) {
        this.visibile = visibileCorr;
    }

    public boolean isLasciato() {
        return lasciato;
    }
}
