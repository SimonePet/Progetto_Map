/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;
/**
 *
 * @author Giannantonio
 */
public class Server implements Runnable{
    private static int port=1234;
    private static ServerSocket serverSocket;
    private static PrintWriter writer;
    private static Socket clientSocket;
    private static JTextArea textArea;
    private static String nomeUtente;
    
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server avviato. In attesa di connessioni...");
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Nuova connessione accettata.");
            }
        } catch (IOException e) {
            System.out.println("Errore durante l'avvio del server: " + e.getMessage());
        }
    }
    
    public static void elaboraMessaggio() throws IOException{
        String messaggioClient = leggiMessaggioClient();
        if(messaggioClient.equalsIgnoreCase("Aiuto venitemi a salvare")){
            inviaRispostaClient("Al momento siamo impegnati in altre missioni più urgenti. Teniamoci in contatto, tra 5/6 giorni forse passeremo. \nMa come ti chiami?");
            scriviRispostaTextArea("Al momento siamo impegnati in altre missioni più urgenti.\nTeniamoci in contatto, tra 5/6 giorni forse passeremo. \nMa come ti chiami?\n");
        }
        else if(messaggioClient.equalsIgnoreCase("perfavore portatemi una birra")){
            inviaRispostaClient("Sta arrivando un elicottero per risolvere questa questione di stato.\n" +
            "\nMa come ti chiami?");
            scriviRispostaTextArea("Sta arrivando un elicottero per risolvere questa questione di stato.\n" +
            "\nMa come ti chiami?\n");
        }else if(messaggioClient.contains("Mi chiamo")){
            inviaRispostaClient("Potevi scegliere un nome migliore. Ma dove ti trovi?");
            scriviRispostaTextArea("Potevi scegliere un nome migliore. Ma dove ti trovi?\n");
        }
        else if(messaggioClient.equalsIgnoreCase("Non ho accettato i diritti sulla privacy")){
            inviaRispostaClient("Le inviamo subito un contratto in PDF, lo firmi e lo rispedisca. Ma dove ti trovi?\n");
            scriviRispostaTextArea("Le inviamo subito un contratto in PDF, lo firmi e lo rispedisca. Ma dove ti trovi?\n");            
        }
        else if(messaggioClient.equalsIgnoreCase("Mi trovo su un'isola deserta")){
            inviaRispostaClient("In bocca al lupo noi non possiamo aiutarti. \nMa per caso l'edificio chiedeva un codice?\n");
            scriviRispostaTextArea("In bocca al lupo noi non possiamo aiutarti.\nMa per caso l'edificio chiedeva un codice? \n");              
        }
        else if(messaggioClient.equalsIgnoreCase("Mi trovo in vacanza")){
            inviaRispostaClient("Beato te.\nMa per caso l'edificio chiedeva un codice? \n");
            scriviRispostaTextArea("Beato te.\nMa per caso l'edificio chiedeva un codice? \n");             
        }
        else if(messaggioClient.equalsIgnoreCase("Si era 2538")){
            inviaRispostaClient("Allora ti trovi in una vecchia sede militare. Hai presente l'armadio situato all'interno dell'edificio?\n"
                    + "Bene, nasconde un vecchio covo militare. Basterà spostarlo per trovare tutto quello\n"
                    + "di cui hai bisogno. Buona fortuna, spero di incontrarti vivo e non come un cadavere.");
            scriviRispostaTextArea("Allora ti trovi in una vecchia sede militare. Hai presente l'armadio situato all'interno dell'edificio?\n"
                    + "Bene, nasconde un vecchio covo militare. Basterà spostarlo per trovare tutto quello\n"
                    + "di cui hai bisogno. Buona fortuna, spero di incontrarti vivo e non come un cadavere.");
        }
        else if(messaggioClient.equalsIgnoreCase("Non lo ricordo adesso ma era presente")){
            inviaRispostaClient("Allora ti trovi in una vecchia sede militare. Hai presente l'armadio situato all'interno dell'edificio?\n"
                    + "Bene, nasconde un vecchio covo militare. Basterà spostarlo per trovare tutto quello\n"
                    + "di cui hai bisogno. Buona fortuna, spero di incontrarti vivo e non come un cadavere.");
            scriviRispostaTextArea("Allora ti trovi in una vecchia sede militare. Hai presente l'armadio situato all'interno dell'edificio?\n"
                    + "Bene, nasconde un vecchio covo militare. Basterà spostarlo per trovare tutto quello\n"
                    + "di cui hai bisogno. Buona fortuna, spero di incontrarti vivo e non come un cadavere.");           
        }
    }
        
    public static String leggiMessaggioClient() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String messaggioClient = reader.readLine();
        System.out.println("SERVER:"+" Messaggio ricevuto dal client: " + messaggioClient);       
        return messaggioClient;
    }
    
    public static void inviaRispostaClient(String messaggio) throws IOException{
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        // Esempio di invio di una risposta al client           
        writer.println(messaggio);
    }
    
    public static void scriviRispostaTextArea(String messaggio){
        textArea.setText(textArea.getText()+ " "+messaggio);
    }
        
    public static void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Errore durante la chiusura del server: " + e.getMessage());
        }
    }
    
    public static void setTextArea(JTextArea txtArea){
        textArea = txtArea;
    }
    
    public static void setNomeUtente(String username){
        nomeUtente = username;
    }
    

}
