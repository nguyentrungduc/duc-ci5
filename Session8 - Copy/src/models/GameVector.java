package models;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class GameVector {
    public double dx;
    public double dy;

    public GameVector() {
        this(0, 0);
    }

    public GameVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
