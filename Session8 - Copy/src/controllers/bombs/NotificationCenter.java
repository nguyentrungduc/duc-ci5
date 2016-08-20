package controllers.bombs;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 8/10/2016.
 */


public class NotificationCenter {
    private Vector<BombSubscriber> subscribers;
    private Vector<FreezzeSubcriber> freezzeSubcribers;
    private Vector<GiftSubscriber> giftSubscribers;

    public NotificationCenter() {
        subscribers = new Vector<BombSubscriber>();
        freezzeSubcribers = new Vector<FreezzeSubcriber>();
        giftSubscribers = new Vector<GiftSubscriber>();
    }

    public void subsribe(BombSubscriber bombSubscriber) {
        subscribers.add(bombSubscriber);
    }

    public void subsribeFrezze(FreezzeSubcriber bombSubscriber) {
        freezzeSubcribers.add(bombSubscriber);
    }

    public void subscribeGift(GiftSubscriber giftSubscriber){
        giftSubscribers.add(giftSubscriber);
    }

    public void onBomExpode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = subscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if(!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public void onFrezze(int x, int y) {
        Iterator<FreezzeSubcriber> bombSubscriberIterator = freezzeSubcribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            FreezzeSubcriber freezzeSubcriber = bombSubscriberIterator.next();
            if(!freezzeSubcriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                freezzeSubcriber.onFrezze(x, y);
            }
        }
    }

    public void onGift(int x, int y){
        Iterator<GiftSubscriber> giftSubscriberIterator = giftSubscribers.iterator();
        while(giftSubscriberIterator.hasNext()) {
            GiftSubscriber giftSubscriber = giftSubscriberIterator.next();
            if(!giftSubscriber.getGameObject().isAlive()) {
                giftSubscriberIterator.remove();
            } else {
                giftSubscriber.onGift(x, y);
            }
        }
    }

    public static final NotificationCenter instance = new NotificationCenter();
}
