import models.Bullet;
import models.EnemyPlane;
import models.Plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.Random;

//java awt invisible
/**
 * Created by DUC on 7/28/2016.
 */

public class GameWindow extends Frame implements Runnable{
    Image background;
    Image planeImage1;
    Image planeImage2;
    Image bulletImage;
    Image enemyplaneImage1;
    Image enemyplaneImage2;
    int plane1width;
    int plane1height;
    int plane2width;
    int plane2height;
    int enenyplanewidth1;
    int enenyplaneheight1;
    int enenyplanewidth2;
    int enenyplaneheight2;
    Thread thread;
    Thread threadep1;
    Thread threadep2;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphic;
    Plane plane1;
    Plane plane2;
    Vector<Bullet> bulletVector;
    Vector<EnemyPlane> enemyPlaneVector1;
    Vector<EnemyPlane> enemyPlaneVector2;

    public GameWindow() {
        System.out.println("GameWindow constructor");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setLocation(0, 0);
        plane1 = new Plane(400, 500);
        plane2 = new Plane(200, 500);
        bulletVector = new Vector<Bullet>();
        enemyPlaneVector1 = new Vector<EnemyPlane>();
        enemyPlaneVector2 = new Vector<EnemyPlane>();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println(" windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        try {
            background = ImageIO.read(new File("resources/background.png"));
            planeImage1 = ImageIO.read(new File("resources/plane4.png"));
            planeImage2 = ImageIO.read(new File("resources/plane2.png"));
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
            enemyplaneImage1 = ImageIO.read(new File("resources/enemy_plane_white_1.png"));
            enemyplaneImage2 = ImageIO.read(new File("resources/enemy_plane_yellow_1.png"));
            this.plane1width = planeImage1.getWidth(null);
            this.plane1height = planeImage1.getHeight(null);
            this.plane2height = planeImage2.getHeight(null);
            this.plane2width = planeImage2.getWidth(null);
            this.enenyplaneheight1 = enemyplaneImage1.getHeight(null);
            this.enenyplanewidth1 = enemyplaneImage1.getWidth(null);
            this.enenyplaneheight2 = enemyplaneImage2.getHeight(null);
            this.enenyplanewidth2 = enemyplaneImage2.getWidth(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE: {
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane2.x + plane2height / 2, plane2.y);
                        bulletVector.add(bullet);
                        break;
                    }
                    case KeyEvent.VK_LEFT:
                        plane1.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        plane1.y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.y += 10;
                        break;
                }
                repaint();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2.moveTo(e.getX() - plane2width / 2, e.getY() - plane2height / 2);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Bullet bullet = new Bullet();
                bullet.moveTo(plane1.x + plane1height / 2, plane1.y);
                bulletVector.add(bullet);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        threadep1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Random rd = new Random();
                        EnemyPlane enemyPlane1 = new EnemyPlane(rd.nextInt(700), 0);
                        enemyPlaneVector1.add(enemyPlane1);
                        threadep1.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        threadep2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Random rd1 = new Random();
                        EnemyPlane enemyPlane2 = new EnemyPlane(rd1.nextInt(700), 0);
                        enemyPlaneVector2.add(enemyPlane2);
                        threadep2.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        threadep1.start();
        threadep2.start();
    }
    @Override
    public void update(Graphics g){
        bufferedImageGraphic.drawImage(background, 0, 0, null);
        bufferedImageGraphic.drawImage(planeImage1, plane1.x, plane1.y, null);
        bufferedImageGraphic.drawImage(planeImage2, plane2.x, plane2.y, null);
        for (Bullet bullet : bulletVector) {
            bufferedImageGraphic.drawImage(bulletImage, bullet.x, bullet.y, null);
        }
        for (EnemyPlane enemyplane1 : enemyPlaneVector1) {
            bufferedImageGraphic.drawImage(enemyplaneImage1, enemyplane1.x, enemyplane1.y, null);
        }
        for (EnemyPlane enemyplane2 : enemyPlaneVector2) {
            bufferedImageGraphic.drawImage(enemyplaneImage2, enemyplane2.x, enemyplane2.y, null);
        }
        g.drawImage(bufferedImage, 0, 0, null);
        System.out.println("Paint");
    }
    public void checkcollision(){
        Iterator<EnemyPlane> planeEnemy1Iterator = enemyPlaneVector1.iterator();
        while(planeEnemy1Iterator.hasNext()){
            EnemyPlane enemyPlane1 = planeEnemy1Iterator.next();
            Rectangle planeEnemyRectangle = new Rectangle(enemyPlane1.x, enemyPlane1.y, enemyplaneImage1.getHeight(null), enemyplaneImage1.getWidth(null));
            Iterator<Bullet> bulletIterator = bulletVector.iterator();
            while(bulletIterator.hasNext()){
                Bullet bullet = bulletIterator.next();
                Rectangle bulletRectangle = new Rectangle(bullet.x, bullet.y, bulletImage.getHeight(null), bulletImage.getWidth(null));
                if (planeEnemyRectangle.intersects(bulletRectangle)) {
                    bulletIterator.remove();
                    planeEnemy1Iterator.remove();
                    break;
                }
            }
        }
        Iterator<EnemyPlane> planeEnemyIterator2 = enemyPlaneVector2.iterator();
        while(planeEnemyIterator2.hasNext()){
            EnemyPlane enemyPlane2 = planeEnemyIterator2.next();
            Rectangle planeEnemy2Rectangle = new Rectangle(enemyPlane2.x, enemyPlane2.y, enemyplaneImage2.getHeight(null), enemyplaneImage2.getWidth(null));
            Iterator<Bullet> bulletIterator = bulletVector.iterator();
            while(bulletIterator.hasNext()){
                Bullet bullet = bulletIterator.next();
                Rectangle bulletRectangle = new Rectangle(bullet.x, bullet.y, bulletImage.getHeight(null), bulletImage.getWidth(null));
                if (planeEnemy2Rectangle.intersects(bulletRectangle)) {
                    bulletIterator.remove();
                    planeEnemyIterator2.remove();
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(27);
                checkcollision();

                Iterator<Bullet> bulletIterator = bulletVector.iterator();

                while(bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    if(bullet.y <= 0) {
                        bulletIterator.remove();
                    }
                }
                Iterator<EnemyPlane> enemyPlaneIterator1 = enemyPlaneVector1.iterator();

                while(enemyPlaneIterator1.hasNext()) {
                    EnemyPlane enemyPlane1 = enemyPlaneIterator1.next();
                    enemyPlane1.y += 10;
                    if(enemyPlane1.y >= 700) {
                        enemyPlaneIterator1.remove();
                    }
                }

                Iterator<EnemyPlane> enemyPlaneIterator2 = enemyPlaneVector2.iterator();

                while(enemyPlaneIterator2.hasNext()) {
                    EnemyPlane enemyPlane2 = enemyPlaneIterator2.next();
                    enemyPlane2.y += 10;
                    if(enemyPlane2.y >= 700) {
                        enemyPlaneIterator2.remove();
                    }
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



}
