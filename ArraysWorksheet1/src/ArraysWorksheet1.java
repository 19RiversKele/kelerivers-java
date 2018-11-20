



import java.util.Arrays;
import java.util.Scanner;

public class ArraysWorksheet1 {
    public static void main(String[] args) {
        //Exercise 1
        int[] exercise1 = new int[8];
        //Exercise 2a
        exercise1[0] = 1;
        exercise1[1] = 2;
        exercise1[2] = 3;
        exercise1[3] = 4;
        exercise1[4] = 5;
        exercise1[5] = 6;
        exercise1[6] = 7;
        exercise1[7] = 8;
        //Exercise 2b
        for (int i : exercise1) {
            exercise1[i-1]++;
        }

        int[] differentTest = assignValues(8);
        System.out.println(Arrays.toString(exercise1));
        //Exercise 2c
        System.out.println(Arrays.toString(differentTest));
        //Exercise 2d
        Scanner arrayInput = new Scanner(System.in);
        System.out.println("How large do you want your array? ");
        int arraySize = arrayInput.nextInt();
        int[] array2d = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Enter an integer: ");
            array2d[i] = arrayInput.nextInt();
        }
        System.out.println(Arrays.toString(array2d));
        //Exercise 2e
        int[] exercise2e = {1,3,5,7,9};
        System.out.println(Arrays.toString(exercise2e));
    }

    public static int[] assignValues(int size) {
        int[] differentTest = new int[size];
        for (int i = 0; i < differentTest.length; i++) {
            differentTest[i] = i;
        }
        return(differentTest);
        }


    }


