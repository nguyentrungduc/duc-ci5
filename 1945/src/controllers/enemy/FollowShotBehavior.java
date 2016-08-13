package controllers.enemy;

import controllers.PlaneController;
import models.EnemyBullet;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by DUC on 8/12/2016.
 */
public class FollowShotBehavior implements ShotBehavior{
    private final static int BULLET_SPEED = 9;
    private final static int SHOT_PERIOD = 100;
    private int count;

    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if(count >= SHOT_PERIOD) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();
            BulletEnemyController bulletEnemyController =
                    new BulletEnemyController(
                            new EnemyBullet(
                                    gameObject.getMiddleX() - EnemyBullet.SIZE / 2,
                                    gameObject.getBottom()),
                            new ImageDrawer("resources/enemy_bullet.png")
                    );
            int dx = PlaneController.instance.getGameObject().getX() -
                    gameObject.getX();
            int dy = PlaneController.instance.getGameObject().getY() -
                    gameObject.getY();

            if (dy > 0) {
                double ratio = Math.sqrt(dx * dx + dy * dy) / BULLET_SPEED;

                bulletEnemyController.getGameVector().dy = (int) (dy / ratio);
                bulletEnemyController.getGameVector().dx = (int) (dx / ratio);

                BulletEnemyControllerManager.instance.add(bulletEnemyController);
            }
        }
    }
}
