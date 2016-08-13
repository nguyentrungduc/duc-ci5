package controllers.gift;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by DUC on 8/12/2016.
 */
public class NotificationCenter {
    private Vector<BombSubscriber> bombSubscribers;
    private Vector<FreezzeSubscriber> freezzeSubscribers;

    public NotificationCenter(){
        bombSubscribers = new Vector<BombSubscriber>();
        freezzeSubscribers = new Vector<FreezzeSubscriber>();
    }

    public void subscriberBom(BombSubscriber bomSubscriber){
        bombSubscribers.add(bomSubscriber);
    }

    public void onBomExpode(int x, int y){
        Iterator<BombSubscriber> bombSubscriberIterator = bombSubscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if(!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public void subscribersFreezze(FreezzeSubscriber freezzeSubscriber){
        freezzeSubscribers.add(freezzeSubscriber);
    }

    public void onFrezze(int x, int y) {
        Iterator<FreezzeSubscriber> bombSubscriberIterator = freezzeSubscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            FreezzeSubscriber freezzeSubcriber = bombSubscriberIterator.next();
            if(!freezzeSubcriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                freezzeSubcriber.onFrezze(x, y);
            }
        }
    }

    public static final NotificationCenter instance = new NotificationCenter();

}
