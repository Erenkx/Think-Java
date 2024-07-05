public class Max {

    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3, 4, 5};
        System.out.println(maxInRange(ints1, 2, 4));    // 5
        System.out.println(maxInRange(ints1, 0, 2));    // 3
        System.out.println(maxInRange(ints1, 3, 3));    // 4

        int[] ints2 = {12, 53, 23, 56, 123, 546, 1, 0};
        System.out.println(maxInRange(ints2, 0, 5));    // 546
        System.out.println(maxInRange(ints2, 3, 7));    // 546
        System.out.println(maxInRange(ints2, 6, 7));    // 1

        System.out.println(max(ints1)); // 5
        System.out.println(max(ints2)); // 546
    }

    /**
     * Finds the maximum value in the array between lowIndex and highIndex,
     * including both.
     *
     * @param ints      an array of integers
     * @param lowIndex  lower bound index
     * @param highIndex higher bound index
     * @return          max value in the array
     */
    public static int maxInRange(int[] ints, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return ints[lowIndex];
        }

        int maxLeft = maxInRange(ints, lowIndex,
                                (lowIndex + highIndex) / 2);
        int maxRight = maxInRange(ints, (lowIndex + highIndex) / 2 + 1,
                                 highIndex);
        if (maxLeft >= maxRight) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }

    /**
     * Finds the maximum value in the array.
     *
     * @param ints  an array of integers
     * @return      max value in the array
     */
    public static int max(int[] ints) {
        return maxInRange(ints, 0, ints.length - 1);
    }

}