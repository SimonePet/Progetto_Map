package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.messaggi.*;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.OggettoContenitore;

import java.util.HashSet;
import java.util.Set;

public class InizializzaOggetti {

    private InizializzaOggetti() {
    }

    public static void initOggetti(GiocoNaufragioIsola GNI){
        InizializzaOggetti.initRadio(GNI);
        InizializzaOggetti.initBatteria(GNI);
        InizializzaOggetti.initCartina(GNI);
        InizializzaOggetti.initTelecomando(GNI);
        InizializzaOggetti.initAcciarino(GNI);
        InizializzaOggetti.initCifrario(GNI);
        InizializzaOggetti.initLampada(GNI);
        InizializzaOggetti.initLastra(GNI);
        InizializzaOggetti.initVela(GNI);
        InizializzaOggetti.initAccetta(GNI);
        InizializzaOggetti.initCorde(GNI);
        InizializzaOggetti.initFucile(GNI);
        InizializzaOggetti.initBarca(GNI);
        InizializzaOggetti.initCartello(GNI);
        InizializzaOggetti.initArmadio(GNI);
        InizializzaOggetti.initTv(GNI);
        InizializzaOggetti.initDivano(GNI);
        InizializzaOggetti.initAlbero(GNI);
        InizializzaOggetti.initLegno(GNI);
        InizializzaOggetti.initZattera(GNI);
        InizializzaOggetti.initBotola(GNI);

    }

