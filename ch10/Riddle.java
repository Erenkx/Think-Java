import java.awt.Point;

public class Riddle {

    public static void main(String[] args) {
        int x = 5;
        Point blank = new Point(1, 2);

        System.out.println(riddle(x, blank));   // 15
        System.out.println(x);                  // 5
        System.out.println(blank.x);            // 1
        System.out.println(blank.y);            // 2
    }

    public static int riddle(int x, Point p) {
        x = x + 7;
        return x + p.x + p.y;
    }

}