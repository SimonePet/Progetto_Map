package di.uniba.map.b.adventure.messaggi;

/**
 * Stringhe relative a messaggi approdo.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioApprodo {
    /**
     * Costruttore privato della classe MessaggioApprodo.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioApprodo() {

    }

    private static final String NOME = "Approdo";
    private static final String DESCRIZIONE_COMPLETA = "Lentamente riapri gli occhi e ti ritrovi spiaggiato su una costa "
            + "sconosciuta, il mare agitato che si infrange sulle rocce\ncircostanti è l'unico suono che senti.\n"
            + "Ricordi solo la tempesta, l'acqua che invadeva la tua barca e il vento che urlava intorno a te.\n"
            + "La paura ti attanaglia, ma devi farti forza e trovare un modo per fuggire.\n"
            + "Questo è il tuo alter ego che ti parla e ti accompagnerà durante tutta la tua avventura.";
    private static final String DESCRIZIONE_CORTA = "Ti trovi sulla costa nella quale ti sei risvegliato!";
    private static final String OSSERVA = "Sulla sabbia c'e' solo sabbia.";
    private static final String NORD = "Ti sei spostato a nord dell'approdo.";
    private static final String OVEST = "Ti sei spostato a ovest dell'approdo.";
    private static final String NO_SUD = "Se fossi Federica Pellegrini ai suoi tempi d'oro potresti nuotare...";
    private static final String NO_EST = "Potresti provare a nuotare per giorni, già ti ci vedo nella mascella "
            + "di un pesce cane.";
    public static String getDescrizioneCompleta() {
        return MessaggioApprodo.DESCRIZIONE_COMPLETA;
    }
    public static String getDescrizioneCorta() {
        return MessaggioApprodo.DESCRIZIONE_CORTA;
    }
    public static String getOsserva() {
        return MessaggioApprodo.OSSERVA;
    }
    public static String getNord() {
        return MessaggioApprodo.NORD;
    }
    public static String getNoSud() {
        return MessaggioApprodo.NO_SUD;
    }
    public static String getNoEst() {
        return MessaggioApprodo.NO_EST;
    }
    public static String getOvest() {
        return MessaggioApprodo.OVEST;
    }
    public static String getNome() {
        return NOME;
    }
}
