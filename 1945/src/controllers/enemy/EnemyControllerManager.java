package controllers.enemy;

import controllers.ControllerManager;

/**
 * Created by DUC on 8/12/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    private int count;
    private static final int RESPAWN_TYPE1 = 100;
    private static final int RESPAWN_TYPE2 = 200;

    private EnemyControllerManager() {
        super();
    }

    public void run(){
        count ++;
        int enX = 10;
        int enY = 10;
        if(count == RESPAWN_TYPE2){
            count = 0;
            for(int i =0; i < 5; i++){
                EnemyController enemyController = EnemyController.create(
                        enX, enY, EnemyPlaneType.WHITE);
                enX += 100;
                this.add(enemyController);
            }
        }
        else if(count == RESPAWN_TYPE1){
            for(int i =0; i < 5; i++){
                EnemyController enemyController = EnemyController.create(
                        enX, enY, EnemyPlaneType.YELLOW);
                enX += 100;
                this.add(enemyController);
            }
        }
        super.run();
    }

    public static final EnemyControllerManager instance = new EnemyControllerManager();
}
