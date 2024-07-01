import java.util.Scanner;

/**
 * Checks if three sticks are able to arrange a triangle.
 */
public class Triangle {

    public static void main(String[] args) {
        int a, b, c;
        String word;
        Scanner in = new Scanner(System.in);

        // prompt the user and get the value
        System.out.print("a: ");
        if (in.hasNextInt()) {
            a = in.nextInt();
            if (a <= 0) {
                System.err.println("a must be greater than 0.");
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
            if (b <= 0) {
                System.err.println("b must be greater than 0.");
                return;
            }
        } else {
            word = in.next();
            System.err.println(word + " is not an integer.");
            return;
        }

        System.out.print("c: ");
        if (in.hasNextInt()) {
            c = in.nextInt();
            if (c <= 0) {
                System.err.println("c must be greater than 0.");
                return;
            }
        } else {
            word = in.next();
            System.err.println(word + " is not an integer.");
            return;
        }

        // check if it is a triangle
        if (a + b < c || a + c < b || b + c < a) {
            System.out.println("These three sticks cannot form a triangle.");
        } else {
            System.out.println("These three sticks can form a triangle!");
        }
    }

}