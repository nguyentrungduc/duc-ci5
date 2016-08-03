package Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by DUC on 7/31/2016.
 */
public class ControlManager implements BaseController{
    private Vector<SingleController> singleControllerVector;

    public ControlManager(){
        singleControllerVector = new Vector<SingleController>();
    }

    public void add(SingleController singleController){
        singleControllerVector.add(singleController);
    }

    public void draw(Graphics g){
        for(BaseController controller : this.singleControllerVector){
            controller.draw(g);
        }
    }
    @Override
    public void run() {
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
