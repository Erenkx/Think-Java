import javax.swing.JFrame;

/**
 * Langton's Ant.
 */
public class Langton {

    private GridCanvas grid;
    private int xpos;
    private int ypos;
    private int head; // 0=North, 1=East, 2=South, 3=West

    /**
     * Creates a grid with the ant in the center.
     *
     * @param rows number of rows
     * @param cols number of columns
     */
    public Langton(int rows, int cols) {
        grid = new GridCanvas(rows, cols, 20);
        xpos = rows / 2;
        ypos = cols / 2;
        head = 0;
    }

    /**
     * Flips the color of the current cell.
     */
    private void flipCell() {
        Cell cell = grid.getCell(xpos, ypos);
        if (cell.isOff()) {
            // at a white square; turn right and flip color
            head = (head + 1) % 4;
            cell.turnOn();
        } else {
            // at a black square; turn left and flip color
            head = (head + 3) % 4;
            cell.turnOff();
        }
    }

    /**
     * Moves the ant forward one unit.
     */
    private void moveAnt() {
        if (head == 0) {
            ypos -= 1;
        } else if (head == 1) {
            xpos += 1;
        } else if (head == 2) {
            ypos += 1;
        } else {
            xpos -= 1;
        }
    }

    /**
     * Simulates on round of Langton's Ant.
     */
    public void update() {
        flipCell();
        moveAnt();
    }

    /**
     * The simulation loop.
     *
     * @param rate frames per second
     */
    private void mainloop(int rate) {
        while (true) {
            // update the drawing
            this.update();
            grid.repaint();

            // delay the simulation
            try {
                Thread.sleep(1000 / rate);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    /**
     * Creates and runs the simulation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String title = "Langton's Ant";
        Langton game = new Langton(61, 61);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.grid);
        frame.pack();
        frame.setVisible(true);
        game.mainloop(2);
    }

}
