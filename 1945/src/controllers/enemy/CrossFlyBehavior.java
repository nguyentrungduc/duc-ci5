package controllers.enemy;

/**
 * Created by DUC on 8/13/2016.
 */
public class CrossFlyBehavior implements FlyBehavior {
    private final static int ENEMY_SPEED = 3;

    @Override
    public void fly(EnemyController enemyController) {
        enemyController.getGameVector().dy = ENEMY_SPEED;
        enemyController.getGameVector().dx = ENEMY_SPEED;
    }
}
