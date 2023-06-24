/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class Stanza implements Serializable {

    private final int idStanza;

    private String nomeStanza;

    private String descrizioneLungaStanza;

    private String descrizioneCortaStanza;

    private String osserva;
    private boolean raggiungibile = true;
    private boolean visibile = true;
    private boolean visitata = false;
    private Stanza sud = null;

    private Stanza nord = null;

    private Stanza est = null;

    private Stanza ovest = null;

    private String messaggioNord = null;
    private String messaggioSud = null;
    private String messaggioEst = null;
    private String messaggioOvest = null;

    
    private final List<Oggetto> objects=new ArrayList<>();

    public Stanza(int id) {
        this.idStanza = id;
    }

    public Stanza(int id, String nome) {
        this.idStanza = id;
        this.nomeStanza = nome;
    }

    public String getNomeStanza() {
        return this.nomeStanza;
    }

    public void setNome(String nome) {
        this.nomeStanza = nome;
    }

    public String getDescrizioneLungaStanza() {
        return this.descrizioneLungaStanza;
    }

    public String getDescrizioneCortaStanza() {
        return this.descrizioneCortaStanza;
    }

    public void setDescription(String descrizione) {
        this.descrizioneLungaStanza = descrizione;
    }

    public boolean getRaggiungibile() {
        return this.raggiungibile;
    }

    public void setRaggiungibile(boolean raggiungibile) {
        this.raggiungibile = raggiungibile;
    }

    public Stanza getSud() {
        return this.sud;
    }

    public void setSud(Stanza sud) {
        this.sud = sud;
    }

    public Stanza getNord() {
        return this.nord;
    }

    public void setNord(Stanza nord) {
        this.nord = nord;
    }

    public Stanza getEst() {
        return this.est;
    }

    public void setEst(Stanza est) {
        this.est = est;
    }

    public Stanza getOvest() {
        return this.ovest;
    }

    public void setOvest(Stanza ovest) {
        this.ovest = ovest;
    }

    public void setDescrizioneCortaStanza(String descrizioneCortaStanzaCorr) {
        this.descrizioneCortaStanza = descrizioneCortaStanzaCorr;
    }

    public void setDescrizioneCompletaStanza(String descrizioneLungaStanzaCorr) {
        this.descrizioneLungaStanza = descrizioneLungaStanzaCorr;
    }

    public String getMessaggioNord() {
        return this.messaggioNord;
    }

    public String getMessaggioSud() {
        return this.messaggioSud;
    }

    public String getMessaggioEst() {
        return this.messaggioEst;
    }

    public String getMessaggioOvest() {
        return this.messaggioOvest;
    }

    public void setMessaggioNord(String messaggio) {
        this.messaggioNord = messaggio;
    }

    public void setMessaggioSud(String messaggio) {
        this.messaggioSud = messaggio;
    }

    public void setMessaggioEst(String messaggio) {
        this.messaggioEst = messaggio;
    }

    public void setMessaggioOvest(String messaggio) {
        this.messaggioOvest = messaggio;
    }

    public boolean getVisitata() {
        return this.visitata;
    }
    public void setVisitata(boolean visitata) {
        this.visitata = visitata;
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

    public String getOsserva() {
        return osserva;
    }

    public void setOsserva(String osserva) {
        this.osserva = osserva;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }
    public boolean getVisibile(){
        return this.visibile;
    }
}
