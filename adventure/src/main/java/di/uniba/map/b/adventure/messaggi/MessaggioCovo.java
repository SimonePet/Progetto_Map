package di.uniba.map.b.adventure.messaggi;

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
    private static final String NOME = "Covo";
    private static final String DESCRIZIONE_CORTA = "Ti trovi nel covo militare.";
    private static final String DESCRIZIONE_COMPLETA = "Improvvisamente si apre una botola dando accesso al covo "
            + "militare.";
    private static final String OSSERVA = "All’interno del covo trovi: una vela, un’accetta e delle corde.";
    private static final String RITORNATO = "Sei tornato nel covo.";
    private static final String NO_NORD = "Hai sbloccato un superpotere: puoi oltrepassare i muri...";
    private static final String SUD = "Ti sei spostato a sud del covo.";
    private static final String NO_EST = "Non c'e' nulla da vedere qui...";
    private static final String NO_OVEST = "Sono circondato da muri!";
    public static String getDescrizioneCorta() {
        return MessaggioCovo.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioCovo.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioCovo.OSSERVA;
    }
    public static String getRitornato() {
        return MessaggioCovo.RITORNATO;
    }
    public static String getNoNord() {
        return MessaggioCovo.NO_NORD;
    }
    public static String getSud() {
        return MessaggioCovo.SUD;
    }
    public static String getNoEst() {
        return MessaggioCovo.NO_EST;
    }
    public static String getNoOvest() {
        return MessaggioCovo.NO_OVEST;
    }
    public static String getNome() {
        return NOME;
    }
}



