package di.uniba.map.b.adventure.messaggio;

/**
 * Stringhe relative a messaggi della grotta.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioGrotta {
    /**
     * Costruttore privato della classe MessaggioGrotta. Serve ad impedirne l'istanziazione.
     */
    private MessaggioGrotta() {
    }
    private static final String GROTTA_DESCR_CORTA = "Ti trovi in una grotta buia, non si vede assolutamente nulla";
    private static final String GROTTA_DESCR_COMPLETA = "Sei davanti una grotta, nonchè una cavità buia e silenziosa."
            + "Le pareti sembrano essere irregolari, mentre il terreno si presenta irregolare e scivoloso."
            + "La luce è scarsa e servirebbe qualcosa per esplorarla.";
    private static final String GROTTA_OSSERVA_BUIO = "Incredibilmente ti senti un pipistrello e riesci a osservare"
            + "la grotta senza luce. Ah no stai solo immaginando. Non riesci a vedere nulla...";
    private static final String GROTTA_OSSERVA_LUCE = "Grazie alla lampada ad olio riesci a esplorare la grotta"
            + " evitando di imbatterti in possibili pericoli. Procedendo all’interno della grotta durante"
            + " l’esplorazione noti dei graffiti disegnati su una delle pareti.";
    private static final String GROTTA_TORNATO = "Sei tornato nella grotta.";
    private static final String GROTTA_NO_NORD_BUIO = "Potreti inciampare nel buio.";
    private static final String GROTTA_NO_SUD_BUIO = "E' cosi buio che non leggi neanche la bussola.";
    private static final String GROTTA_EST = "";
    private static final String GROTTA_NO_OVEST_BUIO = "La grotta e' buia meglio non muoversi.";
    private static final String GROTTA_NO_NORD_LUCE = "Nulla da vedere...";
    private static final String GROTTA_NO_SUD_LUCE = "Hai battuto la testa al muro... alza la testa quando cammini...";
    private static final String GROTTA_NO_OVEST_LUCE = "Guarda! Il paese dei pinguini volanti! ( non c'e nulla)";

    public static String getGrottaDescrCorta() {
        return MessaggioGrotta.GROTTA_DESCR_CORTA;
    }
    public static String getGrottaDescrCompleta() {
        return MessaggioGrotta.GROTTA_DESCR_COMPLETA;
    }
    public static String getGrottaOsservaBuio() {
        return MessaggioGrotta.GROTTA_OSSERVA_BUIO;
    }
    public static String getGrottaOsservaLuce() {
        return MessaggioGrotta.GROTTA_OSSERVA_LUCE;
    }
    public static String getGrottaTornato() {
        return MessaggioGrotta.GROTTA_TORNATO;
    }
    public static String getGrottaNoNordBuio() {
        return MessaggioGrotta.GROTTA_NO_NORD_BUIO;
    }
    public static String getGrottaNoSudBuio() {
        return MessaggioGrotta.GROTTA_NO_SUD_BUIO;
    }
    public static String getGrottaEst() {
        return MessaggioGrotta.GROTTA_EST;
    }
    public static String getGrottaNoOvestBuio() {
        return MessaggioGrotta.GROTTA_NO_OVEST_BUIO;
    }
    public static String getGrottaNoNordLuce() {
        return MessaggioGrotta.GROTTA_NO_NORD_LUCE;
    }
    public static String getGrottaNoSudLuce() {
        return MessaggioGrotta.GROTTA_NO_SUD_LUCE;
    }
    public static String getGrottaNoOvestLuce() {
        return MessaggioGrotta.GROTTA_NO_OVEST_LUCE;
    }
}
