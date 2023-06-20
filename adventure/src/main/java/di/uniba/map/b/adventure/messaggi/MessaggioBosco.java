package di.uniba.map.b.adventure.messaggio;

/**
 * Stringhe relative a messaggi del bosco.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioBosco {
    /**
     * Costruttore privato della classe MessaggioBosco. Serve ad impedirne l'istanziazione.
     */
    private MessaggioBosco() {
    }
    private static final String BOSCO_DESCR_CORTA = "Ti trovi in un bosco fitto e cupo.";
    private static final String BOSCO_DESCR_COMPLETA = "Sospinto dalla curiosità, ti addentri in un piccolo bosco, "
            + "un luogo dove il tempo sembra essersi fermato e la natura regna sovrana. Tuttavia, ci sono segni che "
            + "qualcuno sia passato di lì, ma chi e perché?";
    private static final String BOSCO_OSSERVA = "Avevi ragione! Qualcuno ci e' passato da qui prima di te, a terra"
            + "nel cespuglio c'e una di quelle vecchie lampade ad olio di cui ti parlava tuo nonno Geppetto.";
    private static final String BOSCO_TORNATO = "Sei tornato nel bosco.";
    private static final String BOSCO_NORD = "";
    private static final String BOSCO_NO_SUD = "Ci sono degli scogli appuntiti e poi l'oceano...";
    private static final String BOSCO_EST = "";
    private static final String BOSCO_OVEST = "";

    public static String getBoscoDescrCorta() {
        return MessaggioBosco.BOSCO_DESCR_CORTA;
    }
    public static String getBoscoDescrCompleta() {
        return MessaggioBosco.BOSCO_DESCR_COMPLETA;
    }
    public static String getBoscoOsserva() {
        return MessaggioBosco.BOSCO_OSSERVA;
    }
    public static String getBoscoTornato() {
        return MessaggioBosco.BOSCO_TORNATO;
    }
    public static String getBoscoNord() {
        return MessaggioBosco.BOSCO_NORD;
    }
    public static String getBoscoNoSud() {
        return MessaggioBosco.BOSCO_NO_SUD;
    }
    public static String getBoscoEst() {
        return MessaggioBosco.BOSCO_EST;
    }
    public static String getBoscoOvest() {
        return MessaggioBosco.BOSCO_OVEST;
    }
}
