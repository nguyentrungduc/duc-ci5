package controllers.gift;

import models.GameObject;

/**
 * Created by DUC on 8/12/2016.
 */
public interface FreezzeSubscriber {
    public void onFrezze(int x, int y);
    public GameObject getGameObject();
}
