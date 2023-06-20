package di.uniba.map.b.adventure.messaggio;

/**
 * Stringhe relative a messaggi del covo.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioCovo {
    /**
     * Costruttore privato della classe MessaggioCovo. Serve ad impedirne l'istanziazione.
     */
    private MessaggioCovo() {
    }
    private static final String COVO_DESCR_CORTA = "Ti trovi nel covo militare.";
    private static final String COVO_DESCR_COMPLETA = "Improvvisamente si apre una botola dando accesso al covo "
            + "militare descritto dai militari.";
    private static final String COVO_DESCR_OSSERVA = "All’interno del covo trovi: una vela, un’accetta e delle corde.";
    private static final String COVO_TORNATO = "Sei tornato nel covo.";
    private static final String COVO_NO_NORD = "Hai sbloccato un superpotere: puoi oltrepassare i muri...";
    private static final String COVO_SUD = "";
    private static final String COVO_NO_EST = "Non c'e' nulla da vedere qui...";
    private static final String COVO_NO_OVEST = "Sono circondato da muri!";

    public static String getCovoDescrCorta() {
        return MessaggioCovo.COVO_DESCR_CORTA;
    }
    public static String getCovoDescrCompleta() {
        return MessaggioCovo.COVO_DESCR_COMPLETA;
    }
    public static String getCovoDescrOsserva() {
        return MessaggioCovo.COVO_DESCR_OSSERVA;
    }
    public static String getCovoTornato() {
        return MessaggioCovo.COVO_TORNATO;
    }
    public static String getCovoNoNord() {
        return MessaggioCovo.COVO_NO_NORD;
    }
    public static String getCovoSud() {
        return MessaggioCovo.COVO_SUD;
    }
    public static String getCovoNoEst() {
        return MessaggioCovo.COVO_NO_EST;
    }
    public static String getCovoNoOvest() {
        return MessaggioCovo.COVO_NO_OVEST;
    }
}



