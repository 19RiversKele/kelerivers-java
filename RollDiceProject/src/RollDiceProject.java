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
        printAllDice(dice);
        while (playAgain.equals("yes")) {

            int diceNum = rollDice();
            printDice(diceNum, dice);
            drawLine();
            System.out.println("Would you like to play again? (Yes or no)?");
            playAgain = playGame.next();
            playAgain = playAgain.toLowerCase();

        }
    }

    public static void printAllDice(String[][] dicePrinter) {
        for (int diceNum = 0; diceNum < 6; diceNum++) {
            for (int row = 0; row < 5; row++) {
                System.out.println(dicePrinter[row][diceNum]);
            }
            System.out.println();
        }

        System.out.println("printAllDice");
    }

    public static String[][] defDice() {
        System.out.println("defDice");
        String defineDice[][] = new String[5][6];
        String topBottom[] = {" ------- ", " ------- ", " ------- ", " ------- ", " ------- ", " ------- "};
        String topThird[] = {"|       |","| *     |", "| *     |","|  * *  |", "|  * *  |", "|  * *  |"};
        String middleThird[] = {"|   *   |", "|       |", "|   *   |", "|       |", "|   *   |", "|  * *  |"};
        String bottomThird[] = {"|       |", "|     * |", "|     * |", "|  * *  |", "|  * *  |", "|  * *  |"};
        defineDice[0] = topBottom;
        defineDice[1] = topThird;
        defineDice[2] = middleThird;
        defineDice[3] = bottomThird;
        defineDice[4] = topBottom;
        return(defineDice);

    }

    public static void printDice(int rolledNum, String[][] faces) {
        System.out.println("printDice");


    }

    public static int rollDice() {
        Random roll = new Random();
        int result = roll.nextInt(6) + 1;
        System.out.println("rollDice");
        return(result);

    }

    public static void drawLine() {
        System.out.println("drawLine");

    }
}
