/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import data.database.DatabaseController;
import data.FileController;
import di.uniba.map.b.adventure.parser.Parser;
import swing.FrameStart;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

/**
 * Classe Engine che rappresenta il motore principale del gioco.
 * Gestisce la logica di gioco, l'interazione con il giocatore e le operazioni di inizializzazione.
 */
public class Engine {

    private final GameDescription game;
    private Parser parser;

    /**
     * Costruttore per la creazione di un'istanza di Engine.
     *
     * @param gameCorr        Descrizione del gioco.
     * @param partitaCaricata Flag che indica se la partita è stata caricata da un salvataggio.
     */
    public Engine(final GameDescription gameCorr, final boolean partitaCaricata) {
        this.game = gameCorr;
        if (!partitaCaricata) {
            try {
                this.game.init();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
        try {
            String percorso = Utils.PERCORSO_STOPWORDS;
            Set<String> stopwords = Utils.loadFileListInSet(new File(percorso));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Restituisce il nome della stanza corrente.
     *
     * @return Nome della stanza corrente.
     */
    public String getCurrentRoomName() {
        return game.getStanzaCorrente().getNomeStanza();
    }

    /**
     * Restituisce la descrizione del gioco.
     *
     * @return Descrizione del gioco.
     */
    public GameDescription getGame() {
        return game;
    }

    /**
     * Restituisce l'oggetto Parser utilizzato per l'analisi dei comandi.
     *
     * @return Oggetto Parser.
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * Metodo principale per l'avvio dell'applicazione.
     *
     * @param args Argomenti della riga di comando.
     * @throws SQLException Se si verifica un errore durante l'accesso al database.
     */
    public static void main(final String[] args) throws SQLException {
        // Creazione del controller del database
        DatabaseController db = new DatabaseController();
        db.creaTabellaPartita();
        // Creazione del controller del file
        FileController f = new FileController("salvataggioPartita.txt", "resources");
        f.create();
        // Avvio del frame di inizio
        FrameStart.main();
        /*
        Il metodo main() è il punto di ingresso dell'applicazione.
        Inizialmente, viene creato un oggetto DatabaseController per gestire l'accesso al database e viene chiamato il
        metodo creaTabellaPartita() per creare la tabella necessaria.
        Successivamente, viene creato un oggetto FileController per gestire il salvataggio della partita su file e viene chiamato il
        metodo create() per creare il file specificato.
        Infine, viene avviato il frame di inizio chiamando il metodo main() della classe FrameStart.
         */
    }

}
