/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceswarm;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.util.List;
import java.util.Vector;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import processing.core.PApplet;

/**
 *
 * @author Sean
 */
public class State {
    private List<Swarm> swarms;
    private TerrainSpace[][] map;
    private int width;
    private int height;
    private int swarmNum;
    PApplet parent;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public TerrainSpace getSpace(int x, int y) {
        return map[x][y];
    }


    public State(PApplet parent) {
        this.parent = parent;
    }

    public void initState(String filename) {
        try {
            DOMParser p = new DOMParser();
            p.parse(this.getClass().getClassLoader().getResource("files/" + filename + ".xml").getFile());
            Document d = p.getDocument();
            
            this.width = Integer.parseInt(d.getElementsByTagName("width").item(0).getTextContent());
            this.height = Integer.parseInt(d.getElementsByTagName("height").item(0).getTextContent());
            this.map = new TerrainSpace[width][height];
            for (int i = 0; i < width; ++i) {
                for (int j = 0; j < height; ++j) {
                    map[i][j] = new TerrainSpace(parent);
                    map[i][j].draw(i, j);
                }
            }
            int x;
            int y;
            NodeList params;
            int positionx = 0;
            int positiony = 0;
            
            NodeList obstacles = d.getElementsByTagName("obstacle");
            Node current;
            for (int i = 0; i < obstacles.getLength(); ++i) {
                current = obstacles.item(i);

                params = current.getChildNodes();
                x = 0;
                y = 0;

                // Obstacle
                for (int k = 0; k < params.getLength(); ++k) {
                    if (params.item(k).getNodeName().equals("positionx")) {
                        positionx = Integer.parseInt(params.item(k).getTextContent());
                    }
                    if (params.item(k).getNodeName().equals("positiony")) {
                        positiony = Integer.parseInt(params.item(k).getTextContent());
                    }
                }

                Obstacle obstacle = new Obstacle(parent, positionx, positiony);
                map[positionx][positiony] = new TerrainSpace(parent, obstacle);
            }
            
            NodeList swarmList = d.getElementsByTagName("swarm");
            
            NodeList members;
            
            this.swarms = new Vector<Swarm>(swarmList.getLength());
            
            Swarm swarm;
            String color = "black";
            int direction = 0;

            for (int i = 0; i < swarmList.getLength(); ++i) {
                swarm = new Swarm();
                current = swarmList.item(i);
                members = current.getChildNodes();

                for (int j = 0; j < members.getLength(); ++j) {
                    current = members.item(j);

                    if (current.getNodeName().equals("color")) {
                        color = current.getTextContent();
                    }
                    else if (current.getNodeName().equals("ant")) {
                        params = current.getChildNodes();
                        x = 0;
                        y = 0;

                        // Ant
                        for (int k = 0; k < params.getLength(); ++k) {
                            if (params.item(k).getNodeName().equals("positionx")) {
                                positionx = Integer.parseInt(params.item(k).getTextContent());
                            }
                            if (params.item(k).getNodeName().equals("positiony")) {
                                positiony = Integer.parseInt(params.item(k).getTextContent());
                            }
                            if(params.item(k).getNodeName().equals("direction")) {
                                direction = Integer.parseInt(params.item(k).getTextContent());
                            }
                        }
                        Ant ant = new Ant(parent, positionx, positiony, direction, General.convertColor(color), swarm.getBehavior());
                        TerrainSpace space = new TerrainSpace(parent);
                        map[positionx][positiony] = space;
                        try {
                            space.objectEnters(ant);
                        } catch (TerrainSpace.SpaceIsOccupied e) {
                        }
                        swarm.addMember(ant);                        
                    }
                }
                this.swarms.add(swarm);
                swarmNum++;
            }
            // TODO: get obstacles


        } catch (Exception e) {
            System.out.println("File not found, or something");
        }
    }

    public void round() {
        // TODO: make this alternate swarms ant by ant
        for (Swarm s : swarms) {
            for (int i = 0 ; i < s.getSize() ; ++i) {
                s.getMember(i).act();
            }
        }
    }

    public void draw() {

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                map[i][j].draw(i, j);
            }
        }

    }

}
