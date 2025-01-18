import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Specialization of Polygon that has a color and the ability to draw itself.
 */
public class DrawablePolygon extends Polygon implements Actor {

    protected Color color;

    /**
     * Creates an empty polygon.
     */
    public DrawablePolygon() {
        super();
        color = Color.GRAY;
    }

    /**
     * Returns a string representation of the polygon.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String point = String.format("(%d, %d)", xpoints[0], ypoints[0]);
        sb.append(point);
        for (int i = 1; i < npoints; i++) {
            point = String.format(", (%d, %d)", xpoints[i], ypoints[i]);
            sb.append(point);
        }

        return sb.toString();
    }

    /**
     * Draws the polygon on the screen.
     *
     * @param g graphics context
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(this);
    }

    @Override
    public void step() {
        // do nothing
    }

    /**
     * Tests code that creates a DrawablePolygon.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        DrawablePolygon p = new DrawablePolygon();
        p.addPoint(57, 110);
        p.addPoint(100, 35);
        p.addPoint(143, 110);
        p.color = Color.GREEN;
        System.out.println(p);
    }

}
