package controllers.gamescenes;

import controllers.PlaneController;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by DUC on 8/17/2016.
 */
public class OverGameScene implements GameScene, KeyListener{
    private GameSceneListener gameSceneListener;
    private Image background;

    public OverGameScene() {
        background = Utils.loadImage("resources/gameover2.png");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        /*TODO: Draw menu */
    }

    @Override
    public KeyListener getKeyListener() {
        return null;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
        PlaneController.instance.setGameSceneListener(gameSceneListener);
    }

    @Override
    public void run() {
        /*TODO: Run menu */
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameSceneListener != null)
                gameSceneListener.changeGameScene(new PlayGameScene());
        }
    }

    @Override
    public void keyReleased (KeyEvent e){

    }
}
