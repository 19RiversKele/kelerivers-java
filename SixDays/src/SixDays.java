/*
***********************************************
* Kele Rivers
* AP CS A
* Period 1
* September 12, 2018
* Project #1 - SixDays of Xmas
* **********************************************
*/
public class SixDays {
    public static void main(String [] args) {
        //The days
        christmasStatement1();
        christmasStatement2();
        christmasStatement3();
        christmasStatement4();
        christmasStatement5();
        christmasStatement6();
    }
    // Opening Statement modules (on the X-day of Christmas my true love gave to me)
    public static void christmasStatement1() {
        System.out.println("On the 1st day of \"Xmas\", my true love sent to me");
        gift1();
    }
    public static void christmasStatement2() {
        System.out.println("On the 2nd day of \"Xmas\", my true love sent to me");
        gift2();
    }
    public static void christmasStatement3() {
        System.out.println("On the 3rd day of \"Xmas\", my true love sent to me");
        gift3();
    }
    public static void christmasStatement4() {
        System.out.println("On the 4th day of \"Xmas\", my true love sent to me");
        gift4();
    }
    public static void christmasStatement5() {
        System.out.println("On the 5th day of \"Xmas\", my true love sent to me");
        gift5();
    }
    public static void christmasStatement6() {
        System.out.println("On the 6th day of \"Xmas\", my true love sent to me");
        gift6();
    }
    // Gift Statement Modules
    public static void gift1() {
        System.out.println("a partridge in a pear tree.\n");
    }
    public static void gift2() {
        System.out.println("two turtle doves, and");
        gift1();
    }
    public static void gift3() {
        System.out.println("three French hens,");
        gift2();
    }
    public static void gift4() {
        System.out.println("four calling birds,");
        gift3();
    }
    public static void gift5() {
        System.out.println("five golden rings,");
        gift4();
    }
    public static void gift6() {
        System.out.println("six geese a-laying,");
        gift5();
    }
}
