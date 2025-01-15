import javax.swing.JFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Conway's Game of Life.
 */
public class Conway {

    private GridCanvas grid;

    /**
     * Creates a grid with two Blinkers.
     */
    public Conway() {
        grid = new GridCanvas(5, 5, 50);
        grid.turnOn(1, 2);
        grid.turnOn(2, 3);
        grid.turnOn(3, 1);
        grid.turnOn(3, 2);
        grid.turnOn(3, 3);
    }

    /**
     * Creates a grid based on the given file.
     */
    public Conway(String path) {
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            ArrayList<ArrayList<Integer>> list =
                new ArrayList<ArrayList<Integer>>();
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                if (s.startsWith("!")) {
                    continue;
                }

                ArrayList<Integer> row = new ArrayList<Integer>();
                for (char c : s.toCharArray()) {
                    if (c == '.') {
                        row.add(0);
                    } else {
                        row.add(1);
                    }
                }
                list.add(row);
            }

            int rows = list.size();
            int cols = list.get(0).size();
            grid = new GridCanvas(rows, cols, 50);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (list.get(i).get(j) == 1) {
                        grid.turnOn(i, j);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Counts the number of live neighbors around a cell.
     *
     * @param r row index
     * @param c column index
     * @return number of live neighbors
     */
    private int countAlive(int r, int c) {
        int count = 0;
        count += grid.test(r - 1, c - 1);
        count += grid.test(r - 1, c);
        count += grid.test(r - 1, c + 1);
        count += grid.test(r, c - 1);
        count += grid.test(r, c + 1);
        count += grid.test(r + 1, c - 1);
        count += grid.test(r + 1, c);
        count += grid.test(r + 1, c + 1);

        return count;
    }

    /**
     * Applies the update rules of Conway's Game of Life.
     *
     * @param cell the cell to update
     * @param count number of live neighbors
     */
    private static void updateCell(Cell cell, int count) {
        if (cell.isOn()) {
            if (count < 2 || count > 3) {
                // Any live cell with fewer than two live neighbors dies,
                // as if by underpopulation.
                // Any live cell with more than three live neighbors dies,
                // as if by overpopulation.
                cell.turnOff();
            }
        } else {
            if (count == 3) {
                // Any dead cell with exactly three live neighbors
                // becomes a live cell, as if by reproduction.
                cell.turnOn();
            }
        }
    }

    /**
     * Counts the neighbors before changing anything.
     *
     * @return number of neighbors for each cell
     */
    private int[][] countNeighbors() {
        int rows = grid.numRows();
        int cols = grid.numCols();

        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }

        return counts;
    }

    /**
     * Updates each cell based on neighbor counts.
     *
     * @param counts number of neighbors for each cell
     */
    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCols();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCell(cell, counts[r][c]);
            }
        }
    }

    /**
     * Simulates one round of Conway's Game of Life.
     */
    public void update() {
        int[][] counts = countNeighbors();
        updateGrid(counts);
    }

    /**
     * The simulation loop.
     */
    private void mainloop() {
        while (true) {
            // update the drawing
            this.update();
            grid.repaint();

            // delay the simulation
            try {
                Thread.sleep(500);
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
        String title = "Conway's Game of Life";
        Conway game = new Conway("glider.cells");
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.grid);
        frame.pack();
        frame.setVisible(true);
        game.mainloop();
    }

}
