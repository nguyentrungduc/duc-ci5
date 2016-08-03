package Controller;

import Models.GameObject;
import View.GameDraw;

/**
 * Created by DUC on 8/3/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable {
    private static final int SPEED = 20;
    public BulletEnemyController(GameObject gameObject, GameDraw gameDraw) {
        super(gameObject, gameDraw);
        this.gameVector.dy =SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run(){
        super.run();
        if(gameObject.getY()>700){
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            this.getGameObject().destroy();
        }
    }
}
