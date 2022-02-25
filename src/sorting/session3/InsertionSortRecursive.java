package sorting.session3;

import java.util.Arrays;

public class InsertionSortRecursive {

    public static void insertionSortRec(int[] arr, int n) {

        if (n <= 1) {
            return;
        }


        insertionSortRec(arr, n - 1);

        int last = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,9,2,3,5,-1};

        System.out.println(Arrays.toString(arr));

        insertionSortRec(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
