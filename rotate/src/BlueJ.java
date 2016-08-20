import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

/**
 * Created by DUC on 8/19/2016.
 */
public class BlueJ {
    public static void drawHead(Graphics g)
    {
        g.setColor(Color.black);
        g.drawOval(20,100,90,90);
    }

    public static void drawTail(Graphics g)
    {
    }

    public static void drawFace(Graphics g)
    {
        //=============Nose=====================//

        g.setColor(Color.black);
        Polygon nose = new Polygon();

        nose.addPoint(60,160);
        nose.addPoint(40,200);
        nose.addPoint(80,150);
        g.drawPolygon(nose);
        g.fillPolygon(nose);

        //==============Eye======================//
        g.setColor(Color.gray);
        g.fillOval(45,140,15,15);


    }


    public static void drawBody(Graphics g)
    {


        Graphics2D g2d = (Graphics2D) g;
        AffineTransform oldTransform = g2d.getTransform();

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(100, 110, 190, 110, 500, 500);
        g2d.setTransform(AffineTransform.getRotateInstance(Math.PI / 4, 270, 620));
        g2d.draw(roundedRectangle);

        AffineTransform at = AffineTransform.getRotateInstance(Math.PI / 400, 150, 150);

        Shape rotatedRect = at.createTransformedShape(roundedRectangle);



    }


    public static void drawWings(Graphics g)
    {
    }

    public static void drawLegs(Graphics g)
    {
    }
}
