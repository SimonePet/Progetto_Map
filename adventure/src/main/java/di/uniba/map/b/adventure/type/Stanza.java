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
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * La classe Stanza rappresenta una stanza all'interno di un gioco.
 * Ogni stanza ha un ID univoco, un nome, una descrizione lunga e una descrizione corta.
 * La stanza può contenere oggetti e può essere collegata ad altre stanze tramite le direzioni Nord, Sud, Est e Ovest.
 * La classe implementa l'interfaccia Serializable per consentire la serializzazione degli oggetti di tipo Stanza.
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


    private final List<Oggetto> objects = new ArrayList<>();
    /**
     * Costruttore per la creazione di una stanza con l'ID specificato.
     *
     * @param id ID della stanza.
     */
    public Stanza(final int id) {
        this.idStanza = id;
    }

    /**
     * Costruttore per la creazione di una stanza con l'ID e il nome specificati.
     *
     * @param id   ID della stanza.
     * @param nome Nome della stanza.
     */
    public Stanza(final int id, final String nome) {
        this.idStanza = id;
        this.nomeStanza = nome;
    }

    /**
     * Restituisce il nome della stanza.
     *
     * @return Nome della stanza.
     */
    public String getNomeStanza() {
        return this.nomeStanza;
    }

    /**
     * Imposta il nome della stanza.
     *
     * @param nome Nome della stanza da impostare.
     */
    public void setNome(final String nome) {
        this.nomeStanza = nome;
    }

    /**
     * Restituisce la descrizione lunga della stanza.
     *
     * @return Descrizione lunga della stanza.
     */
    public String getDescrizioneLungaStanza() {
        return this.descrizioneLungaStanza;
    }

    /**
     * Restituisce la descrizione corta della stanza.
     *
     * @return Descrizione corta della stanza.
     */
    public String getDescrizioneCortaStanza() {
        return this.descrizioneCortaStanza;
    }

    /**
     * Imposta la descrizione lunga della stanza.
     *
     * @param descrizione Descrizione lunga della stanza da impostare.
     */
    public void setDescription(final String descrizione) {
        this.descrizioneLungaStanza = descrizione;
    }

    /**
     * Restituisce lo stato di raggiungibilità della stanza.
     *
     * @return true se la stanza è raggiungibile, false altrimenti.
     */
    public boolean getRaggiungibile() {
        return this.raggiungibile;
    }

    /**
     * Imposta lo stato di raggiungibilità della stanza.
     *
     * @param raggiungibileCorr Stato di raggiungibilità della stanza da impostare.
     */
    public void setRaggiungibile(final boolean raggiungibileCorr) {
        this.raggiungibile = raggiungibileCorr;
    }

    /**
     * Restituisce la stanza a sud della stanza corrente.
     *
     * @return Stanza a sud.
     */
    public Stanza getSud() {
        return this.sud;
    }

    /**
     * Imposta la stanza a sud della stanza corrente.
     *
     * @param sudCorr Stanza a sud da impostare.
     */
    public void setSud(final Stanza sudCorr) {
        this.sud = sudCorr;
    }

    /**
     * Restituisce la stanza a nord della stanza corrente.
     *
     * @return Stanza a nord.
     */
    public Stanza getNord() {
        return this.nord;
    }

    /**
     * Imposta la stanza a nord della stanza corrente.
     *
     * @param nordCorr Stanza a nord da impostare.
     */
    public void setNord(final Stanza nordCorr) {
        this.nord = nordCorr;
    }

    /**
     * Restituisce la stanza a est della stanza corrente.
     *
     * @return Stanza a est.
     */
    public Stanza getEst() {
        return this.est;
    }

    /**
     * Imposta la stanza a est della stanza corrente.
     *
     * @param estCorr Stanza a est da impostare.
     */
    public void setEst(final Stanza estCorr) {
        this.est = estCorr;
    }

    /**
     * Restituisce la stanza a ovest della stanza corrente.
     *
     * @return Stanza a ovest.
     */
    public Stanza getOvest() {
        return this.ovest;
    }

    /**
     * Imposta la stanza a ovest della stanza corrente.
     *
     * @param ovestCorr Stanza a ovest da impostare.
     */
    public void setOvest(final Stanza ovestCorr) {
        this.ovest = ovestCorr;
    }

    /**
     * Imposta la descrizione corta della stanza.
     *
     * @param descrizioneCortaStanzaCorr Descrizione corta della stanza.
     */
    public void setDescrizioneCortaStanza(final String descrizioneCortaStanzaCorr) {
        this.descrizioneCortaStanza = descrizioneCortaStanzaCorr;
    }

    /**
     * Imposta la descrizione completa della stanza.
     *
     * @param descrizioneLungaStanzaCorr Descrizione completa della stanza.
     */
    public void setDescrizioneCompletaStanza(final String descrizioneLungaStanzaCorr) {
        this.descrizioneLungaStanza = descrizioneLungaStanzaCorr;
    }

    /**
     * Ottiene il messaggio associato alla direzione nord.
     *
     * @return Messaggio associato alla direzione nord.
     */
    public String getMessaggioNord() {
        return this.messaggioNord;
    }

    /**
     * Ottiene il messaggio associato alla direzione sud.
     *
     * @return Messaggio associato alla direzione sud.
     */
    public String getMessaggioSud() {
        return this.messaggioSud;
    }

    /**
     * Ottiene il messaggio associato alla direzione est.
     *
     * @return Messaggio associato alla direzione est.
     */
    public String getMessaggioEst() {
        return this.messaggioEst;
    }

    /**
     * Ottiene il messaggio associato alla direzione ovest.
     *
     * @return Messaggio associato alla direzione ovest.
     */
    public String getMessaggioOvest() {
        return this.messaggioOvest;
    }

    /**
     * Imposta il messaggio associato alla direzione nord.
     *
     * @param messaggio Messaggio associato alla direzione nord.
     */
    public void setMessaggioNord(final String messaggio) {
        this.messaggioNord = messaggio;
    }

    /**
     * Imposta il messaggio associato alla direzione sud.
     *
     * @param messaggio Messaggio associato alla direzione sud.
     */
    public void setMessaggioSud(final String messaggio) {
        this.messaggioSud = messaggio;
    }

    /**
     * Imposta il messaggio associato alla direzione est.
     *
     * @param messaggio Messaggio associato alla direzione est.
     */
    public void setMessaggioEst(final String messaggio) {
        this.messaggioEst = messaggio;
    }

    /**
     * Imposta il messaggio associato alla direzione ovest.
     *
     * @param messaggio Messaggio associato alla direzione ovest.
     */
    public void setMessaggioOvest(final String messaggio) {
        this.messaggioOvest = messaggio;
    }

    /**
     * Verifica se la stanza è stata visitata.
     *
     * @return True se la stanza è stata visitata, altrimenti False.
     */
    public boolean getVisitata() {
        return this.visitata;
    }

    /**
     * Imposta lo stato di visita della stanza.
     *
     * @param visitataCorr True se la stanza è stata visitata, altrimenti False.
     */
    public void setVisitata(final boolean visitataCorr) {
        this.visitata = visitataCorr;
    }

    /**
     * Restituisce la lista degli oggetti presenti nella stanza.
     *
     * @return Lista degli oggetti presenti nella stanza.
     */
    public List<Oggetto> getObjects() {
        return objects;
    }

    /**
     * Calcola il codice hash per l'oggetto corrente.
     *
     * @return Il codice hash calcolato.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idStanza;
        return hash;
    }

    /**
     * Verifica se l'oggetto corrente è uguale all'oggetto specificato.
     *
     * @param obj L'oggetto da confrontare.
     * @return True se l'oggetto corrente è uguale all'oggetto specificato, False altrimenti.
     */
    @Override
    public boolean equals(final Object obj) {
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
        return this.idStanza == other.idStanza;
    }

    /**
     * Restituisce l'osservazione della stanza.
     *
     * @return L'osservazione della stanza.
     */
    public String getOsserva() {
        return osserva;
    }

    /**
     * Imposta l'osservazione della stanza.
     *
     * @param osservaCorr L'osservazione della stanza da impostare.
     */
    public void setOsserva(final String osservaCorr) {
        this.osserva = osservaCorr;
    }

    /**
     * Imposta lo stato di visibilità della stanza.
     *
     * @param visibileCorr Lo stato di visibilità della stanza.
     */
    public void setVisibile(final boolean visibileCorr) {
        this.visibile = visibileCorr;
    }

    /**
     * Restituisce lo stato di visibilità della stanza.
     *
     * @return True se la stanza è visibile, False altrimenti.
     */
    public boolean getVisibile() {
        return this.visibile;
    }
}
