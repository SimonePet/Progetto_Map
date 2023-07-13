package di.uniba.map.b.adventure.messaggi;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Stringhe relative a messaggi dela costa.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioCosta {
    /**
     * Costruttore privato della classe MessaggioCosta.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioCosta() {

    }

    private static final String NOME = "Costa";
    private static final String DESCRIZIONE_CORTA = "Ti trovi su una costa rocciosa e frastagliata.";
    private static final String DESCRIZIONE_COMPLETA = "La camminata sembra non avere fine e il tuo corpo è stanco "
            + "e dolorante.\nDopo aver camminato sulla morbida sabbia, ti ritrovi ad affrontare una costa rocciosa e "
            + "frastagliata.";
    private static final String OSSERVA = "Roccia, pietre, sassolini! Ma non solo... sembra esserci la carcassa "
            + "di una imbarcazione.";
    private static final String NO_NORD = "Provi a scalare la montagna, ma tu sei un uomo di mare potresti mai "
            + "diventare improvvisamente un alpino.";
    private static final String SUD = "Ti sei spostato a sud della costa.";
    private static final String NO_EST = "Una vasta distesa di onde...";
    private static final String OVEST = "Ti sei spostato ad ovest della costa.";
    private static final String CIFRARIO = "-----------------------------------------------------------------------------------------\n"
            + "|\t01: A\t|\t14: B\t|\n"
            + "|\t02: C\t|\t15: D\t|\n"
            + "|\t03: E\t|\t16: F\t|\n"
            + "|\t04: G\t|\t17: H\t|\n"
            + "|\t05: I\t|\t18: J\t|\n"
            + "|\t06: K\t|\t19: L\t|\n"
            + "|\t07: M\t|\t20: N\t|\n"
            + "|\t08: O\t|\t21: P\t|\n"
            + "|\t09: Q\t|\t22: R\t|\n"
            + "|\t10: S\t|\t23: T\t|\n"
            + "|\t11: U\t|\t24: V\t|\n"
            + "|\t12: W\t|\t25: X\t|\n"
            + "|\t13: Y\t|\t26: Z\t|\n"
            + "-----------------------------------------------------------------------------------------\n";

    public static String getDescrizioneCorta() {
        return MessaggioCosta.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioCosta.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioCosta.OSSERVA;
    }
    public static String getNoNord() {
        return MessaggioCosta.NO_NORD;
    }
    public static String getSud() {
        return MessaggioCosta.SUD;
    }
    public static String getNoEst() {
        return MessaggioCosta.NO_EST;
    }
    public static String getOvest() {
        return MessaggioCosta.OVEST;
    }
    public static String getNome() {
        return NOME;
    }
    public static String getDescCifrario() {
        return CIFRARIO;
    }
}
