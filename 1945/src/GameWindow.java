import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.enemy.BulletEnemyControllerManager;
import controllers.enemy.EnemyControllerManager;
import controllers.gift.GiftControllerManager;
import controllers.gift.NotificationCenter;
import ultils.Ultils;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by DUC on 8/11/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;

    public GameWindow(){
        this.setSize(600, 800);
        this.setLocation(0, 0);
        this.setVisible(true);

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

        background = Ultils.loadImage("resources/background.png");

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
        BulletEnemyControllerManager.instance.draw(bufferImageGraphic);
        GiftControllerManager.instance.draw(bufferImageGraphic);

        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                PlaneController.instance.run();
                BulletEnemyControllerManager.instance.run();
                EnemyControllerManager.instance.run();
                GiftControllerManager.instance.run();
                CollsionPool.instance.run();

                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
