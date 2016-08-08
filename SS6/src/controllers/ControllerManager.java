package controllers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class ControllerManager implements BaseController {

    private Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        singleControllerVector = new Vector<SingleController>();
    }

    public void add(SingleController singleController) {
        this.singleControllerVector.add(singleController);
    }

    public Vector<SingleController> getSingleControllerVector(){
        return singleControllerVector;
    }

    @Override
    public void draw(Graphics g) {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(singleController.getGameObject().isAlive()) {
                    singleController.draw(g);
                }
            }
        }
    }

    @Override
    public void run() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(!singleController.getGameObject().isAlive()) {
                    singleControllerIterator.remove();
                } else {
                    singleController.run();
                }
            }
        }
    }
//    private ArrayList<SingleController> singleControllerArrayList;
//
//    public ControllerManager() {
//        singleControllerArrayList = new ArrayList<SingleController>();
//    }
//
//    public void add(SingleController singleController) {
//        this.singleControllerArrayList.add(singleController);
//    }
//    public ArrayList<SingleController> getSingleControllerArrayList(){
//        return singleControllerArrayList;
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        for (int i = 0; i < singleControllerArrayList.size(); i++){
//            if(singleControllerArrayList.get(i).getGameObject().isAlive())
//                singleControllerArrayList.get(i).draw(g);
//        }
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < singleControllerArrayList.size(); i++){
//            if(singleControllerArrayList.get(i).getGameObject().isAlive())
//                singleControllerArrayList.get(i).run();
//            else
//                singleControllerArrayList.remove(i);
//        }
//    }


}
