/**
 * Finds all prime numbers up to any given limit using Sieve of Eratosthenes.
 *
 * Source: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
public class Sieve {

    public static void printArray(boolean[] primes) {
        System.out.print("{ " + primes[0]);
        for (int i = 1; i < primes.length; i++) {
            System.out.print(", " + primes[i]);
        }
        System.out.println(" }");
    }

    public static boolean[] sieve(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        primes[0] = false;
        primes[1] = false;
        int p = 2;
        boolean remain = true;
        while (remain) {
            for (int multiple = 2; multiple * p < n; multiple++) {
                primes[multiple * p] = false;
            }

            int i = p + 1;
            for (; i < n; i++) {
                if (primes[i] == true) {
                    p = i;
                    break;
                }
            }

            if (i == n) {
                remain = false;
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        printArray(sieve(5));   // 2, 3
        printArray(sieve(10));  // 2, 3, 5, 7
        printArray(sieve(100)); // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                                // 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
                                // 89, 97
    }

}