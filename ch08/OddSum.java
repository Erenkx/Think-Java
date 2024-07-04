public class OddSum {

    /**
     * Calculates the sum of odd integers from 1 to n.
     *
     * @param n     a positive odd integer
     * @return      odd sum from 1 to n
     */
    public static int oddSum(int n) {
        if (n <= 0 || n % 2 == 0) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

        return n + oddSum(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(oddSum(2));  // -1
        System.out.println(oddSum(-1)); // -1

        System.out.println(oddSum(3));  // 4
        System.out.println(oddSum(15)); // 64
        System.out.println(oddSum(99)); // 2500
    }

}