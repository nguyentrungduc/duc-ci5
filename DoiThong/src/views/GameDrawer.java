package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by DUC on 8/12/2016.
 */
public interface GameDrawer {
    void draw(Graphics g, GameObject gameObject);
}
