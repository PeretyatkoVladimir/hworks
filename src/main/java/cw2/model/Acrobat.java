package cw2.model;

/**
 * Created by valdess on 15.10.16.
 */
public class Acrobat extends Artist {

    Acrobat(String name) {
        super(name);
    }

    public String makeTrick(){
        return "trick on the water";
    }

    @Override
    public void act() {

    }
}
