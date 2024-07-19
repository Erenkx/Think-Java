/**
 * Represents a date.
 */
public class MyDate {

    private int year;
    private int month;
    private int day;

    /**
     * Constructs a MyDate object with default value.
     */
    public MyDate() {
        this.year = 2002;
        this.month = 1;
        this.day = 6;
    }

    /**
     * Constructs a MyDate object with given value.
     */
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d",
            this.day, this.month, this.year);
    }

    public static void main(String[] args) {
        MyDate kkBirthday = new MyDate();
        MyDate myBirthday = new MyDate(2001, 9, 4);

        System.out.println(kkBirthday);
        System.out.println(myBirthday);
    }

}
