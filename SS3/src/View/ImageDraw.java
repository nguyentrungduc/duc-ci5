package View;

import Models.GameObject;
import utils.Utils;

import java.awt.*;

/**
 * Created by DUC on 7/31/2016.
 */
public class ImageDraw implements GameDraw{
    private Image img;



    public ImageDraw(Image img){
        this.img = img;
    }

    public ImageDraw(String url){
        this.img = Utils.loadImage(url);
    }
    @Override
    public void draw(Graphics g, GameObject gameObject) {
        g.drawImage(img, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(),null);
    }

}
