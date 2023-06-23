/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.messaggi.MessaggioApprodo;
import di.uniba.map.b.adventure.messaggi.MessaggioBosco;
import di.uniba.map.b.adventure.messaggi.MessaggioCosta;
import di.uniba.map.b.adventure.messaggi.MessaggioCovo;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioDentro;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioFuori;
import di.uniba.map.b.adventure.messaggi.MessaggioGrotta;
import di.uniba.map.b.adventure.messaggi.MessaggioSentiero;

import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.OggettoContenitore;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;
import java.io.PrintStream;

/**
 * ATTENZIONE: La descrizione del gioco è fatta in modo che qualsiasi gioco
 * debba estendere la classe GameDescription. L'Engine è fatto in modo che possa
 * eseguire qualsiasi gioco che estende GameDescription, in questo modo si
 * possono creare più gioci utilizzando lo stesso Engine.
 *
 * Diverse migliorie possono essere applicate: - la descrizione del gioco
 * potrebbe essere caricate da file o da DBMS in modo da non modificare il
 * codice sorgente - l'utilizzo di file e DBMS non è semplice poiché all'interno
 * del file o del DBMS dovrebbe anche essere codificata la logica del gioco
 * (nextMove) oltre alla descrizione di stanze, oggetti, ecc...
 *
 * @author pierpaolo
 */
