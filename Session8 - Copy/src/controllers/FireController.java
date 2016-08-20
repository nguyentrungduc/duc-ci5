package controllers;

import controllers.enemies.EnemyController;
import javafx.scene.transform.Rotate;
import models.Fire;
import models.GameObject;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by DUC on 8/18/2016.
 */
public class FireController extends SingleController implements Colliable {
    protected int a;
    protected int b;
    int count = 0;
    public FireController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        a = -90;
        b = 180;
        double dx1;
        double dy1;
        dx1 = Math.sin(Math.toRadians(a + count/10));
        dy1 = Math.cos(Math.toRadians(a + count/10));
        this.getGameVector().dx = dx1;
        this.getGameVector().dy = dy1;
        CollsionPool.instance.add(this);
    }

    public static FireController create(int x, int y) {
        FireController fireController = null;
        fireController = new FireController(
                new Fire(x, y),
                new ImageDrawer("resources/fire.png")
        );
        return fireController;
    }

    public void draw(Graphics g){
        super.draw(g);
    }
    public void run(){
        count++;
        super.run();
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            ((EnemyController) colliable).destroy();
        }
    }

}
