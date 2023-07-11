package di.uniba.map.b.adventure.messaggi;

/**
 * Stringhe relative a messaggi del covo.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioCovo {
    /**
     * Costruttore privato della classe MessaggioCovo.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioCovo() {

    }
    private static final String NOME = "Covo";
    private static final String DESCRIZIONE_CORTA = "Ti trovi nel covo militare.";
    private static final String DESCRIZIONE_COMPLETA = "Improvvisamente si apre un passaggio segreto dando accesso al covo "
            + "militare.";
    private static final String OSSERVA = "All’interno del covo trovi: una vela,un fucile, un’accetta e delle corde.";
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



