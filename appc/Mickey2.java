import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class Mickey2 extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mickey Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Mickey2();
        canvas.setSize(400, 400);
        canvas.setBackground(Color.WHITE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Rectangle bb = new Rectangle(100, 100, 200, 200);
        mickey(g, bb);
    }

    public void mickey(Graphics g, Rectangle bb) {
        boxOval(g, bb);
        mickeyEars(g, bb);
    }

    public void boxOval(Graphics g, Rectangle bb) {
        g.fillOval(bb.x, bb.y, bb.width, bb.height);
    }

    public void mickeyEars(Graphics g, Rectangle bb) {
        if (bb.width < 3 || bb.height < 3) {
            return;
        }

        int hx = bb.width / 2;
        int hy = bb.height / 2;
        Rectangle half = new Rectangle(bb.x, bb.y, hx, hy);

        half.translate(-hx / 2, -hy / 2);
        boxOval(g, half);
        mickeyEars(g, half);

        half.translate(2 * hx, 0);
        boxOval(g, half);
        mickeyEars(g, half);
    }

}
