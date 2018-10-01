public class RocketShip {

    //SIZE is the base unit for the size of the rocket, representing half of the horizontal measurement
    public static final int SIZE = 6;

    public static void main(String[] args) {

        //The integer value testSize is purely for dev hardcode testing
        int testSize = 6;

        //Calls the cone of the rocket, size dependent on Class Constant --SIZE--
        cone();



        //EVERYTHING BELOW THIS POINT IS SIMPLY HARDCODE TEST PROGRAMS

/*
        for (int row = 1; row < testSize; row++) {
            for (int a = 0; a <= (testSize - (row + 1)); a++)
                System.out.print(" ");
            for (int b = 0; b < row; b++)
                System.out.print("/");
            for (int c = 0; c < 2; c++)
                System.out.print("*");
            for (int b = 0; b < row; b++)
                System.out.print("\\");
            System.out.println();
            */

        for (int row = 1; row < (testSize / 2); row++) {
            System.out.print("|");
            for (int dot = 0; dot <= (testSize - ((2 * row) / 2)); dot ++)
                System.out.print(".");
            for (int slash = 1; slash <= (row * 2); slash++)
                System.out.print("/\\");
            System.out.print("|");

        }
    }


    public static void cone() {
        for (int row = 1; row < SIZE; row++) {
            for (int a = 0; a <= (SIZE - (row + 1)); a++)
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


}
