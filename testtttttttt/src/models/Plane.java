package models;

/**
 * Created by DUC on 7/27/2016.
 */
public class Plane {
    public int x;
    public int y;
    public void move(int dx,int dy){
        x += dx;
        y += dy;
    }
    public Plane(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void moveTo(int x,int y){
        this.x = x;
        this.y=  y;
    }


}
