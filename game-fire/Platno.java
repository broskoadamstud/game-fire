import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.HashMap;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example. 
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 * @author: Michal Mrena
 *
 * @version 2.0  (7 November 2022)
 */
public class Platno {

    private static Platno platnoSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */
    public static Platno dajPlatno() {
        if (Platno.platnoSingleton == null) {
            Platno.platnoSingleton = new Platno(
                "BlueJ Shapes Demo",
                400, 400,
                Color.black
            );
        }
        Platno.platnoSingleton.setVisible(true);
        return Platno.platnoSingleton;
    }

    //  ----- instance part -----

    private final JFrame frame;
    private final CanvasPane canvas;
    private Graphics2D graphic;
    private final Color pozadie;
    private Image canvasImage;
    private final HashMap<Object, PopisTvaru> tvary;
    private final HashMap<Object, PopisObrazku> obrazky;
    
    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background colour of the canvas
     */
    private Platno(String titulok, int sirka, int vyska, Color pozadie) {
        this.frame = new JFrame();
        this.canvas = new CanvasPane();
        this.frame.setContentPane(this.canvas);
        this.frame.setTitle(titulok);
        this.canvas.setPreferredSize(new Dimension(sirka, vyska));
        this.pozadie = pozadie;
        this.frame.pack();
        this.tvary = new HashMap<Object, PopisTvaru>();
        this.obrazky = new HashMap<Object, PopisObrazku>();
    }

    /**
     * Znovu vykreslí všetky spravované tvary.
     */
    public void prekresli() {
        this.vymazPlatno();
        this.vykresliTvary();
        this.vykresliObrazky();
        this.canvas.repaint();
    }
    
    /**
     * Zaregistruje tvar s jeho popisom medzi spravované tvary.
     */
    public void zaregistrujTvar(Object tvarObjekt, PopisTvaru popis) {
        this.tvary.put(tvarObjekt, popis);
    }
    
    /**
     * Odregistruje tvar zo spravovaných tvarov.
     */
    public void odregistrujTvar(Object tvarObjekt) {
        this.tvary.remove(tvarObjekt);
    }
    
    /**
     * Zaregistruje obrázok s jeho popisom medzi vykresľované obrázky.
     */
    public void zaregistrujObrazok(Object obrazokObjekt, PopisObrazku popis) {
        this.obrazky.put(obrazokObjekt, popis);
    }
    
    /**
     * Odregistruje obrázok s jeho popisom.
     */
    public void odregistrujObrazok(Object obrazokObjekt) {
        this.obrazky.remove(obrazokObjekt);
    }
    
    /**
     * Pridá listener udalostí z klávesnice.
     */
    public void addKeyListener(KeyListener listener) {
        this.frame.addKeyListener(listener);
    }
    
    /**
     * Pridá listener udalostí myši.
     */
    public void addMouseListener(MouseListener listener) {
        this.canvas.addMouseListener(listener);
    }

    private void vykresliTvary() {        
        for (PopisTvaru popis : this.tvary.values()) {
            this.setForegroundColor(popis.getFarba());
            this.graphic.fill(popis.getTvar());
        }
    }
    
    private void vykresliObrazky() {
        for (PopisObrazku popis : this.obrazky.values()) {
            this.graphic.drawImage(
                popis.getObrazok(),
                popis.getAt(),
                null
            );
        }
    }
       
    private void vymazPlatno() {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.pozadie);
        Dimension size = this.canvas.getSize();
        this.graphic.fill(new Rectangle(0, 0, size.width, size.height));
        this.graphic.setColor(original);
    }
    
    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    private void setVisible(boolean visible) {
        if (this.graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background colour
            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(size.width, size.height);
            this.graphic = (Graphics2D)this.canvasImage.getGraphics();
            this.graphic.setColor(this.pozadie);
            this.graphic.fillRect(0, 0, size.width, size.height);
            this.graphic.setColor(Color.black);
        }
        this.frame.setVisible(visible);
    }
    
    /**
     * Set the foreground colour of the Canvas.
     * @param  newColour   the new colour for the foreground of the Canvas 
     */
    private void setForegroundColor(String farba) {
        if (farba.equals("red")) {
            this.graphic.setColor(Color.red);
        } else if (farba.equals("black")) {
            this.graphic.setColor(Color.black);
        } else if (farba.equals("blue")) {
            this.graphic.setColor(Color.blue);
        } else if (farba.equals("yellow")) {
            this.graphic.setColor(Color.yellow);
        } else if (farba.equals("green")) {
            this.graphic.setColor(Color.green);
        } else if (farba.equals("magenta")) {
            this.graphic.setColor(Color.magenta);
        } else if (farba.equals("white")) {
            this.graphic.setColor(Color.white);
        } else {
            this.graphic.setColor(Color.black);
        }
    }

    private class CanvasPane extends JPanel {
        public void paint(Graphics graphic) {
            graphic.drawImage(Platno.this.canvasImage, 0, 0, null);
        }
    }

    public static class PopisTvaru {
        private Shape tvar;
        private String farba;

        PopisTvaru(Shape tvar, String farba) {
            this.tvar = tvar;
            this.farba = farba;
        }
        
        public String getFarba() {
            return this.farba;
        }
        
        public void setFarba(String farba) {
            this.farba = farba;
        }
        
        public Shape getTvar() {
            return this.tvar;
        }
        
        public void setTvar(Shape s) {
            this.tvar = s;
        }
    }
    
    public static class PopisObrazku {
    
        private BufferedImage obrazok;
        private AffineTransform at;

        public PopisObrazku(BufferedImage obrazok) {
            this.obrazok = obrazok;
            this.at = null;
        }
        
        public BufferedImage getObrazok() {
            return this.obrazok;
        }
        
        public void setObrazok(BufferedImage obrazok) {
            this.obrazok = obrazok;
        }
        
        public AffineTransform getAt() {
            return this.at;
        }
        
        public void setAt(AffineTransform at) {
            this.at = at;
        }
    }
}
