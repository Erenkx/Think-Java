public class Ackermann {

    public static void main(String[] args) {
        System.out.println(ack(0, 0));  // 1
        System.out.println(ack(0, 1));  // 2
        System.out.println(ack(1, 0));  // 2
        System.out.println(ack(1, 2));  // 4
        System.out.println(ack(4, 1));  // 65533
        System.out.println(ack(3, 4));  // 125

        System.out.println(ack(-1, 0)); // error
    }

    public static int ack(int m, int n) {
        if (m < 0 || n < 0) {
            System.err.println("Error: m and n must be non-negatives.");
            System.exit(1);
        }

        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return ack(m - 1, 1);
        } else {
            return ack(m - 1, ack(m, n - 1));
        }
    }

}