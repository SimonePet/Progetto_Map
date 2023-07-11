/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;

import multimediali.Suono;
import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.messaggi.MessaggiConversazione;

/**
 * @author Giannantonio
 */
public class Client implements Runnable {
    private static String indirizzoServer;
    private static int porta;
    private static Socket socket;
    private static PrintWriter writer;
    private static BufferedReader reader;
    private static JTextArea textArea;

    /**
     * Costruisce un nuovo oggetto Client con l'indirizzo del server e la porta specificati.
     *
     * @param indirizzoServerCorr Indirizzo del server a cui il client si connetterà.
     * @param portaServerCorr     Porta del server a cui il client si connetterà.
     */
    public Client(final String indirizzoServerCorr, final int portaServerCorr) {
        Client.indirizzoServer = indirizzoServerCorr;
        Client.porta = portaServerCorr;
    }

    /**
     * Avvia l'esecuzione del thread, creando una connessione socket verso il server utilizzando l'indirizzo e la porta specificati.
     * Crea un writer per inviare messaggi al server attraverso il socket e un reader per leggere le risposte del server.
     * Legge continuamente le risposte del server all'interno di un ciclo infinito.
     * In caso di errori durante la connessione, stampa un messaggio di errore.
     */
    @Override
    public void run() {
        try {
            // Crea una connessione socket verso il server utilizzando l'indirizzo e la porta specificati
            socket = new Socket(indirizzoServer, porta);
            // Crea un writer per inviare messaggi al server attraverso il socket
            writer = new PrintWriter(socket.getOutputStream(), true);
            // Crea un reader per leggere le risposte del server attraverso il socket
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Continua a leggere le risposte del server in un ciclo infinito
            while (true) {
                leggiRispostaServer();
            }
        } catch (IOException e) {
            System.out.println("Errore durante la connessione al server: " + e.getMessage());
        }
    }


    /**
     * Invia un messaggio al server.
     *
     * @param messaggio Messaggio da inviare.
     */
    public static void inviaMessaggio(final String messaggio) {
        writer.println(messaggio);
    }

    /**
     * Legge la risposta inviata dal server.
     * La risposta viene letta dal BufferedReader associato alla connessione di input verso il server.
     * Una volta letta la risposta, estrae il nome della traccia audio (se presente) e la riproduce utilizzando la classe Suono.
     * Successivamente, la risposta viene troncata per rimuovere eventuali informazioni aggiuntive e corretta utilizzando il metodo correggiStringa.
     * Infine, la risposta viene scritta sulla TextArea di output.
     *
     * @throws IOException se si verifica un errore durante la lettura della risposta dal server.
     */
    public static void leggiRispostaServer() throws IOException {
        try {
            String response = reader.readLine();
            String nomeTraccia = ottieniStringaDopo(response, "::");
            Suono.riproduciTraccia(Utils.PERCORSO_SUONI_CONVERSAZIONE + nomeTraccia, false);
            response = troncaStringa(response, "::");
            response = correggiStringa(response);
            scriviRispostaTextArea(response);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura della risposta dal server: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Scrive il messaggio sulla TextArea di output.
     * Se la TextArea è vuota, il messaggio viene impostato direttamente come contenuto della TextArea.
     * Altrimenti, il messaggio viene concatenato al contenuto già presente nella TextArea,
     * separato da una riga di separazione definita dalla costante MessaggiConversazione.SEPARATORE.
     *
     * @param messaggio Messaggio da scrivere sulla TextArea di output.
     */
    public static void scriviRispostaTextArea(final String messaggio) {
        if (textArea.getText().isEmpty()) {
            textArea.setText(messaggio);
        } else {
            textArea.setText(textArea.getText() + "\n" + MessaggiConversazione.SEPARATORE + "\n" + messaggio);
        }
    }

    /**
     * Corregge la stringa di input sostituendo il carattere '$' con il carattere di nuova riga '\n'.
     *
     * @param input Stringa da correggere.
     * @return Stringa corretta con i caratteri '$' sostituiti da '\n'.
     */
    private static String correggiStringa(final String input) {
        return input.replace('$', '\n');
    }

    /**
     * Tronca la stringa di input fino alla prima occorrenza della sottostringa specificata.
     * Se la sottostringa non è presente, la stringa di input viene restituita senza modifiche.
     *
     * @param input      Stringa di input da troncare.
     * @param sottostringa Sottostringa a cui troncare la stringa di input.
     * @return Stringa troncata fino alla prima occorrenza della sottostringa, o la stringa di input originale se la sottostringa non è presente.
     */
    private static String troncaStringa(final String input, final String sottostringa) {
        int indice = input.indexOf(sottostringa);
        if (indice != -1) {
            return input.substring(0, indice);
        } else {
            return input;
        }
    }

    /**
     * Ottiene la stringa successiva alla prima occorrenza della sottostringa specificata.
     * Se la sottostringa non è presente, la stringa di input viene restituita senza modifiche.
     *
     * @param input      Stringa di input da analizzare.
     * @param sottostringa Sottostringa a cui ottenere la stringa successiva.
     * @return Stringa successiva alla prima occorrenza della sottostringa, o la stringa di input originale se la sottostringa non è presente.
     */
    private static String ottieniStringaDopo(final String input, final String sottostringa) {
        int indice = input.indexOf(sottostringa);
        if (indice != -1) {
            int indiceInizio = indice + sottostringa.length();
            return input.substring(indiceInizio);
        } else {
            return input;
        }
    }

    /**
     * Imposta la JTextArea di output per la classe Client.
     * La JTextArea specificata viene assegnata alla variabile statica textArea della classe Client,
     * e viene impostata come non editabile.
     *
     * @param textAreaCorr JTextArea da impostare come output.
     */
    public void setTextArea(final JTextArea textAreaCorr) {
        Client.textArea = textAreaCorr;
        Client.textArea.setEditable(false);
    }
}
