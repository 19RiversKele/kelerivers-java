import java.util.Scanner;


public class DistanceLabExtraCredit {

    public static String COORDINATE1;
    public static String COORDINATE2;
    public static int PRECISION;

    public static void main(String[] args) {
        Scanner firstCoordinate = new Scanner(System.in);
        Scanner secondCoordinate = new Scanner(System.in);
        Scanner precisionLevel = new Scanner(System.in);

        System.out.print("What precision level are you inputing? 1 square meter, 10, 100, 1000, or 10,000?: ");
        PRECISION = precisionLevel.nextInt();

        System.out.print("\nImport first coordinate: ");
        COORDINATE1 = firstCoordinate.next();

        System.out.print("\nImport second coordinate: ");
        COORDINATE2 = secondCoordinate.next();

        singleDigitToDoubleDigitFix(COORDINATE1, COORDINATE2);

        System.out.println(COORDINATE1);
        System.out.println(COORDINATE2);



    }

    public static void singleDigitToDoubleDigitFix(String coordinate1, String coordinate2) {
        char coordOneCheck = coordinate1.charAt(4);
        System.out.println(coordOneCheck);
        char coordTwoCheck = coordinate2.charAt(4);
        System.out.println(coordTwoCheck);
        if (Character.isDigit(coordOneCheck) == true) {
            COORDINATE1 = "0" + COORDINATE1;
        }
        if (Character.isDigit(coordTwoCheck) == true) {
            COORDINATE2 = "0" + COORDINATE2;
        }
    }
}
