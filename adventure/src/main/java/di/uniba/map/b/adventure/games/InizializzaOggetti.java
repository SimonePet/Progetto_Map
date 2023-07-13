package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.messaggi.MessaggioCovo;
import di.uniba.map.b.adventure.messaggi.MessaggioCosta;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioDentro;
import di.uniba.map.b.adventure.messaggi.MessaggioSentiero;
import di.uniba.map.b.adventure.messaggi.MessaggioGrotta;
import di.uniba.map.b.adventure.messaggi.MessaggioBosco;
import di.uniba.map.b.adventure.messaggi.MessaggioOggetti;

import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.OggettoContenitore;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Classe di inizializzazione degli oggetti del gioco "Naufragio sull'Isola".
 * Questa classe contiene metodi statici per inizializzare gli oggetti del gioco,
 * specificando le loro caratteristiche e aggiungendoli alla lista degli oggetti del gioco.
 */
public final class InizializzaOggetti {

    /**
     * Costruttore privato della classe InizializzaOggetti.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i metodi in questa classe sono statici e la classe è progettata per essere utilizzata come classe di utilità.
     * Fornisce metodi di inizializzazione per gli oggetti del gioco "Naufragio sull'Isola".
     * La classe non può essere istanziata o estesa.
     */
    private InizializzaOggetti() {
    }

    /**
     * Inizializza gli oggetti del gioco "Naufragio sull'Isola" specificando le caratteristiche di ciascun oggetto
     * e li aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere gli oggetti
     */
    public static void initOggetti(final GiocoNaufragioIsola gni) {
        InizializzaOggetti.initRadio(gni);
        InizializzaOggetti.initBatteria(gni);
        InizializzaOggetti.initCartina(gni);
        InizializzaOggetti.initTelecomando(gni);
        InizializzaOggetti.initAcciarino(gni);
        InizializzaOggetti.initCifrario(gni);
        InizializzaOggetti.initLampada(gni);
        InizializzaOggetti.initLastra(gni);
        InizializzaOggetti.initVela(gni);
        InizializzaOggetti.initAccetta(gni);
        InizializzaOggetti.initCorde(gni);
        InizializzaOggetti.initFucile(gni);
        InizializzaOggetti.initBarca(gni);
        InizializzaOggetti.initCartello(gni);
        InizializzaOggetti.initArmadio(gni);
        InizializzaOggetti.initTv(gni);
        InizializzaOggetti.initDivano(gni);
        InizializzaOggetti.initAlbero(gni);
        InizializzaOggetti.initLegno(gni);
        InizializzaOggetti.initZattera(gni);
        InizializzaOggetti.initBotola(gni);
    }

