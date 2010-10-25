/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceswarm;

/**
 *
 * @author Sean
 */
public class BehaviorA implements Behavior {

    public void act(SwarmObject object) {
        Observation o = Observation.getObservation(object);
        // decision making stuff takes place here

        if (o.rightEdge && object.dir == 1) {
            object.dir = 2;
        }
        if (o.bottomEdge && object.dir == 2) {
            object.dir = 3;
        }
        if (o.leftEdge && object.dir == 3) {
            object.dir = 0;
        }
        if (o.topEdge && object.dir == 0) {
            object.dir = 1;
        }
        try {
            object.move(object.dir);
        } catch (TerrainSpace.SpaceIsOccupied e) {
                object.dir = (object.dir + 1)%4;
        }
    }
}
