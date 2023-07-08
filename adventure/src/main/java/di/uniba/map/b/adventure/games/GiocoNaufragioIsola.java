/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.games;

import data.FileMatchController;
//Import dei messaggi
import di.uniba.map.b.adventure.messaggi.MessaggioCovo;
import di.uniba.map.b.adventure.messaggi.MessaggioSentiero;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioDentro;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioFuori;
import di.uniba.map.b.adventure.messaggi.MessaggioGrotta;
import di.uniba.map.b.adventure.messaggi.MessaggioCosta;
import di.uniba.map.b.adventure.messaggi.MessaggioBosco;
import di.uniba.map.b.adventure.messaggi.MessaggioOggetti;
import di.uniba.map.b.adventure.messaggi.MessaggioApprodo;


import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.OggettoContenitore;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;

import java.io.PrintStream;

import java.util.HashSet;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * ATTENZIONE: La descrizione del gioco è fatta in modo che qualsiasi gioco
 * debba estendere la classe GameDescription. L'Engine è fatto in modo che possa
 * eseguire qualsiasi gioco che estende GameDescription, in questo modo si
 * possono creare più gioci utilizzando lo stesso Engine.
 * <p>
 * Diverse migliorie possono essere applicate: - la descrizione del gioco
 * potrebbe essere caricate da file o da DBMS in modo da non modificare il
 * codice sorgente - l'utilizzo di file e DBMS non è semplice poiché all'interno
 * del file o del DBMS dovrebbe anche essere codificata la logica del gioco
 * (nextMove) oltre alla descrizione di stanze, oggetti, ecc...
 *
 * @author pierpaolo
 */
public class GiocoNaufragioIsola extends GameDescription {
    /**
     *
     */
    @Override
    public void init() {
        //Comandi del gioco
        InizializzaComandi.initComandi(this);

        //Stanze del gioco
        Stanza approdo = InizializzaStanze.inizializzaApprodo(this);
        Stanza costa = InizializzaStanze.inizializzaCosta(this);
        Stanza bosco = InizializzaStanze.inizializzaBosco(this);
        Stanza sentiero = InizializzaStanze.inizializzaSentiero(this);
        Stanza covo = InizializzaStanze.inizializzaCovo(this);
        Stanza edificioDentro = InizializzaStanze.inizializzaEdificioDentro(this);
        Stanza edificioFuori = InizializzaStanze.inizializzaEdificioFuori(this);
        Stanza grotta = InizializzaStanze.inizializzaGrotta(this);

        //Imposto la mappa

        //Mappa approdo
        approdo.setNord(costa);
        approdo.setSud(null);
        approdo.setEst(null);
        approdo.setOvest(bosco);

        //Mappa costa
        costa.setNord(null);
        costa.setSud(approdo);
        costa.setEst(null);
        costa.setOvest(sentiero);

        //Mappa bosco
        bosco.setNord(sentiero);
        bosco.setSud(null);
        bosco.setEst(approdo);
        bosco.setOvest(grotta);

        //Mappa covo
        covo.setNord(null);
        covo.setSud(edificioDentro);
        covo.setEst(null);
        covo.setOvest(null);

        //Mappa edificioDentro
        edificioDentro.setNord(covo);
        edificioDentro.setSud(edificioFuori);
        edificioDentro.setEst(null);
        edificioDentro.setOvest(null);

        //Mappa edificioFuori
        edificioFuori.setNord(edificioDentro);
        edificioFuori.setSud(sentiero);
        edificioFuori.setEst(null);
        edificioFuori.setOvest(null);

        //Mappa grotta
        grotta.setNord(null);
        grotta.setSud(null);
        grotta.setEst(bosco);
        grotta.setOvest(null);

        //Mappa sentiero
        sentiero.setNord(edificioFuori);
        sentiero.setSud(bosco);
        sentiero.setEst(costa);
        sentiero.setOvest(null);

        // TODO Creare classi per i messaggi e le stringhe degli oggetti
        InizializzaOggetti.initOggetti(this);

        setStanzaCorrente(approdo);
    }




    /* nextMove per scrivere su editor del frame */

    /**
     * @param p
     * @param out
     * @param frame
     * @param panel
     * @param label
     */
    @Override
    public void nextMove(final ParserOutput p, final PrintStream out, final JFrameApp frame, final JPanel panel, final JLabel label) {
        //frame.writeTextOnEditor("\n"+getCurrentRoom().getNomeStanza()+"\n");
        frame.scrviSuEditor("\n\n");
        if (p.getCommand() == null) {
            frame.scrviSuEditor("Non ho capito cosa devo fare! Prova con un altro comando.\n");
        } else {
            TipoComando comandoRiconosciuto = p.getCommand().getTipoComando();
            //move
            switch (comandoRiconosciuto) {
                case NORD:
                    ControlGioco.comandoNord(this, frame, panel, label);
                    break;
                case SUD:
                    ControlGioco.comandoSud(this, frame, panel, label);
                    break;
                case EST:
                    ControlGioco.comandoEst(this, frame, panel, label);
                    break;
                case OVEST:
                    ControlGioco.comandoOvest(this, frame, panel, label);
                    break;
                case OSSERVA:
                    ControlGioco.comandoOsserva(this, frame, p.getObject(), p.getInvObject());
                    break;
                case INVENTARIO:
                    ControlGioco.comandoInventario(this, frame);
                    break;
                case RACCOGLI:
                    ControlGioco.comandoRaccogli(this, frame, p.getObject(), p.getInvObject());
                    break;
                case LASCIA:
                    ControlGioco.comandoLascia(this, frame, p.getInvObject());
                    break;
                case NARRA:
                    frame.scrviSuEditor(getStanzaCorrente().getDescrizioneLungaStanza());
                    break;
                case SALVA:
                    String workingDirectory = System.getProperty("user.dir");
                    String relativePath = "adventure/resources";
                    String fullPath = workingDirectory + File.separator + relativePath;
                    FileMatchController fmc = new FileMatchController("/salvataggioPartita", fullPath);
                    break;
                case LOCALIZZAZIONE:
                    ControlGioco.comandoLocalizzazione(this, frame);
                    break;
                case ACCENDI: {
                    try {
                        ControlGioco.comandoAccendi(this, frame, p.getInvObject());
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(GiocoNaufragioIsola.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case APRI:
                    ControlGioco.comandoApri(this, frame, p.getInvObject());
                    break;
                case LEGGI:
                    ControlGioco.comandoLeggi(frame, p.getInvObject(), p.getObject());
                    break;
                case TAGLIA:
                    ControlGioco.comandoTaglia(this, frame, p.getObject());
                    break;
                case COSTRUISCI:
                    ControlGioco.comandoCostruisci(this, frame, p.getGenericObject());
                    break;
                case SPOSTA:
                    ControlGioco.comandoSposta(this, frame, p.getObject());
                    break;
                case AIUTO:
                    ControlGioco.comandoAiuto(this, frame);
                    break;
                case RIPARA:
                    ControlGioco.comandoRipara(this, frame, p.getObject());
                    break;
            }

        }
        frame.scriviSuLabelStanza(frame.getEngine().getGame().getStanzaCorrente().getNomeStanza());
    }
}
