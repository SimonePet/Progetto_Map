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
    private static final int PORTA_SERVER = 1234;
    private static ServerSocket serverSocket;
    private static PrintWriter writer;
    private static Socket clientSocket;
    private static String nomeUtente;
    private static boolean attivo = false;

    /**
     * Avvia l'esecuzione del thread server.
     * Il server si mette in ascolto di connessioni dai client e elabora i messaggi ricevuti.
     * In caso di errori durante l'avvio del server, viene stampato un messaggio di errore.
     */
    @Override
    public void run() {
        try {
            attivo = true;
            serverSocket = new ServerSocket(PORTA_SERVER);
            clientSocket = serverSocket.accept();
            while (true) {
                elaboraMessaggio();
            }
        } catch (IOException e) {
            System.out.println("Errore durante l'avvio del server: " + e.getMessage());
        }
    }

    /**
     * Elabora il messaggio ricevuto dal client.
     * Il metodo legge il messaggio inviato dal client e confronta il suo contenuto con diverse opzioni predefinite.
     * In base al contenuto del messaggio, viene inviata una risposta appropriata al client.
     * Le opzioni di risposta predefinite sono definite nella classe MessaggiConversazione.
     * Se si verifica un'eccezione durante la lettura o l'invio del messaggio, l'eccezione viene propagata.
     *
     * @throws IOException se si verifica un errore di input/output durante la lettura o l'invio del messaggio
     */
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

    /**
     * Legge il messaggio inviato dal client.
     * Il metodo crea un oggetto BufferedReader per leggere il flusso di input del socket del client.
     * Legge una riga di testo dal flusso di input e restituisce il messaggio letto.
     * Se si verifica un'eccezione durante la lettura del messaggio, l'eccezione viene propagata come `IOException`.
     *
     * @return Messaggio letto dal client
     * @throws IOException se si verifica un errore di input/output durante la lettura del messaggio
     */
    public static String leggiMessaggioClient() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String messaggioClient = reader.readLine();
        return messaggioClient;
    }

    /**
     * Invia una risposta al client.
     * Il metodo crea un oggetto PrintWriter per scrivere il flusso di output verso il socket del client.
     * Utilizza il metodo `println` per inviare la risposta specificata al client.
     * Se si verifica un'eccezione durante l'invio della risposta, l'eccezione viene propagata come `IOException`.
     *
     * @param messaggio Risposta da inviare al client
     * @throws IOException se si verifica un errore di input/output durante l'invio della risposta
     */
    public static void inviaRispostaClient(final String messaggio) throws IOException {
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        writer.println(messaggio);
    }

    /**
     * Ferma il server chiudendo la connessione del socket.
     * Il metodo chiude il socket del server se il server è attivo.
     * Se si verifica un'eccezione durante la chiusura del server, l'eccezione viene gestita e viene visualizzato un messaggio di errore.
     */
    public static void stop() {
        try {
            if (attivo) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Errore durante la chiusura del server: " + e.getMessage());
        }
    }
    public static void setNomeUtente(final String username) {
        nomeUtente = username;
    }
}
