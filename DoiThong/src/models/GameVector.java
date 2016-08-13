package models;

/**
 * Created by DUC on 8/11/2016.
 */
public class GameVector {
    public int dx;
    public int dy;

    public GameVector(){
        this(0, 0);
    }

    public GameVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
