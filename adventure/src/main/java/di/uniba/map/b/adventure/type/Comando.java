/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe per la gestione dei comandi.
 */
public class Comando implements Serializable {
    private static final int HASH_1 = 3;
    private static final int HASH_2 = 97;
    //Verificare che
    private final TipoComando tipoComando;
    private final String nomeComando;
    private Set<String> aliasComando;
    private String descrizione = null;

    /**
     * Costruttore della classe Comando.
     * @param tipoCom tipologia comando.
     * @param nomeCom nome comando.
     */
    public Comando(final TipoComando tipoCom, final String nomeCom) {
        this.tipoComando = tipoCom;
        this.nomeComando = nomeCom;
    }

    /**
     * Costruttore della classe Comando.
     * @param tipoCom tipologia comando.
     * @param nomeCom nome comando.
     * @param aliasCom alias comando.
     */
    public Comando(final TipoComando tipoCom, final String nomeCom, final Set<String> aliasCom) {
        this.tipoComando = tipoCom;
        this.nomeComando = nomeCom;
        this.aliasComando = aliasCom;
    }

    /**
     * Metodo get che restituisce il nome del comando.
     * @return nome del comando.
     */
    public String getNomeComando() {
        return this.nomeComando;
    }

    /**
     * Metodo che restituisce l'alias del comando.
     * @return alias del comando.
     */
    public Set<String> getAliasComando() {
        return this.aliasComando;
    }

    /**
     * Metodo set per impostare un insieme di alias di un comando.
     * @param aliasCom set di alias di comandi.
     */
    public void setAliasComando(final Set<String> aliasCom) {
        this.aliasComando = aliasCom;
    }

    /**
     * Metodo set per impostare un vettore alias di un comando.
     * @param alias vettori di alias.
     */
    public void setAlias(final String[] alias) {
        this.aliasComando = new HashSet<>(Arrays.asList(alias));
    }

    /**
     * Metodo get che restituisce il tipo di comando.
     * @return tipologia del comando.
     */
    public TipoComando getTipoComando() {
        return this.tipoComando;
    }

    /**
     * Metodo che calcola un id univoco al comando.
     * @return id univoco.
     */
    @Override
    public int hashCode() {
        int hash = HASH_1;
        hash = HASH_2 * hash + Objects.hashCode(this.tipoComando);
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
        final Comando other = (Comando) oggetto;
        if (this.tipoComando != other.tipoComando) {
            return false;
        }
        return true;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(final String descrizione) {
        this.descrizione = descrizione;
    }
}
