/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.games;

import data.FileMatchController;
import data.Suono;
import di.uniba.map.b.adventure.messaggi.*;

import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.OggettoContenitore;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

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
public class GiocoNaufragioIsola extends GameDescription{
    @Override
    public void init() throws Exception {
        //Comandi per spostarsi nella mappa
        ControlComandi.initComandi(this);

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
        covo.setRaggiungibile(true);
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
        Set<Comando> set = new HashSet<>();
        Set<Comando> set1 = new HashSet<>();
        Set<Comando> set2 = new HashSet<>();
        Set<Comando> set4 = new HashSet<>();
        Set<Comando> set5 = new HashSet<>();
        Set<Comando> set6 = new HashSet<>();
        Set<Comando> set7 = new HashSet<>();
        Set<Comando> set8 = new HashSet<>();
        Set<Comando> set9 = new HashSet<>();
        Set<Comando> set10 = new HashSet<>();
        Set<Comando> set11 = new HashSet<>();
        Set<Comando> set3 = new HashSet<>();
        //Istanziazione oggetto radio
        Oggetto radio = new Oggetto(0, "radio", MessaggioOggetti.getDescrzioneRadio());
        radio.setAlias(new String[]{});
        radio.setVisibile(true);
        set.add(this.getComando("utilizza"));
        set.add(this.getComando("lascia"));
        radio.setComandiConsentiti(set);
        costa.getObjects().add(radio);

        //Istanziazione oggetto batteria
        Oggetto batteria = new Oggetto(1, "batteria", MessaggioOggetti.getDescrizionePile());
        batteria.setAlias(new String[]{"batterie", "pile", "pila"});
        batteria.setComandiConsentiti(set);
        edificioDentro.getObjects().add(batteria);

        //Cartina correnti marine
        Oggetto cartina = new Oggetto(2, "mappa", MessaggioOggetti.getDescrizioneMappa());
        cartina.setAlias(new String[]{"cartine", "carta", "cartina", "mappe","carte"});
        cartina.setVisibile(true);
        set1.add(this.getComando("lascia"));
        cartina.setComandiConsentiti(set1);
        costa.getObjects().add(cartina);

        //Oggetto contenitore telecomando: contiene pile
        OggettoContenitore telecomando = new OggettoContenitore(3, "telecomando", MessaggioOggetti.getDescrizioneTelecomando());
        telecomando.setAlias(new String[]{"telecomandi"});
        telecomando.setApribile(true);
        telecomando.setRaccogglibile(true);
        telecomando.setAperto(false);
        telecomando.setVisibile(true);
        set2.add(this.getComando("apri"));
        set2.add(this.getComando("lascia"));
        telecomando.setComandiConsentiti(set2);
        edificioDentro.getObjects().add(telecomando);

        //Acciarino
        Oggetto acciarino = new Oggetto(4, "acciarino", MessaggioOggetti.getDescrizioneAcciarino());
        acciarino.setAlias(new String[]{"accendino"});
        acciarino.setVisibile(true);
        set3.add(this.getComando("accendi"));
        set3.add(this.getComando("lascia"));
        acciarino.setComandiConsentiti(set3);
        costa.getObjects().add(acciarino);

        //Lastra
        Oggetto lastra = new Oggetto(5, "lastra", MessaggioOggetti.getDescrizioneLastra());
        lastra.setAlias(new String[]{"pietra", "lastre", "pietre", "lastra pietra","lastra"});
        lastra.setVisibile(false);
        lastra.setRaccogglibile(false);
        lastra.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliLastra());
        set4.add(this.getComando("leggi"));
        lastra.setComandiConsentiti(set4);
        grotta.getObjects().add(lastra);

        //Lampada
        Oggetto lampada = new Oggetto(6, "lampada", MessaggioOggetti.getDescrizioneLampada());
        lampada.setAlias(new String[]{"lampade", "lampadario", "lampadina", "lampadine", "luce", "luci"});
        lampada.setVisibile(true);
        lampada.setComandiConsentiti(set3);
        bosco.getObjects().add(lampada);

        //Libro Cifrario
        Oggetto cifrario = new Oggetto(7, "cifrario", MessaggioOggetti.getDescrizioneCifrario());
        cifrario.setAlias(new String[]{"libro","libri","cifrari"});
        cifrario.setVisibile(true);
        batteria.setComandiConsentiti(set);
        set5.add(this.getComando("leggi"));
        set5.add(this.getComando("lascia"));
        cifrario.setComandiConsentiti(set5);
        costa.getObjects().add(cifrario);

