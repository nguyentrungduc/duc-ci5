package models;

/**
 * Created by DUC on 8/11/2016.
 */
public class Enemy extends GameObjectWithHP {
    public static final int WIDTH = 45;
    public static final int HEIGHT = 30;

    public Enemy(int x, int y, int width, int height) {
        this(x, y, width, height, 1);
    }

    public Enemy(int x, int y, int width, int height, int maxHP) {
        super(x, y, width, height, maxHP);
    }

    public Enemy(int x, int y, int maxHP) {
        this(x, y, WIDTH, HEIGHT, maxHP);
    }

    public Enemy(int x, int y) {
        this(x, y, WIDTH, HEIGHT);
    }
}
