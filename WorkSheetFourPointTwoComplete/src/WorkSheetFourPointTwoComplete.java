//Problem 1a
//The program outputs ---> 14, 6, 2200, 98

//Problem 1b
//The program outputs ---> 11, 4, 99, 2, 44, 0, 0, 0

//Problem 1c
//The program outputs ---> 3, 3, 0, 0, 6, 9, 0, -18

import java.util.Arrays;

public class WorkSheetFourPointTwoComplete {
    public static void main(String[] args) {
        //Problem 1d
        int[] problem1d = {4, 5, 6, 7, 2, 10, 9, 4};
        int maxValue = maxTest(problem1d);
        System.out.println("Max value is " + maxValue);

        //Problem 1e
        int[] problem1e = {10, -2, 4, -4, 9, -5, 19, -7, 39, -1};
        double average = averageCalc(problem1e);
        System.out.println("Average = " + average);
        //Problem 2a
        int[] problem1a = {7, 3, 1100, 49};
        int[] problem2a = answer(problem1a, problem1a.length * 2);
        System.out.println(Arrays.toString(problem2a));
        //Problem 2b
        int[] problem2b = twoB(problem2a);
        System.out.println(Arrays.toString(problem2b));
        //Problem 2c
        int[] problem2c = twoC(problem1a);
        System.out.println(Arrays.toString(problem2c));
        //Problem 3
        int[] list = {36, 12, 25, 19, 46, 31, 22};
        int range = rangeCalc(list);
        System.out.println("Range = " + range);
        //Problem 4
        int[] problem4 = {27, 15, 11, 15, 27};
        int mostFrequent = frequent(problem4);
        System.out.println("Most Frequent = " + mostFrequent);

    }

    public static int frequent(int[] array) {
        int record = 0;
        int timesUp = 0;
        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int x = 0; x < array.length; x++) {
                if (array[x] == array[i]) {
                    temp++;
                }
            }
            if (temp > timesUp) {
                record = array[i];
                timesUp = temp;
            }
            if ((temp == timesUp) && (array[i] < record)) {
                record = array[i];
                timesUp = temp;
            }
        }
        return(record);
    }

    public static int rangeCalc(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }
        return((max - min) + 1);
    }

    public static int[] twoC(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 42;
        }
        return(array);
    }

    public static int[] twoB(int[] array) {
        int[] newArray = new int[4];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return(newArray);
    }


    public static int[] answer(int[] array, int length) {
        int[] data = new int[length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        return(data);
    }

    public static double averageCalc(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        int length = array.length;
        double average = (double)total / length;
        return(average);
    }



    public static int maxTest(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return(max);

    }

}
