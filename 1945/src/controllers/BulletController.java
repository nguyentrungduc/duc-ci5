package controllers;

import controllers.enemy.EnemyController;
import models.Bullet;
import models.GameObject;
import models.GameObjectWithHP;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by DUC on 8/12/2016.
 */
public class BulletController extends SingleController implements Colliable{
    private static final int SPEED = 20;

    public BulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollsionPool.instance.add(this);
    }

    public void run(){
        if(gameObject.getY() < 0){
            gameObject.destroy();
        }
        super.run();
    }

    public void draw(Graphics g){
        super.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            Bullet bullet = (Bullet)gameObject;
            ((GameObjectWithHP)colliable.getGameObject()).decreaseHP(bullet.getDamage());
            this.getGameObject().destroy();
        }
    }
}
