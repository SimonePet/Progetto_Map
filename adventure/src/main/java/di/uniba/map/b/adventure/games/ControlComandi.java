package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;

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

    }

    private static void initNord(GiocoNaufragioIsola GNI){
        Comando nord = new Comando(TipoComando.NORD, "nord");
        nord.setAlias(new String[]{"Nord", "NORD"});
        GNI.getCommands().add(nord);
    }

    private static void initSud(GiocoNaufragioIsola GNI){
        Comando sud = new Comando(TipoComando.SUD, "sud");
        sud.setAlias(new String[]{"Sud", "SUD"});
        GNI.getCommands().add(sud);
    }

    private static void initEst(GiocoNaufragioIsola GNI){
        Comando est = new Comando(TipoComando.EST, "est");
        est.setAlias(new String[]{"Est", "EST"});
        GNI.getCommands().add(est);
    }

    private static void initOvest(GiocoNaufragioIsola GNI){
        Comando ovest = new Comando(TipoComando.OVEST, "ovest");
        ovest.setAlias(new String[]{"Ovest", "OVEST"});
        GNI.getCommands().add(ovest);
    }

    private static void initIventario(GiocoNaufragioIsola GNI){
        Comando inventario = new Comando(TipoComando.INVENTARIO, "inventario");
        inventario.setAlias(new String[]{"inv"});
        GNI.getCommands().add(inventario);
    }

    private static void initOsserva(GiocoNaufragioIsola GNI){
        Comando osserva = new Comando(TipoComando.OSSERVA, "osserva");
        osserva.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        GNI.getCommands().add(osserva);
    }

    private static void initRaccogli(GiocoNaufragioIsola GNI){
        Comando raccogli = new Comando(TipoComando.RACCOGLI, "raccogli");
        raccogli.setAlias(new String[]{"prendi"});
        GNI.getCommands().add(raccogli);

    }

    private static void initApri(GiocoNaufragioIsola GNI){
        Comando apri = new Comando(TipoComando.APRI, "apri");
        apri.setAlias(new String[]{});
        GNI.getCommands().add(apri);
    }

    private static void initPremi(GiocoNaufragioIsola GNI){
        Comando premi = new Comando(TipoComando.PREMI, "premi");
        premi.setAlias(new String[]{"spingi", "attiva"});
        GNI.getCommands().add(premi);
    }

    private static void initAcced(GiocoNaufragioIsola GNI){
        Comando accendi = new Comando(TipoComando.ACCENDI, "accendi");
        accendi.setAlias(new String[]{"illumina"});
        GNI.getCommands().add(accendi);
    }

    private static void initUtilizza(GiocoNaufragioIsola GNI){
        Comando utilizza = new Comando(TipoComando.UTILIZZA, "utilizza");
        utilizza.setAlias(new String[]{"usa"});
        GNI.getCommands().add(utilizza);
    }

    private static void initEnd(GiocoNaufragioIsola GNI){
        Comando end = new Comando(TipoComando.FINE, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
        GNI.getCommands().add(end);
    }

    private static void initLascia(GiocoNaufragioIsola GNI){
        Comando lascia = new Comando(TipoComando.LASCIA, "lascia");
        lascia.setAlias(new String[]{"togli", "butta", "abbandona","posa"});
        GNI.getCommands().add(lascia);
    }

    private static void initNarra(GiocoNaufragioIsola GNI){
        Comando narra = new Comando(TipoComando.NARRA, "narra");
        narra.setAlias(new String[]{"racconta", "narrami", "raccontami"});
        GNI.getCommands().add(narra);
    }

    private static void initSalva(GiocoNaufragioIsola GNI){
        Comando salva = new Comando(TipoComando.SALVA, "salva");
        salva.setAlias(new String[]{});
        GNI.getCommands().add(salva);
    }

    private static void initLeggere(GiocoNaufragioIsola GNI){
        Comando leggere = new Comando(TipoComando.LEGGI, "leggi");
        leggere.setAlias(new String[]{"leggere"});
        GNI.getCommands().add(leggere);
    }
}
