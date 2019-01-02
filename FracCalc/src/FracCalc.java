import java.util.Scanner;

public class FractionHomework {

    public static String OPERATOR = " ";
    public static void main(String[] args) {

        String[][] core = new String[3][3];

        Scanner equationInput = new Scanner(System.in);
        String equation = "-";
        while (!equation.equals("quit")) {
            System.out.println("Input an equation. Type \"quit\" to cancel.");
            String firstNumber = equationInput.next();
            if (!firstNumber.equals("quit")) {
                String operatorID = equationInput.next();
                String secondNumber = equationInput.next();
                System.out.println(firstNumber);
                System.out.println(operatorID);
                System.out.println(secondNumber);
                OPERATOR = operatorID;
                parseWhole(firstNumber, secondNumber, core);
                parseNumerator(firstNumber, secondNumber, core);
                parseDenominator(firstNumber, secondNumber, core);
                operate(core);
                simplify(core);

            }
            if (firstNumber.equals("quit")) {
                equation = firstNumber;
            }
        }
    }

    public static void parseWhole(String first, String second, String[][] coreInput) {
        String whole = "";
        int underscoreIndex = underscoreIndexer(first);
        if (underscoreIndex != -1) {
            for (int i = 0; i < underscoreIndex; i++)
                whole += first.charAt(i);
        } else if (!first.contains("/")) {
            whole = first;

        }

        coreInput[0][0] = whole;
        System.out.println("FIRST WHOLE IS " + whole);

        whole = "";
        underscoreIndex = underscoreIndexer(second);
        if (underscoreIndex != -1) {
            for (int i = 0; i < underscoreIndex; i++)
                whole += second.charAt(i);
        } else if (!second.contains("/")) {
            whole = second;
        }

        coreInput[1][0] = whole;
        System.out.println("SECOND WHOLE IS " + whole);



    }

    public static int underscoreIndexer(String input) {
        int underscoreIndex = -1;
        if (input.contains("_")) {
            underscoreIndex = input.indexOf("_");
            return(underscoreIndex);
        }
        return(underscoreIndex);


    }


    public static void parseNumerator(String first, String second, String[][] coreInput) {
        int slashIndex = first.indexOf("/");
        String numerator = "";
        if (coreInput[0][0].equals("")) {
            for (int i = 0; i < slashIndex; i++) {
                numerator += first.charAt(i);
            }
            coreInput[0][1] = numerator;
        } else {
            for (int i = (coreInput[0][0].length() + 1); i < slashIndex; i++) {
                numerator += first.charAt(i);
            }
            coreInput[0][1] = numerator;
        }

        System.out.println("FIRST NUMERATOR IS " + numerator);

        slashIndex = second.indexOf("/");
        numerator = "";
        if (coreInput[1][0].equals("")) {
            for (int i = 0; i < slashIndex; i++) {
                numerator += second.charAt(i);
            }
            coreInput[1][1] = numerator;
        } else {
            for (int i = (coreInput[1][0].length() + 1); i < slashIndex; i++) {
                numerator += second.charAt(i);
            }
            coreInput[1][1] = numerator;
        }

        System.out.println("SECOND NUMERATOR IS " + numerator);
    }

    public static void parseDenominator(String first, String second, String[][] coreInput) {
        String denominator = "";
        if (first.contains("/")) {
            for (int i = (first.indexOf("/") + 1); i < first.length(); i++)
                denominator += first.charAt(i);
        }
        coreInput[0][2] = denominator;

        System.out.println("FIRST DENOMINATOR IS " + denominator);

        denominator = "";
        if (second.contains("/")) {
            for (int i = (second.indexOf("/") + 1); i < second.length(); i++)
                denominator += second.charAt(i);
        }
        coreInput[1][2] = denominator;

        System.out.println("SECOND DENOMINATOR IS " + denominator);
    }

    public static void operate(String[][] coreInput) {
        int[][] intCore = new int[2][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                intCore[i][j] = 0;
                if (!coreInput[i][j].equals("")) {
                    intCore[i][j] = Integer.parseInt(coreInput[i][j]);
                }
            }
        }

        if (OPERATOR.equals("+")) {
            add(intCore, coreInput);
        } else if (OPERATOR.equals("-")) {
            subtract(intCore, coreInput);
        } else if (OPERATOR.equals("*")) {
            multiply(intCore, coreInput);
        } else if (OPERATOR.equals("/")) {
            divide(intCore, coreInput);
        } else {
            System.out.println("ERROR: INVALID OPERATOR, use (+ - * /)");
        }
    }

    public static void add(int[][] intInput, String[][] coreInput) {

    }

    public static void subtract(int[][] intInput, String[][] coreInput) {

    }

    public static void multiply(int[][] intInput, String[][] coreInput) {
        int w1 = 0;
        int a = 0;
        int b = 0;
        int w2 = 0;
        int c = 0;
        int d = 0;
        int aW = 0;
        int aN = 0;
        int aD = 0;

        if (intInput[0][0] != 0 && intInput[0][1] != 0) {
            a = ((intInput[0][0] * intInput[0][2]) + intInput[0][1]);
            String convertA = Integer.toString(a);
            System.out.println("a is " + a);
            intInput[0][1] = a;
            //coreInput[0][1] = convertA;
        }
        if (intInput[1][0] != 0 && intInput[1][1] != 0) {
            c = ((intInput[1][0] * intInput[1][2]) + intInput[1][1]);
            String convertC = Integer.toString(c);
            System.out.println("C is " + c);
            intInput[1][1] = c;
            //coreInput[1][1] = convertC;
        }
        if (intInput[0][1] == 0 && intInput[1][1] == 0) {
            aW = (intInput[0][0] * intInput[1][0]);
            String convert_aW = Integer.toString(aW);
            coreInput[2][0] = convert_aW;
        }
        if (intInput[0][1] != 0 && intInput[1][1] != 0) {
            aN = (intInput[0][1] * intInput[1][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;
            System.out.println("aN is " + aN);
            aD = (intInput[0][2] * intInput[1][2]);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;

            System.out.println(aN + "/" + aD);
        }
        if (intInput[0][1] == 0 && intInput[1][1] != 0) {
            aN = (intInput[0][0] * intInput[1][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;
            String convert_dTo_aD = Integer.toString(intInput[1][2]);
            coreInput[2][2] = convert_dTo_aD;
        }
        if (intInput[0][1] != 0 && intInput[1][1] == 0) {
            aN = (intInput[1][0] * intInput[0][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;
            String convert_bTo_aD = Integer.toString(intInput[0][2]);
            coreInput[2][2] = convert_bTo_aD;
        }

        System.out.println(coreInput[2][0] + " " + coreInput[2][1] + " " + coreInput[2][2]);


    }

    public static void divide(int[][] intInput, String[][] coreInput) {

    }

    public static void simplify(String[][] coreInput) {
        int[] intAnswerCore = {0, 0, 0};

        int numerator = Integer.parseInt(coreInput[2][1]);
        int denominator = Integer.parseInt(coreInput[2][2]);
        int whole = 0;

        intAnswerCore[1] = numerator;
        intAnswerCore[2] = denominator;

        if (numerator > denominator) {
            whole = (numerator / denominator);
            numerator = (numerator - (whole * denominator));
        }


    }

}


/*(first.length() == coreInput[0][0].length()) {
        coreInput[0][1] = "";
        } else if

  (second.length() == coreInput[1][0].length()) {
            coreInput[1][1] = "";
        } else if

*/
