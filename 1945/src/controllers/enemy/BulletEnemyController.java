package controllers.enemy;

import controllers.Colliable;
import controllers.PlaneController;
import controllers.SingleController;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by DUC on 8/12/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable {
    public BulletEnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            gameObject.destroy();
        }
    }
}
