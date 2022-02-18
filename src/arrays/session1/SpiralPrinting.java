package arrays.session1;

public class SpiralPrinting {


    public static void spiralPrint(int[][] arr) {
        int eR = arr.length;
        int eC = arr[0].length;
        int sR = 0;
        int sC = 0;
        int i, k = 0, l = 0;

        while (sR < eR && sC < eC) {
            // Print the first row
            for (i = sC; i < eC; ++i) {
                System.out.print(arr[sR][i] + " ");
            }
            sR++;

            // Print the last column from the remaining columns
            for (i = sR; i < eR; ++i) {
                System.out.print(arr[i][eC - 1] + " ");
            }
            eC--;

            // Print the last row from the remaining rows */
            if (sR < eR) {
                for (i = eC - 1; i >= sC; --i) {
                    System.out.print(arr[eR - 1][i] + " ");
                }
                eR--;
            }

            // Print the first column from the remaining
            if (sC < eC) {
                for (i = eR - 1; i >= sR; --i) {
                    System.out.print(arr[i][sC] + " ");
                }
                sC++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};

        spiralPrint(arr);
    }
}
