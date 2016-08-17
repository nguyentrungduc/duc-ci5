package main;

import controllers.gamescenes.GameScene;
import controllers.gamescenes.GameSceneListener;
import controllers.gamescenes.MenuGameScence;
import models.GameSetting;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


/**
 * Created by qhuydtvt on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable, GameSceneListener {

    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    GameSetting gameSetting;
    Thread thread;

    GameScene currentGameScene;

    public GameWindow() {
        configUI();
        changeGameScene(new MenuGameScence());

        this.bufferedImage = new BufferedImage(gameSetting.getScreenWidth(),
                gameSetting.getScreenHeight(),
                BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    private void configUI() {

        gameSetting = GameSetting.getInstance();
        this.setVisible(true);
        this.setSize(gameSetting.getScreenWidth(), gameSetting.getScreenHeight());;
        this.setLocation(0, 0);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        this.currentGameScene.draw(bufferImageGraphic);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.currentGameScene.run();
                Thread.sleep(gameSetting.getThreadDelay());
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeGameScene(GameScene gameScene) {
        currentGameScene = gameScene;
        currentGameScene.setGameSceneListener(this);
        this.addKeyListener(currentGameScene.getKeyListener());
    }
}
