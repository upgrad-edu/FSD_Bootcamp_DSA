package search.session2;

public class Session2 {
    /**
     * Find the frequency of each element
     *
     * @param arr
     */
    public static void findFrequency(int[] arr) {
        for (int j = 0; j < arr.length; j++)
            arr[j] = arr[j] - 1;

        for (int i = 0; i < arr.length; i++)
            arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length;

        for (int i = 0; i < arr.length; i++)
            System.out.println(i + 1 + " : " + arr[i] / arr.length);
    }


    /**
     * Find the equilibrium index of the array
     */

    public static int findEquilibriumIndex(int[] arr) {
        int n = arr.length;
        int mid = n / 2;
        int leftSum = 0, rightSum = 0;

        for (int i = 0; i < mid; i++) {
            leftSum += arr[i];
        }
        for (int i = n - 1; i > mid; i--) {
            rightSum += arr[i];
        }

        if (rightSum > leftSum) {
            while (rightSum > leftSum && mid < n - 1) {
                rightSum -= arr[mid + 1];
                leftSum += arr[mid];
                mid++;
            }
        } else {
            while (leftSum > rightSum && mid > 0) {
                rightSum += arr[mid];
                leftSum -= arr[mid - 1];
                mid--;
            }
        }

        if (rightSum == leftSum) {
            return mid;
        }

        return -1;
    }

    /**
     * Number which apprears odd number of times
     *
     * @param
     */

    public static int oddCountNum(int[] arr) {

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }


    /**
     * Rotation count
     */
    public static int rotationCount(int[] arr, int start,
                                     int end) {
        if (start > end)
            return 0;

        if (end == start)
            return start;

        int mid = start + (end - start) / 2;

        if (mid < end && arr[mid + 1] < arr[mid])
            return (mid + 1);

        if (mid > start && arr[mid] < arr[mid - 1])
            return mid;

        if (arr[end] > arr[mid])
            return rotationCount(arr, start, mid - 1);

        return rotationCount(arr, mid + 1, end);
    }


    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 2, 5};
        findFrequency(arr);

        int arr1[] = {1, 1, 1, -1, 1, 1, 1};

        System.out.println(findEquilibriumIndex(arr1));

        int[] arr2 = {1, 2, 3, 2, 3, 1, 3};
        System.out.println(oddCountNum(arr2));

        int arr3[] = {15, 18, 2, 3, 6, 12};
        System.out.println(rotationCount(arr3, 0 , arr3.length-1));
    }
}
