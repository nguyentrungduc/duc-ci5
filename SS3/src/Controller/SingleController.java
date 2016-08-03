package Controller;

import Models.GameObject;
import Models.GameVector;
import View.GameDraw;
import View.ImageDraw;

import java.awt.*;

/**
 * Created by DUC on 7/31/2016.
 */
public class SingleController implements BaseController {
    protected GameObject gameObject;
    protected GameDraw gameDraw;
    protected GameVector gameVector;

    public GameObject getGameObject() {
        return gameObject;
    }

    public SingleController(GameObject gameObject, GameDraw gameDraw) {
        this.gameObject = gameObject;
        this.gameDraw = gameDraw;
        this.gameVector = new GameVector();
    }

    @Override
    public void draw(Graphics g){
        gameDraw.draw(g,gameObject);
    }

    @Override
    public void run() {
        gameObject.move(this.gameVector);
    }

}
