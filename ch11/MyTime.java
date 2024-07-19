/**
 * Represents a time of day.
 */
public class MyTime {

    private int hour;
    private int minute;
    private double second;

    /**
     * Constructs a MyTime object with default values.
     */
    public MyTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0.0;
    }

    /**
     * Constructs a MyTime object with given values.
     */
    public MyTime(int hour, int minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public double getSecond() {
        return this.second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    /**
     * Returns a String representation of the time.
     */
    public String toString() {
        return String.format("%02d:%02d:%04.1f",
            this.hour, this.minute, this.second);
    }

    /**
     * Tests whether two times are equivalent.
     */
    public boolean equals(MyTime that) {
        final double DELTA = 0.001;
        
        return this.hour == that.hour
            && this.minute == that.minute
            && Math.abs(this.second - that.second) < DELTA;
    }

    /**
     * Adds two times and returns a new MyTime object.
     */
    public MyTime add(MyTime t2) {
        final int SEC_PER_MIN = 60;
        final int MIN_PER_HR = 60;
        final int HR_PER_DAY = 24;

        MyTime sum = new MyTime();
        sum.minute = (int) (this.second + t2.second) / SEC_PER_MIN;
        sum.second = (this.second + t2.second) % SEC_PER_MIN;

        sum.hour = (sum.minute + this.minute + t2.minute) / MIN_PER_HR;
        sum.minute = (sum.minute + this.minute + t2.minute) % MIN_PER_HR;

        sum.hour = (sum.hour + this.hour + t2.hour) % HR_PER_DAY;

        return sum;
    }

    public static void main(String[] args) {
        MyTime time1 = new MyTime();
        MyTime time2 = new MyTime(8, 30, 20.5);

        System.out.println(time1.getHour());    // 0
        System.out.println(time1.getMinute());  // 0
        System.out.println(time1.getSecond());  // 0.0

        time1.setHour(8);
        time1.setMinute(30);
        time1.setSecond(20.5);
        System.out.println(time1);  // 08:30:20.5

        System.out.println(time1.equals(time2));    // true
        System.out.println(time1.add(time2));   // 17:00:41.0

        MyTime time3 = new MyTime(16, 0, 0.0);
        MyTime time4 = new MyTime(19, 34, 55.5);
        System.out.println(time1.add(time3));   // 00:30:20.5
        System.out.println(time1.add(time4));   // 04:05:16.0
    }

}
