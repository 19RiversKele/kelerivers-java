/*
***************************************
* Kele Rivers                         *
* AP CS A                             *
* Period 1                            *
* Due Date: October 9, 2018           *
* Project #2 - RocketShip             *
* *************************************
*/

import java.sql.SQLOutput;

public class RocketShipHomeworkFinalProduct {

    // SIZE is the base unit for the size of the rocket, representing half of the horizontal measurement
    public static final int SIZE = 11;

   //Main Rocket Build
    public static void main(String[] args) {

        // The integer value testSize is purely for dev hardcode testing
        int testSize = 6;

        // Calls the cone of the rocket, size dependent on Class Constant --SIZE--
        cone();
        seal();
        topCore();
        bottomCore();
        seal();
        bottomCore();
        topCore();
        seal();
        cone();

    }

    // Cone Build
    public static void cone() {
        for (int row = 1; row < (SIZE * 2); row++) {
            for (int a = 0; a <= ((SIZE * 2) - (row + 1)); a++)
                System.out.print(" ");
            for (int b = 0; b < row; b++)
                System.out.print("/");
            for (int c = 0; c < 2; c++)
                System.out.print("*");
            for (int b = 0; b < row; b++)
                System.out.print("\\");
            System.out.println();

        }
    }

    // Upward Pointing Core
    public static void topCore() {
        //for (int row = 1; row <= (SIZE / 2); row++) {
        for (int row = 1; row <= SIZE; row++) {
            System.out.print("|");
            for (int halves = 1; halves <= 2; halves++) {
                for (int a = 0; a < ((SIZE - row)); a++)
                    System.out.print(".");
                for (int slash = 1; slash <= (row); slash++)
                    System.out.print("/\\");
                for (int a = 0; a < ((SIZE - row)); a++)
                    System.out.print(".");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    // =*=* barrier between sections of the rocket
    public static void seal() {
        System.out.print("+");
        for (int row = 1; row <= (SIZE * 2); row++)
            System.out.print("=*");
        System.out.print("+");
        System.out.println();
    }

    // Downward Pointing Core
    public static void bottomCore() {
        for (int row = SIZE; row >= 1; row--) {
            System.out.print("|");
            for (int halves = 1; halves <= 2; halves++) {
                for (int a = ((SIZE - row)); a > 0; a--)
                    System.out.print(".");
                for (int slash = row; slash >= 1; slash--)
                    System.out.print("\\/");
                for (int a = ((SIZE - row)); a > 0; a--)
                    System.out.print(".");
            }
            System.out.print("|");
            System.out.println();
        }
    }

}

