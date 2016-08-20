package controllers.gamescenes;

/**
 * Created by qhuydtvt on 8/14/2016.
 */
public interface GameSceneListener {
    void changeGameScene(GameScene gameScene, boolean addToStack);
    void back();
}
