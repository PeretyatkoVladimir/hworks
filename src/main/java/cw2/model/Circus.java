package cw2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by valdess on 15.10.16.
 */
public class Circus {

    String name;
    ArrayList<Artist> artists = new ArrayList<>();

    public Circus(String name) {
        this.name = name;
    }


    public void startPerformance(){
        for(Artist a : artists){
            a.act();
        }
    }

    @Override
    public String toString() {
        return "Circus{" +
                "name='" + name + '\'' +
                ", artists=" + artists +
                '}';
    }

    public void sortArtistsByName(){
        Collections.sort(artists, new Comparator<Artist>() {
            @Override
            public int compare(Artist artist1, Artist artist2) {
                return artist1.getName().compareTo(artist2.getName());
            }
        });
    }

    public boolean hireRopeWalker(IRopeWalker ropeWalker){
        return artists.add((Artist) ropeWalker);
    }

}
