package controllers.gamescenes;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by qhuydtvt on 8/14/2016.
 */
public interface GameScene extends Runnable {
    void draw(Graphics g);
    KeyListener getKeyListener();
    void setGameSceneListener(GameSceneListener gameSceneListener);
}