    /**
     * Inizializza l'oggetto "radio" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initRadio(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto radio = new Oggetto(0, "radio", MessaggioOggetti.getDescrzioneRadio());
        radio.setAlias(new String[]{});
        radio.setVisibile(true);
        set.add(gni.getComando("accendi"));
        set.add(gni.getComando("lascia"));
        radio.setComandiConsentiti(set);
        gni.getStanza(MessaggioCosta.getNome()).getObjects().add(radio);
        gni.getOggettiGioco().add(radio);
    }
    /**
     * Inizializza l'oggetto "batteria" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initBatteria(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto batteria = new Oggetto(1, "batteria", MessaggioOggetti.getDescrizionePile());
        batteria.setAlias(new String[]{"batterie", "pile", "pila"});
        set.add(gni.getComando("lascia"));
        batteria.setComandiConsentiti(set);
        gni.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(batteria);
        gni.getOggettiGioco().add(batteria);
    }
    /**
     * Inizializza l'oggetto "cartina" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initCartina(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto cartina = new Oggetto(2, "mappa", MessaggioOggetti.getDescrizioneMappa());
        cartina.setAlias(new String[]{"cartine", "carta", "cartina", "mappe", "carte"});
        cartina.setVisibile(true);
        set.add(gni.getComando("lascia"));
        set.add(gni.getComando("localizzazione"));
        cartina.setComandiConsentiti(set);
        gni.getStanza(MessaggioCosta.getNome()).getObjects().add(cartina);
        gni.getOggettiGioco().add(cartina);
    }

    /**
     * Inizializza l'oggetto "telecomando" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initTelecomando(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        OggettoContenitore telecomando = new OggettoContenitore(3, "telecomando", MessaggioOggetti.getDescrizioneTelecomando());
        telecomando.setAlias(new String[]{"telecomandi"});
        telecomando.setApribile(true);
        telecomando.setRaccogglibile(true);
        telecomando.setAperto(false);
        telecomando.setVisibile(true);
        set.add(gni.getComando("apri"));
        set.add(gni.getComando("lascia"));
        telecomando.setComandiConsentiti(set);
        gni.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(telecomando);
        gni.getOggettiGioco().add(telecomando);
    }

    /**
     * Inizializza l'oggetto "acciarino" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initAcciarino(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto acciarino = new Oggetto(4, "acciarino", MessaggioOggetti.getDescrizioneAcciarino());
        acciarino.setAlias(new String[]{"accendino"});
        acciarino.setVisibile(true);
        set.add(gni.getComando("accendi"));
        set.add(gni.getComando("lascia"));
        acciarino.setComandiConsentiti(set);
        gni.getStanza(MessaggioCosta.getNome()).getObjects().add(acciarino);
        gni.getOggettiGioco().add(acciarino);
    }

    /**
     * Inizializza l'oggetto "lastra" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initLastra(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto lastra = new Oggetto(5, "lastra", MessaggioOggetti.getDescrizioneLastra());
        lastra.setAlias(new String[]{"pietra", "lastre", "pietre", "lastra pietra", "incisioni", "incisione"});
        lastra.setVisibile(false);
        lastra.setRaccogglibile(false);
        lastra.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliLastra());
        set.add(gni.getComando("leggi"));
        lastra.setComandiConsentiti(set);
        gni.getStanza(MessaggioGrotta.getGrottaNome()).getObjects().add(lastra);
        gni.getOggettiGioco().add(lastra);
    }

    /**
     * Inizializza l'oggetto "lampada" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initLampada(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto lampada = new Oggetto(6, "lampada", MessaggioOggetti.getDescrizioneLampada());
        lampada.setAlias(new String[]{"lampade", "lampadario", "lampadina", "lampadine", "luce", "luci"});
        lampada.setVisibile(true);
        set.add(gni.getComando("accendi"));
        set.add(gni.getComando("lascia"));
        lampada.setComandiConsentiti(set);
        gni.getStanza(MessaggioBosco.getNome()).getObjects().add(lampada);
        gni.getOggettiGioco().add(lampada);

    }

    /**
     * Inizializza l'oggetto "cifrario" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initCifrario(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto cifrario = new Oggetto(7, "cifrario", MessaggioOggetti.getDescrizioneCifrario());
        cifrario.setAlias(new String[]{"libro", "libri", "cifrari"});
        cifrario.setVisibile(true);
        set.add(gni.getComando("leggi"));
        set.add(gni.getComando("lascia"));
        cifrario.setComandiConsentiti(set);
        gni.getStanza(MessaggioCosta.getNome()).getObjects().add(cifrario);
        gni.getOggettiGioco().add(cifrario);
    }

    /**
     * Inizializza l'oggetto "vela" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initVela(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto vela = new Oggetto(8, "vela", MessaggioOggetti.getDescrizioneVela());
        vela.setAlias(new String[]{});
        vela.setVisibile(true);
        set.add(gni.getComando("costruisci"));
        set.add(gni.getComando("lascia"));
        vela.setComandiConsentiti(set);
        gni.getStanza(MessaggioCovo.getNome()).getObjects().add(vela);
        gni.getOggettiGioco().add(vela);
    }

    /**
     * Inizializza l'oggetto "accetta" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initAccetta(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto accetta = new Oggetto(9, "accetta", MessaggioOggetti.getDescrizioneAccetta());
        accetta.setAlias(new String[]{"ascia"});
        accetta.setVisibile(true);
        set.add(gni.getComando("taglia"));
        set.add(gni.getComando("lascia"));
        accetta.setComandiConsentiti(set);
        gni.getStanza(MessaggioCovo.getNome()).getObjects().add(accetta);
        gni.getOggettiGioco().add(accetta);
    }
    /**
     * Inizializza l'oggetto "corde" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initCorde(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto corda = new Oggetto(10, "corda", MessaggioOggetti.getDescrizioneCorda());
        corda.setAlias(new String[]{"corde"});
        corda.setVisibile(true);
        set.add(gni.getComando("costruisci"));
        set.add(gni.getComando("lascia"));
        corda.setComandiConsentiti(set);
        gni.getStanza(MessaggioCovo.getNome()).getObjects().add(corda);
        gni.getOggettiGioco().add(corda);
    }

    /**
     * Inizializza l'oggetto "fucile" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initFucile(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto fucile = new Oggetto(11, "fucile", MessaggioOggetti.getDescrizioneFucile());
        fucile.setAlias(new String[]{"arma"});
        fucile.setVisibile(true);
        set.add(gni.getComando("lascia"));
        fucile.setComandiConsentiti(set);
        gni.getStanza(MessaggioCovo.getNome()).getObjects().add(fucile);
        gni.getOggettiGioco().add(fucile);
    }

    /**
     * Inizializza l'oggetto "barca" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initBarca(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto barca = new Oggetto(12, "barca", MessaggioOggetti.getDescrizioneBarca());
        barca.setAlias(new String[]{"barchetta", "nave", "relitto", "carcassa", "imbarcazione"});
        barca.setVisibile(true);
        barca.setRaccogglibile(false);
        barca.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliBarca());
        barca.setComandiConsentiti(set);
        gni.getStanza(MessaggioCosta.getNome()).getObjects().add(barca);
        gni.getOggettiGioco().add(barca);

    }

    /**
     * Inizializza l'oggetto "cartello" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initCartello(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto cartello = new Oggetto(13, "cartello", MessaggioOggetti.getDescrizioneCartello());
        cartello.setAlias(new String[]{"insegna", "scritta"});
        cartello.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliCartello());
        cartello.setVisibile(true);
        cartello.setRaccogglibile(false);
        cartello.setComandiConsentiti(set);
        gni.getStanza(MessaggioSentiero.getNome()).getObjects().add(cartello);
        gni.getOggettiGioco().add(cartello);
    }

    /**
     * Inizializza l'oggetto "armadio" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initArmadio(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto armadio = new Oggetto(14, "armadio", MessaggioOggetti.getDescrizioneArmadio());
        armadio.setAlias(new String[]{});
        armadio.setRaccogglibile(false);
        armadio.setVisibile(true);
        armadio.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliArmadio());
        set.add(gni.getComando("sposta"));
        armadio.setComandiConsentiti(set);
        gni.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(armadio);
        gni.getOggettiGioco().add(armadio);
    }

    /**
     * Inizializza l'oggetto "tv" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initTv(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto tv = new Oggetto(15, "tv", MessaggioOggetti.getDescrizioneTv());
        tv.setAlias(new String[]{"televisione", "tivvu", "televisore"});
        tv.setRaccogglibile(false);
        tv.setVisibile(true);
        tv.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliTv());
        tv.setComandiConsentiti(set);
        gni.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(tv);
        gni.getOggettiGioco().add(tv);
    }

    /**
     * Inizializza l'oggetto "divano" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initDivano(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto divano = new Oggetto(16, "divano", MessaggioOggetti.getDescrizioneDivano());
        divano.setAlias(new String[]{"poltrona", "sofa"});
        divano.setRaccogglibile(false);
        divano.setVisibile(true);
        divano.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliDivano());
        divano.setComandiConsentiti(set);
        gni.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(divano);
        gni.getOggettiGioco().add(divano);
    }

    /**
     * Inizializza l'oggetto "albero" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initAlbero(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto albero = new Oggetto(17, "albero", MessaggioOggetti.getDescrizioneAlbero());
        albero.setAlias(new String[]{"alberi", "legna", "tronco", "rami", "legname"});
        albero.setRaccogglibile(false);
        albero.setVisibile(true);
        albero.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliAlbero());
        set.add(gni.getComando("taglia"));
        albero.setComandiConsentiti(set);
        gni.getStanza(MessaggioBosco.getNome()).getObjects().add(albero);
        gni.getOggettiGioco().add(albero);

    }

    /**
     * Inizializza l'oggetto "legno" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initLegno(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto legno = new Oggetto(18, "legno", MessaggioOggetti.getDescrizioneLegno());
        legno.setAlias(new String[]{"legname", "legna"});
        legno.setRaccogglibile(true);
        legno.setVisibile(false);
        set.add(gni.getComando("costruisci"));
        legno.setComandiConsentiti(set);
        gni.getStanza(MessaggioBosco.getNome()).getObjects().add(legno);
        gni.getOggettiGioco().add(legno);

    }

    /**
     * Inizializza l'oggetto "zattera" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initZattera(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto zattera = new Oggetto(19, "zattera", MessaggioOggetti.getDescrizioneZattera());
        zattera.setAlias(new String[]{});
        zattera.setVisibile(false);
        zattera.setRaccogglibile(false);
        zattera.setComandiConsentiti(set);
        gni.getOggettiGioco().add(zattera);
    }

    /**
     * Inizializza l'oggetto "botola" e lo aggiunge alla lista degli oggetti del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola" a cui aggiungere l'oggetto
     */
    private static void initBotola(final GiocoNaufragioIsola gni) {
        Set<Comando> set = new HashSet<>();
        Oggetto botola = new Oggetto(19, "botola", MessaggioOggetti.getDescrizioneBotola());
        botola.setAlias(new String[]{"botole", "buco", "buchi"});
        botola.setRaccogglibile(false);
        botola.setComandiConsentiti(set);
        botola.setDescrizioneRaccogli(MessaggioOggetti.getRaccogliBotola());
        gni.getStanza(MessaggioEdificioDentro.getNome()).getObjects().add(botola);
        gni.getOggettiGioco().add(botola);
    }
}
