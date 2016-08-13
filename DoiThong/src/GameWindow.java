import ultils.Ultils;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by DUC on 8/13/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;

    public GameWindow(){
        this.setVisible(true);
        this.setLocation(0, 0);
        this.setSize(1000, 2000);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        background = Ultils.loadImage("resources/background.jpg");
        this.bufferedImage = new BufferedImage(1000,2000,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();

        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        bufferImageGraphic.drawImage(background, 0, 0, null);

        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

