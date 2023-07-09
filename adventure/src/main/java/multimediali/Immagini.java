package multimediali;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Immagini {

    private Immagini() {

    }

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
            System.out.println("Errore nell'aggiunta dell'immagine");
        }
    }
    
    public static void caricaImmagine(final String percorso, final String nomeImmagine, final JPanel panel) {
        try {
            BufferedImage img = ImageIO.read(new File((percorso + nomeImmagine + ".png")));
            Image dimg = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            panel.setBackground(new Color(0,0,0,0));
            panel.setOpaque(false);
            panel.setBorder(BorderFactory.createEmptyBorder());
            panel.setLayout(new BorderLayout());
            JLabel background = new JLabel(imageIcon);
            panel.add(background);
            background.setLayout(new FlowLayout());
            panel.revalidate();
            panel.repaint();
        } catch (IOException e) {
            System.out.println("Errore nell'aggiunta dell'immagine");
        }
    }
}
