package models;

import controllers.SingleController;

/**
 * Created by DUC on 8/18/2016.
 */
public class Fire extends GameObject {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    public Fire(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
