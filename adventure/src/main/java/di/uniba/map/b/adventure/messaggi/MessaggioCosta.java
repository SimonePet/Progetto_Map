package di.uniba.map.b.adventure.messaggi;

/**
 * Stringhe relative a messaggi dela costa.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioCosta {
    /**
     * Costruttore privato della classe MessaggioCosta. Serve ad impedirne l'istanziazione.
     */
    private MessaggioCosta() {
    }
    private static final String NOME = "Costa";
    private static final String DESCRIZIONE_CORTA = "Ti trovi su una costa rocciosa e frastagliata.";
    private static final String DESCRIZIONE_COMPLETA = "La camminata sembra non avere fine e il tuo corpo è stanco"
            + "e dolorante.\nDopo aver camminato sulla morbida sabbia, ti ritrovi ad affrontare una costa rocciosa e "
            + "frastagliata.";
    private static final String OSSERVA = "Roccia, pietre, sassolini! Ma non solo... sembra esserci la carcassa"
            + "di una imbarcazione.";
    private static final String RITORNATO = "Sei tornato sulla costa rocciosa e frastagliata.";
    private static final String NO_NORD = "Provi a scalare la montagna, ma tu sei un uomo di mare potresti mai "
            + "diventare improvvisamente un alpino.";
    private static final String SUD = "Ti sei spostato a sud della costa.";
    private static final String NO_EST = "Una vasta distesa di onde...";
    private static final String OVEST = "Ti sei spostato ad ovest della costa.";

    public static String getDescrizioneCorta() {
        return MessaggioCosta.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioCosta.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioCosta.OSSERVA;
    }
    public static String getRitornato() {
        return MessaggioCosta.RITORNATO;
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
}
