package multimediali;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe di utilità per la gestione delle immagini.
 * Questa classe fornisce metodi per caricare e manipolare immagini.
 * Il costruttore è dichiarato privato per evitare l'istanziazione di oggetti Immagini.
 */
public final class Immagini {

    /**
     * Classe di utilità per la gestione delle immagini.
     * Questa classe fornisce metodi per caricare e manipolare immagini.
     * Il costruttore è dichiarato privato per evitare l'istanziazione di oggetti Immagini.
     */
    private Immagini() {

    }

    /**
     * Carica un'immagine specificata dal percorso e nome dell'immagine e la visualizza come sfondo in un JPanel.
     *
     * @param percorso      Percorso dell'immagine.
     * @param nomeImmagine  Nome dell'immagine.
     * @param panel         JPanel in cui visualizzare l'immagine come sfondo.
     * @param background    JLabel utilizzato come sfondo per l'immagine.
     */
    public static void caricaImmagine(final String percorso, final String nomeImmagine, final JPanel panel, final JLabel background) {
        try {
            BufferedImage img = ImageIO.read(new File((percorso + nomeImmagine + ".png")));
            Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            panel.remove(background);
            background.setIcon(imageIcon);
            panel.add(background);
            background.setLayout(new FlowLayout());
            panel.revalidate();
            panel.repaint();
        } catch (IOException e) {
            System.out.println("Errore nell'aggiunta dell'immagine: " + e.getMessage());
        }
    }

    /**
     * Carica un'immagine specificata dal percorso e nome dell'immagine e la visualizza come sfondo in un JPanel.
     * L'immagine viene adattata alle dimensioni del pannello in modo da mantenere l'aspetto originale.
     * Il pannello viene reso trasparente e senza bordi.
     *
     * @param percorso      Percorso dell'immagine.
     * @param nomeImmagine  Nome dell'immagine.
     * @param panel         JPanel in cui visualizzare l'immagine come sfondo.
     */
    public static void caricaImmagine(final String percorso, final String nomeImmagine, final JPanel panel) {
        try {
            BufferedImage img = ImageIO.read(new File((percorso + nomeImmagine + ".png")));
            Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            panel.setBackground(new Color(0, 0, 0, 0));
            panel.setOpaque(false);
            panel.setBorder(BorderFactory.createEmptyBorder());
            panel.setLayout(new BorderLayout());

            JLabel background = new JLabel(imageIcon);
            panel.add(background);
            background.setLayout(new FlowLayout());

            panel.revalidate();
            panel.repaint();
        } catch (IOException e) {
            System.out.println("Errore nell'aggiunta dell'immagine: " + e.getMessage());
        }
    }

}
