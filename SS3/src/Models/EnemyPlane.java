package Models;

/**
 * Created by DUC on 7/31/2016.
 */
public class EnemyPlane extends GameObject {
    int hp;

    public EnemyPlane(int x, int y, int width, int height, int hp) {
        super(x, y, width, height);
        this.hp = hp;
    }

    public void moveTo(){
        this.x = x;
        this.y = y;
    }
}
