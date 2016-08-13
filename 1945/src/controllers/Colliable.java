package controllers;

import models.GameObject;

/**
 * Created by DUC on 8/12/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
