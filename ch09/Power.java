import java.math.BigInteger;

public class Power {

    public static void main(String[] args) {
        System.out.println(pow(3, 0));    // 1
        System.out.println(pow(0, 3));    // 0

        System.out.println(pow(2, 2));    // 4
        System.out.println(pow(2, 3));    // 8
        System.out.println(pow(9, 2));    // 81

        System.out.println(pow(-1, 2));   // 1
        System.out.println(pow(-2, 3));   // -8

        System.out.println(pow(2, 50));   // 1125899906842624
        System.out.println(pow(8, 18));   // 18014398509481984
    }

    public static BigInteger pow(int x, int n) {
        if (n == 0) {
            return BigInteger.valueOf(1);
        }

        // find x to the n/2 recursively
        BigInteger t = pow(x, n/2);

        // if n is even, the result is t squared
        // if n is odd, the result is t squared times x
        BigInteger tSquared = t.multiply(t);
        if (n % 2 == 0) {
            return tSquared;
        } else {
            return tSquared.multiply(BigInteger.valueOf(x));
        }
    }

}