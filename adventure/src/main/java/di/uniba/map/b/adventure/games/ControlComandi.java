package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;

import java.util.concurrent.Callable;

public class ControlComandi {

    public ControlComandi(){
    }

    public static void initComandi(GiocoNaufragioIsola GNI){
        ControlComandi.initNord(GNI);
        ControlComandi.initSud(GNI);
        ControlComandi.initEst(GNI);
        ControlComandi.initOvest(GNI);
        ControlComandi.initAcced(GNI);
        ControlComandi.initIventario(GNI);
        ControlComandi.initOsserva(GNI);
        ControlComandi.initRaccogli(GNI);
        ControlComandi.initApri(GNI);
        ControlComandi.initPremi(GNI);
        ControlComandi.initUtilizza(GNI);
        ControlComandi.initEnd(GNI);
        ControlComandi.initLascia(GNI);
        ControlComandi.initNarra(GNI);
        ControlComandi.initSalva(GNI);
        ControlComandi.initLeggere(GNI);
        ControlComandi.initTaglia(GNI);
        ControlComandi.initCostruisci(GNI);
        ControlComandi.initAiuto(GNI);
    }

    private static void initNord(GiocoNaufragioIsola GNI){
        Comando nord = new Comando(TipoComando.NORD, "nord");
        nord.setAlias(new String[]{"Nord", "NORD"});
        nord.setDescrizione("Nord :\t Comando che ti perfette di spostarti a nord rispetto alla tua posizione;");
        GNI.getCommands().add(nord);
    }

    private static void initSud(GiocoNaufragioIsola GNI){
        Comando sud = new Comando(TipoComando.SUD, "sud");
        sud.setAlias(new String[]{"Sud", "SUD"});
        sud.setDescrizione("Sud :\t Comando che ti perfette di spostarti a sud rispetto alla tua posizione;");
        GNI.getCommands().add(sud);
    }

    private static void initEst(GiocoNaufragioIsola GNI){
        Comando est = new Comando(TipoComando.EST, "est");
        est.setAlias(new String[]{"Est", "EST"});
        est.setDescrizione("Est :\t Comando che ti perfette di spostarti a est rispetto alla tua posizione;");
        GNI.getCommands().add(est);
    }

    private static void initOvest(GiocoNaufragioIsola GNI){
        Comando ovest = new Comando(TipoComando.OVEST, "ovest");
        ovest.setAlias(new String[]{"Ovest", "OVEST"});
        ovest.setDescrizione("Ovest :\t Comando che ti perfette di spostarti a ovest rispetto alla tua posizione;");
        GNI.getCommands().add(ovest);
    }

