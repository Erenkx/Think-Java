public class Doubloon {

    public static boolean isDoubloon(String word) {
        int length = word.length();
        if (length < 2 || length % 2 != 0) {
            return false;
        }

        int count;
        word = word.toLowerCase();
        for (int i = 0; i < length; i++) {

            count = 1;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }

                if (word.charAt(i) == word.charAt(j)) {
                    count++;
                }
            }

            if (count != 2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDoubloon(""));     // false
        System.out.println(isDoubloon("a"));    // false

        System.out.println(isDoubloon("aabb")); // true
        System.out.println(isDoubloon("abab")); // true
        System.out.println(isDoubloon("Abba")); // true
        System.out.println(isDoubloon("Otto")); // true

        System.out.println(isDoubloon("aabba"));    // false
        System.out.println(isDoubloon("aabbaa"));   // false
        System.out.println(isDoubloon("ababc"));    // false
    }

}