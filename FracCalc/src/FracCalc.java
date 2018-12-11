import java.util.Scanner;

public class FracCalc {
    public static void main(String[] args) {
        Scanner equationInput = new Scanner(System.in);
        Scanner calculate = new Scanner(System.in);

        System.out.println("Would you like to calculate fractions?");
        String calculateAgain = calculate.next();

        while (calculateAgain.equals("yes")) {

            System.out.println("Input an equation");
            String equation = equationInput.nextLine();

            loopThroughInitial(equation);

            System.out.println("Would you like to calculate more fractions? If not type \"quit\" to exit.");
            calculateAgain = calculate.next();
            if (!calculateAgain.equals("quit")) {
                while (!calculateAgain.equals("yes")) {
                    System.out.println("Would you like to calculate more fractions? If not type \"quit\" to exit.");
                    calculateAgain = calculate.next();
                    if (calculateAgain.equals("quit"))
                        break;
                }
            }



        }
    }

    public static void loopThroughInitial(String initial) {
        initial = initial + " ";
        String loopThrough = "";
        for (int i = 0; i < initial.length(); i++) {
            loopThrough = loopThrough + initial.charAt(i);
            if (initial.charAt(i) == ' ') {
                System.out.println(loopThrough);
                loopThrough = "";
            }
        }
    }
}
