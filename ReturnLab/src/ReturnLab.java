import java.sql.SQLOutput;

public class ReturnLab {
    public static void main(String[] args) {
        System.out.println(addition(5,7));
        System.out.println(minimum(3, 9, 4));
        System.out.println(complicated(1, 2, 3));
    }
// Methods below here VVV
    public static int addition(int digit1, int digit2) {
        return(digit1 + digit2);
    }

    public static double minimum(double digit1, double digit2, double digit3) {
        return(Math.min(digit1, Math.min(digit2, digit3)));
    }

    public static double complicated(double num1, double num2, double num3) {
        double smallest = Math.min(num1, Math.min(num2, num3));
        double largest = Math.max(num1, Math.max(num2, num3));
        return(Math.sqrt(smallest + largest));
    }
}
