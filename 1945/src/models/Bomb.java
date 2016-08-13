package models;

/**
 * Created by DUC on 8/12/2016.
 */
public class Bomb extends GameObject {
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    public Bomb(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
