package controllers.gift;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.GameObject;
import models.Lock;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by DUC on 8/12/2016.
 */
public class LockController extends SingleController implements Colliable {
    private static final int SPEED = 1;

    public LockController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
//        this.gameVector.dx = SPEED;
//        this.gameVector.dy = SPEED;
    }

    public static LockController create(int x, int y){
        return new LockController(
                new Lock(x, y),
                new ImageDrawer("resources/lock.png")
        );
    }


    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            gameObject.destroy();
            NotificationCenter.instance.onFrezze(
                    gameObject.getX(),
                    gameObject.getY()
            );
        }
    }
}
