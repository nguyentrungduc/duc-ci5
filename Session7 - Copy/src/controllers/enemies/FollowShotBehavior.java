package controllers.enemies;

import controllers.PlaneController;
import models.EnemyBullet;
import models.GameObject;
import models.GameSetting;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 8/10/2016.
 */
public class FollowShotBehavior implements ShotBehavior {

    private final static int BULLET_SPEED = 3;
    private int count;

    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if(GameSetting.getInstance().toMiliseconds(count) > 500.0f) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();
            EnemyBulletController enemyBulletController =
                    new EnemyBulletController(
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

                enemyBulletController.getGameVector().dy = (int) (dy / ratio);
                enemyBulletController.getGameVector().dx = (int) (dx / ratio);

                EnemyBulletControllerManager.instance.add(enemyBulletController);
            }
        }
    }
}
