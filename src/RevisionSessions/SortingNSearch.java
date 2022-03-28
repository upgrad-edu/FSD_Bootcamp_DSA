package RevisionSessions;

public class SortingNSearch {


    /**
     * Find the maximum element
     * in an array which is first increasing and then decreasing
     * <p>
     * Input: arr[] = {18, 20, 30,90, 110, 210, 410, 510, 13, 12, 11}
     * Output: 510
     * <p>
     * Input: arr[] = {11, 13, 60, 20, 19, 17, 16}
     * Output: 60
     */

    public static int findMax(int[] arr, int start, int end) {
        if (start == end)
            return arr[start];

        if ((end == start + 1) && arr[start] >= arr[end])
            return arr[start];
        if ((end == start + 1) && arr[start] < arr[end])
            return arr[end];

        int mid = (start + end) / 2;

        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
            return arr[mid];

        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
            return findMax(arr, start, mid - 1);
        else
            return findMax(arr, mid + 1, end);
    }


    /**
     * Count the number of 1's in the given sorted binary array
     * <p>
     * Input: arr[] = {1, 1, 0, 0, 0, 0, 0}
     * Output: 2
     * <p>
     * Input: arr[] = {1, 1, 1, 1, 1, 1, 1}
     * Output: 7
     */

    public static int count1s(int arr[], int start, int end) {
        if (end >= start) {
            int mid = start + (end - start) / 2;

            if ((mid == end || arr[mid + 1] == 0)
                    && (arr[mid] == 1))
                return mid + 1;

            if (arr[mid] == 1)
                return count1s(arr, (mid + 1), end);

            return count1s(arr, start, (mid - 1));
        }
        return 0;
    }


    /**
     * Kth Smallest  Element
     * <p>
     * input: arr[] = {8, 11, 5, 4, 21, 16}
     * k = 3
     * Output: 8
     */

    public static int partition(int[] arr, int left,
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

        // Swapping arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }

    public static int kthSmallest(int[] arr, int left,
                                  int right, int k) {
        if (k > 0 && k <= right - left + 1) {
            int pos = partition(arr, left, right);

            if (pos - left == k - 1)
                return arr[pos];

            if (pos - left > k - 1)
                return kthSmallest(arr, left, pos - 1, k);

            return kthSmallest(arr, pos + 1, right, k - pos + left - 1);
        }

        return Integer.MAX_VALUE;
    }

    /**
     * Minimum time requires to produce m items
     * Input : arr[] = {1, 2, 3}, m = 11
     * Output : 6
     * In 6 sec, machine 1 produces 6 items, machine 2 produces 3 items,
     * and machine 3 produces 2 items. So to produce 11 items minimum
     * 6 sec are required.
     */

    static int findElements(int[] arr, int temp) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
            ans += (temp / arr[i]);
        return ans;
    }

    static int binarySearch(int[] arr, int m, int high) {
        int low = 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int itm = findElements(arr, mid);

            if (itm < m)
                low = mid + 1;

            else
                high = mid;
        }

        return high;
    }

    public static int minTime(int[] arr, int m) {
        int maxval = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++)
            maxval = Math.max(maxval, arr[i]);

        return binarySearch(arr, m, maxval * m);
    }


    public static void main(String[] args) {
        int[] arr = {18, 20, 30, 90, 110, 210, 410, 510, 13, 12, 11};

        System.out.println(findMax(arr, 0, arr.length - 1));

        int[] arr2 = {1, 1, 0, 0, 0, 0, 0};

        System.out.println(count1s(arr2, 0, arr2.length - 1));

        int[] arr3 = {12, 3, 5, 7, 4, 19, 26};

        System.out.println(kthSmallest(arr3, 0, arr3.length - 1, 3));


        int[] arr4 = {1, 2, 3};

        System.out.println(minTime(arr4, 11));

    }
}
