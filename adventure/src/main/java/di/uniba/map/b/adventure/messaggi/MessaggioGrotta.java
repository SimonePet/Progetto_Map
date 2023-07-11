package di.uniba.map.b.adventure.messaggi;

/**
 * Stringhe relative a messaggi della grotta.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioGrotta {
    /**
     * Costruttore privato della classe MessaggioGrotta.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioGrotta() {

    }
    private static final String NOME = "Grotta";
    private static final String DESCRIZIONE_CORTA = "Ti trovi in una grotta buia, non si vede assolutamente nulla";
    private static final String DESCRIZIONE_CORTA_LUCE = "Sei tornato nella grotta,adesso illuminata grazie alla torcia.";
    private static final String DESCRIZIONE_COMPLETA = "Sei davanti una grotta, nonchè una cavità buia e silenziosa.\n"
            + "Le pareti sembrano essere irregolari, mentre il terreno si presenta irregolare e scivoloso.\n"
            + "La luce è scarsa e servirebbe qualcosa per esplorarla.";
    private static final String DESCRIZIONE_COMPLETA_LUCE = "Sei davanti una grotta, nonchè una cavità buia e silenziosa."
            + "Le pareti sembrano essere irregolari, mentre il terreno si presenta irregolare e scivoloso.\n";
    private static final String OSSERVA_BUIO = "Incredibilmente ti senti un pipistrello e riesci a osservare "
            + "la grotta senza luce.\nAh no stai solo immaginando. Non riesci a vedere nulla...";
    private static final String OSSERVA_LUCE = "Grazie alla lampada ad olio riesci a esplorare la grotta"
            + " evitando di imbatterti in possibili pericoli.\nProcedendo all’interno della grotta durante"
            + " l’esplorazione noti una lastra di pietra con su delle incisioni.";
    private static final String NO_SUD_BUIO = "E' cosi buio che non leggi neanche la bussola.";
    private static final String EST = "Ti sei spostato ad est della grotta.";
    private static final String NO_NORD_LUCE = "Nulla da vedere...";
    private static final String NO_SUD_LUCE = "Hai battuto la testa al muro... alza la testa quando cammini...";
    private static final String NO_OVEST_LUCE = "Guarda! Il paese dei pinguini volanti! (non c'e nulla)";
    private static final String DESCRIZIONE_LEGGI =      "|-----------------------|\n"
                                                        + "|     --> XXV <--     |\n"
                                                        + "|-----------------------|";



    public static String getDescrizioneCorta() {
        return MessaggioGrotta.DESCRIZIONE_CORTA;
    }
    public static String getDescrizioneCompleta() {
        return MessaggioGrotta.DESCRIZIONE_COMPLETA;
    }
    public static String getOsservaBuio() {
        return MessaggioGrotta.OSSERVA_BUIO;
    }
    public static String getOsservaLuce() {
        return MessaggioGrotta.OSSERVA_LUCE;
    }
    public static String getNoSudBuio() {
        return MessaggioGrotta.NO_SUD_BUIO;
    }
    public static String getEst() {
        return MessaggioGrotta.EST;
    }
    public static String getNoNordLuce() {
        return MessaggioGrotta.NO_NORD_LUCE;
    }
    public static String getNoSudLuce() {
        return MessaggioGrotta.NO_SUD_LUCE;
    }
    public static String getNoOvestLuce() {
        return MessaggioGrotta.NO_OVEST_LUCE;
    }
    public static String getGrottaNome() {
        return NOME;
    }
    public static String getDescLastra() {
        return MessaggioGrotta.DESCRIZIONE_LEGGI;
    }
    public static String getDescCortaLuce() {
        return MessaggioGrotta.DESCRIZIONE_CORTA_LUCE;
    }
    public static String getDescCompletaLuce() {
        return MessaggioGrotta.DESCRIZIONE_COMPLETA_LUCE;
    }
}
