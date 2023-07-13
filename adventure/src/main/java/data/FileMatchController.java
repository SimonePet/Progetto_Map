/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


/**
 *  Classe per la gestione dei file per memorizzare gli engine (partite).
 */
public class FileMatchController extends FileController implements Serializable {

    /**
     * Costruttore della classe FileMatchController.
     *
     * @param nomeFileCorrente  Nome del file corrente.
     * @param directoryCorrente Directory corrente del file.
     */
    public FileMatchController(final String nomeFileCorrente, final String directoryCorrente) {
        super(nomeFileCorrente, directoryCorrente);
    }

    /**
     * Aggiunge un oggetto GiocoNaufragioIsola al file.
     *
     * @param game Oggetto GiocoNaufragioIsola da aggiungere.
     * @return true se l'oggetto è stato aggiunto con successo, false in caso contrario.
     * @throws IOException              se si verifica un errore di I/O durante l'operazione di scrittura.
     * @throws ClassNotFoundException se la classe dell'oggetto GiocoNaufragioIsola non viene trovata.
     */
    public boolean aggiungiPartita(final GiocoNaufragioIsola game) throws IOException, ClassNotFoundException {
        try {
            ObjectOutputStream out = null;
            if (this.getFile().exists() && this.getFile().length() == 0) {
                out = new ObjectOutputStream(Files.newOutputStream(this.getFile().toPath()));
            } else {
                out = new ObjectOutputStream(new FileOutputStream(this.getPercorso(), true)) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }
            out.writeObject(game);
            out.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
        /*
        Il metodo addMatch permette di aggiungere un oggetto GiocoNaufragioIsola al file.
        Prende in input un oggetto GiocoNaufragioIsola da aggiungere.
        Restituisce true se l'oggetto è stato aggiunto con successo, altrimenti restituisce false.
        Può lanciare un'eccezione IOException se si verifica un errore di I/O durante l'operazione di scrittura,
        oppure un'eccezione ClassNotFoundException se la classe dell'oggetto GiocoNaufragioIsola non viene trovata.
         */
    }

    /**
     * Ottiene un oggetto GiocoNaufragioIsola corrispondente al nome della partita specificato.
     *
     * @param nomePart Nome della partita per la quale si desidera ottenere l'oggetto GiocoNaufragioIsola.
     * @return Oggetto GiocoNaufragioIsola corrispondente al nome della partita, o null se non trovato.
     * @throws IOException              se si verifica un errore di I/O durante l'operazione di lettura.
     * @throws ClassNotFoundException se la classe dell'oggetto GiocoNaufragioIsola non viene trovata.
     */
    public GiocoNaufragioIsola getMatch(final String nomePart) throws IOException, ClassNotFoundException {
        GiocoNaufragioIsola game;
        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(this.getPercorso()));
        if (this.getFile().exists()) {
            try {
                while (true) {
                    game = (GiocoNaufragioIsola) objectIn.readObject();
                    if (game.getNomePartita().equalsIgnoreCase(nomePart)) {
                        return game;
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    objectIn.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return null;
        /*
        Il metodo getMatch restituisce un oggetto GiocoNaufragioIsola corrispondente al nome della partita specificato.
        Prende in input il nome della partita per la quale si desidera ottenere l'oggetto GiocoNaufragioIsola.
        Restituisce l'oggetto GiocoNaufragioIsola corrispondente al nome della partita, oppure null se non viene trovato.
        Può lanciare un'eccezione IOException se si verifica un errore di I/O durante l'operazione di lettura,
        oppure un'eccezione ClassNotFoundException se la classe dell'oggetto GiocoNaufragioIsola non viene trovata.
         */
    }

    /**
     * Ottiene una lista di oggetti GiocoNaufragioIsola delle partite non terminate.
     *
     * @return Lista di oggetti GiocoNaufragioIsola delle partite non terminate.
     * @throws FileNotFoundException se il file non viene trovato.
     * @throws IOException           se si verifica un errore di I/O durante l'operazione di lettura.
     */
    public List<GiocoNaufragioIsola> getMatch() throws FileNotFoundException, IOException {
        List<GiocoNaufragioIsola> lista = new ArrayList<>();
        GiocoNaufragioIsola game;
        FileInputStream fileIn = new FileInputStream(this.getFile());
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        if (this.getFile().exists() && this.getFile().length() > 0) {
            try {
                while (true) {
                    game = (GiocoNaufragioIsola) objectIn.readObject();
                    if (!game.getFinita()) {
                        lista.add(game);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    objectIn.close();
                    fileIn.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return lista;
    }
    /*
    Il metodo getMatch restituisce una lista di oggetti GiocoNaufragioIsola delle partite non terminate.
    Non prende alcun parametro in input. Restituisce una lista contenente gli oggetti GiocoNaufragioIsola delle partite non terminate.
    Può lanciare un'eccezione FileNotFoundException se il file non viene trovato,
    oppure un'eccezione IOException se si verifica un errore di I/O durante l'operazione di lettura
     */
}
