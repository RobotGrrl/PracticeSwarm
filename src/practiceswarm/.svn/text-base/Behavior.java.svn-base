/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceswarm;

/**
 *
 * @author Sean
 */
public interface Behavior {

    // declare the methods that all ants will use to make decisions
    void act(SwarmObject object);

    class Observation {
        // information we want the ants to be able to have goes here
        TerrainSpace[][] surroundings;
        boolean topEdge;
        boolean bottomEdge;
        boolean leftEdge;
        boolean rightEdge;
        int dir;

        Observation() {
            surroundings = new TerrainSpace[5][5];
            topEdge = false;
            bottomEdge = false;
            leftEdge = false;
            rightEdge = false;
        }

        static Observation getObservation(SwarmObject object) {
            Observation o = new Observation();
            int height = ((Simulator) object.parent).state.getHeight() - 1;
            int width = ((Simulator) object.parent).state.getWidth() - 1;

            if (object.getY() == height) {
                o.topEdge = true;
            }
            if (object.getY() == 0) {
                o.bottomEdge = true;
            }
            if (object.getX() == 0) {
                o.leftEdge = true;
            }
            if (object.getX() == width) {
                o.rightEdge = true;
            }

            return o;
        }
    }
}
