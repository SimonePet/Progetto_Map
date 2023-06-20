/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class Stanza {

    private final int idStanza;

    private String nomeStanza;

    private String descrizioneStanza;

    private String look;

    private boolean visibile = true;

    private Stanza sud = null;

    private Stanza nord = null;

    private Stanza est = null;

    private Stanza ovest = null;
    
    private final List<Oggetto> objects=new ArrayList<>();

    public Stanza(int id) {
        this.idStanza = id;
    }

    public Stanza(int id, String nome, String descrizione) {
        this.idStanza = id;
        this.nomeStanza = nome;
        this.descrizioneStanza = descrizione;
    }

    public String getNomeStanza() {
        return this.nomeStanza;
    }

    public void setNome(String nome) {
        this.nomeStanza = nome;
    }

    public String getDescrizioneStanza() {
        return this.descrizioneStanza;
    }

    public void setDescription(String descrizione) {
        this.descrizioneStanza = descrizione;
    }

    public boolean Visibile() {
        return this.visibile;
    }

    public void setVisible(boolean visibile) {
        this.visibile = visibile;
    }

    public Stanza getSud() {
        return this.sud;
    }

    public void setSouth(Stanza sud) {
        this.sud = sud;
    }

    public Stanza getNord() {
        return this.nord;
    }

    public void setNorth(Stanza nord) {
        this.nord = nord;
    }

    public Stanza getEst() {
        return this.est;
    }

    public void setEast(Stanza est) {
        this.est = est;
    }

    public Stanza getOvest() {
        return this.ovest;
    }

    public void setOvest(Stanza west) {
        this.ovest = ovest;
    }

    public List<Oggetto> getObjects() {
        return objects;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idStanza;
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
        final Stanza other = (Stanza) obj;
        if (this.idStanza != other.idStanza) {
            return false;
        }
        return true;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

}
