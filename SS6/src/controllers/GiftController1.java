package controllers;

import models.GameObject;
import models.GameVector;
import models.Gift;
import views.GameDrawer;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by DUC on 8/7/2016.
 */
public class GiftController1 extends SingleController implements Colliable {
    public static final int SPEED = 1;

    public GiftController1(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        this.gameVector.dx = SPEED;

        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
//            for (int i = 0; i < EnemyControllerManager.instance.getSingleControllerArrayList().size(); i++)
//                EnemyControllerManager.instance.getSingleControllerArrayList().remove(i);
            Iterator<SingleController> singleControllerIterator = EnemyControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController enemyController = singleControllerIterator.next();
                    enemyController.getGameObject().destroy();
            }
        }
    }
}
