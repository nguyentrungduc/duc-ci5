package controllers;
import controllers.bombs.GiftController;
import controllers.bombs.GiftSubscriber;
import controllers.bombs.NotificationCenter;
import controllers.enemies.EnemyBulletController;
import controllers.gamescenes.GameSceneListener;
import controllers.gamescenes.GameOverScene;
import models.Bullet;
import models.Fire;
import models.GameObjectWithHP;
import models.Plane;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class PlaneController extends SingleController
        implements KeyListener, Colliable, GiftSubscriber {

    public static final int SPEED = 10;
    public static final int ATK_SPEED = 3;
    private int count;

    private ControllerManager bulletManager;
    private GameInput gameInput;
    private boolean cheat = false;

    private GameSceneListener gameSceneListener;

    private PlaneController(Plane plane, GameDrawer gameDrawer) {
        super(plane, gameDrawer);
        this.bulletManager = new ControllerManager();
        this.gameInput = new GameInput();
        CollsionPool.instance.add(this);
        NotificationCenter.instance
                .subscribeGift(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
//                this.gameVector.dy = -SPEED;
                this.gameInput.keyUp = true;
                break;
            case KeyEvent.VK_DOWN:
//                this.gameVector.dy = SPEED;
                this.gameInput.keyDown = true;
                break;
            case KeyEvent.VK_LEFT:
                //this.gameVector.dx = -SPEED;
                this.gameInput.keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
//                this.gameVector.dx = SPEED;
                this.gameInput.keyRight = true;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
//                this.gameVector.dy = -SPEED;
                this.gameInput.keyUp = false;
                break;
            case KeyEvent.VK_DOWN:
//                this.gameVector.dy = SPEED;
                this.gameInput.keyDown = false;
                break;
            case KeyEvent.VK_LEFT:
                //this.gameVector.dx = -SPEED;
                this.gameInput.keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
//                this.gameVector.dx = SPEED;
                this.gameInput.keyRight = false;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = false;
//                BulletController bulletController = new BulletController(
//                        new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
//                        new ImageDrawer("resources/bullet.png")
//                );
//                bulletManager.add(bulletController);
                break;
            case KeyEvent.VK_S: /*S stands for Setting :)*/
                gameSceneListener.changeGameScene(new GameOverScene(), false);
                break;
            case KeyEvent.VK_C:
                cheat = true;
                break;

        }
    }

    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    public void decreaseHP(int amount) {
        if(!cheat) {
            ((GameObjectWithHP)gameObject).decreaseHP(amount);
        /*TODO: If HP <= 0 => Change gamescene to Higscore or GameOver */
            if (((GameObjectWithHP) gameObject).getHp() <= 0) {
                gameSceneListener.changeGameScene(new GameOverScene(), false);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void run() {
        count++;
        this.gameVector.dx = 0;
        this.gameVector.dy = 0;

        if(gameInput.keyDown && !gameInput.keyUp) {
            this.gameVector.dy = SPEED;
        } else if(!gameInput.keyDown && gameInput.keyUp) {
            this.gameVector.dy = -SPEED;
        }

        if(gameInput.keyLeft && !gameInput.keyRight) {
            this.gameVector.dx = -SPEED;
        } else if(!gameInput.keyLeft && gameInput.keyRight) {
            this.gameVector.dx = SPEED;
        }

        if (gameInput.keySpace) {
            if(count > ATK_SPEED) {
                BulletController bulletController = new BulletController(
                        new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
                        new ImageDrawer("resources/bullet.png")
                );
                bulletManager.add(bulletController);
                count = 0;
            }
        }
        super.run();
        bulletManager.run();
    }

    public final static PlaneController instance = new PlaneController(
            new Plane(250, 600),
            new ImageDrawer("resources/plane3.png")
    );


    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyBulletController) {
            colliable.getGameObject().destroy();
        }
    }

    @Override
    public void onGift(int x, int y) {
       FireController fireController = FireController
                .create(PlaneController.instance.gameObject.getMiddleX(),
                        PlaneController.instance.gameObject.getY() + 30 );
        FireControllerManager.instance.add(fireController);
        System.out.println("s");
    }
}
