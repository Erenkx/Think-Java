import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Moire extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moire Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Moire();
        canvas.setSize(400, 400);
        canvas.setBackground(Color.WHITE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int diameter = 90;
        int dDiameter = 2;
        int x = getWidth() / 2 - diameter / 2;
        int y = getHeight() / 2 - diameter / 2;

        while (diameter < getWidth()) {
            g.drawOval(x, y, diameter, diameter);
            x -= dDiameter;
            y -= dDiameter;
            diameter = diameter + 2 * dDiameter;
        }
    }

    public void radial(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        int n = (int) Math.pow(2, 7);
        for (int i = 0; i <= n; i++) {
            g.drawLine(centerX, centerY, i * width / n, 0);
        }
        for (int i = 1; i <= n; i++) {
            g.drawLine(centerX, centerY, 0, i * height / n);
        }
        for (int i = 1; i <= n; i++) {
            g.drawLine(centerX, centerY, i * width / n, height);
        }
        for (int i = 1; i <= n; i++) {
            g.drawLine(centerX, centerY, width, i * width / n);
        }
    }

}