package controllers;

import models.GameObject;
import models.GameVector;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by DUC on 8/12/2016.
 */
public class SingleController implements BaseController {
    protected GameObject gameObject;
    private GameDrawer gameDrawer;
    protected GameVector gameVector;


    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameVector = new GameVector();
        this.gameDrawer = gameDrawer;
    }

    public void run(){
        gameObject.move(this.gameVector);
    }

    public void draw(Graphics g){
        gameDrawer.draw(g, gameObject);
    }

    public GameVector getGameVector(){
        return gameVector;
    }

    public GameObject getGameObject(){
        return gameObject;
    }

}
