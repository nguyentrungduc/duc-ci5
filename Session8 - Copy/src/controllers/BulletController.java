package controllers;

import controllers.enemies.EnemyController;
import controllers.enemies.EnemyControllerManager;
import models.Bullet;
import models.Explosion;
import models.GameObjectWithHP;
import utils.Utils;
import views.AnimationDrawer;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class BulletController extends SingleController implements Colliable {

    private static final int SPEED = 20;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            Bullet bullet = (Bullet)gameObject;
            GameObjectWithHP target = (GameObjectWithHP) colliable.getGameObject();
            //((GameObjectWithHP) colliable.getGameObject()).decreaseHP(bullet.getDamage());
            this.getGameObject().destroy();

            ((EnemyController) colliable).destroy();
        }
    }
}
