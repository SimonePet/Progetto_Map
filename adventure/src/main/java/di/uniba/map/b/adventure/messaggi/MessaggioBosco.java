package di.uniba.map.b.adventure.messaggi;

/**
 * Stringhe relative a messaggi del bosco.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioBosco {
    /**
     * Costruttore privato della classe MessaggioBosco.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioBosco() {

    }

    private static final String NOME = "Bosco";
    private static final String DESCRIZIONE_CORTA = "Ti trovi in un bosco fitto e cupo.";
    private static final String DESCRIZIONE_COMPLETA = "Sospinto dalla curiosità, ti addentri in un piccolo bosco, "
            + "un luogo dove il tempo\nsembra essersi fermato e la natura regna sovrana.\nTuttavia, ci sono segni che "
            + "qualcuno sia passato di lì, ma chi e perché?";
    private static final String OSSERVA = "Avevi ragione! Qualcuno ci e' passato da qui prima di te, a terra"
            + "nel cespuglio c'e una di quelle vecchie lampade\nad olio di cui ti parlava tuo nonno Geppetto.";

    private static final String NORD = "Ti sei spostato al nord del bosco.";
    private static final String NO_SUD = "Ci sono degli scogli appuntiti e poi l'oceano...";
    private static final String EST = "Ti sei spostato a est del bosco.";
    private static final String OVEST = "Ti sei spostato ad ovest del bosco.";

    public static String getDescrizioneCorta() {
        return MessaggioBosco.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioBosco.DESCRIZIONE_COMPLETA;
    }
    public static String getOsserva() {
        return MessaggioBosco.OSSERVA;
    }
    public static String getNord() {
        return MessaggioBosco.NORD;
    }
    public static String getNoSud() {
        return MessaggioBosco.NO_SUD;
    }
    public static String getEst() {
        return MessaggioBosco.EST;
    }
    public static String getOvest() {
        return MessaggioBosco.OVEST;
    }
    public static String getNome() {
        return NOME;
    }
}
