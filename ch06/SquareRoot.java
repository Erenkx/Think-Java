/**
 * Finds the square root of a number.
 */
public class SquareRoot {

    public static double squareRoot(double num) {
        double guess = num;
        double improvedGuess = num / 2;
        while (Math.abs(guess - improvedGuess) >= 0.0001) {
            guess = improvedGuess;
            improvedGuess = (guess + num / guess) / 2;
        }

        return improvedGuess;
    }

    public static void main(String[] args) {
        // perfect squares
        System.out.printf("The square root of 1: %.3f\n", squareRoot(1));
        System.out.printf("The square root of 4: %.3f\n", squareRoot(4));
        System.out.printf("The square root of 9: %.3f\n", squareRoot(9));
        System.out.printf("The square root of 25: %.3f\n", squareRoot(25));

        // imperfect squares
        System.out.printf("The square root of 2: %.3f\n", squareRoot(2));
        System.out.printf("The square root of 3: %.3f\n", squareRoot(3));
        System.out.printf("The square root of 5: %.3f\n", squareRoot(5));
        System.out.printf("The square root of 7: %.3f\n", squareRoot(7));
    }

}