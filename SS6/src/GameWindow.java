import controllers.*;

import utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class GameWindow extends Frame implements Runnable{
    Image background;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;


    public GameWindow() {
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(600, 800);
        this.setLocation(0, 0);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
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

        background =  Utils.loadImage("resources/background.png");


        this.addKeyListener(PlaneController.instance);


        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        bufferImageGraphic.drawImage(background, 0, 0, null);

        PlaneController.instance.draw(bufferImageGraphic);
        EnemyControllerManager.instance.draw(bufferImageGraphic);
        GiftControllerManager.instance.draw(bufferImageGraphic);
        EnemyBulletControllerManager.instance.draw(bufferImageGraphic);

        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                PlaneController.instance.run();
                GiftControllerManager.instance.run();
                EnemyBulletControllerManager.instance.run();
                EnemyControllerManager.instance.run();
                CollsionPool.instance.run();

                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
