package cw2.model;

/**
 * Created by valdess on 15.10.16.
 */
public class Clown extends Artist {

    public Clown(String name) {
        super(name);
    }

    public void makeSmile(){
        System.out.println(":)");
    }

    @Override
    public void act() {

    }
}
