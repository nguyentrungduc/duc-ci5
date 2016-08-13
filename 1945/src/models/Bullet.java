package models;

/**
 * Created by DUC on 8/11/2016.
 */
public class Bullet extends GameObject {

    public static final int WIDTH = 13;
    public static final int HEIGHT =30;

    private int damage;

    public Bullet(int x, int y) {
        this(x, y, 2);
    }

    public Bullet(int x, int y, int damage) {
        super(x, y, WIDTH, HEIGHT);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
