package controllers.enemy;

import controllers.EnemyState;

/**
 * Created by DUC on 8/12/2016.
 */
public class FreezeBehavior {
    private int count;
    private int frezzePeriod;

    public FreezeBehavior(int frezzePeriod){
        this.count = 0;
        this.frezzePeriod = frezzePeriod;
    }

    public void run(EnemyController enemyController){
        switch (enemyController.getEnemyState()){
            case NORMAL:
                break;
            case FREZZED:
                count ++;
                if(count == frezzePeriod){
                    count = 0;
                    enemyController.setEnemyState(EnemyState.NORMAL);
                }
        }
    }
}
