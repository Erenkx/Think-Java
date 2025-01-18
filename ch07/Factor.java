public class Factor {

    /**
     * Checks if an integer n is a prime number.
     *
     * @param n an integer
     * @return true if n is a prime, false otherwise
     */
    public static boolean isPrime(int n) {
        // 2 is the smallest prime number
        if (n < 2) {
            return false;
        }

        // any prime number is only divided by 1 and itself
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the numbers in the array are all factors of n.
     *
     * @param n an integer
     * @param factors an integer array
     * @return true if the numbers in factors are all factors of n, false
     * otherwise
     */
    public static boolean areFactors(int n, int[] factors) {
        if (factors.length == 0) {
            return false;
        }

        for (int factor : factors) {
            if (n % factor != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the numbers in the array are all prime and
     * their product is n.
     *
     * @param n an integer
     * @param pfactors an integer array
     * @return true if the numbers in pfactors are all prime and their
     * product is n, false otherwise
     */
    public static boolean arePrimeFactors(int n, int[] pfactors) {
        if (pfactors.length == 0) {
            return false;
        }

        int product = 1;
        for (int pfactor : pfactors) {
            if (!isPrime(pfactor)) {
                return false;
            }

            product *= pfactor;
        }

        return product == n;
    }

    public static void main(String[] args) {
        int n1 = 10;
        int[] factors1 = {1, 2, 5};
        System.out.println(areFactors(n1, factors1));   // true

        int n2 = 1;
        int[] factors2 = {1};
        System.out.println(areFactors(n2, factors2));   // true

        int n3 = 15;
        int[] factors3 = {};
        System.out.println(areFactors(n3, factors3));   // false

        int n4 = 15;
        int[] factors4 = {3, 5};
        System.out.println(arePrimeFactors(n4, factors4));  // true

        int n5 = 20;
        int[] factors5 = {2, 10};
        System.out.println(arePrimeFactors(n5, factors5));  // false

        int n6 = 20;
        int[] factors6 = {2, 5};
        System.out.println(arePrimeFactors(n6, factors6));  // false
    }

}