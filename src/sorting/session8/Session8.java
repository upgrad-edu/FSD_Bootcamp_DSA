package sorting.session8;

import java.util.Arrays;
import java.util.Random;

public class Session8 {
    /**
     * Matching Nuts and Bolts
     */
    public static void matchNutsNBolts(char[] nuts, char[] bolts, int start,
                                       int end) {
        if (start < end) {
            int pivot = partition(nuts, start, end, bolts[end]);

            partition(bolts, start, end, nuts[pivot]);

            matchNutsNBolts(nuts, bolts, start, pivot - 1);
            matchNutsNBolts(nuts, bolts, pivot + 1, end);
        }
    }

    private static int partition(char[] arr, int start, int end, char pivot) {
        int i = start;
        char temp1, temp2;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
            } else if (arr[j] == pivot) {
                temp1 = arr[j];
                arr[j] = arr[end];
                arr[end] = temp1;
                j--;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[end];
        arr[end] = temp2;

        return i;
    }
// #################################

    /**
     * Randomized quick sort
     */
    static void randomNum(int[] arr, int low, int high) {

        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int temp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;
    }

    static int randomPartition(int arr[], int low, int high) {
        randomNum(arr, low, high);
        int pivot = arr[high];


        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public static void randomQuickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = randomPartition(arr, low, high);

            randomQuickSort(arr, low, pi - 1);
            randomQuickSort(arr, pi + 1, high);
        }
    }

    /**
     * Kth smallest element in the array
     */
    private static int partitionArr(int[] arr, int left,
                                    int right) {
        int x = arr[right], i = left;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= x) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }

    public static int kthSmallestElement(int[] arr, int left,
                                         int right, int k) {
        if (k > 0 && k <= right - left + 1) {
            int pos = partitionArr(arr, left, right);

            if (pos - left == k - 1)
                return arr[pos];

            if (pos - left > k - 1)
                return kthSmallestElement(arr, left, pos - 1, k);

            return kthSmallestElement(arr, pos + 1, right, k - pos + left - 1);
        }

        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        matchNutsNBolts(nuts, bolts, 0, nuts.length - 1);

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));

        int arr[] = {10, 7, 8, 9, 1, 5};
        System.out.println(Arrays.toString(arr));
        randomQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


        int[] arr2 = { 13, 4, 6, 8, 5, 20, 27 };
        int k =3;

        System.out.println(kthSmallestElement(arr2, 0, arr2.length-1, 3));
    }
}