public class GiocoNaufragioIsola extends GameDescription {
    @Override
    public void init() throws Exception {
        //Comandi per spostarsi nella mappa
        Comando nord = new Comando(TipoComando.NORD, "nord");
        nord.setAlias(new String[]{"Nord", "NORD"});
        getCommands().add(nord);

        Comando sud = new Comando(TipoComando.SUD, "sud");
        sud.setAlias(new String[]{"Sud", "SUD"});
        getCommands().add(sud);

        Comando est = new Comando(TipoComando.EST, "est");
        est.setAlias(new String[]{"Est", "EST"});
        getCommands().add(est);

        Comando ovest = new Comando(TipoComando.OVEST, "ovest");
        ovest.setAlias(new String[]{"Ovest", "OVEST"});
        getCommands().add(ovest);

        //Comando per inventario
        Comando inventario = new Comando(TipoComando.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv"});
        getCommands().add(inventario);

        //Comando per osservare
        Comando osserva = new Comando(TipoComando.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        getCommands().add(osserva);

        //Comando per raccogliere
        Comando raccogli = new Comando(TipoComando.RACCOGLI, "raccogli");
        raccogli.setAlias(new String[]{"prendi"});
        getCommands().add(raccogli);

        //Comando per aprire
        Comando apri = new Comando(TipoComando.APRI, "apri");
        apri.setAlias(new String[]{});
        getCommands().add(apri);

        //Comando per premere
        Comando premi = new Comando(TipoComando.PREMI, "premi");
        premi.setAlias(new String[]{"spingi", "attiva"});
        getCommands().add(premi);

        //Comando per accendere
        Comando accendi = new Comando(TipoComando.ACCENDI, "accendi");
        accendi.setAlias(new String[]{"illumina"});
        getCommands().add(accendi);

        //Comando per utilizzare
        Comando utilizza = new Comando(TipoComando.UTILIZZA, "utilizza");
        utilizza.setAlias(new String[]{"usa"});
        getCommands().add(utilizza);

        //Comando per terminare
        Comando end = new Comando(TipoComando.FINE, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
        getCommands().add(end);

        //Comando per lasciare
        Comando lascia = new Comando(TipoComando.LASCIA, "lascia");
        lascia.setAlias(new String[]{"togli", "butta", "abbandona","posa"});
        getCommands().add(lascia);


        //Istanziazione stanza approdo
        Stanza approdo = new Stanza(0, MessaggioApprodo.getNome());
        //Imposto la descrizione corta della stanza
        approdo.setDescrizioneCortaStanza(MessaggioApprodo.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        approdo.setDescrizioneCompletaStanza(MessaggioApprodo.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        approdo.setOsserva(MessaggioApprodo.getOsserva());
        //Imposto la visibilita della stanza
        approdo.setVisibile(true);
        //Imposto il messaggio per Nord
        approdo.setMessaggioNord(MessaggioApprodo.getNord());
        //Imposto il messaggio per Sud
        approdo.setMessaggioSud(MessaggioApprodo.getNoSud());
        //Imposto il messaggio per Est
        approdo.setMessaggioEst(MessaggioApprodo.getNoEst());
        //Imposto il messaggio per Ovest
        approdo.setMessaggioOvest(MessaggioApprodo.getOvest());
        //Aggiungo la stanza
        getRooms().add(approdo);

        // TODO Aggiungere i messaggi di output
        //Istanziazione stanza costa
        Stanza costa = new Stanza(1, MessaggioCosta.getNome());
        //Imposto la descrizione corta della stanza
        costa.setDescrizioneCortaStanza(MessaggioCosta.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        costa.setDescrizioneCompletaStanza(MessaggioCosta.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        costa.setOsserva(MessaggioCosta.getOsserva());
        //Imposto la visibilita della stanza
        costa.setVisibile(true);
        //Imposto il messaggio per Nord
        costa.setMessaggioNord(MessaggioCosta.getNoNord());
        //Imposto il messaggio per Sud
        costa.setMessaggioSud(MessaggioCosta.getSud());
        //Imposto il messaggio per Est
        costa.setMessaggioEst(MessaggioCosta.getNoEst());
        //Imposto il messaggio per Ovest
        costa.setMessaggioOvest(MessaggioCosta.getOvest());
        //Aggiungo la stanza
        getRooms().add(costa);

        //Istanziazione stanza bosco
        Stanza bosco = new Stanza(2, MessaggioBosco.getNome());
        //Imposto la descrizione corta della stanza
        bosco.setDescrizioneCortaStanza(MessaggioBosco.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        bosco.setDescrizioneCompletaStanza(MessaggioBosco.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        bosco.setOsserva(MessaggioBosco.getOsserva());
        //Imposto la visibilita della stanza
        bosco.setVisibile(true);
        //Imposto il messaggio per Nord
        bosco.setMessaggioNord(MessaggioBosco.getNord());
        //Imposto il messaggio per Sud
        bosco.setMessaggioSud(MessaggioBosco.getNoSud());
        //Imposto il messaggio per Est
        bosco.setMessaggioEst(MessaggioBosco.getEst());
        //Imposto il messaggio per Ovest
        bosco.setMessaggioOvest(MessaggioBosco.getOvest());
        //Aggiungo la stanza
        getRooms().add(bosco);

        //Istanziazione stanza covo
        Stanza covo = new Stanza(3, MessaggioCovo.getNome());
        ///Imposto la descrizione corta della stanza
        covo.setDescrizioneCortaStanza(MessaggioCovo.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        covo.setDescrizioneCompletaStanza(MessaggioCovo.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        covo.setOsserva(MessaggioCovo.getOsserva());
        //Imposto la visibilita della stanza
        covo.setVisibile(true);
        //Imposto il messaggio per Nord
        covo.setMessaggioNord(MessaggioCovo.getNoNord());
        //Imposto il messaggio per Sud
        covo.setMessaggioSud(MessaggioCovo.getSud());
        //Imposto il messaggio per Est
        covo.setMessaggioEst(MessaggioCovo.getNoEst());
        //Imposto il messaggio per Ovest
        covo.setMessaggioOvest(MessaggioCovo.getNoOvest());
        //Aggiungo la stanza
        getRooms().add(covo);

        //Istanziazione stanza edificioDentro
        Stanza edificioDentro = new Stanza(4, MessaggioEdificioDentro.getNome());
        ///Imposto la descrizione corta della stanza
        edificioDentro.setDescrizioneCortaStanza(MessaggioEdificioDentro.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        edificioDentro.setDescrizioneCompletaStanza(MessaggioEdificioDentro.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        edificioDentro.setOsserva(MessaggioEdificioDentro.getOsserva());
        //Imposto la visibilita della stanza
        edificioDentro.setVisibile(true);
        //Imposto il messaggio per Nord
        edificioDentro.setMessaggioNord(MessaggioEdificioDentro.getNoNord());
        //Imposto il messaggio per Sud
        edificioDentro.setMessaggioSud(MessaggioEdificioDentro.getSud());
        //Imposto il messaggio per Est
        edificioDentro.setMessaggioEst(MessaggioEdificioDentro.getNoEst());
        //Imposto il messaggio per Ovest
        edificioDentro.setMessaggioOvest(MessaggioEdificioDentro.getNoOvest());
        //Aggiungo la stanza
        getRooms().add(edificioDentro);

        //Istanziazione stanza edificioFuori
        Stanza edificioFuori = new Stanza(5, MessaggioEdificioFuori.getNome());
        ///Imposto la descrizione corta della stanza
        edificioFuori.setDescrizioneCortaStanza(MessaggioEdificioFuori.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        edificioFuori.setDescrizioneCompletaStanza(MessaggioEdificioFuori.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        edificioFuori.setOsserva(MessaggioEdificioFuori.getOsserva());
        //Imposto la visibilita della stanza
        edificioFuori.setVisibile(true);
        //Imposto il messaggio per Nord
        edificioFuori.setMessaggioNord(MessaggioEdificioFuori.getNoNord());
        //Imposto il messaggio per Sud
        edificioFuori.setMessaggioSud(MessaggioEdificioFuori.getSud());
        //Imposto il messaggio per Est
        edificioFuori.setMessaggioEst(MessaggioEdificioFuori.getNoEst());
        //Imposto il messaggio per Ovest
        edificioFuori.setMessaggioOvest(MessaggioEdificioFuori.getNoOvest());
        //Aggiungo la stanza
        getRooms().add(edificioFuori);

        //Istanziazione stanza grotta
        Stanza grotta = new Stanza(6, MessaggioGrotta.getGrottaNome());
        ///Imposto la descrizione corta della stanza
        grotta.setDescrizioneCortaStanza(MessaggioGrotta.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        grotta.setDescrizioneCompletaStanza(MessaggioGrotta.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        grotta.setOsserva(MessaggioGrotta.getOsservaBuio());
        //Imposto la visibilita della stanza
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
        getRooms().add(grotta);

        //Istanziazione stanza sentiero
        Stanza sentiero = new Stanza(7, MessaggioSentiero.getNome());
        ///Imposto la descrizione corta della stanza
        sentiero.setDescrizioneCortaStanza(MessaggioSentiero.getDescrizioneCorta());
        //Imposto la descrizione lunga della stanza
        sentiero.setDescrizioneCompletaStanza(MessaggioSentiero.getDescrizioneCompleta());
        //Imposto il messaggio di osserva
        sentiero.setOsserva(MessaggioSentiero.getOsserva());
        //Imposto la visibilita della stanza
        sentiero.setVisibile(true);
        //Imposto il messaggio per Nord
        sentiero.setMessaggioNord(MessaggioSentiero.getNord());
        //Imposto il messaggio per Sud
        sentiero.setMessaggioSud(MessaggioSentiero.getSud());
        //Imposto il messaggio per Est
        sentiero.setMessaggioEst(MessaggioSentiero.getEst());
        //Imposto il messaggio per Ovest
        sentiero.setMessaggioOvest(MessaggioSentiero.getNoOvest());
        //Aggiungo la stanza
        getRooms().add(sentiero);

        //Imposto la mappa

        //Mappa approdo
        approdo.setNord(costa);
        approdo.setSud(null);
        approdo.setEst(null);
        approdo.setOvest(bosco);

        //Mappa costa
        costa.setNord(null);
        costa.setSud(approdo);
        costa.setEst(null);
        costa.setOvest(sentiero);

        //Mappa bosco
        bosco.setNord(sentiero);
        bosco.setSud(null);
        bosco.setEst(approdo);
        bosco.setOvest(grotta);

        //Mappa covo
        covo.setNord(null);
        covo.setSud(edificioDentro);
        covo.setEst(null);
        covo.setOvest(null);

        //Mappa edificioDentro
        edificioDentro.setNord(covo);
        edificioDentro.setSud(edificioFuori);
        edificioDentro.setEst(null);
        edificioDentro.setOvest(null);

        //Mappa edificioFuori
        edificioFuori.setNord(edificioDentro);
        edificioFuori.setSud(sentiero);
        edificioFuori.setEst(null);
        edificioFuori.setOvest(null);

        //Mappa grotta
        grotta.setNord(null);
        grotta.setSud(null);
        grotta.setEst(bosco);
        grotta.setOvest(null);

        //Mappa sentiero
        sentiero.setNord(edificioFuori);
        sentiero.setSud(bosco);
        sentiero.setEst(costa);
        sentiero.setOvest(null);

        // TODO Creare classi per i messaggi e le stringhe degli oggetti

        //Istanziazione oggetto radio
        Oggetto radio = new Oggetto(0, "radio", "E' una vecchia radio a pile..."
                + "chissa se funzionera'...");
        radio.setAlias(new String[]{});
        costa.getObjects().add(radio);

        //Istanziazione oggetto batteria
        Oggetto batteria = new Oggetto(1, "batteria", "Un pacco di batterie, chissà se sono cariche.");
        batteria.setAlias(new String[]{"batterie", "pile", "pila"});
        edificioDentro.getObjects().add(batteria);

        //Cartina correnti marine
        Oggetto cartina = new Oggetto(2, "mappa", "Una antica cartina delle correnti.");
        cartina.setAlias(new String[]{"cartine", "carta", "cartina", "mappe","carte"});
        costa.getObjects().add(cartina);

        //Oggetto contenitore telecomando: contiene pile
        OggettoContenitore telecomando = new OggettoContenitore(3, "telecomando", "Un semplice telecomando.");
        telecomando.setAlias(new String[]{"telecomandi"});
        telecomando.setApribile(true);
        telecomando.setRaccogglibile(false);
        telecomando.setAperto(false);

        //Acciarino
        Oggetto acciarino = new Oggetto(4, "acciarino", "Un acciarino, potresti riscaldarti o darti fuoco.");
        acciarino.setAlias(new String[]{"accendino"});
        costa.getObjects().add(acciarino);

        //Lastra
        Oggetto lastra = new Oggetto(5, "lastra di pietra", "Una lastra incisa.");
        lastra.setAlias(new String[]{"pietra", "lastre", "pietre", "lastra pietra"});
        grotta.getObjects().add(lastra);

        //Lampada
        Oggetto lampada = new Oggetto(6, "lampada", "Una vecchia lampada ad olio.");
        lampada.setAlias(new String[]{"lampade", "lampadario", "lampadina", "lampadine", "luce", "luci"});
        bosco.getObjects().add(lampada);

        //Libro Cifrario
        Oggetto cifrario = new Oggetto(7, "cifrario", "Un libricino che spiega come decifrare"
                + "delle strane scritture.");
        cifrario.setAlias(new String[]{"libro","libri","cifrari"});
        costa.getObjects().add(cifrario);

        //Vela
        Oggetto vela = new Oggetto(8, "vela", "Una vela...");
        vela.setAlias(new String[]{});
        covo.getObjects().add(vela);

        //Accetta
        Oggetto accetta = new Oggetto(9, "accetta", "Un' accetta...");
        accetta.setAlias(new String[]{});
        covo.getObjects().add(accetta);

        //Corde
        Oggetto corda = new Oggetto(10, "corda", "Corda...");
        corda.setAlias(new String[]{"corde"});
        corda.setAlias(new String[]{});
        covo.getObjects().add(corda);

        //Fucile
        Oggetto fucile = new Oggetto(11, "fucile", "Un fucile...");
        fucile.setAlias(new String[]{"arma"});
        covo.getObjects().add(fucile);

        setCurrentRoom(approdo);
    }


    /* nextMove per scrivere su editor del frame */
    @Override
    public void nextMove(final ParserOutput p, final PrintStream out, final JFrameApp frame) {
        boolean noroom = false;
        boolean move = false;
        //frame.writeTextOnEditor("\n"+getCurrentRoom().getNomeStanza()+"\n");
        frame.writeTextOnEditor("\n\n");
        if (p.getCommand() == null) {
            frame.writeTextOnEditor("Non ho capito cosa devo fare! Prova con un altro comando.\n");
        } else {
            TipoComando comandoRiconosciuto = p.getCommand().getTipoComando();
            //move
            switch (comandoRiconosciuto) {
                case NORD:
                    //frame.writeTextOnEditor("\n=====NORD=====\n");
                    frame.writeTextOnEditor(getCurrentRoom().getMessaggioNord());
                    frame.writeTextOnEditor("\n");
                    if (getCurrentRoom().getNord() != null && getCurrentRoom().getNord().getVisibile()) {
                        setCurrentRoom(getCurrentRoom().getNord());
                        frame.writeTextOnEditor(getCurrentRoom().getDescrizioneLungaStanza());
                        move = true;
                    } else {
                        noroom = true;
                    }
                    break;
                case SUD:
                    //frame.writeTextOnEditor("\n=====SUD=====\n");
                    frame.writeTextOnEditor(getCurrentRoom().getMessaggioSud());
                    frame.writeTextOnEditor("\n");
                    if (getCurrentRoom().getSud() != null && getCurrentRoom().getSud().getVisibile()) {
                        setCurrentRoom(getCurrentRoom().getSud());
                        frame.writeTextOnEditor(getCurrentRoom().getDescrizioneLungaStanza());
                        move = true;
                    } else {
                        noroom = true;
                    }
                    break;
                case EST:
                    //frame.writeTextOnEditor("\n=====EST=====\n");
                    frame.writeTextOnEditor(getCurrentRoom().getMessaggioEst());
                    frame.writeTextOnEditor("\n");
                    if (getCurrentRoom().getEst() != null && getCurrentRoom().getEst().getVisibile()) {
                        setCurrentRoom(getCurrentRoom().getEst());
                        frame.writeTextOnEditor(getCurrentRoom().getDescrizioneLungaStanza());
                        move = true;
                    } else {
                        noroom = true;
                    }
                    break;
                case OVEST:
                    //frame.writeTextOnEditor("\n=====OVEST=====\n");
                    frame.writeTextOnEditor(getCurrentRoom().getMessaggioOvest());
                    frame.writeTextOnEditor("\n");
                    if (getCurrentRoom().getOvest() != null && getCurrentRoom().getOvest().getVisibile()) {
                        setCurrentRoom(getCurrentRoom().getOvest());
                        frame.writeTextOnEditor(getCurrentRoom().getDescrizioneLungaStanza());
                        move = true;
                    } else {
                        noroom = true;
                    }
                    break;
                case OSSERVA:
                    frame.writeTextOnEditor(getCurrentRoom().getOsserva());
                    break;
                case INVENTARIO:
                    if (!getInventory().isEmpty()) {
                        frame.writeTextOnEditor("Nel tuo inventario ci sono:\n");
                        for (Oggetto oggettoInv : getInventory()) {
                            frame.writeTextOnEditor(oggettoInv.getNomeOggetto() + ": " + oggettoInv.getDescrizioneOggetto() + "\n");
                        }
                    }else {
                        frame.writeTextOnEditor("Il tuo inventario e' vuoto.");
                    }
                    break;
                case RACCOGLI:
                    if (p.getObject() != null) {
                        if (p.getObject().isRaccogglibile()) {
                            getInventory().add(p.getObject());
                            getCurrentRoom().getObjects().remove(p.getObject());
                            frame.writeTextOnEditor("Hai raccolto: " + p.getObject().getNomeOggetto());
                        } else {
                            frame.writeTextOnEditor("Non puoi raccogliere questo oggetto.");
                        }
                    } else {
                        frame.writeTextOnEditor("Non c'è niente da raccogliere qui.");
                    }
                    break;
                case LASCIA:
                    System.out.println("PIPPO"+p.getInvObject().getNomeOggetto());
                    if (p.getInvObject() != null){
                        //Se possiedo l'oggetto
                        if(getInventory().contains(p.getInvObject())){
                            getInventory().remove(p.getInvObject());
                            getCurrentRoom().getObjects().add(p.getInvObject());
                            frame.writeTextOnEditor("Hai lasciato: " + p.getInvObject().getNomeOggetto());
                        }else{
                            frame.writeTextOnEditor("Non possiedi questo oggetto.");
                        }
                    } else {
                        frame.writeTextOnEditor("Non capisco di che oggetto parli.");
                    }
            }
        }
    }




            /*
            } else if (p.getCommand().getTipoComando() == TipoComando.OSSERVA) {
                if (getCurrentRoom().getOsserva() != null) {
                    frame.writeTextOnEditor(getCurrentRoom().getOsserva()+"\n");
                    out.println(getCurrentRoom().getOsserva());
                } else {
                    frame.writeTextOnEditor("Non c'è niente di interessante qui.\n");
                    out.println("Non c'è niente di interessante qui.");
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.RACCOGLI) {

            } else if (p.getCommand().getTipoComando() == TipoComando.APRI) {
                ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                 * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                 * Potrebbe non esssere la soluzione ottimale.

                if (p.getObject() == null && p.getInvObject() == null) {
                    out.println("Non c'è niente da aprire qui.");
                    frame.writeTextOnEditor("Non c'è niente da aprire qui.\n");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isApribile() && p.getObject().isAperto() == false) {
                            if (p.getObject() instanceof OggettoContenitore) {
                                out.println("Hai aperto: " + p.getObject().getNomeOggetto());
                                frame.writeTextOnEditor("Hai aperto: " + p.getObject().getNomeOggetto()+"\n");
                                OggettoContenitore c = (OggettoContenitore) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getNomeOggetto() + " contiene:");
                                    frame.writeTextOnEditor(c.getNomeOggetto() + " contiene:\n");
                                    Iterator<Oggetto> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Oggetto next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        out.print(" " + next.getNomeOggetto());
                                        frame.writeTextOnEditor(" " + next.getNomeOggetto()+"\n");
                                        it.remove();
                                    }
                                    out.println();
                                    frame.writeTextOnEditor("\n");
                                }
                                p.getObject().setAperto(true);
                            } else {
                                out.println("Hai aperto: " + p.getObject().getNomeOggetto());
                                frame.writeTextOnEditor("Hai aperto: " + p.getObject().getNomeOggetto()+"\n");
                                p.getObject().setAperto(true);
                            }
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                            frame.writeTextOnEditor("Non puoi aprire questo oggetto.\n");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isApribile() && p.getInvObject().isAperto() == false) {
                            if (p.getInvObject() instanceof OggettoContenitore) {
                                OggettoContenitore c = (OggettoContenitore) p.getInvObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getNomeOggetto() + " contiene:");
                                    frame.writeTextOnEditor(c.getNomeOggetto() + " contiene:"+"\n");
                                    Iterator<Oggetto> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Oggetto next = it.next();
                                        getInventory().add(next);
                                        out.print(" " + next.getNomeOggetto());
                                        frame.writeTextOnEditor(" " + next.getNomeOggetto()+"\n");
                                        it.remove();
                                    }
                                    out.println();
                                    frame.writeTextOnEditor("\n");
                                }
                                p.getInvObject().setAperto(true);
                            } else {
                                p.getInvObject().setAperto(true);
                            }
                            out.println("Hai aperto nel tuo inventario: " + p.getInvObject().getNomeOggetto());
                            frame.writeTextOnEditor("Hai aperto nel tuo inventario: " + p.getInvObject().getNomeOggetto()+"\n");
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                            frame.writeTextOnEditor("Non puoi aprire questo oggetto.\n");
                        }
                    }
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.PREMI) {
                //ricerca oggetti pushabili
                if (p.getObject() != null && p.getObject().isPremibile()) {
                    out.println("Hai premuto: " + p.getObject().getNomeOggetto());
                    frame.writeTextOnEditor("Hai premuto: " + p.getObject().getNomeOggetto()+"\n");
                    if (p.getObject().getIdOggetto() == 3) {
                        end(out);
                    }
                } else if (p.getInvObject() != null && p.getInvObject().isPremibile()) {
                    out.println("Hai premuto: " + p.getInvObject().getNomeOggetto());
                    frame.writeTextOnEditor("Hai premuto: " + p.getInvObject().getNomeOggetto()+"\n");
                    if (p.getInvObject().getIdOggetto() == 3) {
                        end(out);
                    }
                } else {
                    out.println("Non ci sono oggetti che puoi premere qui.");
                    frame.writeTextOnEditor("Non ci sono oggetti che puoi premere qui.\n");
                }
            }
            if (noroom) {
                out.println("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...");
                frame.writeTextOnEditor("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...\n");
            } else if (move) {
                out.println(getCurrentRoom().getNord());
                frame.writeTextOnEditor(getCurrentRoom().getNomeStanza()+"\n");
                out.println("================================================");
                frame.writeTextOnEditor("================================================\n");
                out.println(getCurrentRoom().getDescrizioneLungaStanza());
                frame.writeTextOnEditor(getCurrentRoom().getDescrizioneLungaStanza()+"\n");
           }
    */



    private void end(PrintStream out) {
        out.println("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
        System.exit(0);
    }

}
