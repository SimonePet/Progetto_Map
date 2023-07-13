package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;

/**
 * La classe InizializzaComandi fornisce metodi statici per inizializzare i comandi del gioco "Naufragio sull'Isola".
 * Ogni metodo inizializza un singolo comando specificando le azioni associate a esso e lo aggiunge alla lista dei comandi del gioco.
 */

public final class InizializzaComandi {

    /**
     * Costruttore privato senza argomenti.
     * Questo costruttore impedisce l'istanziazione della classe, in quanto tutti i suoi metodi sono statici e non richiedono un'istanza separata.
     */
    private InizializzaComandi() {
    }

    /**
     * Inizializza i comandi del gioco specificando le azioni associate a ciascun comando.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    public static void initComandi(final GiocoNaufragioIsola gni) {
        InizializzaComandi.initNord(gni);
        InizializzaComandi.initSud(gni);
        InizializzaComandi.initEst(gni);
        InizializzaComandi.initOvest(gni);
        InizializzaComandi.initAcced(gni);
        InizializzaComandi.initInventario(gni);
        InizializzaComandi.initOsserva(gni);
        InizializzaComandi.initRaccogli(gni);
        InizializzaComandi.initApri(gni);
        InizializzaComandi.initSposta(gni);
        InizializzaComandi.initLascia(gni);
        InizializzaComandi.initNarra(gni);
        InizializzaComandi.initLeggi(gni);
        InizializzaComandi.initTaglia(gni);
        InizializzaComandi.initCostruisci(gni);
        InizializzaComandi.initAiuto(gni);
        InizializzaComandi.initLocalizzazione(gni);
        InizializzaComandi.initFine(gni);
        InizializzaComandi.initRipara(gni);
    }

    /**
     * Inizializza il comando "NORD" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "NORD" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initNord(final GiocoNaufragioIsola gni) {
        Comando nord = new Comando(TipoComando.NORD, "nord");
        nord.setAlias(new String[]{"Nord", "NORD"});
        nord.setDescrizione("Nord :\t\t Comando che ti permette di spostarti a nord rispetto alla tua posizione;");
        gni.getComandi().add(nord);
    }

    /**
     * Inizializza il comando "SUD" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "SUD" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initSud(final GiocoNaufragioIsola gni) {
        Comando sud = new Comando(TipoComando.SUD, "sud");
        sud.setAlias(new String[]{"Sud", "SUD"});
        sud.setDescrizione("Sud :\t\t Comando che ti permette di spostarti a sud rispetto alla tua posizione;");
        gni.getComandi().add(sud);
    }

    /**
     * Inizializza il comando "EST" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "EST" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initEst(final GiocoNaufragioIsola gni) {
        Comando est = new Comando(TipoComando.EST, "est");
        est.setAlias(new String[]{"Est", "EST"});
        est.setDescrizione("Est :\t\t Comando che ti permette di spostarti a est rispetto alla tua posizione;");
        gni.getComandi().add(est);
    }

    /**
     * Inizializza il comando "OVEST" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "OVEST" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initOvest(final GiocoNaufragioIsola gni) {
        Comando ovest = new Comando(TipoComando.OVEST, "ovest");
        ovest.setAlias(new String[]{"Ovest", "OVEST"});
        ovest.setDescrizione("Ovest :\t\t Comando che ti permette di spostarti a ovest rispetto alla tua posizione;");
        gni.getComandi().add(ovest);
    }

    /**
     * Inizializza il comando "INVENTARIO" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "INVENTARIO" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initInventario(final GiocoNaufragioIsola gni) {
        Comando inventario = new Comando(TipoComando.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv"});
        inventario.setDescrizione("Inventario :\t\t Comando che ti permette di visualizzare gli oggetti nel tuo inventario;");
        gni.getComandi().add(inventario);
    }

    /**
     * Inizializza il comando "OSSERVA" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "OSSERVA" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */

