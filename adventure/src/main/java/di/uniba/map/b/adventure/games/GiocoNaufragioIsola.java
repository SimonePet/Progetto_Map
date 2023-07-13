/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.messaggi.Messaggio;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.TipoComando;
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Classe che rappresenta il gioco "Naufragio sull'Isola".
 * Estende la classe astratta GameDescription e definisce il comportamento del gioco.
 */

public class GiocoNaufragioIsola extends GameDescription {

    /**
     * Inizializza l'ambiente di gioco configurando comandi, stanze e le loro connessioni.
     * Inizializza anche gli oggetti di gioco.
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

        InizializzaOggetti.initOggetti(this);

        setStanzaCorrente(approdo);
    }

    /**
     * Esegue la prossima mossa del gioco in base all'output del parser.
     * Aggiorna l'interfaccia grafica e l'output di testo del gioco.
     *
     * @param p       Output del parser che contiene le informazioni sulla mossa
     * @param out     Oggetto PrintStream per l'output del gioco
     * @param frame   Oggetto JFrameApp per l'interfaccia grafica del gioco
     * @param panel   Pannello JPanel per l'interfaccia grafica del gioco
     * @param label   Etichetta JLabel per l'interfaccia grafica del gioco
     */
    @Override
    public void nextMove(final ParserOutput p, final PrintStream out, final JFrameApp frame, final JPanel panel, final JLabel label) {
        // Aggiunge una riga vuota all'editor
        frame.scrviSuEditor("\n\n");

        if (p == null) {
            // L'output del parser è nullo
            frame.scrviSuEditor(Messaggio.getComandoNonRiconosciuto());
        } else {
            if (p.getComando() == null) {
                // Il comando riconosciuto dall'output del parser è nullo
                frame.scrviSuEditor(Messaggio.getComandoNonRiconosciuto());
            } else {
                TipoComando comandoRiconosciuto = p.getComando().getTipoComando();
                // Esegue il comando corrispondente
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
                        ControlGioco.comandoOsserva(this, frame, p.getOggetto(), p.getInvOggetto());
                        break;
                    case INVENTARIO:
                        ControlGioco.comandoInventario(this, frame);
                        break;
                    case RACCOGLI:
                        ControlGioco.comandoRaccogli(this, frame, p.getOggetto(), p.getInvOggetto());
                        break;
                    case LASCIA:
                        ControlGioco.comandoLascia(this, frame, p.getInvOggetto());
                        break;
                    case NARRA:
                        // Mostra la descrizione lunga della stanza corrente nell'editor
                        frame.scrviSuEditor(getStanzaCorrente().getDescrizioneLungaStanza());
                        break;
                    case LOCALIZZAZIONE:
                        ControlGioco.comandoLocalizzazione(this, frame);
                        break;
                    case ACCENDI:
                        try {
                            ControlGioco.comandoAccendi(this, frame, p.getInvOggetto());
                        } catch (IOException | InterruptedException ex) {
                            Logger.getLogger(GiocoNaufragioIsola.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case APRI:
                        ControlGioco.comandoApri(this, frame, p.getInvOggetto());
                        break;
                    case LEGGI:
                        ControlGioco.comandoLeggi(frame, p.getInvOggetto(), p.getOggetto());
                        break;
                    case TAGLIA:
                        ControlGioco.comandoTaglia(this, frame, p.getOggetto());
                        break;
                    case COSTRUISCI:
                        ControlGioco.comandoCostruisci(this, frame, p.getGenericoOggetto());
                        break;
                    case SPOSTA:
                        ControlGioco.comandoSposta(this, frame, p.getOggetto());
                        break;
                    case AIUTO:
                        ControlGioco.comandoAiuto(this, frame);
                        break;
                    case RIPARA:
                        ControlGioco.comandoRipara(this, frame, p.getOggetto());
                        break;
                    case FINE:
                        ControlGioco.comandoFine(this, frame);
                        break;
                    case COMANDO_NON_RICONOSCIUTO:
                        ControlGioco.comandoNonRiconosciuto(frame);
                        break;
                }
            }
        }
        // Aggiorna l'etichetta con il nome della stanza corrente
        frame.scriviSuLabelStanza(frame.getEngine().getGame().getStanzaCorrente().getNomeStanza());
    }
}
