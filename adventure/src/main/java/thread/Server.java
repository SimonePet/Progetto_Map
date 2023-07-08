/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import di.uniba.map.b.adventure.messaggi.MessaggiConversazione;

/**
 * @author Giannantonio
 */
public class Server implements Runnable {
    private static int port = 1234;
    private static ServerSocket serverSocket;
    private static PrintWriter writer;
    private static Socket clientSocket;
    private static String nomeUtente;
    private static boolean attivo=false;
    
    @Override
    public void run() {
        try {
            attivo=true;
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            while (true) {
                elaboraMessaggio();
            }
        } catch (IOException e) {
            System.out.println("Errore durante l'avvio del server: " + e.getMessage());
        }
    }

    public static void elaboraMessaggio() throws IOException {
        String messaggioClient = leggiMessaggioClient();
        if (messaggioClient.equalsIgnoreCase(MessaggiConversazione.MSG_UTENTE_1_OPZ_1)) {
            inviaRispostaClient(MessaggiConversazione.MSG_RADIO_1_OPZ_1);
        } else if (messaggioClient.equalsIgnoreCase(MessaggiConversazione.MSG_UTENTE_1_OPZ_2)) {
            inviaRispostaClient(MessaggiConversazione.MSG_RADIO_1_OPZ_2);
        } else if (messaggioClient.contains(MessaggiConversazione.MI_CHIAMO)) {
            inviaRispostaClient(MessaggiConversazione.MSG_RADIO_2_OPZ_1);
        } else if (messaggioClient.equalsIgnoreCase(MessaggiConversazione.MSG_UTENTE_2_OPZ_1)) {
            inviaRispostaClient(MessaggiConversazione.MSG_RADIO_2_OPZ_2);
        } else if (messaggioClient.equalsIgnoreCase(MessaggiConversazione.MSG_UTENTE_3_OPZ_1)) {
            inviaRispostaClient(MessaggiConversazione.MSG_RADIO_3_OPZ_1);
        } else if (messaggioClient.equalsIgnoreCase(MessaggiConversazione.MSG_UTENTE_3_OPZ_2)) {
            inviaRispostaClient(MessaggiConversazione.MSG_RADIO_3_OPZ_2);
        } else if (messaggioClient.equalsIgnoreCase(MessaggiConversazione.MSG_UTENTE_4_OPZ_1)) {
            inviaRispostaClient(MessaggiConversazione.RISPOSTA_FINALE);
        } else if (messaggioClient.equalsIgnoreCase(MessaggiConversazione.MSG_UTENTE_4_OPZ_2)) {
            inviaRispostaClient(MessaggiConversazione.RISPOSTA_FINALE);
        }
    }

    public static String leggiMessaggioClient() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String messaggioClient = reader.readLine();
        return messaggioClient;
    }

    public static void inviaRispostaClient(String messaggio) throws IOException {
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        // Esempio di invio di una risposta al client
        writer.println(messaggio);
    }

    public static void stop() {
        try {
            if(attivo){
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Errore durante la chiusura del server: " + e.getMessage());
        }
    }

    public static void setNomeUtente(String username) {
        nomeUtente = username;
    }


}
