import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Japan extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Japanese Flag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Japan();
        canvas.setSize(600, 400);
        canvas.setBackground(Color.WHITE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Color red = new Color(188, 0, 45);
        g.setColor(red);
        g.fillOval(180, 80, 240, 240);
    }

}
