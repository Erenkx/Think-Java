public class Recurse {

    public static void main(String[] args) {
        String s = "Think Java";
        System.out.println(first(s));   // 'T'
        System.out.println(rest(s));    // "hink Java"
        System.out.println(middle(s));  // "Hink Jav"
        System.out.println(length(s));  // 10

        printString("Hello");
        System.out.println();
        printBackward("Hello");

        System.out.println(reverseString("Hello"));
        System.out.println(reverseString("I'm Eren"));

        System.out.println();
        System.out.println(isPalindrome("otto"));   // true
        System.out.println(isPalindrome("palindromeemordnilap"));   // true
        System.out.println(isPalindrome("a"));      // true
        System.out.println(isPalindrome("abca"));   // false
    }

    /**
     * Returns the first character of the given String.
     */
    public static char first(String s) {
        return s.charAt(0);
    }

    /**
     * Returns all but the first letter of the given String.
     */
    public static String rest(String s) {
        return s.substring(1);
    }

    /**
     * Returns all but the first and last letter of the String.
     */
    public static String middle(String s) {
        return s.substring(1, s.length() - 1);
    }

    /**
     * Returns the length of the given String.
     */
    public static int length(String s) {
        return s.length();
    }

    /**
     * Displays the letters of the given String, one on each line.
     */
    public static void printString(String s) {
        if (length(s) == 0) {
            return;
        }

        System.out.println(first(s));
        printString(rest(s));
    }

    /**
     * Displays the letters of the given String backward, one on each line.
     */
    public static void printBackward(String s) {
        if (length(s) == 0) {
            return;
        }

        printBackward(rest(s));
        System.out.println(first(s));
    }

    /**
     * Returns the given String in reverse order.
     */
    public static String reverseString(String s) {
        if (length(s) == 0) {
            return "";
        }

        return reverseString(rest(s)) + first(s);
    }

    /**
     * Checks if the given String is a palindrome.
     */
    public static boolean isPalindrome(String s) {
        if (length(s) == 1 || length(s) == 0) {
            return true;
        }

        return first(s) == first(reverseString(s)) &&
               isPalindrome(middle(s));
    }

}