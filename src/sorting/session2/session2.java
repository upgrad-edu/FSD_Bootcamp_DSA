package sorting.session2;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;

import java.util.Arrays;

public class session2 {
    /**
     * Bubble sort using recursion
     */
    public static void bubbleSortRec(int[] arr, int n) {
        if (n == 1)
            return;

        for (int i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

        bubbleSortRec(arr, n - 1);
    }

    /**
     * Sort linked list of 0,1 and 2
     */
    public static ListNode sortList(ListNode head) {
        int count[] = {0, 0, 0};

        ListNode ptr = head;

        while (ptr != null) {
            count[ptr.getData()]++;
            ptr = ptr.getNext();
        }

        int i = 0;
        ptr = head;

        while (ptr != null) {
            if (count[i] == 0)
                i++;
            else {
                ptr.setData(i);
                --count[i];
                ptr = ptr.getNext();
            }
        }

        return head;
    }

    /**
     * Sort the linked list in the wave form
     */
    void waveSort(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            if (i > 0 && arr[i - 1] > arr[i]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }

            if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }

        }
    }

    /**
     * Find the minimum length of the unsorted subarray, sorting which makes the
     * complete array sorted
     * <p>
     * [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60]
     * <p>
     * Output should be (3,8) elements need to be sorted
     * <p>
     * [5,4,3,2,1]
     * <p>
     * Output should be (0,4)
     *
     * @param
     */

    static void printUnsortedIndex(int[] arr) {
        int start = 0, end = arr.length - 1, i, max, min;

        for (start = 0; start < arr.length - 1; start++) {
            if (arr[start] > arr[start + 1])
                break;
        }
        if (start == arr.length - 1) {
            //"The complete array is sorted"
            System.out.println("Nothing needs to be sorted");
            return;
        }

        for (end = arr.length - 1; end > 0; end--) {
            if (arr[end] < arr[end - 1])
                break;
        }

        max = arr[start];
        min = arr[start];
        for (i = start + 1; i <= end; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        // step 2(b) of above algo
        for (i = 0; i < start; i++) {
            if (arr[i] > min) {
                start = i;
                break;
            }
        }

        // step 2(c) of above algo
        for (i = arr.length - 1; i >= end + 1; i--) {
            if (arr[i] < max) {
                end = i;
                break;
            }
        }

        System.out.println(" Array needs to be sorted between " + start + " and " + end);
        return;
    }

    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        bubbleSortRec(arr, arr.length);

        System.out.println("Sorted array : ");
        System.out.println(Arrays.toString(arr));


        ListNode head = new ListNode(2);

        head.setNext(new ListNode(1));
        head.getNext().setNext(new ListNode(2));
        head.getNext().getNext().setNext(new ListNode(1));
        head.getNext().getNext().getNext().setNext(new ListNode(1));
        head.getNext().getNext().getNext().getNext().setNext(new ListNode(2));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(0));
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(1));
        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(0));

        TraverseLL.traverse(head);

        TraverseLL.traverse(sortList(head));


    }
}
