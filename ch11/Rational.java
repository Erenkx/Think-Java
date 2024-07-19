public class Rational {

    private int numerator;
    private int denominator;

    /**
     * Constructs a Rational object with default values.
     */
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * Constructs a Rational object with given values.
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Gets the value of numerator.
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Gets the value of denominator.
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Sets the value of numerator.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Sets the value of denominator.
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Displays a Rational object.
     */
    public void printRational() {
        System.out.printf("%d/%d\n",
            this.numerator, this.denominator);
    }

    /**
     * Returns a String representation of a Rational object.
     */
    public String toString() {
        return String.format("%d/%d",
            this.numerator, this.denominator);
    }

    /**
     * Reverses the sign of a rational number.
     */
    public void negate() {
        this.numerator *= -1;
    }

    /**
     * Swaps the numerator and denominator.
     */
    public void invert() {
        int temp = this.denominator;
        this.denominator = this.numerator;
        this.numerator = temp;

        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    /**
     * Converts the rational number to a double.
     */
    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    /**
     * Calculates the greatest common divisor of a and b.
     */
    private int getGCD(int a, int b) {
        if (a == 0)
            return b;

        return getGCD(b % a, a);
    }

    /**
     * Reduces a rational number to its lowest terms.
     */
    public void reduce() {
        int gcd = getGCD(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    /**
     * Adds two rational numbers.
     */
    public Rational add(Rational that) {
        Rational result = new Rational();

        if (this.denominator == that.denominator) {
            result.numerator = this.numerator + that.numerator;
            result.denominator = this.denominator;
        } else {
            result.numerator = this.numerator * that.denominator +
                    this.denominator * that.numerator;
            result.denominator = this.denominator * that.denominator;
        }
        result.reduce();

        return result;
    }

    public static void main(String[] args) {
        Rational rational = new Rational();
        rational.setNumerator(5);
        rational.setDenominator(2);
        rational.printRational();       // 5/2
        System.out.println(rational);   // 5/2

        rational.negate();
        rational.printRational();   // -5/2
        rational.invert();
        rational.printRational();   // -2/5
        rational.invert();
        rational.negate();


        Rational rational2 = new Rational(17, 3);
        rational2.invert();
        rational2.printRational();  // 3/17
        System.out.println(rational2.toDouble());   // 0.176471
        rational2.invert();
        rational2.reduce();
        rational2.printRational();   // 17/3


        Rational rational3 = new Rational(21, 3);
        rational3.printRational();  // 21/3
        rational3.reduce();
        rational3.printRational();  // 7/1


        System.out.println(rational2.add(rational3));   // 38/3
        Rational rational4 = new Rational(5, 10);
        System.out.println(rational.add(rational4));    // 3/1
    }

}