    private static void initIventario(GiocoNaufragioIsola GNI){
        Comando inventario = new Comando(TipoComando.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv"});
        inventario.setDescrizione("Inventario : Comando che ti permette di visualizzare gli oggetti nel tuo inventario;");
        GNI.getCommands().add(inventario);
    }

    private static void initOsserva(GiocoNaufragioIsola GNI){
        Comando osserva = new Comando(TipoComando.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        osserva.setDescrizione("Osserva : Comando che senza parametri di restituisce la descrizione della stanza in cui ti trovi;\n"+
                "Osserva [oggetto] : Comando che con parametri come gli oggetti del gioco ti restituisce la loro descrizione;");
        GNI.getCommands().add(osserva);
    }

    private static void initRaccogli(GiocoNaufragioIsola GNI){
        Comando raccogli = new Comando(TipoComando.RACCOGLI, "raccogli");
        raccogli.setAlias(new String[]{"prendi"});
        raccogli.setDescrizione("Raccogli [oggetto] : Comando che quando invocato su oiggetti validi li aggiunge al tuo inventario;");
        GNI.getCommands().add(raccogli);

    }

    private static void initApri(GiocoNaufragioIsola GNI){
        Comando apri = new Comando(TipoComando.APRI, "apri");
        apri.setAlias(new String[]{});
        apri.setDescrizione("Apri [oggetto_inventario] : ti permette di aprire oggetti che possono contenere altri oggetti;");
        GNI.getCommands().add(apri);
    }

    private static void initPremi(GiocoNaufragioIsola GNI){
        Comando premi = new Comando(TipoComando.PREMI, "premi");
        premi.setAlias(new String[]{"spingi", "attiva"});
        premi.setDescrizione("Premi [oggetto] : Comando che non so ancora cosa faccia;");
        GNI.getCommands().add(premi);
    }

    private static void initAcced(GiocoNaufragioIsola GNI){
        Comando accendi = new Comando(TipoComando.ACCENDI, "accendi");
        accendi.setAlias(new String[]{"illumina"});
        accendi.setDescrizione("Accendi [oggetto_inventario] : comando che ti permette di accendere degli oggetti del tuo inventario;");
        GNI.getCommands().add(accendi);
    }

    private static void initUtilizza(GiocoNaufragioIsola GNI){
        Comando utilizza = new Comando(TipoComando.UTILIZZA, "utilizza");
        utilizza.setAlias(new String[]{"usa"});
        utilizza.setDescrizione("Utilizza [oggetto] : Comando che non so ancora cosa faccia;");
        GNI.getCommands().add(utilizza);
    }

    private static void initEnd(GiocoNaufragioIsola GNI){
        Comando end = new Comando(TipoComando.FINE, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
        end.setDescrizione("End : Comando che ti permette di abbandonare il gioco;");
        GNI.getCommands().add(end);
    }

    private static void initLascia(GiocoNaufragioIsola GNI){
        Comando lascia = new Comando(TipoComando.LASCIA, "lascia");
        lascia.setAlias(new String[]{"togli", "butta", "abbandona","posa"});
        lascia.setDescrizione("Lascia [oggetto_inventario] : Comando che ti permette di lasciare degli oggetti del tuo inventario;");
        GNI.getCommands().add(lascia);
    }

    private static void initNarra(GiocoNaufragioIsola GNI){
        Comando narra = new Comando(TipoComando.NARRA, "narra");
        narra.setAlias(new String[]{"racconta", "narrami", "raccontami"});
        narra.setDescrizione("Narra : Comando che ti restituisce la descrizione lunga della stanza in cui ti trovi;");
        GNI.getCommands().add(narra);
    }

    private static void initSalva(GiocoNaufragioIsola GNI){
        Comando salva = new Comando(TipoComando.SALVA, "salva");
        salva.setAlias(new String[]{});
        salva.setDescrizione("Salva : Comando che ti permette di salvare la partita in corso;");
        GNI.getCommands().add(salva);
    }

    private static void initLeggere(GiocoNaufragioIsola GNI){
        Comando leggere = new Comando(TipoComando.LEGGI, "leggi");
        leggere.setAlias(new String[]{"leggere"});
        leggere.setDescrizione("Leggere [oggettto] : Comando che ti permette di leggere qualsiasi tipo di scritta;");
        GNI.getCommands().add(leggere);
    }

    private static void initTaglia(GiocoNaufragioIsola GNI){
        Comando Taglia = new Comando(TipoComando.TAGLIA,"taglia");
        Taglia.setAlias(new String[]{"abbatti"});
        Taglia.setDescrizione("Taglia [oggetto] : Comando che ti permette di tagliare oggetti mediante oggetti del tuo inventario.");
        GNI.getCommands().add(Taglia);
    }

    private static void initCostruisci(GiocoNaufragioIsola GNI){
        Comando Costruisci = new Comando(TipoComando.COSTRUISCI,"costruisci");
        Costruisci.setAlias(new String[]{"crea","assembla"});
        Costruisci.setDescrizione("Costruisci [oggetto] : Comando che ti permette di costruire qualcosa mediante gli oggetti nel tuo inventario;");
        GNI.getCommands().add(Costruisci);
    }

    private static void initAiuto(GiocoNaufragioIsola GNI){
        Comando Aiuto = new Comando(TipoComando.AIUTO,"aiuto");
        Aiuto.setAlias(new String[]{"help","-h","--help"});
        GNI.getCommands().add(Aiuto);
    }
}
