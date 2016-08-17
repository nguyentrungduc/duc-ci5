package controllers.enemies;

import controllers.bombs.FreezzeSubcriber;
import controllers.bombs.NotificationCenter;
import controllers.bombs.BombSubscriber;
import controllers.Colliable;
import controllers.CollsionPool;
import controllers.SingleController;
import models.Enemy;
import models.GameSetting;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by qhuydtvt on 7/31/2016.
 */

public class EnemyController extends
        SingleController implements
        Colliable, BombSubscriber, FreezzeSubcriber {

    public static final int SPEED = 3;
    private EnemyState enemyState;
    private int frezzeCount;

    private int FREZZE_PERIOD = 200;

    private FreezeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private FlyBehavior flyBehavior;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer,
                           FreezeBehavior freezeBehavior,
                           ShotBehavior shotBehavior,
                           FlyBehavior flyBehavior) {
        super(gameObject, gameDrawer);

        CollsionPool.instance.add(this);
        NotificationCenter.instance
                .subsribe(this);
        NotificationCenter.instance
                .subsribeFrezze(this);
        enemyState = EnemyState.NORMAL;

        this.freezeBehavior = freezeBehavior;
        this.shotBehavior = shotBehavior;
        this.flyBehavior = flyBehavior;
    }

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer,
                           FreezeBehavior freezeBehavior,
                           ShotBehavior shotBehavior) {
        this(gameObject, gameDrawer, freezeBehavior, shotBehavior, null);
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;
        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"),
                        new FreezeBehavior(200),
                        null,
                        new FlyZigZacBehavior());
                break;
            case WHITE:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_1.png"),
                        new FreezeBehavior(300),
                        new FollowShotBehavior(),
                        new FlyVerticalBehavior());
                break;
        }
        return enemyController;
    }

    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();
    }

    @Override
    public void run() {
        switch (this.enemyState) {
            case NORMAL:
                super.run();
                if(shotBehavior != null)
                    shotBehavior.doShot(this);
                if(flyBehavior != null)
                    flyBehavior.doFly(this);
                if(!GameSetting.getInstance().inScreen(gameObject)) {
                    gameObject.destroy();
                }
                break;
            case FREZZED:
                break;
        }

        if (freezeBehavior != null)
            freezeBehavior.run(this);

    }

    @Override
    public void onFrezze(int x, int y) {
        enemyState = EnemyState.FREZZED;
        frezzeCount = 0;
    }
}
