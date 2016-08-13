package controllers.gift;

import controllers.ControllerManager;

import java.util.Random;

/**
 * Created by DUC on 8/12/2016.
 */
public class GiftControllerManager extends ControllerManager  {
    private int count;
    private static final int BOMB_PERIOD = 150;
    private static final int LOCK_PERIOD = 200;

    public static final GiftControllerManager instance = new GiftControllerManager();

    @Override
    public void run() {
        count++;

        Random r = new Random();
        int x = r.nextInt(600);
        int y = r.nextInt(800);

        if(count >= LOCK_PERIOD) {
            count = 0;
            LockController lockController = LockController
                    .create(x, y);
            this.add(lockController);
        }
        else if(count == BOMB_PERIOD) {
            /*  Generate bomb */
            BombController bombController = BombController
                    .create(x, y);
            this.add(bombController);
        }
        super.run();
    }
}
