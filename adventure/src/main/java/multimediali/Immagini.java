package multimediali;

import di.uniba.map.b.adventure.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
        } catch (Exception e) {
            System.out.println("Errore nell'aggiunta dell'immagine");
        }

    }
}
