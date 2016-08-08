package controllers;

import models.GameVector;
import models.Gift;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by DUC on 8/7/2016.
 */
public class GiftControllerManager extends ControllerManager {
    private int count;
    private GiftControllerManager() {
        super();
    }

    public void run(){
        super.run();
        count++;
        if(count == 200){
            count = 0;
            Random rand = new Random();
            int enX = 0;
            int enY = rand.nextInt(1000);
            GiftController1 giftController1 = new GiftController1(
                    new Gift(enX, enY),
                    new ImageDrawer("resources/bomb_1.png")
            );
            this.add(giftController1);
        }
        else if(count == 100){
            Random rand = new Random();
            int enX = 600;
            int enY = rand.nextInt(1000);
            GiftController2 giftController2 = new GiftController2(
                    new Gift(enX, enY),
                    new ImageDrawer("resources/bomb_2.png")
            );
            this.add(giftController2);

        }
    }

    public final static GiftControllerManager instance = new GiftControllerManager();
}
