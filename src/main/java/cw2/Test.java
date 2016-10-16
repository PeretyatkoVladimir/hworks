package cw2;

import cw2.model.Circus;
import cw2.model.ClownRopeWalker;
import cw2.model.IRopeWalker;

/**
 * Created by valdess on 15.10.16.
 */
public class Test {

    public static void main(String[] args) {

        Circus circus = new Circus("Kozlov");

        IRopeWalker a1 = new ClownRopeWalker("Vasya");
        IRopeWalker a2 = new ClownRopeWalker("Abama");

        circus.hireRopeWalker(a1);
        circus.hireRopeWalker(a2);

        System.out.println(circus);
        circus.sortArtistsByName();
        System.out.println(circus);

        circus.startPerformance();
    }
}
