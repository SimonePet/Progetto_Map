package di.uniba.map.b.adventure.messaggi;

/**
 * Stringhe relative a messaggi del sentiero.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioSentiero {
    /**
     * Costruttore privato della classe MessaggioSentiero.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioSentiero() {

    }
    private static final String NOME = "Sentiero";
    private static final String DESCRIZIONE_CORTA = "Ti trovi in un sentiero sperduto.";
    private static final String DESCRIZIONE_COMPLETA = "Ti imbatti in un sentiero, troppo strano...\nSembra che "
            + "qualche essere umano lo abbia creato.";
    private static final String OSSERVA = "Tra un albero ed un altro noti un cartello di legno, del resto "
            + "rimani affascinato da una enorme ferula, sembra\ndi essere sulla Murgia.";
    private static final String NORD = "Ti sei spostato a nord del sentiero.";
    private static final String SUD = "Ti sei spostato a sud del sentiero.";
    private static final String EST = "Ti sei spostato a est del sentiero.";
    private static final String NO_OVEST = "Un enorme precipizio, meglio evitare.";
    private static final String CARTELLO = "------------------------------------------------------------------\n"
                                           + "|                     SUD --->   3.0km   <---                   |\n"
                                           + "|                        14-08-10-02-08                           |\n"
                                           + "------------------------------------------------------------------\n"
                                           + "|                    NORD --->   8.0km   <---                 |\n"
                                           + "|                   03-15-05-16-05-02-05-08                |\n"
                                           + "------------------------------------------------------------------\n"
                                           + "                                       ||             \n"
                                           + "                                       ||             \n"
                                           + "                                       ||             \n";


    public static String getDescrizioneCorta() {
        return MessaggioSentiero.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioSentiero.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioSentiero.OSSERVA;
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

    public static String getCARTELLO() {
        return CARTELLO;
    }
}
