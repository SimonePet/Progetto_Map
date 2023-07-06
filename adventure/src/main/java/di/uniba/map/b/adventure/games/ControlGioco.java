package di.uniba.map.b.adventure.games;

import data.PercorsoFileSystem;
import data.Suono;
import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.messaggi.Messaggio;
import di.uniba.map.b.adventure.messaggi.MessaggioCosta;
import di.uniba.map.b.adventure.messaggi.MessaggioGrotta;
import di.uniba.map.b.adventure.messaggi.MessaggioSentiero;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.Oggetto;
import swing.JFrameApp;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

    private static Set<Comando> comandi = new HashSet<>();

    /**
     * @param gni
     * @param frame
     * @param panel
     * @param background
     */
    public static void comandoNord(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioNord());
        frame.scrviSuEditor("\n");
        if (gni.getStanzaCorrente().getNord() != null) {
            if (!gni.getStanzaCorrente().getNord().getRaggiungibile() && gni.getStanzaCorrente().getNomeStanza().equalsIgnoreCase("Edificio esterno")) {
                Utils.generaFinestraPorta(frame, gni);
            } else {
                if (gni.getStanzaCorrente().getNord().getRaggiungibile()) {
                    gni.setStanzaCorrente(gni.getStanzaCorrente().getNord());
                    Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_SUONI_STANZE) + gni.getStanzaCorrente().getNomeStanza(), true);
                }
            }
            //System.out.println(Utils.percorsoAssoluto);
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());
            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            gni.getStanzaCorrente().setVisitata(true);
            try {
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_IMMAGINI_STANZE) + gni.getStanzaCorrente().getNomeStanza() + ".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            } catch (Exception e) {
                System.out.println("Errore nell'aggiunta dell'immagine");
            }
        }
    }

    /**
     *
     * @param gni
     * @param frame
     * @param panel
     * @param background
     */
    public static void comandoSud(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioSud());
        frame.scrviSuEditor("\n");
        if (gni.getStanzaCorrente().getSud() != null && gni.getStanzaCorrente().getSud().getRaggiungibile()) {
            gni.setStanzaCorrente(gni.getStanzaCorrente().getSud());
            Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_SUONI_STANZE) + gni.getStanzaCorrente().getNomeStanza(), true);
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());
            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            gni.getStanzaCorrente().setVisitata(true);
            try {
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_IMMAGINI_STANZE) + gni.getStanzaCorrente().getNomeStanza() + ".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            } catch (Exception e) {
                System.out.println("Errore nell'aggiunta dell'immagine");
            }
        }
    }

    /**
     * @param gni
     * @param frame
     * @param panel
     * @param background
     */
    public static void comandoEst(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioEst());
        frame.scrviSuEditor("\n");
        if (gni.getStanzaCorrente().getEst() != null && gni.getStanzaCorrente().getEst().getRaggiungibile()) {
            gni.setStanzaCorrente(gni.getStanzaCorrente().getEst());
            Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_SUONI_STANZE) + gni.getStanzaCorrente().getNomeStanza(), true);
            gni.getStanzaCorrente().setVisitata(true);
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());
            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            gni.getStanzaCorrente().setVisitata(true);
            try {
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_IMMAGINI_STANZE) + gni.getStanzaCorrente().getNomeStanza() + ".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            } catch (Exception e) {
                System.out.println("Errore nell'aggiunta dell'immagine");
            }
        }
    }

    /**
     * @param gni
     * @param frame
     * @param panel
     * @param background
     */
    public static void comandoOvest(final GiocoNaufragioIsola gni, final JFrameApp frame, final JPanel panel, final JLabel background) {
        frame.scrviSuEditor(gni.getStanzaCorrente().getMessaggioOvest());
        frame.scrviSuEditor("\n");
        if (gni.getStanzaCorrente().getOvest() != null && gni.getStanzaCorrente().getOvest().getRaggiungibile()) {
            gni.setStanzaCorrente(gni.getStanzaCorrente().getOvest());
            Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_SUONI_STANZE) + gni.getStanzaCorrente().getNomeStanza(), true);
            if (gni.getStanzaCorrente().getVisitata()) {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneCortaStanza());

            } else {
                frame.scrviSuEditor(gni.getStanzaCorrente().getDescrizioneLungaStanza());
            }
            gni.getStanzaCorrente().setVisitata(true);
            try {
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_IMMAGINI_STANZE) + gni.getStanzaCorrente().getNomeStanza() + ".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            } catch (Exception e) {
                System.out.println("Errore nell'aggiunta dell'immagine");
            }
        }
    }

    /**
     * @param gni
     * @param frame
     */
    public static void comandoInventario(final GiocoNaufragioIsola gni, final JFrameApp frame) {
        if (!gni.getInventario().isEmpty()) {
            frame.scrviSuEditor(Messaggio.getInventario() + Messaggio.getInvio());
            for (Oggetto oggettoInv : gni.getInventario()) {
                frame.scrviSuEditor(Utils.sostituisciPrimoCarattereMaiuscolo(oggettoInv.getNomeOggetto()) + ":\t" + oggettoInv.getDescrizioneOggetto() + Messaggio.getInvio());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getInvVuoto());
        }
    }

    /**
     *
     * @param gni
     * @param frame
     * @param ogg
     * @param oggInv
     */
    public static void comandoRaccogli(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg, final Oggetto oggInv) {
        //Verifico se la stanza corrente è visibile.
        if (gni.getStanzaCorrente().getVisibile()) {
            //Verifico che l'oggetto nel luogo corrente esiste.
            if (ogg != null) {
                //Verifico che l'oggetto può essere raccolto
                System.out.println("L'oggetto " + ogg.getNomeOggetto() + " e raccoglibile: " + ogg.isRaccogglibile());
                System.out.println("\nL'oggetto " + ogg.getNomeOggetto() + " e visibile: " + ogg.isVisibile());
                if (ogg.isVisibile()) {
                    if (ogg.isRaccogglibile()) {
                        Suono.riproduciTraccia(ogg.getNomeOggetto(), false);
                        gni.getInventario().add(ogg);
                        gni.getStanzaCorrente().getObjects().remove(ogg);
                        frame.scrviSuEditor(Messaggio.getHaiRaccolto() + ogg.getNomeOggetto());
                    } else {
                        //Se sono qui signigica che l'oggetto esiste ma non può essere raccolto
                        frame.scrviSuEditor(ogg.getDescrizioneRaccogli());
                    }
                } else {
                    //Se sono qui signigica che l'oggetto esiste ma non può essere raccolto
                    frame.scrviSuEditor(Messaggio.getOggettoNonPresente());
                }
            } else {
                if (oggInv != null) {
                    //Dato che l'oggeto da raccogliere non esiste controllo se sto cercando di raccogliere un oggetto
                    //che è presente nel mio inventario.
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
     * @param gni
     * @param frame
     * @param ogg
     * @param oggInv
     */
    public static void comandoOsserva(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg, final Oggetto oggInv) {
        if (ogg == null && oggInv == null) {
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
            if (ogg.getNomeOggetto().equalsIgnoreCase("cartello")) {
                frame.scrviSuEditor(MessaggioSentiero.getCARTELLO());
            } else {
                frame.scrviSuEditor(ogg.getDescrizioneOggetto());
            }
        } else if (ogg == null) {
            frame.scrviSuEditor(oggInv.getDescrizioneOggetto());
        } else {
            frame.scrviSuEditor("Non capisco.");
        }
    }

    /**
     *
     * @param gni
     * @param frame
     * @param oggInv
     */
    public static void comandoLascia(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto oggInv) {
        if (oggInv != null) {
            //Se possiedo l'oggetto
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
     *
     * @param gni
     * @param frame
     * @param oggInv
     * @throws IOException
     * @throws InterruptedException
     */
    public static void comandoAccendi(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto oggInv) throws IOException, InterruptedException {
        if (oggInv != null) {
            if (oggInv.getNomeOggetto().equalsIgnoreCase("lampada")) {
                if (gni.getInventario().contains(gni.getOggettoGioco("acciarino"))) {
                    frame.scrviSuEditor(Messaggio.getAccendiLampada());
                    gni.getOggettoGioco("lastra").setVisibile(true);
                    gni.getStanza("grotta").setVisibile(true);
                    gni.getStanza("grotta").setDescrizioneCortaStanza(MessaggioGrotta.getDescCortaLuce());
                    gni.getStanza("grotta").setDescrizioneCompletaStanza(MessaggioGrotta.getDescCompletaLuce());
                    gni.getStanza("grotta").setOsserva(MessaggioGrotta.getOsservaLuce());
                    gni.getStanza("grotta").setMessaggioNord(MessaggioGrotta.getNoNordLuce());
                    gni.getStanza("grotta").setMessaggioSud(MessaggioGrotta.getNoSudLuce());
                    gni.getStanza("grotta").setMessaggioOvest(MessaggioGrotta.getNoOvestLuce());
                    gni.getStanza("grotta").setOsserva(MessaggioGrotta.getOsservaLuce());
                } else if (oggInv.getNomeOggetto().equals("lampada")) {
                    frame.scrviSuEditor(Messaggio.getNoAccendiLampada());
                }
            } else if (oggInv.getNomeOggetto().equalsIgnoreCase("radio")) {
                if (gni.getInventario().contains(gni.getOggettoGioco("batteria"))) {
                    String nomeUtente = gni.getUsername();
                    JDialogRadio d = new JDialogRadio(frame, true, nomeUtente);
                    d.setVisible(true);
                    Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.PERCORSO_SUONI_STANZE) + gni.getStanzaCorrente().getNomeStanza(), true);
                } else if (oggInv.getNomeOggetto().equals("radio")) {
                    frame.scrviSuEditor("Impossibile accendere radio. Ti mancano le batterie");
                }
            } else {
                frame.scrviSuEditor(Messaggio.getNoAccendi());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    /**
     *
     * @param frame
     * @param oggInv
     * @param ogg
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
     *
     * @param gni
     * @param frame
     * @param ogg
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
     *
     * @param gni
     * @param frame
     * @param ogg
     */
    public static void comandoCostruisci(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg) {
        if (ogg != null) {
            if (ogg.getNomeOggetto().equals("zattera")) {
                if (gni.getInventario().contains(gni.getOggettoGioco("vela"))
                        && gni.getInventario().contains(gni.getOggettoGioco("corda"))
                        && gni.getInventario().contains(gni.getOggettoGioco("legno"))) {
                    frame.scrviSuEditor("Hai utilizzato il legno,le corde e la vela per costruire la zattera.\n\n");
                    frame.scrviSuEditor("==========HAI VINTO==========\n\n");
                    frame.scrviSuEditor("Complimenti sei riuscito a vincere questo gioco molto difficile.");

                } else {
                    frame.scrviSuEditor("Non hai ancora tutti gli oggetti a disposizione.");
                }
            } else {
                frame.scrviSuEditor("Non e possibile costruire questo oggetto.");
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }

    /**
     *
     * @param gni
     * @param frame
     */
    public static void comandoAiuto(final GiocoNaufragioIsola gni, final JFrameApp frame) {
        setComandi(gni);
        Oggetto prossimo;
        for (Oggetto oggetto : gni.getInventario()) {
            prossimo = oggetto;
            comandi.addAll(prossimo.getComandiConsentiti());
        }
        Iterator<Comando> iteratore1 = comandi.iterator();
        frame.scrviSuEditor(Messaggio.getListaComandi() + "\n");
        while (iteratore1.hasNext()) {
            frame.scrviSuEditor(iteratore1.next().getDescrizione() + "\n");
        }

    }

    /**
     *
     * @param gni
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
            comandi.add(gni.getComando("localizzazione"));
        }
    }

    /**
     *
     * @param gni
     * @param frame
     * @param invOgg
     */
    public static void comandoApri(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto invOgg) {
        if (invOgg != null) {
            if (invOgg.equals(gni.getOggettoGioco("telecomando"))) {
                frame.scrviSuEditor("Apri il telecomando e cade a terra... solo pezzi di plastica, tasti in gomma e due batterie.");
                gni.getOggettoGioco("batteria").setVisibile(true);
            } else {
                frame.scrviSuEditor("Nulla da aprire.");
                frame.scrviSuEditor("Non puoi aprire questo oggetto");
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    /**
     *
     * @param gni
     * @param frame
     * @param ogg
     */
    public static void comandoSposta(final GiocoNaufragioIsola gni, final JFrameApp frame, final Oggetto ogg) {
        if (ogg != null) {
            if (ogg.equals(gni.getOggettoGioco("armadio"))) {
                frame.scrviSuEditor("Spostando l'ardmadio hai scoperto un passaggio segreto ad un vecchio covo militare.");
                gni.getStanza("covo").setRaggiungibile(true);
            } else {
                frame.scrviSuEditor("Non puoi spostare questo oggetto.");
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }
    public static void comandoLocalizzazione(final GiocoNaufragioIsola gni, final JFrameApp frame) {
        frame.scrviSuEditor("La tua posizione e': " + gni.getStanzaCorrente().getNomeStanza());
        frame.scrviSuEditor(Messaggio.getInvio());
        if(gni.getStanzaCorrente().getNord()==null){
            frame.scrviSuEditor("Nord : Inaccessibile.");
        }
        else if(gni.getStanzaCorrente().getNord().getVisitata()){
            frame.scrviSuEditor("Nord : stanza " + gni.getStanzaCorrente().getNord().getNomeStanza());
        }
        else{
            frame.scrviSuEditor("Nord : stanza sconosciuta.");
        }
        frame.scrviSuEditor(Messaggio.getInvio());
        if(gni.getStanzaCorrente().getSud()==null){
            frame.scrviSuEditor("Sud : Inaccessibile.");
        }
        else if(gni.getStanzaCorrente().getSud().getVisitata()){
            frame.scrviSuEditor("Sud : la stanza " + gni.getStanzaCorrente().getSud().getNomeStanza());
        }
        else{
            frame.scrviSuEditor("Sud : stanza sconosciuta.");
        }
        frame.scrviSuEditor(Messaggio.getInvio());
        if(gni.getStanzaCorrente().getEst()==null){
            frame.scrviSuEditor("Est : Inaccessibile.");
        }
        else if(gni.getStanzaCorrente().getEst().getVisitata()){
            frame.scrviSuEditor("Est : la stanza " + gni.getStanzaCorrente().getEst().getNomeStanza());
        }
        else{
            frame.scrviSuEditor("Est : stanza sconosciuta.");
        }
        frame.scrviSuEditor(Messaggio.getInvio());
        if(gni.getStanzaCorrente().getOvest()==null){
            frame.scrviSuEditor("Ovest : Inaccessibile.");
        }
        else if(gni.getStanzaCorrente().getOvest().getVisitata()){
            frame.scrviSuEditor("Ovest : la stanza " + gni.getStanzaCorrente().getOvest().getNomeStanza());
        }
        else{
            frame.scrviSuEditor("Ovest : stanza sconosciuta.");
        }
    }
}
