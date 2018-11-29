import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class RollDiceProject {
    public static void main(String[] args) {
        System.out.println("Would you like to play a game? (Yes or no)?");
        Scanner playGame = new Scanner(System.in);
        String playAgain = playGame.next();
        playAgain = playAgain.toLowerCase();
        String dice[][] = defDice();
        //System.out.println(dice[1]);
        printAllDice();
       while (playAgain.equals("yes")) {

           rollDice();
           printDice();
           drawLine();
           System.out.println("Would you like to play again? (Yes or no)?");
           playAgain = playGame.next();
           playAgain = playAgain.toLowerCase();

       }
    }

    public static void printAllDice() {
        System.out.println("printAllDice");
    }

    public static String[][] defDice() {
        System.out.println("defDice");
        String defineDice[][] = new String[6][1];
        return(defineDice);

    }

    public static void printDice() {
        System.out.println("printDice");

    }

    public static int rollDice() {
        System.out.println("rollDice");
        return(-1);

    }

    public static void drawLine() {
        System.out.println("drawLine");

    }
}
