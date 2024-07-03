import java.util.Arrays;

public class LetterHist {

    public static void printArray(int[] hist) {
        System.out.print("{ " + hist[0]);
        for (int i = 1; i < hist.length; i++) {
            System.out.print(", " + hist[i]);
        }
        System.out.println(" }");
    }

    public static int[] letterHist(String s) {
        int[] hist = new int[26];
        s = s.toLowerCase();

        int index;
        for (char letter : s.toCharArray()) {
            if (!Character.isLetter(letter)) {
                continue;
            }

            index = letter - 'a';
            hist[index]++;
        }

        return hist;
    }

    public static boolean areAnagrams(String s1, String s2) {
        return Arrays.equals(letterHist(s1), letterHist(s2));
    }

    public static void main(String[] args) {
        printArray(letterHist("abcdefg"));
        printArray(letterHist("ABCDEFG"));
        printArray(letterHist("aaaaaaa"));
        printArray(letterHist(""));
        printArray(letterHist("zkljvpoairGNBRIhhareghoinbIM"));

        System.out.println(areAnagrams("stop", "pots"));
        System.out.println(areAnagrams("allen downey", "well annoyed"));
        System.out.println(areAnagrams("christopher mayfield",
                                       "hi prof the camel is dry"));
        System.out.println(areAnagrams("AbC", "aBc"));
    }

}