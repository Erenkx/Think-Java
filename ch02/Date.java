public class Date {

    public static void main(String[] args) {
        String day = "Wednesday";
        int date = 26;
        String month = "June";
        int year = 2024;

        System.out.println(
            "American format: " + day + ", " +
            month + " " + date + ", " + year
        );

        System.out.println(
            "European format: " + day + " " +
            date + " " + month + " " + year
        );
    }
}