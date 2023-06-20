package di.uniba.map.b.adventure.messaggio;

/**
 * Stringhe relative a messaggi del sentiero.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioSentiero {
    /**
     * Costruttore privato della classe MessaggioSentiero. Serve ad impedirne l'istanziazione.
     */
    private MessaggioSentiero() {
    }
    private static final String SENTIERO_DESCR_CORTA = "Ti trovi in un sentiero sperduto.";
    private static final String SENTIERO_DESCR_COMPLETA = "Ti imbatti in un sentiero, troppo strano... sembra che "
            + "qualche essere umano lo abbia creato.";
    private static final String SENTIERO_OSSERVA = "Tra un albero ed un altro noti un cartello di legno, del resto "
            + "rimani affascinato da una enorme ferula, sembra di essere sulla Murgia.";
    private static final String SENTIERO_TORNATO = "Sei tornato nel sentiero.";
    private static final String SENTIERO_NORD = "";
    private static final String SENTIERO_SUD = "";
    private static final String SENTIERO_EST = "";
    private static final String SENTIERO_NO_OVEST = "Un enorme precipizio, meglio evitare.";

    public static String getSentieroDescrCorta() {
        return MessaggioSentiero.SENTIERO_DESCR_CORTA;
    }
    public static String getSentieroDescrCompleta() {
        return MessaggioSentiero.SENTIERO_DESCR_COMPLETA;
    }
    public static String getSentieroOsserva() {
        return MessaggioSentiero.SENTIERO_OSSERVA;
    }
    public static String getSentieroTornato() {
        return MessaggioSentiero.SENTIERO_TORNATO;
    }
    public static String getSentieroNord() {
        return MessaggioSentiero.SENTIERO_NORD;
    }
    public static String getSentieroSud() {
        return MessaggioSentiero.SENTIERO_SUD;
    }
    public static String getSentieroEst() {
        return MessaggioSentiero.SENTIERO_EST;
    }
    public static String getSentieroNoOvest() {
        return MessaggioSentiero.SENTIERO_NO_OVEST;
    }
}