        //Vela
        Oggetto vela = new Oggetto(8, "vela", MessaggioOggetti.getDescrizioneVela());
        vela.setAlias(new String[]{});
        vela.setVisibile(true);
        set6.add(this.getComando("costruisci"));
        set6.add(this.getComando("lascia"));
        vela.setComandiConsentiti(set6);
        covo.getObjects().add(vela);

        //Accetta
        Oggetto accetta = new Oggetto(9, "accetta", MessaggioOggetti.getDescrizioneAccetta());
        accetta.setAlias(new String[]{"ascia"});
        accetta.setVisibile(true);
        set7.add(this.getComando("taglia"));
        set7.add(this.getComando("lascia"));
        accetta.setComandiConsentiti(set7);
        covo.getObjects().add(accetta);

        //Corde
        Oggetto corda = new Oggetto(10, "corda",MessaggioOggetti.getDescrizioneCorda());
        corda.setAlias(new String[]{"corde"});
        corda.setVisibile(true);
        corda.setComandiConsentiti(set6);
        covo.getObjects().add(corda);

        //Fucile
        Oggetto fucile = new Oggetto(11, "fucile", MessaggioOggetti.getDescrizioneFucile());
        fucile.setAlias(new String[]{"arma"});
        fucile.setVisibile(true);
        fucile.setComandiConsentiti(set1);
        covo.getObjects().add(fucile);

