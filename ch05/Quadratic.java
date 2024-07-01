import java.util.Scanner;

/**
 * Finds the roots of ax^2 + bx + c = 0 using quadratic formula.
 */
public class Quadratic {

    public static void main(String[] args) {
        int a, b, c;
        String word;
        Scanner in = new Scanner(System.in);

        // prompt the user and get the value
        System.out.print("a: ");
        if (in.hasNextInt()){
            a = in.nextInt();
            if (a == 0) {
                System.err.println("a must not be 0.");
                return;
            }
        } else {
            word = in.next();
            System.err.println(word + " is not an integer.");
            return;
        }

        System.out.print("b: ");
        if (in.hasNextInt()) {
            b = in.nextInt();
        } else {
            word = in.next();
            System.err.println(word + " is not an integer.");
            return;
        }

        System.out.print("c: ");
        if (in.hasNextInt()) {
            c = in.nextInt();
        } else {
            word = in.next();
            System.err.println(word + " is not an integer.");
            return;
        }

        // calculate and output the result
        double delta = Math.pow(b, 2) - 4.0 * a * c;
        if (delta < 0.0) {
            System.out.println("There is no solution");
        } else if (delta == 0.0) {
            System.out.println("There is only one solution: " +
                -b / (2.0 * a));
        } else {
            System.out.printf("There are two solutions: %.2f and %.2f\n",
                (-b + Math.sqrt(delta)) / (2.0 * a),
                (-b - Math.sqrt(delta)) / (2.0 * a));
        }
    }

}