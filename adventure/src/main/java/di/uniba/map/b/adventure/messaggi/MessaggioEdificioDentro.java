package di.uniba.map.b.adventure.messaggio;

/**
 * Stringhe relative a messaggi dell'edificio abbandonato (interno).
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioEdificioDentro {
    /**
     *Costruttore privato della classe MessaggioEdificioDentro. Serve ad impedirne l'istanziazione.
     */
    private MessaggioEdificioDentro() {
    }
    private static final String EDIFICIO_INTERNO_DESCR_CORTA = "Ti trovi all'interno di un vecchio edificio "
            + "abbandonato.";
    private static final String EDIFICIO_INTERNO_DESCR_COMPLETA = "Sei riuscito ad entrare... sembra essere un "
            + "normalissimo antico riparo.";
    private static final String EDIFICIO_INTERNO_OSSERVA = "L’interno sembra assomigliare ad una normale casa, "
            + "c’è un armadio, una tv, un divano...";
    private static final String EDIFICIO_INTERNO_TORNATO = "Sei tornato all'interno dell'edificio";
    private static final String EDIFICIO_INTERNO_NO_NORD = "Sembra una botola... nulla di interessante.";
    private static final String EDIFICIO_INTERNO_SUD = "";
    private static final String EDIFICIO_INTERNO_NO_EST = "C'e' una finestra, nulla di che...";
    private static final String EDIFICIO_INTERNO_NO_OVEST = "Che botta! Hai urtato contro il muro";

    public static String getEdificioInternoDescrCorta() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_DESCR_CORTA;
    }

    public static String getEdificioInternoDescrCompleta() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_DESCR_COMPLETA;
    }
    public static String getEdificioInternoOsserva() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_OSSERVA;
    }
    public static String getEdificioInternoTornato() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_TORNATO;
    }
    public static String getEdificioInternoNoNord() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_NO_NORD;
    }
    public static String getEdificioInternoSud() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_SUD;
    }
    public static String getEdificioInternoNoEst() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_NO_EST;
    }
    public static String getEdificioInternoNoOvest() {
        return MessaggioEdificioDentro.EDIFICIO_INTERNO_NO_OVEST;
    }
}
