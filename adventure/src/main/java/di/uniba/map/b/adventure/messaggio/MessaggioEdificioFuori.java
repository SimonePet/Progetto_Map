package di.uniba.map.b.adventure.messaggio;

/**
 * Stringhe relative a messaggi dell'edificio abbandonato (esterno).
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioEdificioFuori {
    /**
     *Costruttore privato della classe MessaggioEdificioFuori. Serve ad impedirne l'istanziazione.
     */
    private MessaggioEdificioFuori() {
    }
    private static final String EDIFICIO_ESTERNO_DESCR_CORTA = "Ti trovi fuori un vecchio edificio abbandonato.";
    private static final String EDIFICIO_ESTERNO_DESCR_COMPLETA = "Tra gli alberi, noti un'ombra oscura che si staglia "
            + "contro il cielo del crepuscolo. Avvicinandoti, scopri che si tratta di un vecchio edificio abbandonato, "
            + "un tempo maestoso e possente, ora fatiscente e coperto di piante rampicanti che sembrano aver preso il "
            + "sopravvento.";
    private static final String EDIFICIO_ESTERNO_OSSERVA = "Intorno all’edificio sembra non esserci nulla se "
            + "non un binocolo. Si osserva della luce uscire da una finestra.";
    private static final String EDIFICIO_ESTERNO_TORNATO = "Sei tornato all'esterno dell'edificio";
    private static final String EDIFICIO_ESTERNO_NO_NORD = "Sei davanti all'ingresso adesso. La porta e' chiusa...";
    private static final String EDIFICIO_ESTERNO_SUD = "";
    private static final String EDIFICIO_ESTERNO_NO_EST = "Montagne invalicabili...";
    private static final String EDIFICIO_ESTERNO_OVEST = "Ti imbatti in un ripido precipizio, sembra essere "
            + "alto una decina di metri, a meno che tu abbia bevuto 10 redBull non credo tu possa volare.";

    public static String getEdificioEsternoDescrCorta() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_DESCR_CORTA;
    }
    public static String getEdificioEsternoDescrCompleta() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_DESCR_COMPLETA;
    }
    public static String getEdificioEsternoOsserva() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_OSSERVA;
    }
    public static String getEdificioEsternoTornato() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_TORNATO;
    }
    public static String getEdificioEsternoNoNord() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_NO_NORD;
    }
    public static String getEdificioEsternoSud() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_SUD;
    }
    public static String getEdificioEsternoNoEst() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_NO_EST;
    }
    public static String getEdificioEsternoOvest() {
        return MessaggioEdificioFuori.EDIFICIO_ESTERNO_OVEST;
    }
}
