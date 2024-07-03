public class Index {

    public static int indexOfMax(int[] ints) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3};
        System.out.println(indexOfMax(ints1));  // 2

        int[] ints2 = {4, 5, 2, 15, 234, 43, 123, 8};
        System.out.println(indexOfMax(ints2));  // 4

        int[] ints3 = {};
        System.out.println(indexOfMax(ints3));   // -1

        int[] ints4 = {5};
        System.out.println(indexOfMax(ints4));  // 0

        int[] ints5 = {2, 2, 2};
        System.out.println(indexOfMax(ints5));  // 0
    }

}