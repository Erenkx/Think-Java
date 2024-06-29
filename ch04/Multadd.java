public class Multadd {

    public static double multadd(double a, double b, double c) {
        return a * b + c;
    }

    public static double expSum(double x) {
        return multadd(x, Math.exp(-x), Math.sqrt(1 - Math.exp(-x)));
    }

    public static void main(String[] args) {
        // multadd
        // a = cos(pi/4), b = 1/2, c = sin(pi/4)
        System.out.printf("sin(pi/4) + (cos(pi/4) / 2) = %.2f\n",
            multadd(Math.cos(Math.PI / 4), 0.5, Math.sin(Math.PI / 4))
        );

        // a = log10, b = 1, c = log20
        System.out.printf("log10 + log20 = %.2f\n",
            multadd(Math.log(10), 1, Math.log(20))
        );

        // expSum
        // x = 0
        System.out.printf("xe^(-x) + sqrt(1 - e^(-x)) = %.2f when x = 0\n",
            expSum(0.0)
        );

        // x = 5
        System.out.printf("xe^(-x) + sqrt(1 - e^(-x)) = %.2f when x = 5\n",
            expSum(5.0)
        );
    }

}