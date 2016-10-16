package cw2.model;

/**
 * Created by valdess on 15.10.16.
 */
public abstract class Artist {

    String name;

    Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                '}';
    }

    public abstract void act();

}
