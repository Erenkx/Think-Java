public class Lyrics {

    public static void readLyrics(int n) {
        if (n == 0) {
            System.out.println("No bottles of beer on the wall,");
            System.out.println("no bottles of beer,");
            System.out.println("ya' can't take one down, " +
                "ya' can't pass it around,");
            System.out.println("'cause there are no more bottles of beer " +
                "on the wall!");
            return;
        }

        System.out.printf("%d bottles of beer on the wall,\n", n);
        System.out.printf("%d bottles of beer,\n", n);
        System.out.println("ya' take one down, ya' pass it around,");
        System.out.printf("%d bottles of beer on the wall.\n", n - 1);
        System.out.println();

        readLyrics(n - 1);
    }

    public static void main(String[] args) {
        readLyrics(99);
    }

}