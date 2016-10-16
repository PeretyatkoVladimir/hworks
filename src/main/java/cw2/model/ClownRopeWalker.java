package cw2.model;

/**
 * Created by valdess on 15.10.16.
 */
public class ClownRopeWalker extends Clown implements IRopeWalker {

    public ClownRopeWalker(String name) {
        super(name);
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void ropeWalk() {
        System.out.println("Walk on the rope!");
    }
}
