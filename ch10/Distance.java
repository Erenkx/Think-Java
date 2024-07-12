import java.awt.Point;
import java.awt.Rectangle;

public class Distance {

    public static void main(String[] args) {
        Point blank = new Point(5, 8);

        Rectangle rect = new Rectangle(0, 2, 4, 4);
        Point center = findCenter(rect);    // (2, 4)

        double dist = distance(center, blank);  // 5.0
        System.out.println(dist);
    }

    public static double distance(Point p1, Point p2) {
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Point findCenter(Rectangle box) {
        int x = box.x + box.width / 2;
        int y = box.y + box.height / 2;

        return new Point(x, y);
    }

}