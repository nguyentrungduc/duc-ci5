package controllers.enemy;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.EnemyState;
import controllers.SingleController;
import controllers.gift.BombSubscriber;
import controllers.gift.FreezzeSubscriber;
import controllers.gift.NotificationCenter;
import models.Enemy;
import models.GameObject;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by DUC on 8/12/2016.
 */
public class EnemyController extends SingleController
        implements Colliable, BombSubscriber, FreezzeSubscriber{

    private EnemyState enemyState;
    private FreezeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private FlyBehavior flyBehavior;

    public EnemyController(GameObject gameObject,
                           GameDrawer gameDrawer,
                           FreezeBehavior frezzeBehavior,
                           ShotBehavior shotBehavior,
                           FlyBehavior flyBehavior) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        NotificationCenter.instance.subscriberBom(this);
        NotificationCenter.instance.subscribersFreezze(this);
        enemyState = EnemyState.NORMAL;
        this.freezeBehavior = frezzeBehavior;
        this.shotBehavior = shotBehavior;
        this.flyBehavior = flyBehavior;
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    public static EnemyController create(int x, int y, EnemyPlaneType type){
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW: {
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"),
                        new FreezeBehavior(330),
                        new FollowShotBehavior(),
                        new CrossFlyBehavior()
                );
                break;
            }
            case WHITE: {
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_1.png"),
                        new FreezeBehavior(160),
                        new StraightShotBehavior(),
                        new ZiczacFlyBehavior()
                );
                break;
            }
        }
        return enemyController;
    }

    public void run(){
        switch (this.enemyState) {
            case NORMAL:
                super.run();
                break;
            case FREZZED:
                break;
        }
        if (freezeBehavior != null)
            freezeBehavior.run(this);

        if(shotBehavior != null)
            shotBehavior.doShot(this);

        if(flyBehavior != null) {
            flyBehavior.fly(this);
        }

    }

    @Override
    public void onCollide(Colliable colliable) {


    }

    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();
    }

    @Override
    public void onFrezze(int x, int y) {
        this.enemyState = EnemyState.FREZZED;
    }
}
