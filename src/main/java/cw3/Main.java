package cw3;

import java.util.ArrayList;

/**
 * Created by valdess on 22.10.16.
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Point> points = new ArrayList<>();

        Point p1 = new Point(2, 5);
        ColorPoint cp1 = new ColorPoint(2,5, Color.green);
        ColorPoint cp2 = new ColorPoint(2,5, Color.red);

        points.add(p1);

        System.out.println(points.contains(cp1));

        System.out.println(p1.equals(cp1));
        System.out.println(cp1.equals(cp2));
        System.out.println(p1.equals(cp2));


    }
}
