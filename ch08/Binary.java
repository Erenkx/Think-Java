public class Binary {

    public static void displayBinary(int value) {
        if (value > 0) {
            displayBinary(value / 2);
            System.out.print(value % 2);
        }
    }

    public static void main(String[] args) {
        displayBinary(23);      // output is 10111
        System.out.println();
    }

}