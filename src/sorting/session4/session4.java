package sorting.session4;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;
import sorting.session1.BubbleSort;
import sorting.session3.InsertionIteratively;

import java.util.Arrays;
import java.util.List;

public class session4 {


    /**
     * Sort a singly linked list using insertion sort
     */
    private static ListNode sortedHead;

    public static ListNode insertionSortLL(ListNode head) {
        // Initialize sorted linked list
        sortedHead = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.getNext();
            insert(current);
            current = next;
        }
        head = sortedHead;
        return head;


    }

    private static void insert(ListNode head) {

        /* Special case for the head end */
        if (sortedHead == null || sortedHead.getData() >= head.getData()) {
            head.setNext(sortedHead);
            sortedHead = head;
        } else {
            ListNode current = sortedHead;
            while (current.getNext() != null && current.getNext().getData() < head.getData()) {
                current = current.getNext();
            }
            head.setNext(current.getNext());
            current.setNext(head);
        }


    }

    /**
     * Sort an array which only contains elements 0, 1 and 2
     * <p>
     * Input: {0, 1, 2, 0, 1, 2}
     * Output: {0, 0, 1, 1, 2, 2}
     */

    static void sortArr(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (arr[mid]) {
                case 0: {
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }


    /**
     *
     * Sort 1 to N by swapping adjacent elements
     */


    public static boolean canBeSortedBySwapping(int[] arr, boolean[] swap){


        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    if(!swap[j]){
                        return false;
                    }
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        return true;
    }

    /**
     * Alternative sorting
     * @param
     */

    public static void alternateSorting(int[] arr)
    {
        InsertionIteratively.insertionSort(arr);
        int[] temp = new int[arr.length];
        int in = 0;
        int i = 0, j = arr.length-1;
        while (i < j) {
            temp[in++]=arr[i++];
            temp[in++]=arr[j--];
        }

        if (arr.length % 2 != 0)
            temp[in]=arr[i];

        for(int k=0;k<arr.length;k++){
            arr[k]=temp[k];
        }
    }







    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.setNext(new ListNode(3));
        head.getNext().setNext(new ListNode(2));
        head.getNext().getNext().setNext(new ListNode(1));

        TraverseLL.traverse(head);

        TraverseLL.traverse(insertionSortLL(head));

        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

        System.out.println(Arrays.toString(arr));

        sortArr(arr);
        System.out.println(Arrays.toString(arr));

        int A[] = { 1, 2, 5, 3, 4, 6 };
        boolean B[] = { false, true, true, true, false };

        System.out.println(canBeSortedBySwapping(A, B));

        int A1[] = {2, 3, 1, 4, 5, 6};
        boolean B1[] = {false, true, true, true, true};
        System.out.println(canBeSortedBySwapping(A1, B1));


        System.out.println(Arrays.toString(A1));
        alternateSorting(A1);
        System.out.println(Arrays.toString(A1));


    }
}
