package sorting.session5;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[arr.length];
        int tIndex = start;
        int leftS = start;
        int rightS = mid + 1;

        while (leftS <= mid && rightS <= end) {
            if (arr[leftS] <= arr[rightS]) {
                temp[tIndex++] = arr[leftS++];
            } else {
                temp[tIndex++] = arr[rightS++];
            }
        }

        while (leftS <= mid) {
            temp[tIndex++] = arr[leftS++];
        }

        while (rightS <= end) {
            temp[tIndex++] = arr[rightS++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
