/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import data.DatabaseController;
import data.FileController;
import di.uniba.map.b.adventure.parser.Parser;
import swing.FrameStart;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

/**
 * ATTENZIONE: l'Engine è molto spartanoo, in realtà demanda la logica alla
 * classe che implementa GameDescription e si occupa di gestire I/O sul
 * terminale.
 *
 * @author pierpaolo
 */
public class Engine {

    private final GameDescription game;
    private Parser parser;

    /**
     *
     * @param gameCorr
     * @param partitaCaricata
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
            String percorso=Utils.PERCORSO_STOPWORDS;
            System.out.println("Percorso stopwords: "+percorso);
            Set<String> stopwords = Utils.loadFileListInSet(new File(percorso));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     *
     */
    public void execute() {
        /*
        System.out.println("================================");
        System.out.println("* Adventure v. 0.3 - 2021-2022 *");
        System.out.println("================================");
        System.out.println(game.getCurrentRoom().getName());
        System.out.println();
        System.out.println(game.getCurrentRoom().getDescription());
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            ParserOutput p = parser.parse(command, game.getCommands(), game.getCurrentRoom().getObjects(), game.getInventory());
            if (p == null || p.getCommand() == null) {
                System.out.println("Non capisco quello che mi vuoi dire.");
            } else if (p.getCommand() != null && p.getCommand().getType() == CommandType.END) {
                System.out.println("Addio!");
                break;
            } else {
                game.nextMove(p, System.out);
                System.out.println();
            }
        }*/
    }

    /**
     *
     * @return
     */
    public String getCurrentRoomName() {
        return game.getStanzaCorrente().getNomeStanza();
    }

    /**
     *
     * @return
     */
    public GameDescription getGame() {
        return game;
    }

    /**
     *
     * @return
     */
    public Parser getParser() {
        return parser;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) throws SQLException {
        //Non dovrebbe servire in quanto la partita viene caricata ed inizializzata in JFrameApp
        //Engine engine = new Engine(new GiocoNaufragioIsola());
        //engine.execute();
        DatabaseController db = new DatabaseController();
        db.creaTabellaPartita();
        FileController f = new FileController("salvataggioPartita.txt","resources");
        f.create();
        FrameStart.main();
    }
}
