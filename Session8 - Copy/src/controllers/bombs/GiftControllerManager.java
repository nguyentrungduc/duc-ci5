package controllers.bombs;

import controllers.ControllerManager;

import java.util.Random;

/**
 * Created by DUC on 8/18/2016.
 */
public class GiftControllerManager extends ControllerManager {
    public static final GiftControllerManager instance = new GiftControllerManager();
    int t = 0;
    public void run(){
        Random r = new Random();
        int x = r.nextInt(600);
        int y = r.nextInt(800);
        t++;
        if(t == 100){
            t = 0;
            GiftController giftController = GiftController.create(x,y);
            this.add(giftController);
        }
        super.run();
    }
}
