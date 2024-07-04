public class Power {

    public static void main(String[] args) {
        System.out.println(power(3, 0));    // 1
        System.out.println(power(0, 3));    // 0

        System.out.println(power(2, 2));    // 4
        System.out.println(power(2, 3));    // 8
        System.out.println(power(9, 2));    // 81

        System.out.println(power(-1, 2));   // 1
        System.out.println(power(-2, 3));   // -8

        System.out.println(power(0.5, 2));  // 0.25
    }

    public static double power(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            double halfPower = power(x, n / 2);
            return halfPower * halfPower;
        } else {
            return x * power(x, n - 1);
        }
    }

}