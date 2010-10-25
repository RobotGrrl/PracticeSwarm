/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceswarm;

import processing.core.PApplet;

/**
 *
 * @author Sean
 */
public abstract class SwarmObject {
    Behavior behavior;
    PApplet parent;
    protected int positionx;
    protected int positiony;
    String memory;
    int dir;

    int[] color;

    /**
     * Executes the actions of the object
     */
    public void act() {
        behavior.act(this);
    }

    public SwarmObject() {
        memory = "";
    }

    public SwarmObject(int positionx, int positiony) {
        this();
        this.positionx = positionx;
        this.positiony = positiony;
    }

    /**
     * Moves the object
     * @param dir The direction in which to move
     */
    public void move(int dir) throws TerrainSpace.SpaceIsOccupied {
        
    }

    public int getX() {
        return positionx;
    }

    public int getY() {
        return positiony;
    }

    /**
     * Checks if the object is solid
     * @return true by default, false for some subclasses
     */
    public boolean isSolid() {
        return true;
    }

    public abstract void draw();
}
