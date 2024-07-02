public class Abecedarian {

    public static boolean isAbecedarian(String word) {
        if (word.length() < 2) {
            return true;
        }

        for (int i = 1; i < word.length(); i++){
            if (word.charAt(i) < word.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAbecedarian("a")); // true
        System.out.println(isAbecedarian(""));  // true

        System.out.println(isAbecedarian("abdest"));    // true
        System.out.println(isAbecedarian("cestuy"));    // true
        System.out.println(isAbecedarian("abcdefg"));   // true

        System.out.println(isAbecedarian("apple"));     // false
        System.out.println(isAbecedarian("banana"));    // false
        System.out.println(isAbecedarian("abcdegf"));   // false
    }

}