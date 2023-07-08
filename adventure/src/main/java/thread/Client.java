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
 *
 * @author Giannantonio
 */
public class Client implements Runnable{
    private static String indirizzoServer;
    private static int porta;
    private static Socket socket;
    private static PrintWriter writer;
    private static BufferedReader reader;
    private static JTextArea textArea;

    public Client(String indirizzo, int portaServer,JTextArea textArea) {
        indirizzoServer = indirizzo;
        porta = portaServer;
        this.textArea=textArea;
        this.textArea.setEditable(false);
    }
   
    /*  connessione al Socket Server */
    @Override
    public void run() {
        try {
            socket = new Socket(indirizzoServer, porta);
            System.out.println("Connessione al server stabilita.");
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                leggiRispostaServer();
            }
        } catch (IOException e) {
            System.out.println("Errore durante la connessione al server: " + e.getMessage());
        }
    }
    
    
    public static void inviaMessaggio(String messaggio){
        System.out.println("CLIENT:"+messaggio +" inviato");
        writer.println(messaggio);
    }
    
    public static void leggiRispostaServer(){
        try {
            String response = reader.readLine();
            String nomeTraccia = ottieniStringaDopo(response,"::");
            Suono.riproduciTraccia(Utils.PERCORSO_SUONI_CONVERSAZIONE + nomeTraccia, false);
            response = troncaStringa(response,"::");
            response = correggiStringa(response);
            System.out.println("Risposta dal server: " + response);
            scriviRispostaTextArea(response);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura della risposta dal server: " + e.getMessage());
        }
    }

    public static void scriviRispostaTextArea(String messaggio) {
        if(textArea.getText().isEmpty()) {
            textArea.setText(messaggio);
        }
        else{
            textArea.setText(textArea.getText() + "\n"+ MessaggiConversazione.SEPARATORE+"\n" + messaggio);
        }
    }
    private static String correggiStringa(String input) {
        return input.replace('$', '\n');
    }

    private static String troncaStringa(String input, String sottostringa) {
        int indice = input.indexOf(sottostringa);
        if (indice != -1) {
            return input.substring(0, indice);
        } else {
            return input;
        }
    }

    private static String ottieniStringaDopo(String input, String sottostringa) {
        int indice = input.indexOf(sottostringa);
        if (indice != -1) {
            int indiceInizio = indice + sottostringa.length();
            return input.substring(indiceInizio);
        } else {
            return input;
        }
    }
}
