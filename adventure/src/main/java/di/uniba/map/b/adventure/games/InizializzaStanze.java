package di.uniba.map.b.adventure.games;


import di.uniba.map.b.adventure.messaggi.MessaggioCovo;
import di.uniba.map.b.adventure.messaggi.MessaggioCosta;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioFuori;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioDentro;
import di.uniba.map.b.adventure.messaggi.MessaggioApprodo;
import di.uniba.map.b.adventure.messaggi.MessaggioSentiero;
import di.uniba.map.b.adventure.messaggi.MessaggioGrotta;
import di.uniba.map.b.adventure.messaggi.MessaggioBosco;

import di.uniba.map.b.adventure.type.Stanza;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Classe di utilità per l'inizializzazione delle stanze del gioco "Naufragio sull'Isola".
 * Fornisce metodi statici per inizializzare le diverse stanze del gioco.
 * La classe non può essere istanziata o estesa.
 */
public final class InizializzaStanze {

    /**
     * Costruttore privato della classe InizializzaStanze.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i metodi in questa classe sono statici e la classe è progettata per essere utilizzata come classe di utilità.
     * Fornisce metodi di inizializzazione per le stanze del gioco "Naufragio sull'Isola".
     * La classe non può essere istanziata o estesa.
     */
    private InizializzaStanze() {
    }

