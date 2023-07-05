/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;
import swing.JDialogRadio;

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

    public Client(String indirizzo, int portaServer) {
        indirizzoServer = indirizzo;
        porta = portaServer;
    }
   
    /*  connessione al Socket Server */
    @Override
    public void run() {
        try {
            socket = new Socket(indirizzoServer, porta);
            System.out.println("Connessione al server stabilita.");

            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
            System.out.println("Risposta dal server: " + response);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura della risposta dal server: " + e.getMessage());
        }
    }
    
   
    
    
}
