package di.uniba.map.b.adventure.messaggi;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Stringhe relative a messaggi dell'edificio abbandonato (interno).
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioEdificioDentro {
    /**
     * Costruttore privato della classe MessaggioEdificioDentro.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioEdificioDentro() {

    }

    private static final String NOME = "Edificio interno";
    private static final String DESCRIZIONE_CORTA = "Ti trovi all'interno di un vecchio edificio "
            + "abbandonato.";
    private static final String DESCRIZIONE_COMPLETA = "Sei riuscito ad entrare... sembra essere un "
            + "normalissimo antico riparo.";
    private static final String OSSERVA = "L’interno sembra assomigliare ad una normale casa, "
            + "c’è un armadio, una tv, un divano...";
    private static final String NO_NORD = "Sembra una botola... nulla di interessante.";
    private static final String NORD = "Ti sei spostato a nord dell'edificio.";
    private static final String SUD = "Ti sei spostato a sud dell'edificio";
    private static final String NO_OVEST = "Che botta! Hai urtato contro il muro";
    private static final String NO_EST = "Sei un trimone.";

    public static String getDescrizioneCorta() {
        return MessaggioEdificioDentro.DESCRIZIONE_CORTA;
    }

    public static String getDescrizioneCompleta() {
        return MessaggioEdificioDentro.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioEdificioDentro.OSSERVA;
    }
    public static String getNoNord() {
        return MessaggioEdificioDentro.NO_NORD;
    }
    public static String getSud() {
        return MessaggioEdificioDentro.SUD;
    }
    public static String getNoEst() {
        return MessaggioEdificioDentro.NO_EST;
    }
    public static String getNoOvest() {
        return MessaggioEdificioDentro.NO_OVEST;
    }
    public static String getNome() {
        return NOME;
    }
    public static String getNord() {
        return NORD;
    }
}
