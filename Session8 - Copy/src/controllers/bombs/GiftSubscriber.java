package controllers.bombs;

import models.GameObject;

/**
 * Created by DUC on 8/18/2016.
 */
public interface GiftSubscriber {
    public void onGift(int x, int y);
    public GameObject getGameObject();
}
