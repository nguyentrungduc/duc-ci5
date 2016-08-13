package models;

/**
 * Created by DUC on 8/12/2016.
 */
public class EnemyBullet extends GameObject {
    public static final int SIZE = 32;

    public EnemyBullet(int x, int y) {
        super(x, y, SIZE, SIZE);
    }
}
