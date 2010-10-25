/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceswarm;

import processing.core.PApplet;

/**
 * Ant is the class for the primary members of the swarm
 *
 * @author Sean
 */
public class Ant extends SwarmObject {

    private float a = 0.0f;
    private float inc = PApplet.TWO_PI/25.0f;
    private int swarmObjID = 1;
    private int x;
    private int y;
    private float scale = 0.5f;

    private int mouseX;
    private int mouseY;
    private int myDir;

    private boolean isTurn;


    Ant(PApplet p, int positionx, int positiony, int thedir, int[] color, Behavior behavior) {
        super(positionx, positiony);
        this.color = color;
        this.behavior = behavior;
        this.positionx = positionx;
        this.positiony = positiony;
        this.dir = thedir;
        parent = p;
    }

    public int getID() {
        return swarmObjID;
    }

    public void setPositions(int positionx, int positiony, int thedir) {
        this.x = positionx;
        this.y = positiony;
        this.dir = thedir;
    }

    public void setScale(float s) {
        scale = s;
    }

    @Override
    public void move(int dir) throws TerrainSpace.SpaceIsOccupied{
        this.dir = dir;
        TerrainSpace target;
        int newX;
        int newY;

        switch (dir) {
            case 0:
                newX = positionx;
                newY = positiony - 1;
                target = ((Simulator) this.parent).state.getSpace(newX, newY);
                break;
            case 1:
                newX = positionx + 1;
                newY = positiony;
                target = ((Simulator) this.parent).state.getSpace(newX, newY);
                break;
            case 2:
                newX = positionx;
                newY = positiony + 1;
                target = ((Simulator) this.parent).state.getSpace(newX, newY);
                break;
            case 3:
                newX = positionx - 1;
                newY = positiony;
                target = ((Simulator) this.parent).state.getSpace(newX, newY);
                break;
            default:
                return;
        }

        try {
            target.objectEnters(this);
        } catch (TerrainSpace.SpaceIsOccupied e) {
            throw e;
        }

        ((Simulator) this.parent).state.getSpace(positionx, positiony).objectLeaves();
        positionx = newX;
        positiony = newY;
    }

    @Override
    // 0: N 1: E 2: S 3: W
    public void draw() { //int x, int y, int dir) {

        x = (int)( ( TerrainSpace.squareSize ) * positionx) + TerrainSpace.squareSize/2;
        y = (int)( ( TerrainSpace.squareSize ) * positiony) + TerrainSpace.squareSize/2;

        int legLength = 12;
        float legWalk = 2.5f*PApplet.sin(a);

        // Body
        parent.fill(0);
        parent.stroke(0);
        parent.strokeWeight(0);

        if(dir == 0 || dir == 2) { // North or South
            parent.ellipse(x, y-(scale*15), scale*15, scale*20);
            parent.ellipse(x, y, scale*15, scale*20);
            parent.ellipse(x, y+(scale*15), scale*15, scale*20);
        } else if(dir == 1 || dir == 3) { // East or West
            parent.ellipse(x-(scale*15), y, scale*20, scale*15);
            parent.ellipse(x, y, scale*20, scale*15);
            parent.ellipse(x+(scale*15), y, scale*20, scale*15);
        }

        // Legs
        parent.stroke(0);
        parent.strokeWeight(4);

        if(dir == 0 || dir == 2) { // North or South
            parent.line(x, y-(scale*15), x+(scale*legLength), y-(scale*(15+legWalk)));
            parent.line(x, y, x+(scale*legLength), y+(scale*legWalk));
            parent.line(x, y+(scale*15), x+(scale*legLength), y+(scale*(15+legWalk)));

            parent.line(x, y-(scale*15), x-(scale*legLength), y-(scale*(15+legWalk)));
            parent.line(x, y, x-(scale*legLength), y+(scale*legWalk));
            parent.line(x, y+(scale*15), x-(scale*legLength), y+(scale*(15+legWalk)));
        } else if(dir == 1 || dir == 3) { // East or West
            parent.line(x-(scale*15), y, x-(scale*(15+legWalk)), y+(scale*legLength));
            parent.line(x, y, x+(scale*legWalk), y+(scale*legLength));
            parent.line(x+(scale*15), y, x+(scale*(15+legWalk)), y+(scale*legLength));

            parent.line(x-(scale*15), y, x-(scale*(15+legWalk)), y-(scale*legLength));
            parent.line(x, y, x+(scale*legWalk), y-(scale*legLength));
            parent.line(x+(scale*15), y, x+(scale*(15+legWalk)), y-(scale*legLength));
        }

        // Eyes
        parent.stroke(0);
        parent.strokeWeight(0);
        parent.fill(255);

        switch(dir) {
            case 0: // NORTH
                parent.ellipse(x+(scale*3), y-(scale*18), scale*5, scale*5);
                parent.ellipse(x-(scale*3), y-(scale*18), scale*5, scale*5);
                this.laserBeams(mouseX, mouseY, mouseX, mouseY-100, myDir);
                break;
            case 1: // EAST
                parent.ellipse(x+(scale*18), y+(scale*3), scale*5, scale*5);
                parent.ellipse(x+(scale*18), y-(scale*3), scale*5, scale*5);
                this.laserBeams(mouseX, mouseY, mouseX+100, mouseY, myDir);
                break;
            case 2: // SOUTH
                parent.ellipse(x+(scale*3), y+(scale*18), scale*5, scale*5);
                parent.ellipse(x-(scale*3), y+(scale*18), scale*5, scale*5);
                this.laserBeams(mouseX, mouseY, mouseX, mouseY+100, myDir);
                break;
            case 3: // WEST
                parent.ellipse(x-(scale*18), y+(scale*3), scale*5, scale*5);
                parent.ellipse(x-(scale*18), y-(scale*3), scale*5, scale*5);
                this.laserBeams(mouseX, mouseY, mouseX-100, mouseY, myDir);
                break;
        }

        a += inc;

    }

    public void update(int _mouseX, int _mouseY, int _myDir) {

        this.mouseX = _mouseX;
        this.mouseY = _mouseY;
        this.myDir = _myDir;

        this.setPositions(this.mouseX, this.mouseY, this.myDir);

    }

    public void laserBeams(int x0, int y0, int x, int y, int dir) {

        parent.strokeWeight(3);
        parent.stroke(0, 255, 0, 80);

        switch(dir) {
            case 0: // NORTH
                parent.line(x0+(scale*3), y0-(scale*18), x, y);
                parent.line(x0-(scale*3), y0-(scale*18), x, y);
                break;
            case 1: // EAST
                parent.line(x0+(scale*18), y0+(scale*3), x, y);
                parent.line(x0+(scale*18), y0-(scale*3), x, y);
                break;
            case 2: // SOUTH
                parent.line(x0+(scale*3), y0+(scale*18), x, y);
                parent.line(x0-(scale*3), y0+(scale*18), x, y);
                break;
            case 3: // WEST
                parent.line(x0-(scale*18), y0+(scale*3), x, y);
                parent.line(x0-(scale*18), y0-(scale*3), x, y);
                break;
        }
    }

    public boolean getIsTurn() {
        return isTurn;
    }

    public void startTurn() {
        isTurn = true;
    }

    public void endTurn() {
        isTurn = false;
    }

}
