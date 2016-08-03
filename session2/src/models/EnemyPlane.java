package models;

/**
 * Created by DUC on 7/28/2016.
 */
public class EnemyPlane {
    public int x;
    public int y;
    public int hp;
    public EnemyPlane(){
        this(0, 0, 10);
    }
    public EnemyPlane(int x,int y){
        this.x = x;
        this.y = y;
    }
    public EnemyPlane(int x,int y,int hp){
        this.x = x;
        this.y = y;
        this.hp = hp;
    }


}
