package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.messaggi.Messaggio;
import di.uniba.map.b.adventure.type.Oggetto;
import swing.JFrameApp;


public class ControlGioco {

    public ControlGioco(){

    }

    public static void ComandoNord(GiocoNaufragioIsola GNI, final JFrameApp frame){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioNord());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getNord() != null && GNI.getCurrentRoom().getNord().getRaggiungibile()) {
            GNI.setCurrentRoom(GNI.getCurrentRoom().getNord());
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
            //move = true;
        } else {
            boolean noroom = true;
        }
    }

    public static void ComandoSud(GiocoNaufragioIsola GNI, final JFrameApp frame){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioSud());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getSud() != null && GNI.getCurrentRoom().getSud().getRaggiungibile()) {
            GNI.setCurrentRoom(GNI.getCurrentRoom().getSud());;
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
            //move = true;
        } else {
            boolean noroom = true;
        }
    }

    public static void ComandoEst(GiocoNaufragioIsola GNI, final JFrameApp frame){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioEst());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getEst() != null && GNI.getCurrentRoom().getEst().getRaggiungibile()) {
            GNI.setCurrentRoom(GNI.getCurrentRoom().getEst());
            GNI.getCurrentRoom().setVisitata(true);
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
            //move = true;
        } else {
            boolean noroom = true;
        }
    }

    public static void ComandoOvest(GiocoNaufragioIsola GNI, final JFrameApp frame){
        frame.scrviSuEditor(GNI.getCurrentRoom().getMessaggioOvest());
        frame.scrviSuEditor("\n");
        if (GNI.getCurrentRoom().getOvest() != null && GNI.getCurrentRoom().getOvest().getRaggiungibile()) {
            GNI.setCurrentRoom(GNI.getCurrentRoom().getOvest());
            if(GNI.getCurrentRoom().getVisitata())
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneCortaStanza());
            else
                frame.scrviSuEditor(GNI.getCurrentRoom().getDescrizioneLungaStanza());
            GNI.getCurrentRoom().setVisitata(true);
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
                if (ogg.isRaccogglibile()) {
                    GNI.getInventory().add(ogg);
                    GNI.getCurrentRoom().getObjects().remove(ogg);
                    frame.scrviSuEditor(Messaggio.getHaiRaccolto() + ogg.getNomeOggetto());
                } else {
                    //Se sono qui signigica che l'oggetto esiste ma non può essere raccolto
                    frame.scrviSuEditor(Messaggio.getNoRaccogli());
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

    public static void ComandoLascia(GiocoNaufragioIsola GNI, final JFrameApp frame,Oggetto oggInv){
        if (oggInv != null){
            System.out.println("p.getInvObject() restituisce: "+oggInv.getNomeOggetto());
            //Se possiedo l'oggetto
            if(GNI.getInventory().contains(oggInv)){
                GNI.getInventory().remove(oggInv);
                GNI.getCurrentRoom().getObjects().add(oggInv);
                frame.scrviSuEditor(Messaggio.getHaiLasciato() + oggInv.getNomeOggetto());
            }else{
                frame.scrviSuEditor(Messaggio.getOggettoNonPosseduto());
            }
        } else {
            frame.scrviSuEditor(Messaggio.getOggettoNonInventario());
        }
    }



}
