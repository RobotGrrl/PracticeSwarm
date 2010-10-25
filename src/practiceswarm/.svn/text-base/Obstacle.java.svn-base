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
public class Obstacle extends SwarmObject {
    boolean isSolid = true;
    int x, y, x0, y0;

    private float scale = 0.9f;

    public Obstacle(PApplet parent, int x0, int y0) {
        this.parent = parent;
        this.x0 = x0;
        this.y0 = y0;
        this.color = new int[4];
        this.color[0] = 128;
        this.color[1] = 128;
        this.color[2] = 128;
        this.color[3] = 0;
    }

    @Override
    public void draw() {
        parent.fill(0);
        parent.stroke(0);
        parent.strokeWeight(0);
        x = (int) ((TerrainSpace.squareSize) * x0 + TerrainSpace.squareSize/2);
        y = (int) ((TerrainSpace.squareSize) * y0 + TerrainSpace.squareSize/2);
        parent.ellipse(x, y, scale*TerrainSpace.squareSize, scale * TerrainSpace.squareSize);
    }
}
