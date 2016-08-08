package Controller;

import Models.Bullet;
import Models.GameObject;
import Models.Plane;
import View.GameDraw;
import View.ImageDraw;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by DUC on 7/31/2016.
 */
public class PlaneController extends SingleController implements
        KeyListener, Colliable {
    public static final int SPEED = 10;
    private ControlManager bulletManager;
    private PlaneController(Plane plane, GameDraw gameDraw){
        super(plane,gameDraw);
        this.bulletManager = new ControlManager();
        CollsionPool.instance.add(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.gameVector.dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                this.gameVector.dy = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                this.gameVector.dx = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameVector.dx = SPEED;
                break;
            case KeyEvent.VK_SPACE:
                BulletController bulletController = new BulletController(
                        new Bullet(this.gameObject.midX() - Bullet.WIDTH / 2, this.gameObject.getY()),
                        new ImageDraw("resources/bullet.png")
                );
                bulletManager.add(bulletController);
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                this.gameVector.dy = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                this.gameVector.dx = 0;
                break;
        }
    }

        @Override
        public void draw(Graphics g) {
            super.draw(g);
            bulletManager.draw(g);
        }

        @Override
        public void run() {
            super.run();
            bulletManager.run();
        }

    public final static PlaneController planeController = new PlaneController(
            new Plane(250, 600),
            new ImageDraw("resources/plane3.png")
    );

    @Override
    public void onCollide(Colliable colliable) {

    }
}
