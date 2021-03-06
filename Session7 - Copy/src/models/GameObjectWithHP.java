package models;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
public class GameObjectWithHP extends GameObject {

    protected int hp;
    protected int maxHP;

    public GameObjectWithHP(int x, int y, int width, int height, int maxHP) {
        super(x, y, width, height);
        this.hp = maxHP;
        this.maxHP = maxHP;
    }

    public GameObjectWithHP(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public int getHp() {
        return hp;
    }

    public void increaseHP(int amount) {
        this.hp += amount;
        if(this.hp > maxHP)
            this.hp = maxHP;
    }

    public void decreaseHP (int amount)
    {
        this.hp -= amount;
        if(this.hp < 0) {
            destroy();
        }
    }
}
