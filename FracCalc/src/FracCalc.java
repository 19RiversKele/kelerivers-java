/*
*********************************************
* Kele Rivers                               *
* AP CS A                                   *
* Period 1                                  *
* 4 January, 2019                           *
* Project: FracCalc                         *
*********************************************
 */

import java.util.Scanner;

public class FracCalc {
    //OPERATOR stores the operation being done (+-*/)
    //ADDSUB when of value one allows only for the process of adding, subtracting, or multiplying whole numbers only
    public static String OPERATOR = " ";
    public static int ADDSUB = 0;

    public static void main(String[] args) {
        //core stores inputted values and the answer
        String[][] core = new String[3][3];
        //Sets up scanner for the equation
        Scanner equationInput = new Scanner(System.in);
        String equation = "-";
        //As long as the user keeps putting in equations program keeps running
        while (!equation.equals("quit")) {
            //ADDSUB and OPERATOR reset for new equations
            ADDSUB = 0;
            OPERATOR = " ";
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    core[i][j] = null;
                }
            }
            //User asked for an equation and operations run on it
            System.out.println("Input an equation. Type \"quit\" to cancel.");
            String firstNumber = equationInput.next();
            if (!firstNumber.equals("quit")) {
                String operatorID = equationInput.next();
                String secondNumber = equationInput.next();
                OPERATOR = operatorID;
                parseWhole(firstNumber, secondNumber, core);
                parseNumerator(firstNumber, secondNumber, core);
                parseDenominator(firstNumber, secondNumber, core);
                operate(core);
                simplify(core);
                printAnswer(core);

                System.out.println("");
                //System.out.println(core[2][0] + " " + core[2][1] + " " + core[2][2]);

            }
            //Ends program if user types "quit"
            if (firstNumber.equals("quit")) {
                equation = firstNumber;
            }
        }
    }

    //Parses out the whole number in both parts of the equation
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
        //System.out.println("FIRST WHOLE IS " + whole);

        whole = "";
        underscoreIndex = underscoreIndexer(second);
        if (underscoreIndex != -1) {
            for (int i = 0; i < underscoreIndex; i++)
                whole += second.charAt(i);
        } else if (!second.contains("/")) {
            whole = second;
        }

        coreInput[1][0] = whole;
        //System.out.println("SECOND WHOLE IS " + whole);



    }

    //Finds the index of the underscore if present
    public static int underscoreIndexer(String input) {
        int underscoreIndex = -1;
        if (input.contains("_")) {
            underscoreIndex = input.indexOf("_");
            return(underscoreIndex);
        }
        return(underscoreIndex);


    }

    //Takes any numerators present from the equation, inputs into core[][]
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

        //System.out.println("FIRST NUMERATOR IS " + numerator);

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

        //System.out.println("SECOND NUMERATOR IS " + numerator);
    }

    //Finds the denominators of the equation if present, inputs into core[][]
    public static void parseDenominator(String first, String second, String[][] coreInput) {
        String denominator = "";
        if (first.contains("/")) {
            for (int i = (first.indexOf("/") + 1); i < first.length(); i++)
                denominator += first.charAt(i);
        }
        coreInput[0][2] = denominator;

        //System.out.println("FIRST DENOMINATOR IS " + denominator);

        denominator = "";
        if (second.contains("/")) {
            for (int i = (second.indexOf("/") + 1); i < second.length(); i++)
                denominator += second.charAt(i);
        }
        coreInput[1][2] = denominator;

        //System.out.println("SECOND DENOMINATOR IS " + denominator);
    }

    //Determines the operation to be done based off of OPERATOR, creates intCore[][] for easier calculation of integers
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

    //If OPERATOR is "+", the parts are added based off of all possible input combinations of positive, negative, fraction, whole, and mixed inputs
    public static void add(int[][] intInput, String[][] coreInput) {
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
            if (intInput[0][0] > 0) {
                a = ((intInput[0][0] * intInput[0][2]) + intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
            }
            if (intInput[0][0] < 0) {
                a = ((intInput[0][0] * intInput[0][2]) - intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
                //System.out.println(a);
            }

        }
        if (intInput[1][0] != 0 && intInput[1][1] != 0) {
            if (intInput[1][0] > 0) {
                c = ((intInput[1][0] * intInput[1][2]) + intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }
            if (intInput[1][0] < 0) {
                c = ((intInput[1][0] * intInput[1][2]) - intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }

        }
        if (intInput[0][1] == 0 && intInput[1][1] == 0) {
            aW = (intInput[0][0] + intInput[1][0]);
            String convert_aW = Integer.toString(aW);
            coreInput[2][0] = convert_aW;
            ADDSUB = 1;
        }
        if (intInput[0][1] != 0 && intInput[1][1] != 0) {
            int tempB = intInput[0][2];
            int tempD = intInput[1][2];

            intInput[0][1] = (intInput[0][1] * tempD);
            intInput[1][1] = (intInput[1][1] * tempB);

            aN = (intInput[0][1] + intInput[1][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;

            aD = (tempB * tempD);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;

            //System.out.println("AN IS " + aN);
            //System.out.println("AD IS " + aD);
        }
        if (intInput[0][1] == 0 && intInput[1][1] != 0) {
            aN = ((intInput[0][0] * intInput[1][2]) + intInput[1][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;

            aD = (intInput[1][2]);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;
        }
        if (intInput[0][1] != 0 && intInput[1][1] == 0) {
            aN = ((intInput[1][0] * intInput[0][2]) + intInput[0][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;

            aD = (intInput[0][2]);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;


        }



    }

    //If OPERATOR is "-", the parts are subtracted based off all possible combinations of positive, negative, whole, fraction, and mixed
    public static void subtract(int[][] intInput, String[][] coreInput) {
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
            if (intInput[0][0] > 0) {
                a = ((intInput[0][0] * intInput[0][2]) + intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
            }
            if (intInput[0][0] < 0) {
                a = ((intInput[0][0] * intInput[0][2]) - intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
            }

        }
        if (intInput[1][0] != 0 && intInput[1][1] != 0) {
            if (intInput[0][0] > 0) {
                c = ((intInput[1][0] * intInput[1][2]) + intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }
            if (intInput[0][0] < 0) {
                c = ((intInput[1][0] * intInput[1][2]) - intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }


        }
        if (intInput[0][1] == 0 && intInput[1][1] == 0) {
            aW = (intInput[0][0] - intInput[1][0]);
            String convert_aW = Integer.toString(aW);
            coreInput[2][0] = convert_aW;
            //System.out.println(aW);
            ADDSUB = 1;
        }
        if (intInput[0][1] != 0 && intInput[1][1] != 0) {
            int tempB = intInput[0][2];
            int tempD = intInput[1][2];

            intInput[0][1] = (intInput[0][1] * tempD);
            intInput[1][1] = (intInput[1][1] * tempB);

            aN = (intInput[0][1] - intInput[1][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;

            aD = (tempB * tempD);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;

            //System.out.println("AN IS " + aN);
            //System.out.println("AD IS " + aD);
        }
        if (intInput[0][1] == 0 && intInput[1][1] != 0) {
            aN = ((intInput[0][0] * intInput[1][2]) - intInput[1][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;

            aD = (intInput[1][2]);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;
        }
        if (intInput[0][1] != 0 && intInput[1][1] == 0) {
            aN = ((intInput[0][1] - (intInput[1][0] * intInput[0][2])));
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;

            aD = (intInput[0][2]);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;


        }

    }

    //If OPERATOR is "*", inputs are multiplied based off of all possible combinations of positive, negative, whole, fraction, or mixed
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
            if (intInput[0][0] > 0) {
                a = ((intInput[0][0] * intInput[0][2]) + intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
            }
            if (intInput[0][0] < 0) {
                a = ((intInput[0][0] * intInput[0][2]) - intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
            }


        }
        if (intInput[1][0] != 0 && intInput[1][1] != 0) {
            if (intInput[1][0] > 0) {
                c = ((intInput[1][0] * intInput[1][2]) + intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }
            if (intInput[1][0] < 0) {
                c = ((intInput[1][0] * intInput[1][2]) - intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }


        }
        if (intInput[0][1] == 0 && intInput[1][1] == 0) {
            aW = (intInput[0][0] * intInput[1][0]);
            String convert_aW = Integer.toString(aW);
            coreInput[2][0] = convert_aW;
            ADDSUB = 1;
        }
        if (intInput[0][1] != 0 && intInput[1][1] != 0) {
            aN = (intInput[0][1] * intInput[1][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;
            //System.out.println("aN is " + aN);
            aD = (intInput[0][2] * intInput[1][2]);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;

            //System.out.println(aN + "/" + aD);
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

        //System.out.println(coreInput[2][0] + " " + coreInput[2][1] + " " + coreInput[2][2]);


    }

    //If OPERATOR is "/", inputs are divided based off all possible combinations of positive, negative, whole, fraction, or mixed
    public static void divide(int[][] intInput, String[][] coreInput) {
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
            if (intInput[0][0] > 0) {
                a = ((intInput[0][0] * intInput[0][2]) + intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
            }
            if (intInput[0][0] < 0) {
                a = ((intInput[0][0] * intInput[0][2]) - intInput[0][1]);
                String convertA = Integer.toString(a);
                //System.out.println("a is " + a);
                intInput[0][1] = a;
                //coreInput[0][1] = convertA;
            }

        }
        if (intInput[1][0] != 0 && intInput[1][1] != 0) {
            if (intInput[0][0] > 0) {
                c = ((intInput[1][0] * intInput[1][2]) + intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }
            if (intInput[0][0] < 0) {
                c = ((intInput[1][0] * intInput[1][2]) - intInput[1][1]);
                String convertC = Integer.toString(c);
                //System.out.println("C is " + c);
                intInput[1][1] = c;
                //coreInput[1][1] = convertC;
            }


        }
        if (intInput[0][1] == 0 && intInput[1][1] == 0) {

            coreInput[0][0] = Integer.toString(intInput[0][0]);
            coreInput[1][0] = Integer.toString(intInput[1][0]);



        }
        if (intInput[0][1] != 0 && intInput[1][1] != 0) {
            aN = (intInput[0][1] * intInput[1][2]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;
            //System.out.println("aN is " + aN);
            aD = (intInput[0][2] * intInput[1][1]);
            String convert_aD = Integer.toString(aD);
            coreInput[2][2] = convert_aD;

            //System.out.println(aN + "/" + aD);
        }
        if (intInput[0][1] == 0 && intInput[1][1] != 0) {
            aN = (intInput[0][0] * intInput[1][2]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;
            String convert_dTo_aD = Integer.toString(intInput[1][1]);
            coreInput[2][2] = convert_dTo_aD;
        }
        if (intInput[0][1] != 0 && intInput[1][1] == 0) {
            aN = (intInput[0][1]);
            String convert_aN = Integer.toString(aN);
            coreInput[2][1] = convert_aN;
            aD = (intInput[1][0] * intInput[0][2]);
            String convert_bTo_aD = Integer.toString(aD);
            coreInput[2][2] = convert_bTo_aD;
        }

    }

    //Simplifies the answers given by the above operations
    public static void simplify(String[][] coreInput) {

        //If not only whole numbers were added, subtracted, or multiplied
        if (ADDSUB == 0) {

            //If a numerator is present in the answer row of core[][]
            if (coreInput[2][1] != null) {


                int numerator = Integer.parseInt(coreInput[2][1]);
                int denominator = Integer.parseInt(coreInput[2][2]);
                int whole = 0;

                //Determines if answer fraction is improper, if so gives out a whole number and adjusts the numerator if so
                if (Math.abs(numerator) >= Math.abs(denominator)) {
                    whole = (numerator / denominator);
                    numerator = (numerator - (whole * denominator));
                    //System.out.println("NUMERATOR IS " + numerator + " WHOLE IS " + whole + " DENOMINATOR IS " + denominator);
                }
                //Tests if answer can be simplified to 1/x, if not simplifies numerator and denominator
                if (numerator != 0 && denominator % numerator == 0) {
                    denominator /= numerator;
                    numerator = 1;
                } else {
                    int testForSimplified = 1;
                    while (testForSimplified == 1) {
                        testForSimplified = 0;
                        for (int i = 2; i <= numerator; i++) {
                            if ((numerator % i == 0) && (denominator % i == 0)) {
                                testForSimplified = 1;
                                int endVar = numerator;
                                numerator /= i;
                                denominator /= i;
                                i = endVar;
                            }
                        }
                    }
                }
                //Next four int statements remove double negatives
                if (denominator < 0 && numerator > 0) {
                    numerator *= -1;
                    denominator *= -1;
                }

                if (whole < 0 && numerator < 0 && denominator > 0) {
                    numerator *= -1;
                }

                if (numerator < 0 && denominator < 0) {
                    numerator *= -1;
                    denominator *= -1;
                }

                if (numerator > 0 && denominator < 0) {
                    numerator *= -1;
                    denominator *= -1;
                }
                //Sends answers to core[][]
                coreInput[2][0] = Integer.toString(whole);
                coreInput[2][1] = Integer.toString(numerator);
                coreInput[2][2] = Integer.toString(denominator);
            } else {
                //This is if working with whole numbers that were divided

                int numerator = Integer.parseInt(coreInput[0][0]);
                int denominator = Integer.parseInt(coreInput[1][0]);
                int whole = 0;

                if (Math.abs(numerator) >= Math.abs(denominator)) {
                    whole = (numerator / denominator);
                    numerator = (numerator - (whole * denominator));
                    //System.out.println("NUMERATOR IS " + numerator + " WHOLE IS " + whole + " DENOMINATOR IS " + denominator);
                }

                if (numerator != 0 && denominator % numerator == 0) {
                    denominator /= numerator;
                    numerator = 1;
                } else {
                    int testForSimplified = 1;
                    while (testForSimplified == 1) {
                        testForSimplified = 0;
                        for (int i = 2; i <= numerator; i++) {
                            if ((numerator % i == 0) && (denominator % i == 0)) {
                                testForSimplified = 1;
                                int endVar = numerator;
                                numerator /= i;
                                denominator /= i;
                                i = endVar;
                            }
                        }
                    }
                }
                //Gets rid of double negatives
                if (denominator < 0 && numerator > 0) {
                    numerator *= -1;
                    denominator *= -1;
                }

                if (whole < 0 && numerator < 0 && denominator > 0) {
                    numerator *= -1;
                }

                if (numerator < 0 && denominator < 0) {
                    numerator *= -1;
                    denominator *= -1;
                }

                if (numerator > 0 && denominator < 0) {
                    numerator *= -1;
                    denominator *= -1;
                }
                //Sends answers to core[][]
                coreInput[2][0] = Integer.toString(whole);
                coreInput[2][1] = Integer.toString(numerator);
                coreInput[2][2] = Integer.toString(denominator);
            }
        }

    }

    //Prints answer depending on the simplified values stored in core[][] under the answer row
    public static void printAnswer(String[][] coreInput) {

        int whole = 0;
        int numerator = 0;
        int denominator = 0;
        //Based off the compartments of the answer row of core (core[2][0 through 2]), whole, numerator, and denominator are determined for the answer
        if (coreInput[2][0] != null)
            whole = Integer.parseInt(coreInput[2][0]);
        if (coreInput[2][1] != null)
            numerator = Integer.parseInt(coreInput[2][1]);
        if (coreInput[2][2] != null)
            denominator = Integer.parseInt(coreInput[2][2]);

        //Prints the answer
        if (numerator == 0) {
            System.out.println("Answer: " + whole);
        } else if (whole == 0) {
            System.out.println("Answer: " + numerator + "/" + denominator);
        } else {
            System.out.println("Answer: " + whole + "_" + numerator + "/" + denominator);
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
