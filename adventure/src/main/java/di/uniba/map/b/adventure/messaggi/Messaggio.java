/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.messaggi;

/**
 * Stringhe relative a messaggi generali.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class Messaggio {
    /**
     * Costruttore privato della classe Messaggio. Serve ad impedirne l'istanziazione.
     */
    private Messaggio() {
    }
    private static final String HELP = "Per muoverti all'interno della mappa digita: Nord/Sud/Est/Ovest\n"
            + "Per osservare un luogo/oggetto digita: osserva [nome luogo/nome oggetto]\n"
            + "Per raccogliere/lasciare un oggetto digita: raccogli/lascia [nome oggetto]\n"
            + "Per visualizzare inventario digita: inventario/inv\n"
            + "Per alcuni verbi sono accettati anche dei sinonimi\n"
            + "Durante il gioco potrebbero essere necessarie delle azioni su degli oggetti. Per esempio: \n"
            + "'Mangia banana' oppure 'Leggi libro'\n"
            + "Se sei in difficolta' digita: aiuto [nome stanza]";
    private static final String SEI_TORNATO = "Sei tornato ";
    private static final String TI_TROVI = "Ti trovi ";
    private static final String HAI_RACCOLTO = "Hai raccolto: ";
    private static final String HAI_LASCIATO = "Hai lasciato: ";
    private static final String INVENTARIO_PIENO = "Inventario pieno!";
    private static final String INVENTARIO_VUOTO = "Il tuo inventario e' vuoto.";
    private static final String NO_RACCOGLI = "Non puoi raccogliere questo oggetto.";
    private static final String GIA_RACCOLTO = "Hai gia raccolto questo oggetto. E' presente nel tuo inventario.";
    private static final String NORD = "Nord";
    private static final String SUD = "Sud";
    private static final String EST = "Est";
    private static final String OVEST = "Ovest";
    private static final String TI_SEI_SPOSTATO_A = "Ti sei spostato a ";
    private static final String INVENTARIO = "Nel tuo inventario ci sono:";
    private static final String INVIO ="/n";
    private static final String NON_VEDO_OGGETTI = "Non c'è luce. Non vedo nulla da raccogliere.";
    private static final String OGGETTO_NON_PRESENTE = "L'oggetto che vuoi raccogliere non c'è.";
    private static final String OGGETTO_NON_POSSEDUTO = "Non possiedi questo oggetto.";
    private static final String OGGETTO_NON_INVENTARIO = "Questo oggetto non è presente nell' inventario.";
    public static String getHelp() {
       return Messaggio.HELP;
   }
    public static String getSeiTornato() {
        return Messaggio.SEI_TORNATO;
    }
    public static String getTiTrovi() {
        return Messaggio.TI_TROVI;
     }
    public static String getHaiRaccolto() {
        return Messaggio.HAI_RACCOLTO;
    }
    public static String getHaiLasciato() {
        return Messaggio.HAI_LASCIATO;
    }
    public static String getInventarioPieno() {
        return Messaggio.INVENTARIO_PIENO;
    }
    public static String getNord() {
        return Messaggio.NORD;
    }
    public static String getSud() {
        return Messaggio.SUD;
    }
    public static String getEst() {
        return Messaggio.EST;
    }
    public static String getOvest() {
        return Messaggio.OVEST;
    }
    public static String getTiSeiSpostatoA() {
        return Messaggio.TI_SEI_SPOSTATO_A;
    }
    public static String getInventario(){return Messaggio.INVENTARIO;}
    public static String getInvio(){return Messaggio.INVIO;}
    public static String getInvVuoto(){return Messaggio.INVENTARIO_VUOTO;}
    public static String getNoRaccogli(){return Messaggio.NO_RACCOGLI;}
    public static String getGiaRaccolto(){return Messaggio.GIA_RACCOLTO;}
    public static String getNonVedoOggetti(){return Messaggio.NON_VEDO_OGGETTI;}
    public static String getOggettoNonPresente(){return Messaggio.OGGETTO_NON_PRESENTE;}
    public static String getOggettoNonPosseduto(){return Messaggio.OGGETTO_NON_POSSEDUTO;}
    public static String getOggettoNonInventario(){return Messaggio.OGGETTO_NON_INVENTARIO;}
}
