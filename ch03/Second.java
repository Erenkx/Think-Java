import java.util.Scanner;

/**
 * Converts seconds to hours, minutes, and seconds.
 */
public class Second {

    public static void main(String[] args) {
        int seconds;
        int hour, minute, second;
        final int SECOND_PER_MINUTE = 60;
        final int MINUTE_PER_HOUR = 60;
        Scanner in = new Scanner(System.in);

        // prompt the user and get the value
        System.out.print("Enter a total number of seconds: ");
        seconds = in.nextInt();

        // Convert and output the result
        minute = seconds / SECOND_PER_MINUTE;
        second = seconds % SECOND_PER_MINUTE;

        hour = minute / MINUTE_PER_HOUR;
        minute = minute % MINUTE_PER_HOUR;

        System.out.printf("%d seconds = " +
            "%d hours, %d minutes, and %d seconds\n",
            seconds, hour, minute, second);
    }
    
}