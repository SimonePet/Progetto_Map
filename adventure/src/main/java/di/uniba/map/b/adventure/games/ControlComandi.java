package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;

/**
 *
 */
public final class ControlComandi {

    private ControlComandi() {
    }

    /**
     *
     * @param gni
     */
    public static void initComandi(final GiocoNaufragioIsola gni) {
        ControlComandi.initNord(gni);
        ControlComandi.initSud(gni);
        ControlComandi.initEst(gni);
        ControlComandi.initOvest(gni);
        ControlComandi.initAcced(gni);
        ControlComandi.initIventario(gni);
        ControlComandi.initOsserva(gni);
        ControlComandi.initRaccogli(gni);
        ControlComandi.initApri(gni);
        ControlComandi.initSposta(gni);
        ControlComandi.initUtilizza(gni);
        ControlComandi.initEnd(gni);
        ControlComandi.initLascia(gni);
        ControlComandi.initNarra(gni);
        ControlComandi.initSalva(gni);
        ControlComandi.initLeggere(gni);
        ControlComandi.initTaglia(gni);
        ControlComandi.initCostruisci(gni);
        ControlComandi.initAiuto(gni);
        ControlComandi.initLocalizzazione(gni);
        ControlComandi.initFine(gni);
    }

    private static void initNord(final GiocoNaufragioIsola gni) {
        Comando nord = new Comando(TipoComando.NORD, "nord");
        nord.setAlias(new String[]{"Nord", "NORD"});
        nord.setDescrizione("Nord :\t Comando che ti permette di spostarti a nord rispetto alla tua posizione;");
        gni.getComandi().add(nord);
    }

    private static void initSud(final GiocoNaufragioIsola gni) {
        Comando sud = new Comando(TipoComando.SUD, "sud");
        sud.setAlias(new String[]{"Sud", "SUD"});
        sud.setDescrizione("Sud :\t Comando che ti permette di spostarti a sud rispetto alla tua posizione;");
        gni.getComandi().add(sud);
    }

    private static void initEst(final GiocoNaufragioIsola gni) {
        Comando est = new Comando(TipoComando.EST, "est");
        est.setAlias(new String[]{"Est", "EST"});
        est.setDescrizione("Est :\t Comando che ti permette di spostarti a est rispetto alla tua posizione;");
        gni.getComandi().add(est);
    }

    private static void initOvest(final GiocoNaufragioIsola gni) {
        Comando ovest = new Comando(TipoComando.OVEST, "ovest");
        ovest.setAlias(new String[]{"Ovest", "OVEST"});
        ovest.setDescrizione("Ovest :\t Comando che ti permette di spostarti a ovest rispetto alla tua posizione;");
        gni.getComandi().add(ovest);
    }

