public class Pair {

    public static void main(String[] args) {
        System.out.println(isBalanced("((3 + 7) * 2)", '(', ')'));  // true
        System.out.println(isBalanced(")(3 + 7( * 2)", '(', ')'));  // false
        System.out.println(isBalanced("((3 + 7} * 2}", '(', '}'));  // true
        System.out.println(isBalanced("((3 + 7) * 2", '(', ')'));   // false
        System.out.println(isBalanced("}}3 + 7{ * 2{", '}', '{'));  // true
    }

    public static boolean isBalanced(String s, char opening, char closing) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == opening) {
                count++;
            } else if (c == closing) {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

}