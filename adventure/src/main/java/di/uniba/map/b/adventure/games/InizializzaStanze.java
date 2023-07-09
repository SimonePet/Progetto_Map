package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.messaggi.*;
import di.uniba.map.b.adventure.type.Stanza;

public class InizializzaStanze {

    private InizializzaStanze() {
    }

    public static Stanza inizializzaApprodo(GiocoNaufragioIsola GNI) {
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
        GNI.getStanze().add(approdo);
        return approdo;
    }

    public static Stanza inizializzaCosta(GiocoNaufragioIsola GNI) {
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
        GNI.getStanze().add(costa);
        return costa;
    }

    public static Stanza inizializzaBosco(GiocoNaufragioIsola GNI) {
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
        GNI.getStanze().add(bosco);
        return bosco;
    }

    public static Stanza inizializzaSentiero(GiocoNaufragioIsola GNI){
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
        GNI.getStanze().add(sentiero);
        return sentiero;
    }

    public static Stanza inizializzaCovo(GiocoNaufragioIsola GNI) {
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
        GNI.getStanze().add(covo);
        return covo;
    }

    public static Stanza inizializzaEdificioDentro(GiocoNaufragioIsola GNI){
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
        GNI.getStanze().add(edificioDentro);
        return edificioDentro;
    }

    public static Stanza inizializzaEdificioFuori(GiocoNaufragioIsola GNI){
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
        GNI.getStanze().add(edificioFuori);
        return edificioFuori;
    }

    public static Stanza inizializzaGrotta(GiocoNaufragioIsola GNI){
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
        GNI.getStanze().add(grotta);
        return grotta;
    }


}
