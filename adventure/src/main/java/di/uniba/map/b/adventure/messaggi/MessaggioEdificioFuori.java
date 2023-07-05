package di.uniba.map.b.adventure.messaggi;

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
    private static final String NOME = "Edificio esterno";
    private static final String DESCRIZIONE_CORTA = "Ti trovi fuori un vecchio edificio abbandonato.";
    private static final String DESCRIZIONE_COMPLETA = "Tra gli alberi, noti un'ombra oscura che si staglia "
            + "contro il cielo del crepuscolo.\nAvvicinandoti, scopri che si tratta di un vecchio edificio abbandonato, "
            + "un tempo maestoso e possente, ora fatiscente\ne coperto di piante rampicanti che sembrano aver preso il "
            + "sopravvento.";
    private static final String OSSERVA = "Intorno all’edificio sembra non esserci nulla se "
            + "non un binocolo. Si osserva della luce uscire da una finestra.";
    private static final String RITORNATO = "Sei tornato all'esterno dell'edificio";
    private static final String NO_NORD = "Sei davanti all'ingresso adesso. La porta e' chiusa...";
    private static final String NORD = "Ti sei spostato a nord dell'edificio abbandonato.";
    private static final String SUD = "Ti sei spostato a sud del'edificio abbandonato";
    private static final String NO_EST = "Montagne invalicabili...";
    private static final String NO_OVEST = "Ti imbatti in un ripido precipizio, sembra essere "
            + "alto una decina di metri, a meno che tu abbia bevuto 10 redBull\nnon credo tu possa volare.";

    public static String getDescrizioneCorta() {
        return MessaggioEdificioFuori.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioEdificioFuori.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioEdificioFuori.OSSERVA;
    }
    public static String getRitornatoornato() {
        return MessaggioEdificioFuori.RITORNATO;
    }
    public static String getNoNord() {
        return MessaggioEdificioFuori.NO_NORD;
    }
    public static String getSud() {
        return MessaggioEdificioFuori.SUD;
    }
    public static String getNoEst() {
        return MessaggioEdificioFuori.NO_EST;
    }
    public static String getNoOvest() {
        return MessaggioEdificioFuori.NO_OVEST;
    }
    public static String getNord() {
        return MessaggioEdificioFuori.NORD;
    }
    public static String getNome() {
        return NOME;
    }
}
