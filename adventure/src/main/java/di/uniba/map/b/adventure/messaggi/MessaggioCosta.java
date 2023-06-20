package di.uniba.map.b.adventure.messaggio;

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
    private static final String COSTA_DESCR_CORTA = "Ti trovi su una costa rocciosa e frastagliata.";
    private static final String COSTA_DESCR_COMPLETA = "La camminata sembra non avere fine e il tuo corpo è stanco"
            + "e dolorante. Dopo aver camminato sulla morbida sabbia, ti ritrovi ad affrontare una costa rocciosa e "
            + "frastagliata.";
    private static final String COSTA_OSSERVA = "Roccia, pietre, sassolini! Ma non solo... sembra esserci la carcassa"
            + "di una imbarcazione.";
    private static final String COSTA_TORNATO = "Sei tornato sulla costa rocciosa e frastagliata.";
    private static final String COSTA_NO_NORD = "Provi a scalare la montagna, ma tu sei un uomo di mare potresti mai "
            + "diventare improvvisamente un alpino.";
    private static final String COSTA_SUD = "";
    private static final String COSTA_NO_EST = "Una vasta distesa di onde...";
    private static final String COSTA_OVEST = "";

    public static String getCostaDescrCorta() {
        return MessaggioCosta.COSTA_DESCR_CORTA;
    }
    public static String getCostaDescrCompleta() {
        return MessaggioCosta.COSTA_DESCR_COMPLETA;
    }
    public static String getCostaOsserva() {
        return MessaggioCosta.COSTA_OSSERVA;
    }
    public static String getCostaTornato() {
        return MessaggioCosta.COSTA_TORNATO;
    }
    public static String getCostaNoNord() {
        return MessaggioCosta.COSTA_NO_NORD;
    }
    public static String getCostaSud() {
        return MessaggioCosta.COSTA_SUD;
    }
    public static String getCostaNoEst() {
        return MessaggioCosta.COSTA_NO_EST;
    }
    public static String getCostaOvest() {
        return MessaggioCosta.COSTA_OVEST;
    }
}
