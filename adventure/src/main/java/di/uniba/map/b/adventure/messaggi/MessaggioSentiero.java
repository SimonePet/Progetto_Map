package di.uniba.map.b.adventure.messaggi;

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
    private static final String NOME = "Sentiero";
    private static final String DESCRIZIONE_CORTA = "Ti trovi in un sentiero sperduto.";
    private static final String DESCRIZIONE_COMPLETA = "Ti imbatti in un sentiero, troppo strano... sembra che "
            + "qualche essere umano lo abbia creato.";
    private static final String OSSERVA = "Tra un albero ed un altro noti un cartello di legno, del resto "
            + "rimani affascinato da una enorme ferula, sembra di essere sulla Murgia.";
    private static final String RITORNATO = "Sei tornato nel sentiero.";
    private static final String NORD = "Ti sei spostato a nord del sentiero.";
    private static final String SUD = "Ti sei spostato a sud del sentiero.";
    private static final String EST = "Ti sei spostato a est del sentiero.";
    private static final String NO_OVEST = "Un enorme precipizio, meglio evitare.";



    public static String getDescrizioneCorta() {
        return MessaggioSentiero.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioSentiero.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioSentiero.OSSERVA;
    }
    public static String getRiornato() {
        return MessaggioSentiero.RITORNATO;
    }
    public static String getNord() {
        return MessaggioSentiero.NORD;
    }
    public static String getSud() {
        return MessaggioSentiero.SUD;
    }
    public static String getEst() {
        return MessaggioSentiero.EST;
    }
    public static String getNoOvest() {
        return MessaggioSentiero.NO_OVEST;
    }
    public static String getNome() {
        return NOME;
    }

}
