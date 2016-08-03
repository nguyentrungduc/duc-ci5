package Controller;

import Models.Bullet;
import Models.GameObject;
import View.GameDraw;

/**
 * Created by DUC on 7/31/2016.
 */
public class BulletController extends SingleController implements Colliable{
    private static final int SPEED = 20;

    public BulletController(Bullet bullet, GameDraw gameDraw) {
        super(bullet,gameDraw);
        this.gameVector.dy = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run(){
        super.run();
        if(gameObject.getY()<0){
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
