package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.type.TipoComando;
import multimediali.Immagini;
import multimediali.Suono;
import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.messaggi.*;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.Oggetto;
import swing.JFrameApp;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import swing.JDialogPunteggio;

import swing.JDialogRadio;

/**
 *
 */
public final class ControlGioco {
    /**
     *
     */
    private ControlGioco() {
    }

    private static final Set<Comando> comandi = new HashSet<>();
    private static final Comando[] comandiArray = new Comando[25];


    /**
     * Esegue il comando "nord" nel gioco del naufragio sull'isola.
     *
     * @param gni        Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame      Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param panel      Riferimento al pannello in cui viene visualizzata l'immagine di sfondo.
     * @param background Riferimento all'etichetta che mostra l'immagine di sfondo.
     */
    public static void comandoNord(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        // Scrive il messaggio della stanza corrente nell'editor
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioNord());
        // Verifica se la stanza a nord è raggiungibile
        if (gni.getStanzaCorrente().getNord() != null) {
            // Gestione speciale per l'Edificio esterno se la stanza a nord non è raggiungibile
            if (!gni.getStanzaCorrente().getNord().getRaggiungibile() && gni.getStanzaCorrente().getNomeStanza().equalsIgnoreCase(MessaggioEdificioFuori.getNome())) {
                Utils.generaFinestraPorta(frame, gni);
            } else {
                // Spostamento alla stanza a nord se è raggiungibile
                if (gni.getStanzaCorrente().getNord().getRaggiungibile()) {
                    gni.setStanzaCorrente(gni.getStanzaCorrente().getNord());
                    Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + gni.getStanzaCorrente().getNomeStanza(), true);
                }
            }
            // Mostra la descrizione della stanza corrente nell'editor
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());
            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            // Imposta la stanza corrente come visitata
            gni.getStanzaCorrente().setVisitata(true);
            // Carica l'immagine della stanza corrente nel pannello di sfondo
            Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_STANZE, gni.getStanzaCorrente().getNomeStanza(), panel, background);
        }
    }

    /**
     * Esegue il comando "sud" nel gioco del naufragio sull'isola.
     *
     * @param gni        Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame      Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param panel      Riferimento al pannello in cui viene visualizzata l'immagine di sfondo.
     * @param background Riferimento all'etichetta che mostra l'immagine di sfondo.
     */
    public static void comandoSud(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        // Scrive il messaggio della stanza corrente nell'editor
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioSud());
        // Verifica se la stanza a sud è raggiungibile
        if (gni.getStanzaCorrente().getSud() != null && gni.getStanzaCorrente().getSud().getRaggiungibile()) {
            // Spostamento alla stanza a sud
            gni.setStanzaCorrente(gni.getStanzaCorrente().getSud());
            Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + gni.getStanzaCorrente().getNomeStanza(), true);
            // Mostra la descrizione della stanza corrente nell'editor
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());
            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            // Imposta la stanza corrente come visitata
            gni.getStanzaCorrente().setVisitata(true);
            // Carica l'immagine della stanza corrente nel pannello di sfondo
            Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_STANZE, gni.getStanzaCorrente().getNomeStanza(), panel, background);
        }
    }

    /**
     * Esegue il comando "est" nel gioco del naufragio sull'isola.
     *
     * @param gni        Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame      Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param panel      Riferimento al pannello in cui viene visualizzata l'immagine di sfondo.
     * @param background Riferimento all'etichetta che mostra l'immagine di sfondo.
     */
    public static void comandoEst(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        // Scrive il messaggio della stanza corrente nell'editor
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioEst());
        // Verifica se la stanza a est è raggiungibile
        if (gni.getStanzaCorrente().getEst() != null && gni.getStanzaCorrente().getEst().getRaggiungibile()) {
            // Spostamento alla stanza a est
            gni.setStanzaCorrente(gni.getStanzaCorrente().getEst());
            Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + gni.getStanzaCorrente().getNomeStanza(), true);
            // Imposta la stanza corrente come visitata
            gni.getStanzaCorrente().setVisitata(true);
            // Mostra la descrizione della stanza corrente nell'editor
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());
            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            // Imposta la stanza corrente come visitata
            gni.getStanzaCorrente().setVisitata(true);
            // Carica l'immagine della stanza corrente nel pannello di sfondo
            Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_STANZE, gni.getStanzaCorrente().getNomeStanza(), panel, background);
        }
    }

    /**
     * Esegue il comando "ovest" nel gioco del naufragio sull'isola.
     *
     * @param gni        Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame      Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param panel      Riferimento al pannello in cui viene visualizzata l'immagine di sfondo.
     * @param background Riferimento all'etichetta che mostra l'immagine di sfondo.
     */
    public static void comandoOvest(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        // Scrive il messaggio della stanza corrente nell'editor
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioOvest());
        // Verifica se la stanza a ovest è raggiungibile
        if (gni.getStanzaCorrente().getOvest() != null && gni.getStanzaCorrente().getOvest().getRaggiungibile()) {
            // Spostamento alla stanza a ovest
            gni.setStanzaCorrente(gni.getStanzaCorrente().getOvest());
            Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + gni.getStanzaCorrente().getNomeStanza(), true);
            // Mostra la descrizione della stanza corrente nell'editor
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());
            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            // Imposta la stanza corrente come visitata
            gni.getStanzaCorrente().setVisitata(true);
            // Carica l'immagine della stanza corrente nel pannello di sfondo
            Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_STANZE, gni.getStanzaCorrente().getNomeStanza(), panel, background);
        }
    }

    /**
     * Esegue il comando "inventario" nel gioco del naufragio sull'isola.
     *
     * @param gni   Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     */
    public static void comandoInventario(final GiocoNaufragioIsola gni, final JFrameApp frame) {
        // Verifica se l'inventario non è vuoto
        if (!gni.getInventario().isEmpty()) {
            // Mostra l'intestazione del messaggio di inventario
            frame.scrviSuEditor(Messaggio.getInventario() + Messaggio.getInvio());
            // Scorre gli oggetti nell'inventario e li mostra nell'editor
            for (Oggetto oggettoInv : gni.getInventario()) {
                frame.scrviSuEditor(Utils.sostituisciPrimoCarattereMaiuscolo(oggettoInv.getNomeOggetto()) + ":\t" + oggettoInv.getDescrizioneOggetto() + Messaggio.getInvio());
            }
        } else {
            // Mostra un messaggio che l'inventario è vuoto
            frame.scrviSuEditor(Messaggio.getInvVuoto());
        }
    }

    /**
     * Esegue il comando "raccogli" nel gioco del naufragio sull'isola.
     *
     * @param gni     Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame   Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param ogg     Oggetto da raccogliere nella stanza corrente.
     * @param oggInv  Oggetto da raccogliere già presente nell'inventario.
     */
    public static void comandoRaccogli(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg, final Oggetto oggInv) {
        // Verifica se la stanza corrente è visibile
        if (gni.getStanzaCorrente().getVisibile()) {
            // Verifica che l'oggetto nel luogo corrente esista
            if (ogg != null) {
                // Verifica che l'oggetto possa essere raccolto
                if (ogg.isVisibile()) {
                    if (ogg.isRaccogglibile()) {
                        gni.getInventario().add(ogg);
                        gni.getStanzaCorrente().getObjects().remove(ogg);
                        frame.scrviSuEditor(Messaggio.getHaiRaccolto() + ogg.getNomeOggetto());
                    } else {
                        // Se sono qui significa che l'oggetto esiste ma non può essere raccolto
                        frame.scrviSuEditor(ogg.getDescrizioneRaccogli());
                    }
                } else {
                    // Se sono qui significa che l'oggetto esiste ma non può essere raccolto
                    frame.scrviSuEditor(Messaggio.getOggettoNonPresente());
                }
            } else {
                if (oggInv != null) {
                    // Dato che l'oggetto da raccogliere non esiste, controllo se sto cercando di raccogliere un oggetto
                    // che è presente nel mio inventario.
                    frame.scrviSuEditor(Messaggio.getGiaRaccolto());
                } else {
                    frame.scrviSuEditor(Messaggio.getOggettoNonPresente());
                }
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNonVedoOggetti());
        }
    }

    /**
     * Esegue il comando "osserva" nel gioco del naufragio sull'isola.
     *
     * @param gni     Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame   Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param ogg     Oggetto da osservare nella stanza corrente.
     * @param oggInv  Oggetto da osservare già presente nell'inventario.
     */
    public static void comandoOsserva(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg, final Oggetto oggInv) {
        if (ogg == null && oggInv == null) {
            // Osserva la stanza corrente e gli oggetti lasciati
            frame.scrviSuEditor(gni.getStanzaCorrente().getOsserva());
            Oggetto prossimo;
            boolean trovato = false;
            for (Oggetto oggetto : gni.getStanzaCorrente().getObjects()) {
                prossimo = oggetto;
                if (prossimo.isLasciato()) {
                    if (!trovato) {
                        frame.scrviSuEditor("\n" + Messaggio.getOggettiLasciati() + "\n");
                    }
                    frame.scrviSuEditor("-" + prossimo.getNomeOggetto() + ";\n");
                    trovato = true;
                }
            }
        } else if (ogg != null && oggInv == null) {
            // Osserva un oggetto presente nella stanza corrente
            if (ogg.getNomeOggetto().equalsIgnoreCase("cartello")) {
                frame.scrviSuEditor(MessaggioSentiero.getCARTELLO());
            } else {
                frame.scrviSuEditor(ogg.getDescrizioneOggetto());
            }
        } else if (ogg == null) {
            // Osserva un oggetto presente nell'inventario
            frame.scrviSuEditor(oggInv.getDescrizioneOggetto());
        } else {
            // Caso non riconosciuto
            frame.scrviSuEditor("Non capisco.");
        }
    }

    /**
     * Esegue il comando "lascia" nel gioco del naufragio sull'isola.
     *
     * @param gni     Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame   Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param oggInv  Oggetto da lasciare nell'inventario.
     */
    public static void comandoLascia(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto oggInv) {
        if (oggInv != null) {
            // Se possiedo l'oggetto
            if (gni.getInventario().contains(oggInv)) {
                gni.getInventario().remove(oggInv);
                oggInv.setLasciato(true);
                gni.getStanzaCorrente().getObjects().add(oggInv);
                frame.scrviSuEditor(Messaggio.getHaiLasciato() + oggInv.getNomeOggetto());
            } else {
                frame.scrviSuEditor(Messaggio.getOggettoNonPosseduto());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    /**
     * Esegue il comando "accendi" nel gioco del naufragio sull'isola.
     *
     * @param gni     Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame   Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param oggInv  Oggetto da accendere presente nell'inventario.
     * @throws IOException            Se si verifica un errore di input/output durante la riproduzione audio.
     * @throws InterruptedException   Se il thread viene interrotto durante l'esecuzione.
     */
    public static void comandoAccendi(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto oggInv) throws IOException, InterruptedException {
        if (oggInv != null) {
            if (oggInv.getNomeOggetto().equalsIgnoreCase("lampada")) {
                if (gni.getInventario().contains(gni.getOggettoGioco("acciarino"))) {
                    if(!gni.getStanza(MessaggioGrotta.getGrottaNome()).getVisibile()) {
                        frame.scrviSuEditor(Messaggio.getAccendiLampada());
                        gni.getOggettoGioco("lastra").setVisibile(true);
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setVisibile(true);
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setDescrizioneCortaStanza(MessaggioGrotta.getDescCortaLuce());
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setDescrizioneCompletaStanza(MessaggioGrotta.getDescCompletaLuce());
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setOsserva(MessaggioGrotta.getOsservaLuce());
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setMessaggioNord(MessaggioGrotta.getNoNordLuce());
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setMessaggioSud(MessaggioGrotta.getNoSudLuce());
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setMessaggioOvest(MessaggioGrotta.getNoOvestLuce());
                        gni.getStanza(MessaggioGrotta.getGrottaNome()).setOsserva(MessaggioGrotta.getOsservaLuce());
                    }
                    else{
                        frame.scrviSuEditor(Messaggio.getLampadaAccesa());
                    }
                } else {
                    frame.scrviSuEditor(Messaggio.getNoAccendiLampada());
                }
            } else if (oggInv.getNomeOggetto().equalsIgnoreCase("radio")) {
                if (gni.getInventario().contains(gni.getOggettoGioco("batteria"))) {
                    String nomeUtente = gni.getUsername();
                    JDialogRadio jDialogRadio = new JDialogRadio(frame, true, nomeUtente);
                    jDialogRadio.setVisible(true);
                    Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + gni.getStanzaCorrente().getNomeStanza(), true);
                    gni.getComandi().add(gni.getComando("sposta"));
                } else {
                    frame.scrviSuEditor(Messaggio.getNoAccendiRadio());
                }
            } else {
                frame.scrviSuEditor(Messaggio.getNoAccendi());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    /**
     * Esegue il comando "leggi" nel gioco del naufragio sull'isola.
     *
     * @param frame   Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param oggInv  Oggetto presente nell'inventario da leggere.
     * @param ogg     Oggetto presente nella stanza da leggere.
     */
    public static void comandoLeggi(final JFrameApp frame, final Oggetto oggInv, final Oggetto ogg) {
        if (oggInv != null || ogg != null) {
            if (oggInv != null) {
                if (oggInv.getNomeOggetto().equals("cifrario")) {
                    frame.scrviSuEditor(MessaggioCosta.getDescCifrario());
                } else {
                    frame.scrviSuEditor(Messaggio.getNoLeggi());
                }
            } else {
                if (ogg.getNomeOggetto().equals("lastra")) {
                    frame.scrviSuEditor(MessaggioGrotta.getDescLastra());
                } else {
                    frame.scrviSuEditor(Messaggio.getNoLeggi());
                }
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }


    /**
     * Esegue il comando "taglia" nel gioco del naufragio sull'isola.
     *
     * @param gni    Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame  Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param ogg    Oggetto da tagliare presente nella stanza.
     */
    public static void comandoTaglia(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg) {
        if (ogg != null) {
            if (ogg.getNomeOggetto().equals("albero")) {
                if (gni.getInventario().contains(gni.getOggettoGioco("accetta"))) {
                    frame.scrviSuEditor(Messaggio.getTagliaLegna());
                    gni.getInventario().add(gni.getOggettoGioco("legno"));
                } else {
                    frame.scrviSuEditor(Messaggio.getNoTagliaLegna());
                }
            } else {
                frame.scrviSuEditor(Messaggio.getNoTaglia());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }

    /**
     * Esegue il comando "costruisci" nel gioco del naufragio sull'isola.
     *
     * @param gni    Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame  Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param ogg    Oggetto da costruire presente nella stanza.
     */
    public static void comandoCostruisci(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg){
        if (ogg != null) {
            if (ogg.getNomeOggetto().equals("zattera")) {
                if (gni.getInventario().contains(gni.getOggettoGioco("vela"))
                        && gni.getInventario().contains(gni.getOggettoGioco("corda"))
                        && gni.getInventario().contains(gni.getOggettoGioco("legno"))) {
                    if (gni.getStanzaCorrente().getNomeStanza().equalsIgnoreCase(MessaggioApprodo.getNome())
                            || gni.getStanzaCorrente().getNomeStanza().equalsIgnoreCase(MessaggioCosta.getNome())) {
                        frame.scrviSuEditor(Messaggio.getVittoria());
                        Suono.riproduciTraccia(Utils.PERCORSO_SUONO_FINALE + "vittoria", true);
                        frame.finePartita();
                        gni.setFinita(true);
                        Utils.generaFinestraPunteggio(frame, gni);
                    } else {
                        frame.scrviSuEditor(Messaggio.getNoLuogoZattera());
                    }
                } else {
                    frame.scrviSuEditor(Messaggio.getNoTuttiOggetti());
                }
            } else {
                frame.scrviSuEditor(Messaggio.getNoCostruisci());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }

    /**
     * Esegue il comando "aiuto" nel gioco del naufragio sull'isola.
     *
     * @param gni    Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame  Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     */
    public static void comandoAiuto(final GiocoNaufragioIsola gni, final JFrameApp frame) {
        if(comandi.isEmpty()){
            setComandi(gni);
        }
        if(comandiArray[0] == null){
            inizializzaOrdineComandi(gni);
        }
        Oggetto prossimo;
        for (Oggetto oggetto : gni.getInventario()) {
            prossimo = oggetto;
            comandi.addAll(prossimo.getComandiConsentiti());
        }
        frame.scrviSuEditor(Messaggio.getListaComandi() + "\n");
        for(int i=0; i<25; i++) {
            if(comandi.contains(comandiArray[i])){
                frame.scrviSuEditor(comandiArray[i].getDescrizione() + "\n");
            }
        }
    }

    /**
     * Imposta i comandi disponibili nel gioco del naufragio sull'isola.
     *
     * @param gni    Il riferimento all'istanza del gioco del naufragio sull'isola.
     */
    public static void setComandi(final GiocoNaufragioIsola gni) {
        if (comandi.isEmpty()) {
            comandi.add(gni.getComando("nord"));
            comandi.add(gni.getComando("sud"));
            comandi.add(gni.getComando("est"));
            comandi.add(gni.getComando("ovest"));
            comandi.add(gni.getComando("inventario"));
            comandi.add(gni.getComando("osserva"));
            comandi.add(gni.getComando("raccogli"));
            comandi.add(gni.getComando("narra"));
            comandi.add(gni.getComando("salva"));
        }
    }

    /**
     * Esegue il comando "apri" nel gioco del naufragio sull'isola.
     *
     * @param gni     Il riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame   Il riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param invOgg  L'oggetto da aprire, preso dall'inventario del giocatore.
     */
    public static void comandoApri(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto invOgg) {
        if (invOgg != null) {
            if (invOgg.equals(gni.getOggettoGioco("telecomando"))) {
                if(!gni.getOggettoGioco("batteria").isVisibile()) {
                    frame.scrviSuEditor(Messaggio.getApriTelecomando());
                    gni.getOggettoGioco("batteria").setVisibile(true);
                }
                else{
                    frame.scrviSuEditor(Messaggio.getTelecomandoAperto());
                }
            } else {
                frame.scrviSuEditor(Messaggio.getNoApri());

            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    /**
     * Esegue il comando "sposta" nel gioco del naufragio sull'isola.
     *
     * @param gni     Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame   Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param ogg     Oggetto da spostare nella stanza corrente.
     */
    public static void comandoSposta(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg) {
        if (ogg != null) {
            if (ogg.equals(gni.getOggettoGioco("armadio"))) {
                if(!gni.getStanza(MessaggioCovo.getNome()).getRaggiungibile()) {
                    frame.scrviSuEditor(Messaggio.getSpostaArmadio());
                    gni.getStanzaCorrente().setMessaggioNord(MessaggioEdificioDentro.getNord());
                    gni.getStanza(MessaggioCovo.getNome()).setRaggiungibile(true);
                }
                else {
                    frame.scrviSuEditor(Messaggio.getArmadioSpostato());
                }
            } else {
                frame.scrviSuEditor(Messaggio.getNoSposta());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }

    /**
     * Esegue il comando "localizzazione" nel gioco del naufragio sull'isola.
     *
     * @param gni    Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame  Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     */
    public static void comandoLocalizzazione(final GiocoNaufragioIsola gni, final JFrameApp frame) {
        if(gni.getInventario().contains(gni.getOggettoGioco("mappa"))) {
            frame.scrviSuEditor("La tua posizione è: " + gni.getStanzaCorrente().getNomeStanza());
            frame.scrviSuEditor(Messaggio.getInvio());

            // Localizzazione delle stanze adiacenti
            if (gni.getStanzaCorrente().getNord() == null) {
                frame.scrviSuEditor(Messaggio.getNord()+ Messaggio.getStanzaInaccessibile());
            } else if (gni.getStanzaCorrente().getNord().getVisitata()) {
                frame.scrviSuEditor(Messaggio.getNord() + Messaggio.getStanza() + gni.getStanzaCorrente().getNord().getNomeStanza());
            } else {
                frame.scrviSuEditor(Messaggio.getNord()+ Messaggio.getStanzaSconosciuta());
            }
            frame.scrviSuEditor(Messaggio.getInvio());

            if (gni.getStanzaCorrente().getSud() == null) {
                frame.scrviSuEditor(Messaggio.getSud()+ Messaggio.getStanzaInaccessibile());
            } else if (gni.getStanzaCorrente().getSud().getVisitata()) {
                frame.scrviSuEditor(Messaggio.getSud()+Messaggio.getStanza() + gni.getStanzaCorrente().getSud().getNomeStanza());
            } else {
                frame.scrviSuEditor(Messaggio.getSud()+Messaggio.getStanzaSconosciuta());
            }
            frame.scrviSuEditor(Messaggio.getInvio());

            if (gni.getStanzaCorrente().getEst() == null) {
                frame.scrviSuEditor(Messaggio.getEst() + Messaggio.getStanzaInaccessibile());
            } else if (gni.getStanzaCorrente().getEst().getVisitata()) {
                frame.scrviSuEditor(Messaggio.getEst() + Messaggio.getStanza() + gni.getStanzaCorrente().getEst().getNomeStanza());
            } else {
                frame.scrviSuEditor(Messaggio.getEst() + Messaggio.getStanzaSconosciuta());
            }
            frame.scrviSuEditor(Messaggio.getInvio());

            if (gni.getStanzaCorrente().getOvest() == null) {
                frame.scrviSuEditor(Messaggio.getOvest()+ Messaggio.getStanzaInaccessibile());
            } else if (gni.getStanzaCorrente().getOvest().getVisitata()) {
                frame.scrviSuEditor(Messaggio.getOvest()+ Messaggio.getStanza() + gni.getStanzaCorrente().getOvest().getNomeStanza());
            } else {
                frame.scrviSuEditor(Messaggio.getOvest() + Messaggio.getStanzaSconosciuta());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOrientati());
        }
    }

    /**
     * Esegue il comando "ripara" nel gioco del naufragio sull'isola.
     *
     * @param gni    Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame  Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     * @param ogg    Oggetto da riparare.
     */
    public static void comandoRipara(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg) {
        if (ogg != null) {
            if (ogg.equals(gni.getOggettoGioco("barca"))) {
                frame.scrviSuEditor(Messaggio.getNoBarca());
            } else {
                frame.scrviSuEditor(Messaggio.getNoRipara());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }

    /**
     * Esegue il comando "fine" nel gioco del naufragio sull'isola.
     *
     * @param gni    Riferimento all'istanza del gioco del naufragio sull'isola.
     * @param frame  Riferimento all'oggetto JFrameApp per la gestione dell'interfaccia grafica.
     */
    public static void comandoFine(final GiocoNaufragioIsola gni, final JFrameApp frame) {
        frame.scrviSuEditor(Messaggio.getSconfitta());
        // Setta il textField non editabile
        Suono.riproduciTraccia(Utils.PERCORSO_SUONO_FINALE + "sconfitta", true);
        frame.finePartita();
        gni.setAbbandonata(true);
        gni.setFinita(true);
    }

    /**
     * Esegue l'azione quando il comando inserito non viene riconosciuto.
     *
     * @param frame Oggetto JFrameApp per la gestione dell'interfaccia grafica.
     */
    public static void comandoNonRiconosciuto(final JFrameApp frame) {
        frame.scrviSuEditor("Non capisco quello che mi vuoi dire.\n");
    }

    public static void inizializzaOrdineComandi(final GiocoNaufragioIsola GNI){
        comandiArray[0] = GNI.getComando("nord");
        comandiArray[1] = GNI.getComando("sud");
        comandiArray[2] = GNI.getComando("est");
        comandiArray[3] = GNI.getComando("ovest");
        comandiArray[4] = GNI.getComando("raccogli");
        comandiArray[5] = GNI.getComando("lascia");
        comandiArray[6] = GNI.getComando("inventario");
        comandiArray[7] = GNI.getComando("osserva");
        comandiArray[8] = GNI.getComando("apri");
        comandiArray[9] = GNI.getComando("accendi");
        comandiArray[10] = GNI.getComando("utilizza");
        comandiArray[11] = GNI.getComando("narra");
        comandiArray[12] = GNI.getComando("localizzazione");
        comandiArray[13] = GNI.getComando("ripara");
        comandiArray[14] = GNI.getComando("leggere");
        comandiArray[15] = GNI.getComando("costruisci");
        comandiArray[16] = GNI.getComando("sposta");
        comandiArray[17] = GNI.getComando("taglia");
        comandiArray[18] = GNI.getComando("salva");
        comandiArray[19] = GNI.getComando("fine");
    }
}
