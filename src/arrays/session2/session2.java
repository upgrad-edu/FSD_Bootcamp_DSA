package arrays.session2;

import java.util.Arrays;

public class session2 {

    /**
     * Arrange even and odd
     */
    public static void arrangeEvenOdd(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (arr[i] % 2 == 0 && i < j)
                i++;

            while (arr[j] % 2 == 1 && i < j)
                j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

    private static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    /**
     * Subarray with Zero sum
     */
    public static boolean subArraySum(int arr[]) {
        int currSum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= arr.length; i++) {
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (currSum > 0 && start < i - 1) {
                currSum = currSum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum,
            // then return true
            if (currSum == 0) {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " + start
                                + " and " + p);
                return true;
            }

            // Add this element to curr_sum
            if (i < arr.length)
                currSum = currSum + arr[i];
        }

        return false;
    }

    /**
     * Row with the maximum number of 1's
     */
    public static int findRowWithMaximumOnes(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;
        int j, max_row_index = 0;
        j = columns - 1;

        for (int i = 0; i < rows; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                j = j - 1;
                max_row_index = i;
            }
        }
        if (max_row_index == 0 && arr[0][columns - 1] == 0)
            return -1;
        return max_row_index;
    }

    /**
     * Rotate a matrix by 90 degree
     */

    static void rotate90Clockwise(int[][] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = i; j < arr.length - i - 1; j++) {

                // Swap elements of each cycle in clockwise direction
                int temp = arr[i][j];
                arr[i][j] = arr[arr.length - 1 - j][i];
                arr[arr.length - 1 - j][i] = arr[arr.length - 1 - i][arr.length - 1 - j];
                arr[arr.length - 1 - i][arr.length - 1 - j] = arr[j][arr.length - 1 - i];
                arr[j][arr.length - 1 - i] = temp;
            }
        }
    }

    static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    /**
     * Find the repeating and missing number
     */
    static void findRepeatingAndMissing(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            int absVal = Math.abs(arr[i]);
            if (arr[absVal - 1] > 0)
                arr[absVal - 1] = -arr[absVal - 1];
            else
                System.out.println("Repeating no is : [ " + absVal + "]");
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println("Missing number is : [ " + i + 1 + " ]");
        }
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(arr);
        arrangeEvenOdd(arr);
        print(arr);
        int[] arr1 = {3, 4, -5, 1, 6};
        System.out.println(subArraySum(arr1));

        int arr2[][] = {{0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        System.out.println(findRowWithMaximumOnes(arr2));

        printArr(arr2);

        rotate90Clockwise(arr2);
        System.out.println("#############");
        printArr(arr2);

    }
}
