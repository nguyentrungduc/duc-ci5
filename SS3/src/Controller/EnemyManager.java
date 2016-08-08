package Controller;

import Models.Bullet;
import Models.Enemy;
import Models.EnemyPlane;
import View.ImageDraw;
import com.sun.prism.Graphics;

import java.util.Iterator;
import java.util.Random;


/**
 * Created by DUC on 8/3/2016.
 */
public class EnemyManager extends ControlManager {

    public EnemyManager() {
     super();
    }

    private int t = 0;
    @Override
    public void run() {
        t++;
        if (t == 30) {
            t = 0;
            Random rand = new Random();
            int enX = 10;
            int enY = rand.nextInt(450);
            EnemyController enemyController = new EnemyController(
                    new Enemy(enX, enY),
                    new ImageDraw("resources/plane1.png"));
            this.add(enemyController);
        }
        super.run();
    }

    public final static EnemyManager instance = new EnemyManager();

}
