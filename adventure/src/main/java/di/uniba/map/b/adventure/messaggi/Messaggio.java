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
    private static final String NORD = "Nord :";
    private static final String SUD = "Sud :";
    private static final String EST = "Est :";
    private static final String OVEST = "Ovest :";
    private static final String TI_SEI_SPOSTATO_A = "Ti sei spostato a ";
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
            + "Complimenti sei riuscito a vincere questo gioco molto difficile.";
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

    public static String getInventario() {
        return Messaggio.INVENTARIO;
    }

    public static String getInvio() {
        return Messaggio.INVIO;
    }

    public static String getInvVuoto() {
        return Messaggio.INVENTARIO_VUOTO;
    }

    public static String getNoRaccogli() {
        return Messaggio.NO_RACCOGLI;
    }

    public static String getGiaRaccolto() {
        return Messaggio.GIA_RACCOLTO;
    }

    public static String getNonVedoOggetti() {
        return Messaggio.NON_VEDO_OGGETTI;
    }

    public static String getOggettoNonPresente() {
        return Messaggio.OGGETTO_NON_PRESENTE;
    }

    public static String getOggettoNonPosseduto() {
        return Messaggio.OGGETTO_NON_POSSEDUTO;
    }

    public static String getOggettoNonInventario() {
        return Messaggio.OGGETTO_NON_INVENTARIO;
    }

    public static String getAccendiLampada() {
        return Messaggio.ACCENDI_LAMPADA;
    }

    public static String getNoAccendiLampada() {
        return Messaggio.NO_ACCENDI_LAMPADA;
    }

    public static String getNoAccendi() {
        return Messaggio.NO_ACCENDI;
    }

    public static String getNoLeggi() {
        return Messaggio.NO_LEGGI;
    }

    public static String getNoPresente() {
        return Messaggio.NO_PRESENTE;
    }

    public static String getTagliaLegna() {
        return Messaggio.TAGLIA_LEGNA;
    }

    public static String getNoTagliaLegna() {
        return Messaggio.NO_TAGLIA_LEGNA;
    }

    public static String getNoTaglia() {
        return Messaggio.NO_TAGLIA;
    }

    public static String getListaComandi() {
        return Messaggio.LISTA_COMANDI;
    }

    public static String getOggettiLasciati() {
        return Messaggio.OGGETTI_LASCIATI;
    }

    public static String getNoAccendiRadio() {
        return Messaggio.NO_ACCENDI_RADIO;
    }

    public static String getVittoria() {
        return Messaggio.VITTORIA;
    }

    public static String getNoLuogoZattera() {
        return Messaggio.NO_LUOGO_ZATTERA;
    }

    public static String getNoTuttiOggetti() {
        return Messaggio.NO_TUTTI_OGGETTI;
    }

    public static String getNoCostruisci() {
        return Messaggio.NO_COSTRUISCI;
    }

    public static String getApriTelecomando() {
        return Messaggio.APRI_TELECOMANDO;
    }

    public static String getNoApri() {
        return Messaggio.NO_APRI;
    }

    public static String getSpostaArmadio() {
        return Messaggio.SPOSTA_ARMADIO;
    }

    public static String getNoSposta() {
        return Messaggio.NO_SPOSTA;
    }

    public static String getStanza() {
        return Messaggio.STANZA;
    }

    public static String getStanzaSconosciuta() {
        return Messaggio.STANZA_SCONOSCIUTA;
    }

    public static String getStanzaInaccessibile() {
        return Messaggio.STANZA_INACCESSIBILE;
    }

    public static String getNoBarca() {
        return Messaggio.NO_BARCA;
    }

    public static String getNoRipara() {
        return Messaggio.NO_RIPARA;
    }

    public static String getSconfitta() {
        return Messaggio.SCONFITTA;
    }

    public static String getOrientati() {
        return Messaggio.ORIENTARTI;
    }

    public static String getLampadaAccesa() {
        return Messaggio.LAMPADA_ACCESA;
    }

    public static String getTelecomandoAperto() {
        return Messaggio.TELECOMANDO_APERTO;
    }

    public static String getArmadioSpostato() {
        return Messaggio.ARMADIO_SPOSTATO;
    }
    public static String getComandoNonRiconosciuto() {
        return Messaggio.COMANDO_NON_RICONOSCIUTO;
    }

}