    private static void initIventario(final GiocoNaufragioIsola gni) {
        Comando inventario = new Comando(TipoComando.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv"});
        inventario.setDescrizione("Inventario : Comando che ti permette di visualizzare gli oggetti nel tuo inventario;");
        gni.getComandi().add(inventario);
    }

    private static void initOsserva(final GiocoNaufragioIsola gni) {
        Comando osserva = new Comando(TipoComando.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        osserva.setDescrizione("Osserva : Comando che senza parametri di restituisce la descrizione della stanza in cui ti trovi;\n"
                + "Osserva [oggetto] : Comando che con parametri come gli oggetti del gioco ti restituisce la loro descrizione;");
        gni.getComandi().add(osserva);
    }

    private static void initRaccogli(final GiocoNaufragioIsola gni) {
        Comando raccogli = new Comando(TipoComando.RACCOGLI, "raccogli");
        raccogli.setAlias(new String[]{"prendi"});
        raccogli.setDescrizione("Raccogli [oggetto] : Comando che quando invocato su oiggetti validi li aggiunge al tuo inventario;");
        gni.getComandi().add(raccogli);

    }

    private static void initApri(final GiocoNaufragioIsola gni) {
        Comando apri = new Comando(TipoComando.APRI, "apri");
        apri.setAlias(new String[]{});
        apri.setDescrizione("Apri [oggetto_inventario] : ti permette di aprire oggetti che possono contenere altri oggetti;");
        gni.getComandi().add(apri);
    }

    private static void initSposta(final GiocoNaufragioIsola gni) {
        Comando sposta = new Comando(TipoComando.SPOSTA, "sposta");
        sposta.setAlias(new String[]{"spingi", "tira", "muovi"});
        sposta.setDescrizione("Premi [oggetto] : Comando che non so ancora cosa faccia;");
        gni.getComandi().add(sposta);
    }

    private static void initAcced(final GiocoNaufragioIsola gni) {
        Comando accendi = new Comando(TipoComando.ACCENDI, "accendi");
        accendi.setAlias(new String[]{"illumina"});
        accendi.setDescrizione("Accendi [oggetto_inventario] : comando che ti permette di accendere degli oggetti del tuo inventario;");
        gni.getComandi().add(accendi);
    }

    private static void initUtilizza(final GiocoNaufragioIsola gni) {
        Comando utilizza = new Comando(TipoComando.UTILIZZA, "utilizza");
        utilizza.setAlias(new String[]{"usa"});
        utilizza.setDescrizione("Utilizza [oggetto] : Comando che non so ancora cosa faccia;");
        gni.getComandi().add(utilizza);
    }

    private static void initEnd(final GiocoNaufragioIsola gni) {
        Comando end = new Comando(TipoComando.FINE, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
        end.setDescrizione("End : Comando che ti permette di abbandonare il gioco;");
        gni.getComandi().add(end);
    }

    private static void initLascia(final GiocoNaufragioIsola gni) {
        Comando lascia = new Comando(TipoComando.LASCIA, "lascia");
        lascia.setAlias(new String[]{"togli", "butta", "abbandona", "posa"});
        lascia.setDescrizione("Lascia [oggetto_inventario] : Comando che ti permette di lasciare degli oggetti del tuo inventario;");
        gni.getComandi().add(lascia);
    }

    private static void initNarra(final GiocoNaufragioIsola gni) {
        Comando narra = new Comando(TipoComando.NARRA, "narra");
        narra.setAlias(new String[]{"racconta", "narrami", "raccontami"});
        narra.setDescrizione("Narra : Comando che ti restituisce la descrizione lunga della stanza in cui ti trovi;");
        gni.getComandi().add(narra);
    }

    private static void initSalva(final GiocoNaufragioIsola gni) {
        Comando salva = new Comando(TipoComando.SALVA, "salva");
        salva.setAlias(new String[]{});
        salva.setDescrizione("Salva : Comando che ti permette di salvare la partita in corso;");
        gni.getComandi().add(salva);
    }

    private static void initLeggere(final GiocoNaufragioIsola gni) {
        Comando leggere = new Comando(TipoComando.LEGGI, "leggi");
        leggere.setAlias(new String[]{"leggere"});
        leggere.setDescrizione("Leggere [oggettto] : Comando che ti permette di leggere qualsiasi tipo di scritta;");
        gni.getComandi().add(leggere);
    }

    private static void initTaglia(final GiocoNaufragioIsola gni) {
        Comando taglia = new Comando(TipoComando.TAGLIA, "taglia");
        taglia.setAlias(new String[]{"abbatti"});
        taglia.setDescrizione("Taglia [oggetto] : Comando che ti permette di tagliare oggetti mediante oggetti del tuo inventario.");
        gni.getComandi().add(taglia);
    }

    private static void initCostruisci(final GiocoNaufragioIsola gni) {
        Comando costruisci = new Comando(TipoComando.COSTRUISCI, "costruisci");
        costruisci.setAlias(new String[]{"crea", "assembla"});
        costruisci.setDescrizione("Costruisci [oggetto] : Comando che ti permette di costruire qualcosa mediante gli oggetti nel tuo inventario;");
        gni.getComandi().add(costruisci);
    }

    private static void initAiuto(final GiocoNaufragioIsola gni) {
        Comando aiuto = new Comando(TipoComando.AIUTO, "aiuto");
        aiuto.setAlias(new String[]{"help", "-h", "--help"});
        gni.getComandi().add(aiuto);
    }
    
    private static void initLocalizzazione(final GiocoNaufragioIsola gni) {
        Comando localizzazione = new Comando(TipoComando.LOCALIZZAZIONE, "localizzazione");
        localizzazione.setAlias(new String[]{"localizzazione", "posizione", "dove","ubicazione","posizione"});
        localizzazione.setDescrizione("Localizzazione : Comando che ti restituisce la posizione corrente all'interno della mappa.");
        gni.getComandi().add(localizzazione);
    }

    private static void initFine(final GiocoNaufragioIsola gni) {
        Comando fine = new Comando(TipoComando.FINE, "fine");
        fine.setAlias(new String[]{"fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit", "addio"});
        fine.setDescrizione("Fine : Comando che ti permette di abbandonare il gioco.");
        gni.getComandi().add(fine);
    }
}