        //Nave
        Oggetto barca = new Oggetto(12, "barca", MessaggioOggetti.getDescrizioneBarca());
        barca.setAlias(new String[]{"barchetta","nave","relitto"});
        barca.setVisibile(true);
        barca.setRaccogglibile(false);
        barca.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliBarca());
        barca.setComandiConsentiti(set11);
        costa.getObjects().add(barca);

        //cartello
        Oggetto cartello = new Oggetto(13, "cartello", MessaggioOggetti.getDescrizioneCartello());
        cartello.setAlias(new String[]{"insegna","scritta"});
        cartello.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliCartello());
        cartello.setVisibile(true);
        cartello.setRaccogglibile(false);
        cartello.setComandiConsentiti(set11);
        sentiero.getObjects().add(cartello);

        //Armadio
        Oggetto armadio = new Oggetto(14, "armadio", MessaggioOggetti.getDescrizioneArmadio());
        armadio.setAlias(new String[]{});
        armadio.setRaccogglibile(false);
        armadio.setVisibile(true);
        armadio.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliArmadio());
        set8.add(this.getComando("sposta"));
        armadio.setComandiConsentiti(set8);
        edificioDentro.getObjects().add(armadio);

        Oggetto tv = new Oggetto(15, "tv", MessaggioOggetti.getDescrizioneTv());
        tv.setAlias(new String[]{"televisione","tivvu","televisore"});
        tv.setRaccogglibile(false);
        tv.setVisibile(true);
        tv.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliTv());
        tv.setComandiConsentiti(set11);
        edificioDentro.getObjects().add(tv);

        Oggetto divano = new Oggetto(16, "divano", MessaggioOggetti.getDescrizioneDivano());
        divano.setAlias(new String[]{"poltrona", "sofa", "televisore"});
        divano.setRaccogglibile(false);
        divano.setVisibile(true);
        divano.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliDivano());
        divano.setComandiConsentiti(set11);
        edificioDentro.getObjects().add(divano);

        Oggetto albero = new Oggetto(17, "albero", MessaggioOggetti.getDescrizioneAlbero());
        albero.setAlias(new String[]{});
        albero.setRaccogglibile(false);
        albero.setVisibile(true);
        albero.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliAlbero());
        set9.add(this.getComando("taglia"));
        albero.setComandiConsentiti(set9);
        bosco.getObjects().add(albero);

        Oggetto legno = new Oggetto(18, "legno", MessaggioOggetti.getDescrizioneLegno());
        legno.setAlias(new String[]{"legname","legna"});
        legno.setRaccogglibile(true);
        legno.setVisibile(false);;
        set10.add(this.getComando("costruisci"));
        legno.setComandiConsentiti(set10);
        bosco.getObjects().add(legno);

        Oggetto zattera = new Oggetto(19, "zattera", MessaggioOggetti.getDescrizioneZattera());
        zattera.setAlias(new String[]{});
        zattera.setVisibile(false);
        zattera.setRaccogglibile(false);
        zattera.setComandiConsentiti(set11);
        approdo.getObjects().add(zattera);

        setCurrentRoom(approdo);
        //Suono.stopRiproduzione(getCurrentRoom().getNomeStanza());

        //Aggiungo tutti gli oggetti alla lista degli oggetti in game description
        getOggettiGioco().add(radio);
        getOggettiGioco().add(batteria);
        getOggettiGioco().add(cartina);
        getOggettiGioco().add(telecomando);
        getOggettiGioco().add(acciarino);
        getOggettiGioco().add(lastra);
        getOggettiGioco().add(lampada);
        getOggettiGioco().add(cifrario);
        getOggettiGioco().add(vela);
        getOggettiGioco().add(accetta);
        getOggettiGioco().add(corda);
        getOggettiGioco().add(fucile);
        getOggettiGioco().add(barca);
        getOggettiGioco().add(cartello);
        getOggettiGioco().add(armadio);
        getOggettiGioco().add(tv);
        getOggettiGioco().add(divano);
        getOggettiGioco().add(albero);
        getOggettiGioco().add(legno);
        getOggettiGioco().add(zattera);
    }


    /* nextMove per scrivere su editor del frame */
    @Override
    public void nextMove(final ParserOutput p, final PrintStream out, final JFrameApp frame,final JPanel panel) {
        boolean noroom = false;
        boolean move = false;
        //frame.writeTextOnEditor("\n"+getCurrentRoom().getNomeStanza()+"\n");
        frame.scrviSuEditor("\n\n");
        if (p.getCommand() == null) {
            frame.scrviSuEditor("Non ho capito cosa devo fare! Prova con un altro comando.\n");
        } else {
            TipoComando comandoRiconosciuto = p.getCommand().getTipoComando();
            //move
            switch (comandoRiconosciuto) {
                case NORD:
                    ControlGioco.ComandoNord(this,frame,panel);
                    break;
                case SUD:
                    ControlGioco.ComandoSud(this,frame);
                    break;
                case EST:
                    ControlGioco.ComandoEst(this,frame);
                    break;
                case OVEST:
                    ControlGioco.ComandoOvest(this,frame);
                    break;
                case OSSERVA: ;
                    ControlGioco.ComandoOsserva(this,frame,p.getObject(),p.getInvObject());
                    break;
                case INVENTARIO:
                    ControlGioco.ComandoInventario(this,frame);
                    break;
                case RACCOGLI:
                    ControlGioco.ComandoRaccogli(this,frame,p.getObject(),p.getInvObject());
                    break;
                case LASCIA:
                    ControlGioco.ComandoLascia(this,frame,p.getInvObject());
                    break;
                case NARRA:
                    frame.scrviSuEditor(getCurrentRoom().getDescrizioneLungaStanza());
                    break;
                case SALVA:
                    String workingDirectory = System.getProperty("user.dir");
                    String relativePath = "adventure/resources";
                    String fullPath = workingDirectory + File.separator + relativePath;
                    FileMatchController FMC = new FileMatchController("/salvataggioPartita", fullPath);
                    break;
                case ACCENDI:
                    ControlGioco.ComandoAccendi(this,frame,p.getInvObject());
                    break;
                case APRI:
                    ControlGioco.ComandoApri(this,frame,p.getInvObject());
                    break;
                case LEGGI:
                    ControlGioco.ComandoLeggi(frame,p.getInvObject(), p.getObject());
                    break;
                case FINE:
                    frame.scrviSuEditor("Non sei stato in grado di vincere?? Forse non sei un buon giocatore.");
                    System.exit(0);
                    break;
                case TAGLIA:
                    ControlGioco.ComandoTaglia(this,frame,p.getObject());
                    break;
                case COSTRUISCI:
                    ControlGioco.ComandoCostruisci(this,frame,p.getObject());
                    break;
                case AIUTO:
                    ControlGioco.ComandoAiuto(this,frame);
                    break;
            }

        }
        frame.scriviSuLabelStanza(frame.getEngine().getGame().getCurrentRoom().getNomeStanza());
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
