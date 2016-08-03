package models;

/**
 * Created by DUC on 7/30/2016.
 */
public class GameObject {
    private  int x;
    private int y;
    private int width;
    private int height;

    public void setX(int x) {
        if(x >= 0) {
            this.x = x;
        }
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
}
