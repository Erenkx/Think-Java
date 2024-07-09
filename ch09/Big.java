import java.math.BigInteger;

public class Big {

    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            System.out.printf("%d! = %d\n", i, factorial(i));
        }
    }

    public static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(1);
        }

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

}