package controllers.enemy;

import controllers.SingleController;
import models.GameObject;

/**
 * Created by DUC on 8/13/2016.
 */

public class ZiczacFlyBehavior implements FlyBehavior {
    private final static int ENEMY_SPEED1 = 1;
    private final static int ENEMY_SPEED2 = 3;

    @Override
    public void fly(EnemyController enemyController) {
        GameObject gameObject = enemyController.getGameObject();
        enemyController.getGameVector().dy = ENEMY_SPEED1;
        enemyController.getGameVector().dx = ENEMY_SPEED2;
        if(gameObject.getX() > 500){
            System.out.println("left");
            enemyController.getGameVector().dx = - enemyController.getGameVector().dx;
        }else if(gameObject.getX() < 0){
            System.out.println("right");
            enemyController.getGameVector().dx = - enemyController.getGameVector().dx;
        }
    }

}
