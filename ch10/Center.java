import java.awt.Point;
import java.awt.Rectangle;

public class Center {

    public static void main(String[] args) {
        Rectangle box1 = new Rectangle(2, 4, 7, 9);
        Point p1 = findCenter(box1);    // (5, 8)
        printPoint(p1);

        box1.grow(1, 1);    // (1, 3, 9, 11)
        Point p2 = findCenter(box1);    // (5, 8)
        printPoint(p2);
    }

    public static Point findCenter(Rectangle box) {
        int x = box.x + box.width / 2;
        int y = box.y + box.height / 2;

        return new Point(x, y);
    }

    public static void printPoint(Point p) {
        System.out.println("(" + p.x + ", " + p.y + ")");
    }

}