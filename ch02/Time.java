public class Time {

    public static void main(String[] args) {
        int hour = 15;
        int minute = 8;
        int second = 22;

        int secondsSinceMidnight = (hour * 60 * 60) + (minute * 60) + second;
        System.out.println(
            "The number of seconds since midnight: " + secondsSinceMidnight
        );

        int secondsPerDay = 24 * 60 * 60;
        int secondsRemaining = secondsPerDay - secondsSinceMidnight;
        System.out.println(
            "The number of seconds remaining in the day: " + secondsRemaining
        );

        double timePassed = secondsSinceMidnight * 100.0 / secondsPerDay;
        System.out.println(
            "The percentage of the day that has passed: " + timePassed + "%"
        );
    }
}