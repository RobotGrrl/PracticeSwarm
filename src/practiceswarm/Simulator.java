/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceswarm;

import processing.core.*;

/**
 *
 * @author Sean
 */
public class Simulator extends PApplet {

    int count;
    int myDir;

    TerrainSpace myTS = new TerrainSpace(this);

    int[] color = new int[4];

    Ant erinsAnt = new Ant(this, 0, 0, 0, color, null);
    State state = new State(this);
    
    public Simulator() {
        
    }

   public static void main(String[] args) {
       // must match the name of your class ie "letsp5.Main" = packageName.className
       PApplet.main( new String[]{"practiceswarm.Simulator"} );
   }

   @Override
   public void setup () {
       state.initState("stateInit");
       size(state.getWidth()*TerrainSpace.squareSize, state.getHeight()*TerrainSpace.squareSize);
       background(128);
       smooth();
       count = 1;
       //noStroke();

       myTS.setRGBA(255, 0, 255, 60);
       
   }

   @Override
   public void draw () {

       //background(128);

       /*
       // Just testing terrain space
       for(int j=0; j<10; j++) {
        for(int i=0; i<10; i++) {
            myTS.draw(i,j);
        }
       }
       */
       
       
       state.draw();

       //antTesting();

       if (count % 100 == 0) {
           count = 0;
           state.round();
       }
       else {
           ++count;
       }
       
   }

   void antTesting() {
       erinsAnt.draw();
       erinsAnt.update(mouseX, mouseY, myDir);
   }

   @Override
   public void mouseDragged() {
       line(mouseX, mouseY, pmouseX, pmouseY);
   }

   public void keyPressed() {
       if (key == CODED) {
            if (keyCode == UP) {          // NORTH
                myDir = 0;
            } else if(keyCode == RIGHT) { // EAST
                myDir = 1;
            } else if(keyCode == DOWN) {  // SOUTH
                myDir = 2;
            } else if(keyCode == LEFT) {  // WEST
                myDir = 3;
            }
       }

   }


   
}
