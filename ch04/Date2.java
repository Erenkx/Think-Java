public class Date2 {

    public static void printAmerican(String day, int date,
                                     String month, int year) {
        System.out.println(
            "American format: " + day + ", " +
            month + " " + date + ", " + year
        );
    }

    public static void printEuropean(String day, int date,
                                     String month, int year) {
        System.out.println(
            "European format: " + day + " " +
            date + " " + month + " " + year
        );
    }

    public static void main(String[] args) {
        String day = "Saturday";
        int date = 29;
        String month = "June";
        int year = 2024;

        printAmerican(day, date, month, year);
        printEuropean(day, date, month, year);
    }

}