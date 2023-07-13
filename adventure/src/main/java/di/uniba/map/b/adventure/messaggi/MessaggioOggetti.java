package di.uniba.map.b.adventure.messaggi;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Stringhe relative a messaggi degli oggetti.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final class MessaggioOggetti {
    /**
     * Costruttore privato della classe MessaggioOggetti.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggioOggetti() {

    }

    private static final String DESCRZIONE_RADIO = "E' una vecchia radio a pile..."
            + "chissa se funzionera'...";
    private static final String DESCRIZIONE_PILE = "Sono delle pile stilo, non sembrano"
            + " essere scariche...";
    private static final String DESCRIZIONE_MAPPA = "E' una mappa del luogo, sembra essere"
            + " disegnata a mano...";
    private static final String DESCRIZIONE_TELECOMANDO = "Un semplice telecomando, sembra contenere delle batterie.";
    private static final String DESCRIZIONE_ACCIARINO = "Un acciarino, potresti riscaldarti o darti fuoco.";
    private static final String DESCRIZIONE_LASTRA = "Una lastra incisa, dovrei leggerla.";
    private static final String RACCOGLI_LASTRA = "Ma cosa pensi di essere....Il campione di bodybuilding.";
    private static final String DESCRIZIONE_LAMPADA = "Una lampada a petrolio, potrebbe essere utile per illuminare qualcosa.";
    private static final String DESCRIZIONE_CIFRARIO = "Un libricino che spiega come decifrare delle strane scritture.";
    private static final String DESCRIZIONE_VELA = "Una vela...veniva usata dai militari per costruire zattere di fortuna.";
    private static final String DESCRIZIONE_ACCETTA = "Un accetta, potrebbe essere utile per tagliare qualcosa.";
    private static final String DESCRIZIONE_CORDA = "Una corda, potrebbe essere utile per legare qualcosa.";
    private static final String DESCRIZIONE_FUCILE = "Un fucile, potrebbe essere utile per sparare a qualcosa.";
    private static final String DESCRIZIONE_BARCA = "Si tratta del relitto della tua imbarcazione... al suo interno uno stupido acciarino, una mappa, una radio ed un\nmisterioso libro del quale non ne conoscevi l'esistenza.";
    private static final String RACCOGLI_BARCA = "Pensi veramnete di poter raccogliere una barca????";
    private static final String DESCRIZIONE_CARTELLO = "Un incomprensibile cartello in legno...";
    private static final String RACCOGLI_CARTELLO = "Dove pensi di portare questo cartello potra' servire a qualcun altro.";
    private static final String DESCRIZIONE_ARMADIO = "Un grande armadio in legno...";
    private static final String RACCOGLI_ARMADIO = "Ammenoche tu non abbia idea di ristrutturare casa l'armadio non puoi raccoglierlo.";
    private static final String DESCRIZIONE_TV = "Una televisione un po' datata chissa se si accende...";
    private static final String RACCOGLI_TV = "Ma ti sei trasformato in un ladro per caso.";
    private static final String DESCRIZIONE_DIVANO = "Un bel divano in pelle, sembra esserci un telecomando.";
    private static final String RACCOGLI_DIVANO = "Ma pensi di avere un inventario cosi capiente???";
    private static final String DESCRIZIONE_ALBERO = "Un albero presente nel bosco.";
    private static final String RACCOGLI_ALBERO = "E' mai possibile che stai cercando di raccogliere un albero.";
    private static final String DESCRIZIONE_LEGNO = "Delle assi di legno.Sarebbero molto utili per costruire una zattera.";
    private static final String DESCRIZIONE_ZATTERA = "Ecco cio' che ti salverà da questa brutta avventura.";
    private static final String DESCRIZIONE_BOTOLA = "Una botola, sembra che non venga aperta da molto tempo.";
    private static final String RACCOGLI_BOTOLA = "Ma pensi di avere un inventario cosi capiente???";


    public static String getDescrzioneRadio() {
        return MessaggioOggetti.DESCRZIONE_RADIO;
    }

    public static String getDescrizionePile() {
        return MessaggioOggetti.DESCRIZIONE_PILE;
    }

    public static String getDescrizioneMappa() {
        return MessaggioOggetti.DESCRIZIONE_MAPPA;
    }

    public static String getDescrizioneTelecomando() {
        return MessaggioOggetti.DESCRIZIONE_TELECOMANDO;
    }

    public static String getDescrizioneAcciarino() {
        return MessaggioOggetti.DESCRIZIONE_ACCIARINO;
    }

    public static String getDescrizioneLastra() {
        return MessaggioOggetti.DESCRIZIONE_LASTRA;
    }

    public static String getRaccogliLastra() {
        return MessaggioOggetti.RACCOGLI_LASTRA;
    }

    public static String getDescrizioneLampada() {
        return MessaggioOggetti.DESCRIZIONE_LAMPADA;
    }

    public static String getDescrizioneCifrario() {
        return MessaggioOggetti.DESCRIZIONE_CIFRARIO;
    }

    public static String getDescrizioneVela() {
        return MessaggioOggetti.DESCRIZIONE_VELA;
    }

    public static String getDescrizioneAccetta() {
        return MessaggioOggetti.DESCRIZIONE_ACCETTA;
    }

    public static String getDescrizioneCorda() {
        return MessaggioOggetti.DESCRIZIONE_CORDA;
    }

    public static String getDescrizioneFucile() {
        return MessaggioOggetti.DESCRIZIONE_FUCILE;
    }

    public static String getDescrizioneBarca() {
        return MessaggioOggetti.DESCRIZIONE_BARCA;
    }

    public static String getRaccogliBarca() {
        return MessaggioOggetti.RACCOGLI_BARCA;
    }

    public static String getDescrizioneCartello() {
        return MessaggioOggetti.DESCRIZIONE_CARTELLO;
    }

    public static String getRaccogliCartello() {
        return MessaggioOggetti.RACCOGLI_CARTELLO;
    }

    public static String getDescrizioneArmadio() {
        return MessaggioOggetti.DESCRIZIONE_ARMADIO;
    }

    public static String getRaccogliArmadio() {
        return MessaggioOggetti.RACCOGLI_ARMADIO;
    }

    public static String getDescrizioneTv() {
        return MessaggioOggetti.DESCRIZIONE_TV;
    }

    public static String getRaccogliTv() {
        return MessaggioOggetti.RACCOGLI_TV;
    }

    public static String getDescrizioneDivano() {
        return MessaggioOggetti.DESCRIZIONE_DIVANO;
    }

    public static String getRaccogliDivano() {
        return MessaggioOggetti.RACCOGLI_DIVANO;
    }

    public static String getDescrizioneAlbero() {
        return MessaggioOggetti.DESCRIZIONE_ALBERO;
    }

    public static String getRaccogliAlbero() {
        return MessaggioOggetti.RACCOGLI_ALBERO;
    }

    public static String getDescrizioneLegno() {
        return MessaggioOggetti.DESCRIZIONE_LEGNO;
    }

    public static String getDescrizioneZattera() {
        return MessaggioOggetti.DESCRIZIONE_ZATTERA;
    }

    public static String getDescrizioneBotola() {
        return MessaggioOggetti.DESCRIZIONE_BOTOLA;
    }

    public static String getRaccogliBotola() {
        return MessaggioOggetti.RACCOGLI_BOTOLA;
    }
}
