package controllers.bombs;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.GameObject;
import models.Gift;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by DUC on 8/18/2016.
 */
public class GiftController extends SingleController implements Colliable{
    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }


    public static GiftController create(int x, int y) {
        return new GiftController(
                new Gift(x, y),
                new ImageDrawer("resources/gift.png"));
    }


    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            NotificationCenter.instance
                    .onGift(gameObject.getX(), gameObject.getY());
            gameObject.destroy();
        }
    }
}
