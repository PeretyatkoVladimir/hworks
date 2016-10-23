package cw3;

/**
 * Created by valdess on 22.10.16.
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || !(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public String toString() {
        return "Point(" + x +";" + y +')';
    }
}
