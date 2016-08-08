package controllers;

import models.GameObject;
import views.GameDrawer;
import java.math.*;
import java.util.Iterator;

/**
 * Created by DUC on 8/7/2016.
 */
public class GiftController2 extends SingleController implements Colliable {
    public static final int SPEED = 1;
    public static final int RADIUS = 200;

    public GiftController2(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        this.gameVector.dx = -SPEED;

        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            Iterator<SingleController> singleControllerIterator =
                    EnemyControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController enemyController = singleControllerIterator.next();
                if(Math.pow(enemyController.gameObject.getX() - this.gameObject.getX(), 2) +
                        Math.pow(enemyController.gameObject.getY() - this.gameObject.getY(), 2 )
                        <= RADIUS*RADIUS) {
                    enemyController.getGameObject().destroy();
                }
            }
        }
    }
}
