package models;

/**
 * Created by qhuydtvt on 7/27/2016.
 */

public class Plane extends GameObjectWithHP {

    public static final int WIDTH = 70;
    public static final int HEIGHT = 50;
    public static final int HP = 3;
    public Plane(int x, int y) {
        super(x, y, WIDTH, HEIGHT, HP);
    }

}
