/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import di.uniba.map.b.adventure.messaggi.MessaggioSentiero;
import di.uniba.map.b.adventure.parser.Parser;
import swing.FrameStart;

import java.io.File;
import java.io.IOException;
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

    public Engine(GameDescription game, boolean partitaCaricata) {
        this.game = game;
        if(!partitaCaricata){
            try {
                this.game.init();
            }catch (Exception ex) {
                System.err.println(ex);
            }
        }
        try {
            //Set<String> stopwords = Utils.loadFileListInSet(new File(".resources/stopwords"));

            String percorsoAssoluto = new File("").getAbsolutePath();
            String percorsoRelativo="";
            if(percorsoAssoluto.contains("adventure")){
                percorsoRelativo = "/resources/stopwords";
            }else{
                percorsoRelativo = "/adventure/resources/stopwords";
            }
            String fullPath = percorsoAssoluto + File.separator + percorsoRelativo;
            Set<String> stopwords = Utils.loadFileListInSet(new File(fullPath));
            parser = new Parser(stopwords);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


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

    public String getCurrentRoomName(){
        return game.getCurrentRoom().getNomeStanza();
    }

    public GameDescription getGame(){
        return game;
    }

    public Parser getParser(){
        return parser;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Non dovrebbe servire in quanto la partita viene caricata ed inizializzata in JFrameApp
        //Engine engine = new Engine(new GiocoNaufragioIsola());
        //engine.execute();
        FrameStart.main();
    }

}