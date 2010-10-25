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
public class TerrainSpace {
    private SwarmObject contents;
    private SwarmObject defaultContents;

    PApplet parent;

    int r, g, b, a;

    static int squareSize = 40;

    public TerrainSpace(PApplet p) {
        this.defaultContents = new EmptySpace();
        this.contents = defaultContents;
        parent = p;
        this.setRGBA(255, 255, 255, 255);
    }

    public TerrainSpace(PApplet p, SwarmObject contents) {
        this.defaultContents = contents;
        this.contents = defaultContents;
        parent = p;
        this.setRGBA(255, 255, 255, 255);
    }

    public void setRGBA(int r0, int g0, int b0, int a0) {
        r = r0;
        g = g0;
        b = b0;
        a = a0;
    }

    public void draw(int x, int y) {

        parent.colorMode(parent.RGB, 255);
        parent.fill(r, g, b, a);
        parent.stroke(0);
        parent.strokeWeight(0);
        
        parent.rect(x*squareSize, y*squareSize, squareSize, squareSize);
        contents.draw();
    }

    public SwarmObject getContents() {
        return contents;
    }
    
    public void objectEnters(SwarmObject object) throws SpaceIsOccupied {
        if (this.defaultContents.isSolid()) {
            throw new SpaceIsOccupied();
        }
        this.contents = object;
    }

    public void objectLeaves() {
        this.contents = this.defaultContents;
    }

    public class SpaceIsOccupied extends Throwable {
        public SpaceIsOccupied() {

        }
    }
}
