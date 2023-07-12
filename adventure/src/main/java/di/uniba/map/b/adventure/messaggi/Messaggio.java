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
     * Costruttore privato della classe Messaggio.
     * Questo costruttore è dichiarato come privato per impedire l'istanziazione della classe.
     * Tutti i membri della classe sono dichiarati come costanti statiche e la classe è progettata per essere utilizzata come classe di utilità.
     * Non è necessario creare istanze di questa classe.
     */
    private Messaggio() {

    }

    private static final String HAI_RACCOLTO = "Hai raccolto: ";
    private static final String HAI_LASCIATO = "Hai lasciato: ";
    private static final String INVENTARIO_VUOTO = "Il tuo inventario e' vuoto.";
    private static final String GIA_RACCOLTO = "Hai gia raccolto questo oggetto. E' presente nel tuo inventario.";
    private static final String NORD = "Nord :";
    private static final String SUD = "Sud :";
    private static final String EST = "Est :";
    private static final String OVEST = "Ovest :";
    private static final String INVENTARIO = "Nel tuo inventario ci sono:";
    private static final String INVIO = "\n";
    private static final String NON_VEDO_OGGETTI = "Non c'è luce. Non vedo nulla da raccogliere.";
    private static final String OGGETTO_NON_PRESENTE = "L'oggetto che vuoi raccogliere non c'è.";
    private static final String OGGETTO_NON_POSSEDUTO = "Non possiedi questo oggetto.";
    private static final String OGGETTO_NON_INVENTARIO = "Questo oggetto non è presente nell' inventario.";
    private static final String ACCENDI_LAMPADA = "Hai utilizzato l'acciarino e la lampada si è accesa.";
    private static final String NO_ACCENDI_LAMPADA = "Non riesci ad accendere la lampada...servirebbe qualcosa...";
    private static final String NO_ACCENDI = "Non puoi accendere questo oggetto.";
    private static final String NO_LEGGI = "Non puoi leggere questo oggetto.";
    private static final String NO_PRESENTE = "Questo oggetto non è presente.";
    private static final String TAGLIA_LEGNA = "Hai utilizzato l'accetta ed hai ottenuto la legna.";
    private static final String NO_TAGLIA_LEGNA = "Non riesci ad abbattere l'albero ti servirebbe qualcosa di affilato...";
    private static final String NO_TAGLIA = "Non puoi tagliare questo oggetto.";
    private static final String LISTA_COMANDI = "Ecco a te tutta la lista dei comandi disponibili:";
    private static final String OGGETTI_LASCIATI = "In questa stanza hai lasciato:";
    private static final String NO_ACCENDI_RADIO = "Impossibile accendere radio. Ti mancano le batterie.";
    private static final String VITTORIA = "Hai utilizzato il legno, le corde e la vela per costruire la zattera.\n\n"
            + "===============HAI VINTO===============\n\n"
            + "Complimenti sei riuscito a vincere questo gioco molto difficile.\n"
            + "===NON CHIUDERE LA FINESTRA ATTENDI!!===";
    private static final String NO_LUOGO_ZATTERA = "Ma pensi veramente di poter costruire una zattera qui.";
    private static final String NO_TUTTI_OGGETTI = "Non hai ancora tutti gli oggetti a disposizione.";
    private static final String NO_COSTRUISCI = "Non è possibile costruire questo oggetto.";
    private static final String APRI_TELECOMANDO = "Apri il telecomando e cade a terra... solo pezzi di plastica, tasti in gomma e due batterie.";
    private static final String NO_APRI = "Nulla da aprire."
            + "Non puoi aprire questo oggetto";
    private static final String SPOSTA_ARMADIO = "Spostando l'armadio hai scoperto un passaggio segreto ad un vecchio covo militare.";
    private static final String NO_SPOSTA = "Non puoi spostare questo oggetto.";
    private static final String STANZA = "stanza ";
    private static final String STANZA_SCONOSCIUTA = "stanza sconosciuta.";
    private static final String STANZA_INACCESSIBILE = "Inaccessibile.";
    private static final String NO_BARCA = "Non avrebbe senso riparare la tua vecchia barca, meglio costruirne una di fortuna.";
    private static final String NO_RIPARA = "Non puoi riparare questo oggetto.";
    private static final String SCONFITTA = "Addio.\n" + "Non sei stato in grado di vincere?? Forse non sei un buon giocatore.";
    private static final String ORIENTARTI = "Ti servirebbe qualcosa per orientarti.";
    private static final String LAMPADA_ACCESA = "La lampada e' gia accesa.";

    private static final String TELECOMANDO_APERTO = "Hai gia aperto il telecomando.";
    private static final String ARMADIO_SPOSTATO = "Hai gia spostato l'armadio";
    private static final String COMANDO_NON_RICONOSCIUTO = "Non capisco quello che mi vuoi dire.";

    /**
     * Restituisce il messaggio "Hai raccolto l'oggetto".
     *
     * @return Messaggio "Hai raccolto l'oggetto".
     */
    public static String getHaiRaccolto() {
        return Messaggio.HAI_RACCOLTO;
    }

    /**
     * Restituisce il messaggio "Hai lasciato l'oggetto".
     *
     * @return Messaggio "Hai lasciato l'oggetto".
     */
    public static String getHaiLasciato() {
        return Messaggio.HAI_LASCIATO;
    }

    /**
     * Restituisce il messaggio per spostarsi verso Nord.
     *
     * @return Messaggio per spostarsi verso Nord.
     */
    public static String getNord() {
        return Messaggio.NORD;
    }

    /**
     * Restituisce il messaggio per spostarsi verso Sud.
     *
     * @return Messaggio per spostarsi verso Sud.
     */
    public static String getSud() {
        return Messaggio.SUD;
    }

    /**
     * Restituisce il messaggio per spostarsi verso Est.
     *
     * @return Messaggio per spostarsi verso Est.
     */
    public static String getEst() {
        return Messaggio.EST;
    }

    /**
     * Restituisce il messaggio per spostarsi verso Ovest.
     *
     * @return Messaggio per spostarsi verso Ovest.
     */
    public static String getOvest() {
        return Messaggio.OVEST;
    }

    /**
     * Restituisce il messaggio per visualizzare l'inventario.
     *
     * @return Messaggio per visualizzare l'inventario.
     */
    public static String getInventario() {
        return Messaggio.INVENTARIO;
    }

    /**
     * Restituisce il messaggio per l'invio di un oggetto.
     *
     * @return Messaggio per l'invio di un oggetto.
     */
    public static String getInvio() {
        return Messaggio.INVIO;
    }

    /**
     * Restituisce il messaggio "L'inventario è vuoto".
     *
     * @return Messaggio "L'inventario è vuoto".
     */
    public static String getInvVuoto() {
        return Messaggio.INVENTARIO_VUOTO;
    }

    /**
     * Restituisce il messaggio "Hai già raccolto questo oggetto".
     *
     * @return Messaggio "Hai già raccolto questo oggetto".
     */
    public static String getGiaRaccolto() {
        return Messaggio.GIA_RACCOLTO;
    }

    /**
     * Restituisce il messaggio "Non vedo nessun oggetto qui".
     *
     * @return Messaggio "Non vedo nessun oggetto qui".
     */
    public static String getNonVedoOggetti() {
        return Messaggio.NON_VEDO_OGGETTI;
    }

    /**
     * Restituisce il messaggio "L'oggetto non è presente qui".
     *
     * @return Messaggio "L'oggetto non è presente qui".
     */
    public static String getOggettoNonPresente() {
        return Messaggio.OGGETTO_NON_PRESENTE;
    }

    /**
     * Restituisce il messaggio "Non possiedi questo oggetto".
     *
     * @return Messaggio "Non possiedi questo oggetto".
     */
    public static String getOggettoNonPosseduto() {
        return Messaggio.OGGETTO_NON_POSSEDUTO;
    }

    /**
     * Restituisce il messaggio "L'oggetto non è nell'inventario".
     *
     * @return Messaggio "L'oggetto non è nell'inventario".
     */
    public static String getOggettoNonInventario() {
        return Messaggio.OGGETTO_NON_INVENTARIO;
    }

    /**
     * Restituisce il messaggio "Accendi la lampada".
     *
     * @return Messaggio "Accendi la lampada".
     */
    public static String getAccendiLampada() {
        return Messaggio.ACCENDI_LAMPADA;
    }

    /**
     * Restituisce il messaggio "Non puoi accendere la lampada qui".
     *
     * @return Messaggio "Non puoi accendere la lampada qui".
     */
    public static String getNoAccendiLampada() {
        return Messaggio.NO_ACCENDI_LAMPADA;
    }

    /**
     * Restituisce il messaggio "Non puoi accendere l'oggetto".
     *
     * @return Messaggio "Non puoi accendere l'oggetto".
     */
    public static String getNoAccendi() {
        return Messaggio.NO_ACCENDI;
    }

    /**
     * Restituisce il messaggio "Non puoi leggere l'oggetto".
     *
     * @return Messaggio "Non puoi leggere l'oggetto".
     */
    public static String getNoLeggi() {
        return Messaggio.NO_LEGGI;
    }

    /**
     * Restituisce il messaggio "L'oggetto non è presente nella stanza".
     *
     * @return Messaggio "L'oggetto non è presente nella stanza".
     */
    public static String getNoPresente() {
        return Messaggio.NO_PRESENTE;
    }

    /**
     * Restituisce il messaggio "Stai tagliando legna".
     *
     * @return Messaggio "Stai tagliando legna".
     */
    public static String getTagliaLegna() {
        return Messaggio.TAGLIA_LEGNA;
    }

    /**
     * Restituisce il messaggio "Non puoi tagliare la legna".
     *
     * @return Messaggio "Non puoi tagliare la legna".
     */
    public static String getNoTagliaLegna() {
        return Messaggio.NO_TAGLIA_LEGNA;
    }

    /**
     * Restituisce il messaggio "Non puoi tagliare l'oggetto".
     *
     * @return Messaggio "Non puoi tagliare l'oggetto".
     */
    public static String getNoTaglia() {
        return Messaggio.NO_TAGLIA;
    }

    /**
     * Restituisce il messaggio con la lista dei comandi disponibili.
     *
     * @return Messaggio con la lista dei comandi disponibili.
     */
    public static String getListaComandi() {
        return Messaggio.LISTA_COMANDI;
    }

    /**
     * Restituisce il messaggio con l'elenco degli oggetti lasciati nella stanza.
     *
     * @return Messaggio con l'elenco degli oggetti lasciati nella stanza.
     */
    public static String getOggettiLasciati() {
        return Messaggio.OGGETTI_LASCIATI;
    }

    /**
     * Restituisce il messaggio "Non puoi accendere la radio".
     *
     * @return Messaggio "Non puoi accendere la radio".
     */
    public static String getNoAccendiRadio() {
        return Messaggio.NO_ACCENDI_RADIO;
    }

    /**
     * Restituisce il messaggio di vittoria.
     *
     * @return Messaggio di vittoria.
     */
    public static String getVittoria() {
        return Messaggio.VITTORIA;
    }

    /**
     * Restituisce il messaggio "Non c'è un luogo per la zattera".
     *
     * @return Messaggio "Non c'è un luogo per la zattera".
     */
    public static String getNoLuogoZattera() {
        return Messaggio.NO_LUOGO_ZATTERA;
    }

    /**
     * Restituisce il messaggio "Non hai tutti gli oggetti necessari".
     *
     * @return Messaggio "Non hai tutti gli oggetti necessari".
     */
    public static String getNoTuttiOggetti() {
        return Messaggio.NO_TUTTI_OGGETTI;
    }

    /**
     * Restituisce il messaggio "Non puoi costruire".
     *
     * @return Messaggio "Non puoi costruire".
     */
    public static String getNoCostruisci() {
        return Messaggio.NO_COSTRUISCI;
    }

    /**
     * Restituisce il messaggio "Apri il telecomando".
     *
     * @return Messaggio "Apri il telecomando".
     */
    public static String getApriTelecomando() {
        return Messaggio.APRI_TELECOMANDO;
    }

    /**
     * Restituisce il messaggio "Non puoi aprire l'oggetto".
     *
     * @return Messaggio "Non puoi aprire l'oggetto".
     */
    public static String getNoApri() {
        return Messaggio.NO_APRI;
    }

    /**
     * Restituisce il messaggio "Sposta l'armadio".
     *
     * @return Messaggio "Sposta l'armadio".
     */
    public static String getSpostaArmadio() {
        return Messaggio.SPOSTA_ARMADIO;
    }

    /**
     * Restituisce il messaggio "Non puoi spostare l'oggetto".
     *
     * @return Messaggio "Non puoi spostare l'oggetto".
     */
    public static String getNoSposta() {
        return Messaggio.NO_SPOSTA;
    }

    /**
     * Restituisce il messaggio "Ti trovi nella stanza".
     *
     * @return Messaggio "Ti trovi nella stanza".
     */
    public static String getStanza() {
        return Messaggio.STANZA;
    }

    /**
     * Restituisce il messaggio "Stanza sconosciuta".
     *
     * @return Messaggio "Stanza sconosciuta".
     */
    public static String getStanzaSconosciuta() {
        return Messaggio.STANZA_SCONOSCIUTA;
    }

    /**
     * Restituisce il messaggio "Stanza inaccessibile".
     *
     * @return Messaggio "Stanza inaccessibile".
     */
    public static String getStanzaInaccessibile() {
        return Messaggio.STANZA_INACCESSIBILE;
    }

    /**
     * Restituisce il messaggio "Non puoi usare la barca".
     *
     * @return Messaggio "Non puoi usare la barca".
     */
    public static String getNoBarca() {
        return Messaggio.NO_BARCA;
    }

    /**
     * Restituisce il messaggio "Non puoi riparare l'oggetto".
     *
     * @return Messaggio "Non puoi riparare l'oggetto".
     */
    public static String getNoRipara() {
        return Messaggio.NO_RIPARA;
    }
    /**
     * Restituisce il messaggio di sconfitta.
     *
     * @return Messaggio di sconfitta.
     */
    public static String getSconfitta() {
        return Messaggio.SCONFITTA;
    }

    /**
     * Restituisce il messaggio "Orientati nella stanza".
     *
     * @return Messaggio "Orientati nella stanza".
     */
    public static String getOrientati() {
        return Messaggio.ORIENTARTI;
    }

    /**
     * Restituisce il messaggio "La lampada è accesa".
     *
     * @return Messaggio "La lampada è accesa".
     */
    public static String getLampadaAccesa() {
        return Messaggio.LAMPADA_ACCESA;
    }

    /**
     * Restituisce il messaggio "Il telecomando è aperto".
     *
     * @return Messaggio "Il telecomando è aperto".
     */
    public static String getTelecomandoAperto() {
        return Messaggio.TELECOMANDO_APERTO;
    }

    /**
     * Restituisce il messaggio "L'armadio è stato spostato".
     *
     * @return Messaggio "L'armadio è stato spostato".
     */
    public static String getArmadioSpostato() {
        return Messaggio.ARMADIO_SPOSTATO;
    }

    /**
     * Restituisce il messaggio "Comando non riconosciuto".
     *
     * @return Messaggio "Comando non riconosciuto".
     */
    public static String getComandoNonRiconosciuto() {
        return Messaggio.COMANDO_NON_RICONOSCIUTO;
    }

}
