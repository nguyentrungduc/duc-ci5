package controllers.gift;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.Bomb;
import models.GameObject;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;

/**
 * Created by DUC on 8/12/2016.
 */
public class BombController extends SingleController implements Colliable {
    public static final int SPEED = 1;

    public BombController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
//        this.gameVector.dx = SPEED;
//        this.gameVector.dy = -SPEED;
        CollsionPool.instance.add(this);
    }

    public static BombController create(int x, int y){
        return new BombController(
                new Bomb(x, y),
                new ImageDrawer("resources/bomb.png")
        );
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            gameObject.destroy();
            NotificationCenter.instance
                    .onBomExpode(gameObject.getX(), gameObject.getY());
        }

    }
}
