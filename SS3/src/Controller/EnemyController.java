package Controller;

import Models.Bullet;
import Models.Enemy;
import Models.GameObject;
import View.GameDraw;
import View.ImageDraw;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by DUC on 8/3/2016.
 */
public class EnemyController extends SingleController implements Colliable {
    public static final int SPEED = 3;

    public EnemyController(final Enemy gameObject, GameDraw gameDraw) {
        super(gameObject, gameDraw);
        this.gameVector.dx = SPEED;
        CollsionPool.instance.add(this);
        BulletEnemyManager bulletEnemyManager;
    }


    @Override
    public void onCollide(Colliable colliable) {

    }
    int t = 0;
    public void run() {
       super.run();
        t++;
        if(t == 30){
            t = 0;
            BulletEnemyController bulletEnemyController = new BulletEnemyController(
                    new Bullet(gameObject.getX()+10, gameObject.getY()),
                    new ImageDraw("resouces/enemy_bullet.png"));
            bulletEnemyController.add(bulletEnemyController);
            BulletEnemyManager.instance.add(bulletEnemyController);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }
}
