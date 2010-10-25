/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practiceswarm;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Sean
 */
public class Swarm {
    private List<SwarmObject> swarm;
    private int size;
    private Behavior behavior;

    public Swarm() {
        this.swarm = new Vector<SwarmObject>();
        this.size = 0;
        this.behavior = new BehaviorA();
    }

    public int getSize() {
        return this.size;
    }

    public SwarmObject getMember(int index) {
        return swarm.get(index);
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public void addMember(SwarmObject member) {
        member.behavior = this.behavior;
        swarm.add(member);
        ++size;
    }
}
