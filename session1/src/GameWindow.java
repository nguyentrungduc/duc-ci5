import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by DUC on 7/24/2016.
 */

public class GameWindow extends Frame implements Runnable{
    Image background;
    Image planeImage;
    Image planeImage2;
    int planeX = 250;
    int planeY = 450;
    int planeX2 = 350;
    int planeY2 = 300;
    Thread thread;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphic;



    public GameWindow() {
        System.out.println("GameWindow constructor");
        this.setVisible(true);
        this.setSize(800,600);
        this.setLocation(0,0);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println(" windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

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
        try {
            background = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();
        try {
            planeImage = ImageIO.read(new File("resources/plane4.png") );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();
        try {
            planeImage2 = ImageIO.read(new File("resources/plane2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        planeX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX += 10;
                        break;
                    case KeyEvent.VK_UP:
                        planeY -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY += 10;
                        break;
                }
                repaint();


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                planeX2=e.getX();
                planeY2=e.getY();

            }
        });

        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();

    }
    @Override
    public void update(Graphics g){
        bufferedImageGraphic.drawImage(background, 0, 0, null);
        bufferedImageGraphic.drawImage(planeImage, planeX, planeY, null);
        bufferedImageGraphic.drawImage(planeImage2, planeX2, planeY2, null);
        g.drawImage(bufferedImage,0,0,null);
        System.out.println("Paint");
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(27);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
