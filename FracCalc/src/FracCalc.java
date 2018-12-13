import java.util.Scanner;

public class FracCalc {

    public static String OPERATOR = " ";
    public static void main(String[] args) {

        String[][] core = new String[3][3];

        Scanner equationInput = new Scanner(System.in);
        String equation = "-";
        while (!equation.equals("quit")) {
            System.out.println("Input an equation. Type \"quit\" to cancel.");
            String test = equationInput.next();
            if (!test.equals("quit")) {
                String test1 = equationInput.next();
                String test2 = equationInput.next();
                System.out.println(test);
                System.out.println(test1);
                System.out.println(test2);
                OPERATOR = test1;
                parseWhole(test, test2, core);

            }
            if (test.equals("quit")) {
                equation = test;
            }
        }
    }

    public static void parseWhole(String first, String second, String[][] coreInput) {

    }

    public static void parseNumerator() {

    }

    public static void parseDenominator() {

    }

}
