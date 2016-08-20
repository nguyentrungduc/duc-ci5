package controllers.enemies;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
//            colliable.getGameObject().destroy();
            ((PlaneController) colliable).decreaseHP(1);
        }
    }
}
