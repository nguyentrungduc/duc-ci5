package models;

/**
 * Created by qhuydtvt on 8/14/2016.
 */
public class GameSetting {

    private static final int WIDTH_DEFAULT = 600;
    private static final int HEIGHT_DEFAULT = 800;
    private static final int THREAD_DELAY = 17;

    private int screenWidth;
    private int screenHeight;
    private int threadDelay;

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }

    private GameSetting(int screenWidth, int screenHeight, int threadDelay) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.threadDelay = threadDelay;
    }

    public boolean inScreen(GameObject gameObject) {
        return gameObject.getY() < this.screenHeight;
    }

    public double toSeconds(int threadCount) {
        return ((double)threadCount * threadDelay) / 1000;
    }

    public double toMiliseconds(int threadCount) {
        return ((double)threadCount * threadDelay);
    }

    private static GameSetting instance;
    public static GameSetting getInstance() {
        if(instance == null) {
            instance = new GameSetting(WIDTH_DEFAULT, HEIGHT_DEFAULT, THREAD_DELAY);
        }
        return instance;
    }
}
