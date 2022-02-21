package arrays.session3;

import javax.swing.*;

public class Session3 {

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /**
     * Printing all the permutations of an array.
     * Below algorithm is also termed as the Heap's algorithm
     */
    public static void arrayPermutations(int[] arr, int size) {
        if (size == 1)
            print(arr);

        for (int i = 0; i < size; i++) {
            arrayPermutations(arr, size - 1);
            if (size % 2 == 1) {
                int temp = arr[0];
                arr[0] = arr[size - 1];
                arr[size - 1] = temp;
            } else {
                int temp = arr[i];
                arr[i] = arr[size - 1];
                arr[size - 1] = temp;
            }
        }
    }

    static int sum_of_digit(int n) {
        if (n == 0)
            return 0;
        return (n % 10 + sum_of_digit(n / 10));
    }

    static int recursiveSumDigits(int n) {
        if (n < 0) {
            throw new RuntimeException("input number can't be negative");
        }
        if (n < 10) {
            return n;
        }

        return recursiveSumDigits(sum_of_digit(n));
    }

    /**
     *
     * Replace every element of the array by product of all other elements
     */

    public static int product(int[] arr , int leftProduct , int index){
        if(index>=arr.length){
            return  1;
        }
        int currentData = arr[index];
        int productTillCurrent = arr[index]*leftProduct;
        int productRight = product(arr, productTillCurrent, index+1);
        arr[index] = leftProduct*productRight;
        return currentData*productRight;
    }


    /**
     * N Queen Problem
     *
     */
    private static void printArr(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(" " + arr[i][j]
                        + " ");
            System.out.println();
        }
    }

    private static boolean isSafePosition(int[][] arr, int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (arr[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (arr[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < arr.length; i++, j--)
            if (arr[i][j] == 1)
                return false;

        return true;
    }

    private static boolean nQueenUtil(int[][] arr, int col)
    {
        if (col >= arr[0].length)
            return true;

        for (int i = 0; i < arr.length; i++) {
            if (isSafePosition(arr, i, col)) {
                arr[i][col] = 1;

                if (nQueenUtil(arr, col + 1) == true)
                    return true;

                arr[i][col] = 0;
            }
        }

        return false;
    }

    public static boolean nQueen()
    {
        int chessBoard[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (!nQueenUtil(chessBoard, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printArr(chessBoard);
        return true;
    }



    public static void main(String[] args) {

        int[] arr = {1, 1, 3};
        arrayPermutations(arr, arr.length);
        System.out.println(recursiveSumDigits(9875));

        int[] arr1 = {1,2,3,4,5};
        product(arr1, 1,0);
        print(arr1);

        System.out.println(nQueen());
    }
}
