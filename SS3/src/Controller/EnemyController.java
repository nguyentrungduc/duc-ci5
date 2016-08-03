package Controller;

import Models.Bullet;
import Models.Enemy;
import View.GameDraw;
import View.ImageDraw;

import java.util.Iterator;

/**
 * Created by DUC on 8/3/2016.
 */
public class EnemyController extends SingleController implements Colliable {
    public static final int SPEED = 3;
    public EnemyController(final Enemy gameObject, GameDraw gameDraw) {
        super(gameObject, gameDraw);
        this.gameVector.dx = SPEED;
        CollsionPool.instance.add(this);

    }

    @Override
    public void onCollide(Colliable colliable) {

    }
    public void run(){
        super.run();
    }
}