    /**
     * Metodo statico per inizializzare la stanza "Approdo" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Approdo" inizializzata.
     */
    public static Stanza inizializzaApprodo(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza approdo
        Stanza approdo = new Stanza(0, MessaggioApprodo.getNome());
        //Imposto la descrizione corta della stanza
        approdo.setDescrizioneCortaStanza(MessaggioApprodo.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        approdo.setDescrizioneCompletaStanza(MessaggioApprodo.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        approdo.setOsserva(MessaggioApprodo.getOsserva());
        //Imposto la visibilita della stanza
        approdo.setRaggiungibile(true);
        //Imposto la stanza iniziale come visitata
        approdo.setVisitata(true);
        //Imposto il messaggio per Nord
        approdo.setMessaggioNord(MessaggioApprodo.getNord());
        //Imposto il messaggio per Sud
        approdo.setMessaggioSud(MessaggioApprodo.getNoSud());
        //Imposto il messaggio per Est
        approdo.setMessaggioEst(MessaggioApprodo.getNoEst());
        //Imposto il messaggio per Ovest
        approdo.setMessaggioOvest(MessaggioApprodo.getOvest());
        //Aggiungo la stanza
        gni.getStanze().add(approdo);
        return approdo;
    }

    /**
     * Metodo statico per inizializzare la stanza "Costa" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Costa" inizializzata.
     */
    public static Stanza inizializzaCosta(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza costa
        Stanza costa = new Stanza(1, MessaggioCosta.getNome());
        //Imposto la descrizione corta della stanza
        costa.setDescrizioneCortaStanza(MessaggioCosta.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        costa.setDescrizioneCompletaStanza(MessaggioCosta.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        costa.setOsserva(MessaggioCosta.getOsserva());
        //Imposto la visibilita della stanza
        costa.setRaggiungibile(true);
        //Imposto il messaggio per Nord
        costa.setMessaggioNord(MessaggioCosta.getNoNord());
        //Imposto il messaggio per Sud
        costa.setMessaggioSud(MessaggioCosta.getSud());
        //Imposto il messaggio per Est
        costa.setMessaggioEst(MessaggioCosta.getNoEst());
        //Imposto il messaggio per Ovest
        costa.setMessaggioOvest(MessaggioCosta.getOvest());
        //Aggiungo la stanza
        gni.getStanze().add(costa);
        return costa;
    }

    /**
     * Metodo statico per inizializzare la stanza "Bosco" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Bosco" inizializzata.
     */
    public static Stanza inizializzaBosco(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza bosco
        Stanza bosco = new Stanza(2, MessaggioBosco.getNome());
        //Imposto la descrizione corta della stanza
        bosco.setDescrizioneCortaStanza(MessaggioBosco.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        bosco.setDescrizioneCompletaStanza(MessaggioBosco.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        bosco.setOsserva(MessaggioBosco.getOsserva());
        //Imposto la visibilita della stanza
        bosco.setRaggiungibile(true);
        //Imposto il messaggio per Nord
        bosco.setMessaggioNord(MessaggioBosco.getNord());
        //Imposto il messaggio per Sud
        bosco.setMessaggioSud(MessaggioBosco.getNoSud());
        //Imposto il messaggio per Est
        bosco.setMessaggioEst(MessaggioBosco.getEst());
        //Imposto il messaggio per Ovest
        bosco.setMessaggioOvest(MessaggioBosco.getOvest());
        //Aggiungo la stanza
        gni.getStanze().add(bosco);
        return bosco;
    }

    /**
     * Metodo statico per inizializzare la stanza "Sentiero" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Sentiero" inizializzata.
     */
    public static Stanza inizializzaSentiero(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza sentiero
        Stanza sentiero = new Stanza(7, MessaggioSentiero.getNome());
        ///Imposto la descrizione corta della stanza
        sentiero.setDescrizioneCortaStanza(MessaggioSentiero.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        sentiero.setDescrizioneCompletaStanza(MessaggioSentiero.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        sentiero.setOsserva(MessaggioSentiero.getOsserva());
        //Imposto il messaggio per Nord
        sentiero.setMessaggioNord(MessaggioSentiero.getNord());
        //Imposto il messaggio per Sud
        sentiero.setMessaggioSud(MessaggioSentiero.getSud());
        //Imposto il messaggio per Est
        sentiero.setMessaggioEst(MessaggioSentiero.getEst());
        //Imposto il messaggio per Ovest
        sentiero.setMessaggioOvest(MessaggioSentiero.getNoOvest());
        //Aggiungo la stanza
        gni.getStanze().add(sentiero);
        return sentiero;
    }

    /**
     * Metodo statico per inizializzare la stanza "Covo" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Covo" inizializzata.
     */
    public static Stanza inizializzaCovo(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza covo
        Stanza covo = new Stanza(3, MessaggioCovo.getNome());
        ///Imposto la descrizione corta della stanza
        covo.setDescrizioneCortaStanza(MessaggioCovo.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        covo.setDescrizioneCompletaStanza(MessaggioCovo.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        covo.setOsserva(MessaggioCovo.getOsserva());
        //Imposto la visibilita della stanza
        covo.setRaggiungibile(false);
        //Imposto il messaggio per Nord
        covo.setMessaggioNord(MessaggioCovo.getNoNord());
        //Imposto il messaggio per Sud
        covo.setMessaggioSud(MessaggioCovo.getSud());
        //Imposto il messaggio per Est
        covo.setMessaggioEst(MessaggioCovo.getNoEst());
        //Imposto il messaggio per Ovest
        covo.setMessaggioOvest(MessaggioCovo.getNoOvest());
        //Aggiungo la stanza
        gni.getStanze().add(covo);
        return covo;
    }

    /**
     * Metodo statico per inizializzare la stanza "Edificio Dentro" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Edificio Dentro" inizializzata.
     */
    public static Stanza inizializzaEdificioDentro(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza edificioDentro
        Stanza edificioDentro = new Stanza(4, MessaggioEdificioDentro.getNome());
        ///Imposto la descrizione corta della stanza
        edificioDentro.setDescrizioneCortaStanza(MessaggioEdificioDentro.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        edificioDentro.setDescrizioneCompletaStanza(MessaggioEdificioDentro.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        edificioDentro.setOsserva(MessaggioEdificioDentro.getOsserva());
        //Imposto la visibilita della stanza
        edificioDentro.setRaggiungibile(false);
        //Imposto il messaggio per Nord
        edificioDentro.setMessaggioNord(MessaggioEdificioDentro.getNoNord());
        //Imposto il messaggio per Sud
        edificioDentro.setMessaggioSud(MessaggioEdificioDentro.getSud());
        //Imposto il messaggio per Est
        edificioDentro.setMessaggioEst(MessaggioEdificioDentro.getNoEst());
        //Imposto il messaggio per Ovest
        edificioDentro.setMessaggioOvest(MessaggioEdificioDentro.getNoOvest());
        //Aggiungo la stanza
        gni.getStanze().add(edificioDentro);
        return edificioDentro;
    }

    /**
     * Metodo statico per inizializzare la stanza "Edificio Fuori" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Edificio Fuori" inizializzata.
     */
    public static Stanza inizializzaEdificioFuori(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza edificioFuori
        Stanza edificioFuori = new Stanza(5, MessaggioEdificioFuori.getNome());
        ///Imposto la descrizione corta della stanza
        edificioFuori.setDescrizioneCortaStanza(MessaggioEdificioFuori.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        edificioFuori.setDescrizioneCompletaStanza(MessaggioEdificioFuori.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        edificioFuori.setOsserva(MessaggioEdificioFuori.getOsserva());
        //Imposto la visibilita della stanza
        edificioFuori.setRaggiungibile(true);
        //Imposto il messaggio per Nord
        edificioFuori.setMessaggioNord(MessaggioEdificioFuori.getNoNord());
        //Imposto il messaggio per Sud
        edificioFuori.setMessaggioSud(MessaggioEdificioFuori.getSud());
        //Imposto il messaggio per Est
        edificioFuori.setMessaggioEst(MessaggioEdificioFuori.getNoEst());
        //Imposto il messaggio per Ovest
        edificioFuori.setMessaggioOvest(MessaggioEdificioFuori.getNoOvest());
        //Aggiungo la stanza
        gni.getStanze().add(edificioFuori);
        return edificioFuori;
    }
    /**
     * Metodo statico per inizializzare la stanza "Grotta" del gioco "Naufragio sull'Isola".
     * @param gni Oggetto GiocoNaufragioIsola che contiene le informazioni di gioco.
     * @return Stanza "Grotta" inizializzata.
     */
    public static Stanza inizializzaGrotta(final GiocoNaufragioIsola gni) {
        //Istanziazione stanza grotta
        Stanza grotta = new Stanza(6, MessaggioGrotta.getGrottaNome());
        ///Imposto la descrizione corta della stanza
        grotta.setDescrizioneCortaStanza(MessaggioGrotta.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        grotta.setDescrizioneCompletaStanza(MessaggioGrotta.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        grotta.setOsserva(MessaggioGrotta.getOsservaBuio());
        //Imposto la visibilita della stanza
        grotta.setRaggiungibile(true);
        //Imposto il messaggio per Nord
        grotta.setVisibile(false);
        //Imposto il messaggio per Nord
        grotta.setMessaggioNord(MessaggioGrotta.getNoNordLuce());
        //Imposto il messaggio per Sud
        grotta.setMessaggioSud(MessaggioGrotta.getNoSudLuce());
        //Imposto il messaggio per Est
        grotta.setMessaggioEst(MessaggioGrotta.getEst());
        //Imposto il messaggio per Ovest
        grotta.setMessaggioOvest(MessaggioGrotta.getNoOvestLuce());
        //Aggiungo la stanza
        gni.getStanze().add(grotta);
        return grotta;
    }
}
