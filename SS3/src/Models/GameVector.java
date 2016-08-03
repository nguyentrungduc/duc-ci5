package Models;

/**
 * Created by DUC on 7/31/2016.
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
}
