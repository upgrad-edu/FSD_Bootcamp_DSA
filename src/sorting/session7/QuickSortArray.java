package sorting.session7;

import java.util.Arrays;

public class QuickSortArray {

    static void swapArrayElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int pivot(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {

                i++;
                swapArrayElements(arr, i, j);
            }
        }
        swapArrayElements(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = pivot(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
