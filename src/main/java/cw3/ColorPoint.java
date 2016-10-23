package cw3;



/**
 * Created by valdess on 22.10.16.
 */
public class ColorPoint extends Point {

    private Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }



    @Override
    public boolean equals(Object o) {

        if (o.getClass() == Point.class) {
            return super.equals(o);
        } else {
            ColorPoint that = (ColorPoint) o;
            return color == that.color;
        }

    }

    @Override
    public String toString() {
        return super.toString() + "Point color - " + color;
    }
}
