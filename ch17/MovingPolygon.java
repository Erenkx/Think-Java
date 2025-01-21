import java.awt.Color;
import java.awt.Graphics;

/**
 * A polygon that periodically changes its position.
 */
public class MovingPolygon extends RegularPolygon implements Actor {

    private final int canvasWidth;
    private final int canvasHeight;
    private int posx;
    private int posy;
    private int dx;
    private int dy;

    /**
     * Constructs a moving polygon, given the number of sides, the X
     * coordinate, and the Y coordinate.
     *
     * @param nsides the number of sides
     * @param posx initial X coordinate
     * @param posy initial Y coordinate
     */
    public MovingPolygon(int nsides, int posx, int posy) {
        this(nsides, 50, posx, posy);
    }

    /**
     * Constructs a moving polygon, given the number of sides, the radius,
     * the X coordinate, and the Y coordinate.
     *
     * @param nsides the number of sides
     * @param radius from center to vertex
     * @param posx initial X coordinate
     * @param posy initial Y coordinate
     */
    public MovingPolygon(int nsides, int radius, int posx, int posy) {
        this(nsides, radius, Color.GRAY, posx, posy);
    }

    /**
     *  Constructs a moving polygon, given the number of sides, the radius,
     *  the fill color, the X coordinate, and the Y coordinate.
     *
     * @param nsides the number of sides
     * @param radius from center to vertex
     * @param color initial fill color
     * @param posx initial X coordinate
     * @param posy initial Y coordinate
     */
    public MovingPolygon(int nsides, int radius, Color color, int posx,
                         int posy) {
        this(nsides, radius, color, posx, posy, 5, 5, 500, 250);
    }

    /**
     *  Constructs a moving polygon.
     *
     * @param nsides the number of sides
     * @param radius from center to vertex
     * @param color initial fill color
     * @param posx initial X coordinate
     * @param posy initial Y coordinate
     * @param dx initial horizontal velocity
     * @param dy initial vertical velocity
     * @param width the width of canvas in pixels
     * @param height the height of canvas in pixels
     */
    public MovingPolygon(int nsides, int radius, Color color, int posx,
                         int posy, int dx, int dy, int width, int height) {
        super(nsides, radius, color);
        this.posx = posx;
        this.posy = posy;
        this.dx = dx;
        this.dy = dy;
        this.canvasWidth = width;
        this.canvasHeight = height;

        for (int i = 0; i < nsides; i++) {
            xpoints[i] += this.posx;
            ypoints[i] += this.posy;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void step() {
        posx += dx;
        posy += dy;

        int rightmost = Integer.MIN_VALUE;
        int leftmost = Integer.MAX_VALUE;
        int topmost = Integer.MAX_VALUE;
        int bottommost = Integer.MIN_VALUE;

        for (int i = 0; i < npoints; i++) {
            xpoints[i] += dx;
            ypoints[i] += dy;

            rightmost = Math.max(rightmost, xpoints[i]);
            leftmost = Math.min(leftmost, xpoints[i]);
            topmost = Math.min(topmost, ypoints[i]);
            bottommost = Math.max(bottommost, ypoints[i]);
        }

        if (rightmost >= canvasWidth) {
            dx = -Math.abs(dx);
        }
        if (leftmost <= 0) {
            dx = Math.abs(dx);
        }
        if (topmost <= 0) {
            dy = Math.abs(dy);
        }
        if (bottommost >= canvasHeight) {
            dy = -Math.abs(dy);
        }
    }

}
