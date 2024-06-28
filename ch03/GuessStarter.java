import java.util.Random;
import java.util.Scanner;

/**
 * Guess My Number.
 */
public class GuessStarter {

    public static void main(String[] args) {
        int guess;
        Scanner in = new Scanner(System.in);

        // pick a random number
        Random random = new Random();
        int number = random.nextInt(100) + 1;

        // prompt the user and get the value
        System.out.println("I'm thiking of a number between 1 and 100 " +
            "(including both). Can you guess what it is?");
        System.out.print("Type a number: ");
        guess = in.nextInt();
        System.out.printf("Your guess is: %d\n", guess);

        // compute and display the difference
        System.out.printf("The number I was thinking of is: %d\n", number);
        System.out.printf("You were off by: %d\n", guess - number);
    }

}