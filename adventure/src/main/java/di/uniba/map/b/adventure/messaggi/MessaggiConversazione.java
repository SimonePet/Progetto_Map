package di.uniba.map.b.adventure.messaggi;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Stringhe relative a messaggi della conversazione.
 * La classe è dichiarata final perchè non può essere estesa da altre classi.
 * La classe è utilizzata come classe di utilità con metodi e costanti accessibili in modo statico.
 */
public final  class MessaggiConversazione {

    /**
     * Costruttore privato della classe MessaggiConversazione.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private MessaggiConversazione() {

    }

    public static final String MSG_UTENTE_1_OPZ_1 = "Aiuto venitemi a salvare";
    public static final String MSG_UTENTE_1_OPZ_2 = "Perfavore portatemi una birra";
    public static final String MSG_RADIO_1_OPZ_1 = "Al momento siamo impegnati in altre missioni più urgenti. Teniamoci in contatto, tra 5/6 giorni forse passeremo.$Ma come ti chiami?::audio1";
    public static final String MSG_RADIO_1_OPZ_2 = "Sta arrivando un elicottero per risolvere questa questione di stato.$Ma come ti chiami?::audio2";
    public static final String MSG_RADIO_2_OPZ_1 = "Potevi scegliere un nome migliore. Ma dove ti trovi?::audio3";
    public static final String MSG_RADIO_2_OPZ_2 = "Le inviamo subito un contratto in PDF, lo firmi e lo rispedisca.$Ma dove ti trovi?::audio4";
    public static final String MSG_UTENTE_2_OPZ_1 = "Non ho accettato i diritti sulla privacy";
    public static final String MSG_UTENTE_3_OPZ_1 = "Mi trovo su un'isola deserta";
    public static final String MSG_UTENTE_3_OPZ_2 = "Mi trovo in vacanza";
    public static final String MSG_RADIO_3_OPZ_1 = "In bocca al lupo noi non possiamo aiutarti.$Ma per caso l'edificio chiedeva un codice?::audio5";
    public static final String MSG_RADIO_3_OPZ_2 = "Beato te.$Ma per caso l'edificio chiedeva un codice?::audio6";
    public static final String MSG_UTENTE_4_OPZ_1 = "Si era 2538";
    public static final String MSG_UTENTE_4_OPZ_2 = "Non lo ricordo adesso ma era presente";
    public static final String RISPOSTA_FINALE = "Allora ti trovi in una vecchia sede militare.$Hai presente l'armadio situato all'interno dell'edificio?"
            + "$Bene, nasconde un vecchio covo militare. $Basterà spostarlo per trovare tutto quello "
            + "di cui hai bisogno. $Buona fortuna, spero di incontrarti vivo e non come un cadavere.::audio7";

    public static final String MI_CHIAMO = "Mi chiamo";
    public static final String SEPARATORE = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
}
