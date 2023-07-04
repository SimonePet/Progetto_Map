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
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ControlGioco {

    public ControlGioco(){

    }

    private static Set<Comando> comandi = new HashSet<>();

    public static void ComandoNord(GiocoNaufragioIsola GNI, final JFrameApp frame,final JPanel panel,JLabel background){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioNord());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getNord() != null && GNI.getCurrentRoom().getNord().getRaggiungibile()) {
            //System.out.println(Utils.percorsoAssoluto);
            GNI.setCurrentRoom(GNI.getCurrentRoom().getNord());
            Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.percorsoSuoniStanze) + GNI.getCurrentRoom().getNomeStanza(),true);
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
            try{
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.percorsoImmaginiStanze)+GNI.getCurrentRoom().getNomeStanza()+".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            }catch (Exception e){
                System.out.println("Errore nell'aggiunta dell'immagine");
            }

            //move = true;
        } else {
            boolean noroom = true;
        }
    }

    public static void ComandoSud(GiocoNaufragioIsola GNI, final JFrameApp frame,final JPanel panel,JLabel background){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioSud());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getSud() != null && GNI.getCurrentRoom().getSud().getRaggiungibile()) {
            GNI.setCurrentRoom(GNI.getCurrentRoom().getSud());;
            Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.percorsoSuoniStanze) + GNI.getCurrentRoom().getNomeStanza(),true);
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
            try{
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.percorsoImmaginiStanze)+GNI.getCurrentRoom().getNomeStanza()+".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            }catch (Exception e){
                System.out.println("Errore nell'aggiunta dell'immagine");
            }
            //move = true;
        } else {
            boolean noroom = true;
        }
    }

    public static void ComandoEst(GiocoNaufragioIsola GNI, final JFrameApp frame,final JPanel panel,JLabel background){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioEst());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getEst() != null && GNI.getCurrentRoom().getEst().getRaggiungibile()) {
            GNI.setCurrentRoom(GNI.getCurrentRoom().getEst());
            Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.percorsoSuoniStanze) + GNI.getCurrentRoom().getNomeStanza(),true);
            GNI.getCurrentRoom().setVisitata(true);
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
            try{
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.percorsoImmaginiStanze)+GNI.getCurrentRoom().getNomeStanza()+".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            }catch (Exception e){
                System.out.println("Errore nell'aggiunta dell'immagine");
            }
            //move = true;
        } else {
            boolean noroom = true;
        }
    }

    public static void ComandoOvest(GiocoNaufragioIsola GNI, final JFrameApp frame,final JPanel panel,JLabel background){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioOvest());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getOvest() != null && GNI.getCurrentRoom().getOvest().getRaggiungibile()) {
            GNI.setCurrentRoom(GNI.getCurrentRoom().getOvest());
            Suono.riproduciTraccia(PercorsoFileSystem.trovaPercorso(Utils.percorsoSuoniStanze) + GNI.getCurrentRoom().getNomeStanza(),true);
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
            try{
                BufferedImage img = ImageIO.read(new File(PercorsoFileSystem.trovaPercorso(Utils.percorsoImmaginiStanze)+GNI.getCurrentRoom().getNomeStanza()+".png"));
                Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                panel.remove(background);
                background.setIcon(imageIcon);
                panel.add(background);
                background.setLayout(new FlowLayout());
                panel.revalidate();
                panel.repaint();
            }catch (Exception e){
                System.out.println("Errore nell'aggiunta dell'immagine");
            }
            //move = true;
        } else {
            boolean noroom = true;
        }
    }

    public static void ComandoInventario(GiocoNaufragioIsola GNI, final JFrameApp frame){
        if (!GNI.getInventory().isEmpty()) {
            frame.scrviSuEditor(Messaggio.getInventario() + Messaggio.getInvio());
            for (Oggetto oggettoInv : GNI.getInventory()) {
                frame.scrviSuEditor(oggettoInv.getNomeOggetto() + ": " + oggettoInv.getDescrizioneOggetto() + Messaggio.getInvio());
            }
        }else {
            frame.scrviSuEditor(Messaggio.getInvVuoto());
        }
    }

    public static void ComandoRaccogli(GiocoNaufragioIsola GNI, final JFrameApp frame, Oggetto ogg,Oggetto oggInv){
        //Verifico se la stanza corrente è visibile.
        if(GNI.getCurrentRoom().getVisibile()) {
            //Verifico che l'oggetto nel luogo corrente esiste.
            if (ogg != null) {
                //Verifico che l'oggetto può essere raccolto
                System.out.println("L'oggetto "+ ogg.getNomeOggetto() + " e raccoglibile: "+ ogg.isRaccogglibile());
                System.out.println("\nL'oggetto "+ ogg.getNomeOggetto() + " e visibile: "+ ogg.isVisibile());
                if(ogg.isVisibile()){
                    if (ogg.isRaccogglibile()) {
                        Suono.riproduciTraccia(ogg.getNomeOggetto(),false);
                        GNI.getInventory().add(ogg);
                        GNI.getCurrentRoom().getObjects().remove(ogg);
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
                if(oggInv!=null){
                    //Dato che l'oggeto da raccogliere non esiste controllo se sto cercando di raccogliere un oggetto
                    //che è presente nel mio inventario.
                    frame.scrviSuEditor(Messaggio.getGiaRaccolto());
                }else{
                    frame.scrviSuEditor(Messaggio.getOggettoNonPresente());
                }
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNonVedoOggetti());
        }
    }

    public static void ComandoOsserva(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto ogg,Oggetto oggInv){
        if(ogg == null && oggInv == null){
            frame.scrviSuEditor(GNI.getCurrentRoom().getOsserva());
            Oggetto prossimo=null;
            boolean trovato=false;
            Iterator<Oggetto> iteratore = GNI.getCurrentRoom().getObjects().iterator();
            while (iteratore.hasNext()) {
                prossimo =iteratore.next();

                if(prossimo.isLasciato()){
                    if(!trovato){
                        frame.scrviSuEditor("\n"+Messaggio.getOggettiLasciati()+"\n");
                    }
                    frame.scrviSuEditor("-"+prossimo.getNomeOggetto()+";\n");
                    trovato=true;
                }
            }
        } else if (ogg !=null && oggInv == null) {
            if(ogg.getNomeOggetto().equalsIgnoreCase("cartello")){
                frame.scrviSuEditor(MessaggioSentiero.getCARTELLO());
            }
            else {
                frame.scrviSuEditor(ogg.getDescrizioneOggetto());
            }
        } else if (ogg == null) {
            frame.scrviSuEditor(oggInv.getDescrizioneOggetto());
        }
        else{
            frame.scrviSuEditor("Non capisco.");
        }
    }

    public static void ComandoLascia(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto oggInv){
        if (oggInv != null){
            //Se possiedo l'oggetto
            if(GNI.getInventory().contains(oggInv)){
                GNI.getInventory().remove(oggInv);
                oggInv.setLasciato(true);
                GNI.getCurrentRoom().getObjects().add(oggInv);
                frame.scrviSuEditor(Messaggio.getHaiLasciato() + oggInv.getNomeOggetto());
            }else{
                frame.scrviSuEditor(Messaggio.getOggettoNonPosseduto());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    public static void ComandoAccendi(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto oggInv){
        if(oggInv != null){
            if(oggInv.getNomeOggetto().equals("lampada")){
                if(GNI.getInventory().contains(GNI.getOggettoGioco("acciarino"))){
                    frame.scrviSuEditor(Messaggio.getAccendiLampada());
                    GNI.getOggettoGioco("lastra").setVisibile(true);
                    GNI.getStanza("grotta").setVisibile(true);
                    GNI.getStanza("grotta").setDescrizioneCortaStanza(MessaggioGrotta.getDescCortaLuce());
                    GNI.getStanza("grotta").setDescrizioneCompletaStanza(MessaggioGrotta.getDescCompletaLuce());
                    GNI.getStanza("grotta").setOsserva(MessaggioGrotta.getOsservaLuce());
                    GNI.getStanza("grotta").setMessaggioNord(MessaggioGrotta.getNoNordLuce());
                    GNI.getStanza("grotta").setMessaggioSud(MessaggioGrotta.getNoSudLuce());
                    GNI.getStanza("grotta").setMessaggioOvest(MessaggioGrotta.getNoOvestLuce());
                    GNI.getStanza("grotta").setOsserva(MessaggioGrotta.getOsservaLuce());

                } else {
                    frame.scrviSuEditor(Messaggio.getNoAccendiLampada());
                }
            } else {
                frame.scrviSuEditor(Messaggio.getNoAccendi());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    public static void ComandoLeggi(final JFrameApp frame,Oggetto oggInv,Oggetto ogg){
        if(oggInv != null || ogg != null){
            if(oggInv!=null){
                if(oggInv.getNomeOggetto().equals("cifrario")) {
                    frame.scrviSuEditor(MessaggioCosta.getDescCifrario());
                }
                else{
                    frame.scrviSuEditor(Messaggio.getNoLeggi());
                }
            }
            else {
                if (ogg.getNomeOggetto().equals("lastra")) {
                    frame.scrviSuEditor(MessaggioGrotta.getDescLastra());
                }
                else {
                    frame.scrviSuEditor(Messaggio.getNoLeggi());
                }
            }
        } else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }

    public static void ComandoTaglia(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto ogg){
        if(ogg != null){
            if(ogg.getNomeOggetto().equals("albero")){
                if(GNI.getInventory().contains(GNI.getOggettoGioco("accetta"))){
                    frame.scrviSuEditor(Messaggio.getTagliaLegna());
                    GNI.getInventory().add(GNI.getOggettoGioco("legno"));

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


    public static void ComandoCostruisci(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto ogg){
        if(ogg != null){
            if(ogg.getNomeOggetto().equals("zattera")){
                if(GNI.getInventory().contains(GNI.getOggettoGioco("vela")) &&
                        GNI.getInventory().contains(GNI.getOggettoGioco("corda")) &&
                        GNI.getInventory().contains(GNI.getOggettoGioco("legno"))){
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

    public static void ComandoAiuto(GiocoNaufragioIsola GNI, final JFrameApp frame){
        setComandi(GNI);
        Oggetto prossimo =null;
        Iterator<Oggetto> iteratore =GNI.getInventory().iterator();
        while(iteratore.hasNext()){
            prossimo =iteratore.next();
            comandi.addAll(prossimo.getComandiConsentiti());
        }
        Iterator<Comando> iteratore1 =comandi.iterator();
        frame.scrviSuEditor(Messaggio.getListaComandi()+"\n");
        while(iteratore1.hasNext()){
            frame.scrviSuEditor(iteratore1.next().getDescrizione()+"\n");
        }

    }

    public static void setComandi(GiocoNaufragioIsola GNI){
        if(comandi.isEmpty()){
            comandi.add(GNI.getComando("nord"));
            comandi.add(GNI.getComando("sud"));
            comandi.add(GNI.getComando("est"));
            comandi.add(GNI.getComando("ovest"));
            comandi.add(GNI.getComando("inventario"));
            comandi.add(GNI.getComando("osserva"));
            comandi.add(GNI.getComando("raccogli"));
            comandi.add(GNI.getComando("narra"));
            comandi.add(GNI.getComando("salva"));
        }
    }

    public static void ComandoApri(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto InvOgg){
        if(InvOgg!=null){
            if(InvOgg.equals(GNI.getOggettoGioco("telecomando"))){
                frame.scrviSuEditor("Apri il telecomando e cade a terra... solo pezzi di plastica, tasti in gomma e due batterie.");
                GNI.getOggettoGioco("batteria").setVisibile(true);
            } else {
                frame.scrviSuEditor("Nulla da aprire.");
                frame.scrviSuEditor("Non puoi aprire questo oggetto");
            }
        }
        else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }

    public static void ComandoSposta(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto Ogg){
        if(Ogg!=null){
            if(Ogg.equals(GNI.getOggettoGioco("armadio"))){
                frame.scrviSuEditor("Spostando l'ardmadio hai scoperto un passaggio segreto ad un vecchio covo militare.");
                GNI.getStanza("covo").setRaggiungibile(true);
            } else {
                frame.scrviSuEditor("Non puoi spostare questo oggetto.");
            }
        }
        else {
            frame.scrviSuEditor(Messaggio.getNoPresente());
        }
    }
}
