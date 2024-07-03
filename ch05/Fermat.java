import java.util.Scanner;

/**
 * Checks to see if Fermat's Last Theorem holds.
 *
 * Fermat's Last Theorem:
 *     There are no positive integers a, b, c, and n such that
 *     a^n + b^n = c^n, except when n <= 2.
 */
public class Fermat {

    public static void main(String[] args) {
        int a, b, c, n;
        String word;
        Scanner in = new Scanner(System.in);

        // prompt the user and get the value
        System.out.print("a: ");
        if (in.hasNextInt()){
            a = in.nextInt();
            if (a <= 0) {
                System.err.println("Error: a must be a positive integer.");
                return;
            }
        } else {
            word = in.next();
            System.err.print("Error: ");
            System.err.println(word + " is not an integer.");
            return;
        }

        System.out.print("b: ");
        if (in.hasNextInt()) {
            b = in.nextInt();
            if (b <= 0) {
                System.err.println("Error: b must be a positive integer.");
                return;
            }
        } else {
            word = in.next();
            System.err.print("Error: ");
            System.err.println(word + " is not an integer.");
            return;
        }

        System.out.print("c: ");
        if (in.hasNextInt()) {
            c = in.nextInt();
            if (c <= 0) {
                System.err.println("Error: c must be a positive integer.");
                return;
            }
        } else {
            word = in.next();
            System.err.print("Error: ");
            System.err.println(word + " is not an integer.");
            return;
        }

        System.out.print("n: ");
        if (in.hasNextInt()) {
            n = in.nextInt();
            if (n <= 0) {
                System.err.println("Error: n must be a positive integer.");
                return;
            }
        } else {
            word = in.next();
            System.err.print("Error: ");
            System.err.println(word + " is not an integer.");
            return;
        }

        // calculate and check if theorem holds
        if (n >= 2 && Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n)) {
            System.out.println("Holy smokes, Fermat was wrong!");
        } else {
            System.out.println("No, that doesn't work.");
        }
    }

}