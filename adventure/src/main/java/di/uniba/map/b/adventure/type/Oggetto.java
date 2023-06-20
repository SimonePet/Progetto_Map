/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe che serve per rappresentare un oggetto nel gioco.
 */
public class Oggetto {
    private final int idOggetto;
    private String nomeOggetto;
    private String descrizioneOggetto;
    private Set<String> aliasOggetto;
    private boolean apribile = false;
    private boolean raccogglibile = true;
    private boolean premibile = false;
    private boolean aperto = false;
    private boolean premuto = false;

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
     */
    public String getNomeOggetto() {
        return this.nomeOggetto;
    }

    /**
     * Metodo set per il nome dell'oggetto.
     */
    public void setNome(final String nome) {
        this.nomeOggetto = nome;
    }

    /**
     * Metodo get per la descrizione dell'oggetto.
     */
    public String getDescrizioneOggetto() {
        return this.descrizioneOggetto;
    }

    /**
     * Metodo set per la descrizione dell'oggetto.
     */
    public void setDescrizioneOggetto(final String descrizione) {
        this.descrizioneOggetto = descrizione;
    }

    /**
     * Metodo booleano: Restituisce vero se un oggetto puo' essere aperto.
     * Falso altrimenti.
     */
    public boolean isApribile() {
        return this.apribile;
    }

    /**
     * Metodo set per dare la possibilita' ad un oggetto di essere raccolto
     */
    public void setApribile(final boolean openable) {
        this.apribile = openable;
    }

    /**
     * Metodo booleano: Restituisce vero se un oggetto puo' essere raccolto.
     * Falso altrimenti.
     */
    public boolean isRaccogglibile() {
        return this.raccogglibile;
    }

    public void setRaccogglibile(final boolean raccogglibile) {
        this.raccogglibile = raccogglibile;
    }

    /**
     * Metodo booleano: Restituisce vero se un oggetto puo' essere premuto.
     * Falso altrimenti.
     */
    public boolean IsPremibile() {
        return this.premibile;
    }

    public void setPremibile(final boolean pushable) {
        this.premibile = pushable;
    }

    public boolean isAperto() {
        return this.aperto;
    }

    public void setAperto(final boolean open) {
        this.aperto = open;
    }

    public boolean isPremuto() {
        return this.premuto;
    }

    public void setPremuto(final boolean push) {
        this.premuto = push;
    }

    public Set<String> getAliasOggetto() {
        return this.aliasOggetto;
    }

    public void setAlias(final Set<String> alias) {
        this.aliasOggetto = alias;
    }
    
    public void setAlias(final String[] alias) {
        this.aliasOggetto = new HashSet<>(Arrays.asList(alias));
    }

    public int getId() {
        return this.idOggetto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idOggetto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oggetto other = (Oggetto) obj;
        if (this.idOggetto != other.idOggetto) {
            return false;
        }
        return true;
    }

}
