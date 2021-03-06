package models;

import java.awt.*;

/**
 * Created by DUC on 8/11/2016.
 */
public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    private boolean isAlive;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void move(GameVector gameVector){
        this.x += gameVector.dx;
        this.y +=gameVector.dy;
    }

    public int getMiddleX(){
        return this.x + this.width / 2;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void destroy() {
        this.isAlive = false;
    }

    public boolean overlap(GameObject gameObject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }

    private Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public int getBottom() {
        return  this.y + this.height;
    }

}