    private static void initRadio(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto radio = new Oggetto(0, "radio", MessaggioOggetti.getDescrzioneRadio());
        radio.setAlias(new String[]{});
        radio.setVisibile(true);
        set.add(GNI.getComando("utilizza"));
        set.add(GNI.getComando("lascia"));
        radio.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCosta.getNome()).getObjects().add(radio);
        GNI.getOggettiGioco().add(radio);
    }

    private static void initBatteria(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto batteria = new Oggetto(1, "batteria", MessaggioOggetti.getDescrizionePile());
        batteria.setAlias(new String[]{"batterie", "pile", "pila"});
        set.add(GNI.getComando("utilizza"));
        set.add(GNI.getComando("lascia"));
        batteria.setComandiConsentiti(set);
        GNI.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(batteria);
        GNI.getOggettiGioco().add(batteria);
    }

    private static void initCartina(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto cartina = new Oggetto(2, "mappa", MessaggioOggetti.getDescrizioneMappa());
        cartina.setAlias(new String[]{"cartine", "carta", "cartina", "mappe", "carte"});
        cartina.setVisibile(true);
        set.add(GNI.getComando("lascia"));
        set.add(GNI.getComando("localizzazione"));
        cartina.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCosta.getNome()).getObjects().add(cartina);
        GNI.getOggettiGioco().add(cartina);
    }

    private static void initTelecomando(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        OggettoContenitore telecomando = new OggettoContenitore(3, "telecomando", MessaggioOggetti.getDescrizioneTelecomando());
        telecomando.setAlias(new String[]{"telecomandi"});
        telecomando.setApribile(true);
        telecomando.setRaccogglibile(true);
        telecomando.setAperto(false);
        telecomando.setVisibile(true);
        set.add(GNI.getComando("apri"));
        set.add(GNI.getComando("lascia"));
        telecomando.setComandiConsentiti(set);
        GNI.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(telecomando);
        GNI.getOggettiGioco().add(telecomando);
    }

    private static void initAcciarino(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto acciarino = new Oggetto(4, "acciarino", MessaggioOggetti.getDescrizioneAcciarino());
        acciarino.setAlias(new String[]{"accendino"});
        acciarino.setVisibile(true);
        set.add(GNI.getComando("accendi"));
        set.add(GNI.getComando("lascia"));
        acciarino.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCosta.getNome()).getObjects().add(acciarino);
        GNI.getOggettiGioco().add(acciarino);
    }

    private static void initLastra(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto lastra = new Oggetto(5, "lastra", MessaggioOggetti.getDescrizioneLastra());
        lastra.setAlias(new String[]{"pietra", "lastre", "pietre", "lastra pietra", "incisioni", "incisione"});
        lastra.setVisibile(false);
        lastra.setRaccogglibile(false);
        lastra.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliLastra());
        set.add(GNI.getComando("leggi"));
        lastra.setComandiConsentiti(set);
        GNI.getStanza(MessaggioGrotta.getGrottaNome()).getObjects().add(lastra);
        GNI.getOggettiGioco().add(lastra);
    }

    private static void initLampada(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto lampada = new Oggetto(6, "lampada", MessaggioOggetti.getDescrizioneLampada());
        lampada.setAlias(new String[]{"lampade", "lampadario", "lampadina", "lampadine", "luce", "luci"});
        lampada.setVisibile(true);
        set.add(GNI.getComando("accendi"));
        set.add(GNI.getComando("lascia"));
        lampada.setComandiConsentiti(set);
        GNI.getStanza(MessaggioBosco.getNome()).getObjects().add(lampada);
        GNI.getOggettiGioco().add(lampada);

    }

    private static void initCifrario(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto cifrario = new Oggetto(7, "cifrario", MessaggioOggetti.getDescrizioneCifrario());
        cifrario.setAlias(new String[]{"libro", "libri", "cifrari"});
        cifrario.setVisibile(true);
        set.add(GNI.getComando("leggi"));
        set.add(GNI.getComando("lascia"));
        cifrario.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCosta.getNome()).getObjects().add(cifrario);
        GNI.getOggettiGioco().add(cifrario);
    }

    private static void initVela(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto vela = new Oggetto(8, "vela", MessaggioOggetti.getDescrizioneVela());
        vela.setAlias(new String[]{});
        vela.setVisibile(true);
        set.add(GNI.getComando("costruisci"));
        set.add(GNI.getComando("lascia"));
        vela.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCovo.getNome()).getObjects().add(vela);
        GNI.getOggettiGioco().add(vela);
    }

    private static void initAccetta(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto accetta = new Oggetto(9, "accetta", MessaggioOggetti.getDescrizioneAccetta());
        accetta.setAlias(new String[]{"ascia"});
        accetta.setVisibile(true);
        set.add(GNI.getComando("taglia"));
        set.add(GNI.getComando("lascia"));
        accetta.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCovo.getNome()).getObjects().add(accetta);
        GNI.getOggettiGioco().add(accetta);
    }

    private static void initCorde(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto corda = new Oggetto(10, "corda", MessaggioOggetti.getDescrizioneCorda());
        corda.setAlias(new String[]{"corde"});
        corda.setVisibile(true);
        set.add(GNI.getComando("costruisci"));
        set.add(GNI.getComando("lascia"));
        corda.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCovo.getNome()).getObjects().add(corda);
        GNI.getOggettiGioco().add(corda);
    }

    private static void initFucile(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto fucile = new Oggetto(11, "fucile", MessaggioOggetti.getDescrizioneFucile());
        fucile.setAlias(new String[]{"arma"});
        fucile.setVisibile(true);
        set.add(GNI.getComando("lascia"));
        fucile.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCovo.getNome()).getObjects().add(fucile);
        GNI.getOggettiGioco().add(fucile);
    }

    private static void initBarca(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto barca = new Oggetto(12, "barca", MessaggioOggetti.getDescrizioneBarca());
        barca.setAlias(new String[]{"barchetta", "nave", "relitto", "carcassa", "imbarcazione"});
        barca.setVisibile(true);
        barca.setRaccogglibile(false);
        barca.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliBarca());
        barca.setComandiConsentiti(set);
        GNI.getStanza(MessaggioCosta.getNome()).getObjects().add(barca);
        GNI.getOggettiGioco().add(barca);

    }

    private static void initCartello(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto cartello = new Oggetto(13, "cartello", MessaggioOggetti.getDescrizioneCartello());
        cartello.setAlias(new String[]{"insegna", "scritta"});
        cartello.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliCartello());
        cartello.setVisibile(true);
        cartello.setRaccogglibile(false);
        cartello.setComandiConsentiti(set);
        GNI.getStanza(MessaggioSentiero.getNome()).getObjects().add(cartello);
        GNI.getOggettiGioco().add(cartello);
    }

    private static void initArmadio(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto armadio = new Oggetto(14, "armadio", MessaggioOggetti.getDescrizioneArmadio());
        armadio.setAlias(new String[]{});
        armadio.setRaccogglibile(false);
        armadio.setVisibile(true);
        armadio.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliArmadio());
        set.add(GNI.getComando("sposta"));
        armadio.setComandiConsentiti(set);
        GNI.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(armadio);
        GNI.getOggettiGioco().add(armadio);
    }

    private static void initTv(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto tv = new Oggetto(15, "tv", MessaggioOggetti.getDescrizioneTv());
        tv.setAlias(new String[]{"televisione", "tivvu", "televisore"});
        tv.setRaccogglibile(false);
        tv.setVisibile(true);
        tv.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliTv());
        tv.setComandiConsentiti(set);
        GNI.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(tv);
        GNI.getOggettiGioco().add(tv);
    }


    private static void initDivano(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto divano = new Oggetto(16, "divano", MessaggioOggetti.getDescrizioneDivano());
        divano.setAlias(new String[]{"poltrona", "sofa"});
        divano.setRaccogglibile(false);
        divano.setVisibile(true);
        divano.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliDivano());
        divano.setComandiConsentiti(set);
        GNI.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(divano);
        GNI.getOggettiGioco().add(divano);
    }

    private static void initAlbero(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto albero = new Oggetto(17, "albero", MessaggioOggetti.getDescrizioneAlbero());
        albero.setAlias(new String[]{"alberi", "legna", "tronco", "rami", "legname"});
        albero.setRaccogglibile(false);
        albero.setVisibile(true);
        albero.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliAlbero());
        set.add(GNI.getComando("taglia"));
        albero.setComandiConsentiti(set);
       GNI.getStanza(MessaggioBosco.getNome()).getObjects().add(albero);
        GNI.getOggettiGioco().add(albero);

    }

    private static void initLegno(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto legno = new Oggetto(18, "legno", MessaggioOggetti.getDescrizioneLegno());
        legno.setAlias(new String[]{"legname", "legna"});
        legno.setRaccogglibile(true);
        legno.setVisibile(false);
        set.add(GNI.getComando("costruisci"));
        legno.setComandiConsentiti(set);
        GNI.getStanza(MessaggioBosco.getNome()).getObjects().add(legno);
        GNI.getOggettiGioco().add(legno);

    }

    private static void initZattera(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto zattera = new Oggetto(19, "zattera", MessaggioOggetti.getDescrizioneZattera());
        zattera.setAlias(new String[]{});
        zattera.setVisibile(false);
        zattera.setRaccogglibile(false);
        zattera.setComandiConsentiti(set);
        GNI.getOggettiGioco().add(zattera);
    }

    private static void initBotola(GiocoNaufragioIsola GNI){
        Set<Comando> set = new HashSet<>();
        Oggetto botola = new Oggetto(19, "botola", MessaggioOggetti.getDescrizioneBotola());
        botola.setAlias(new String[]{"botole", "buco", "buchi"});
        botola.setRaccogglibile(false);
        botola.setComandiConsentiti(set);
        botola.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliBotola());
        GNI.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(botola);
        GNI.getOggettiGioco().add(botola);
    }


}
