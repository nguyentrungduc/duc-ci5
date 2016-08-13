package controllers.enemy;

import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by DUC on 8/13/2016.
 */
public class StraightShotBehavior implements ShotBehavior {
    private final static int BULLET_SPEED = 8;
    private final static int SHOT_PERIOD = 100;
    private int count;

    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if (count >= SHOT_PERIOD) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();
            BulletEnemyController bulletEnemyController =
                    new BulletEnemyController(
                            new EnemyBullet(
                                    gameObject.getMiddleX() - EnemyBullet.SIZE / 2,
                                    gameObject.getBottom()),
                            new ImageDrawer("resources/enemy_bullet.png")
                    );
            bulletEnemyController.getGameVector().dy = BULLET_SPEED;
            BulletEnemyControllerManager.instance.add(bulletEnemyController);
        }
    }
}
