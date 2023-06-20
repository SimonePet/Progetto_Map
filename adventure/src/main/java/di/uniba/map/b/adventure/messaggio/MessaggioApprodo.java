package di.uniba.map.b.adventure.messaggio;

/**
 * Stringhe relative a messaggi approdo.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioApprodo {
    /**
     *Costruttore privato della classe MessaggioApprodo. Serve ad impedirne l'istanziazione.
     */
    private MessaggioApprodo() {
    }
    private static final String INTRODUZIONE = "Lentamente riapri gli occhi e ti ritrovi spiaggiato su una costa "
            + "sconosciuta, il mare agitato che si infrange sulle rocce circostanti è l'unico suono che senti."
            + "Ricordi solo la tempesta, l'acqua che invadeva la tua barca e il vento che urlava intorno a te."
            + "La paura ti attanaglia, ma devi farti forza e trovare un modo per fuggire."
            + "Questo è il tuo alter ego che ti parla e ti accompagnerà durante tutta la tua avventura";

    private static final String APPRODO_DESCR_COMPLETA = INTRODUZIONE;
    private static final String APPRODO_DESCR_CORTA = "Ti trovi sulla costa nella quale ti sei risvegliato!";
    private static final String APPRODO_OSSERVA_INIZIO = "Sulla sabbia c'e' una bussola.";
    private static final String APPRODO_OSSERVA_FINE = "Sulla sabbia c'e' solo sabbia.";
    private static final String APPRODO_TORNATO = "Sei tornato sulla costa nella quale ti sei risvegliato!";
    private static final String APPRODO_NORD = "";
    private static final String APPRODO_NO_SUD = "Se fossi Federica Pellegrini ai suoi tempi d'oro potresti nuotare...";
    private static final String APPRODO_NO_EST = "Potresti provare a nuotare per giorni, già ti ci vedo nella mascella "
            + "di un pesce cane.";
    private static final String APPRODO_OVEST = "";

    public static String getIntroduzione() {
        return MessaggioApprodo.INTRODUZIONE;
    }
    public static String getApprodoDescrCompleta() {
        return MessaggioApprodo.APPRODO_DESCR_COMPLETA;
    }
    public static String getApprodoDescrCorta() {
        return MessaggioApprodo.APPRODO_DESCR_CORTA;
    }
    public static String getApprodoOsservaInizio() {
        return MessaggioApprodo.APPRODO_OSSERVA_INIZIO;
    }
    public static String getApprodoOsservaFine() {
        return MessaggioApprodo.APPRODO_OSSERVA_FINE;
    }
    public static String getApprodoTornato() {
        return MessaggioApprodo.APPRODO_TORNATO;
    }
    public static String getApprodoNoNord() {
        return MessaggioApprodo.APPRODO_NORD;
    }
    public static String getApprodoNoSud() {
        return MessaggioApprodo.APPRODO_NO_SUD;
    }
    public static String getApprodoNoEst() {
        return MessaggioApprodo.APPRODO_NO_EST;
    }
    public static String getApprodoOvest() {
        return MessaggioApprodo.APPRODO_OVEST;
    }
}