    private static void initOsserva(final GiocoNaufragioIsola gni) {
        Comando osserva = new Comando(TipoComando.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        osserva.setDescrizione("Osserva :\t\t Comando che senza parametri di restituisce la descrizione della stanza in cui ti trovi;\n"
                + "Osserva [oggetto] :\t Comando che ti permette di osservare un oggetto, ovvero visualizzare la sua descrizione;");
        gni.getComandi().add(osserva);
    }

    /**
     * Inizializza il comando "RACCOGLI" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "RACCOGLI" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initRaccogli(final GiocoNaufragioIsola gni) {
        Comando raccogli = new Comando(TipoComando.RACCOGLI, "raccogli");
        raccogli.setAlias(new String[]{"prendi"});
        raccogli.setDescrizione("Raccogli [oggetto] :\t Comando che ti permette di raccogliere un oggetto ad aggiungerlo al tuo inventario;");
        gni.getComandi().add(raccogli);
    }

    /**
     * Inizializza il comando "APRI" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "APRI" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initApri(final GiocoNaufragioIsola gni) {
        Comando apri = new Comando(TipoComando.APRI, "apri");
        apri.setAlias(new String[]{"smonta"});
        apri.setDescrizione("Apri [oggetto_inv] :\t Comando che ti permette di aprire un oggetto;");
        gni.getComandi().add(apri);
    }

    /**
     * Inizializza il comando "SPOSTA" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "SPOSTA" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initSposta(final GiocoNaufragioIsola gni) {
        Comando sposta = new Comando(TipoComando.SPOSTA, "sposta");
        sposta.setAlias(new String[]{"spingi", "tira", "muovi"});
        sposta.setDescrizione("Premi [oggetto] :\t Comando che ti permette di premere un oggetto;");
        gni.getComandi().add(sposta);
    }

    /**
     * Inizializza il comando "ACCENDI" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "ACCENDI" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initAcced(final GiocoNaufragioIsola gni) {
        Comando accendi = new Comando(TipoComando.ACCENDI, "accendi");
        accendi.setAlias(new String[]{"illumina", "usa", "utilizza"});
        accendi.setDescrizione("Accendi [oggetto_inv] :\t Comando che ti permette di accendere un oggetto del tuo inventario;");
        gni.getComandi().add(accendi);
    }

    /**
     * Inizializza il comando "LASCIA" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "LASCIA" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initLascia(final GiocoNaufragioIsola gni) {
        Comando lascia = new Comando(TipoComando.LASCIA, "lascia");
        lascia.setAlias(new String[]{"togli", "butta", "abbandona", "posa"});
        lascia.setDescrizione("Lascia [oggetto_inv] :\t Comando che ti permette di lasciare un oggetto del tuo inventario;");
        gni.getComandi().add(lascia);
    }

    /**
     * Inizializza il comando "NARRA" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "NARRA" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initNarra(final GiocoNaufragioIsola gni) {
        Comando narra = new Comando(TipoComando.NARRA, "narra");
        narra.setAlias(new String[]{"racconta", "narrami", "raccontami"});
        narra.setDescrizione("Narra :\t\t Comando che ti restituisce la narrazione iniziale della stanza in cui ti trovi;");
        gni.getComandi().add(narra);
    }

    /**
     * Inizializza il comando "LEGGI" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "LEGGI" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initLeggi(final GiocoNaufragioIsola gni) {
        Comando leggere = new Comando(TipoComando.LEGGI, "leggi");
        leggere.setAlias(new String[]{"leggere"});
        leggere.setDescrizione("Leggere [oggettto] :\t Comando che ti permette di leggere un oggetto;");
        gni.getComandi().add(leggere);
    }

    /**
     * Inizializza il comando "TAGLIA" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "TAGLIA" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initTaglia(final GiocoNaufragioIsola gni) {
        Comando taglia = new Comando(TipoComando.TAGLIA, "taglia");
        taglia.setAlias(new String[]{"abbatti"});
        taglia.setDescrizione("Taglia [oggetto] :\t Comando che ti permette di tagliare un oggetto.");
        gni.getComandi().add(taglia);
    }

    /**
     * Inizializza il comando "COSTRUISCI" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "COSTRUISCI" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initCostruisci(final GiocoNaufragioIsola gni) {
        Comando costruisci = new Comando(TipoComando.COSTRUISCI, "costruisci");
        costruisci.setAlias(new String[]{"crea", "assembla"});
        costruisci.setDescrizione("Costruisci [oggetto] :\t Comando che ti permette di costruire qun oggetto;");
        gni.getComandi().add(costruisci);
    }

    /**
     * Inizializza il comando "AIUTO" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "AIUTO" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initAiuto(final GiocoNaufragioIsola gni) {
        Comando aiuto = new Comando(TipoComando.AIUTO, "aiuto");
        aiuto.setAlias(new String[]{"help", "-h", "--help"});
        gni.getComandi().add(aiuto);
    }

    /**
     * Inizializza il comando "LOCALIZZAZIONE" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "LOCALIZZAZIONE" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initLocalizzazione(final GiocoNaufragioIsola gni) {
        Comando localizzazione = new Comando(TipoComando.LOCALIZZAZIONE, "localizzazione");
        localizzazione.setAlias(new String[]{"localizzazione", "posizione", "dove", "ubicazione", "posizione"});
        localizzazione.setDescrizione("Localizzazione :\t Comando che ti permette di riconoscere la tua posizione all'interno della mappa.");
        gni.getComandi().add(localizzazione);
    }

    /**
     * Inizializza il comando "FINE" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "FINE" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initFine(final GiocoNaufragioIsola gni) {
        Comando fine = new Comando(TipoComando.FINE, "fine");
        fine.setAlias(new String[]{"fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit", "addio"});
        fine.setDescrizione("Fine :\t\t Comando che ti permette di abbandonare il gioco.");
        gni.getComandi().add(fine);
    }
    /**
     * Inizializza il comando "RIPARA" del gioco "Naufragio sull'Isola".
     * Crea un oggetto Comando con il tipo di comando "RIPARA" e lo aggiunge alla lista dei comandi del gioco.
     *
     * @param gni Gioco "Naufragio sull'Isola"
     */
    private static void initRipara(final GiocoNaufragioIsola gni) {
        Comando ripara = new Comando(TipoComando.RIPARA, "ripara");
        ripara.setAlias(new String[]{"ripara", "aggiusta", "sistema"});
        ripara.setDescrizione("Ripara [oggetto] :\t Comando che ti permette di riparare un oggetto del tuo inventario.");
        gni.getComandi().add(ripara);
    }

}
