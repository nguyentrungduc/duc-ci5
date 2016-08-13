package controllers.gift;

import models.GameObject;

/**
 * Created by DUC on 8/12/2016.
 */
public interface BombSubscriber {
    public void onBombExplode(int x, int y);
    public GameObject getGameObject();
}
