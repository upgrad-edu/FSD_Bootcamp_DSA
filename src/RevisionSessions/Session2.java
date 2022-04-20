package RevisionSessions;

import LinkedList.session1.ListNode;

import java.util.Arrays;

public class Session2 {

    /**
     * Printing the alternative nodes of the LinkedList
     */

    public static void printAlternateNodes(ListNode head, boolean isOdd) {
        if (head == null)
            return;
        if (isOdd)
            System.out.print(head.getData() + " -> ");
        printAlternateNodes(head.getNext(), !isOdd);
    }

    /**
     * Sort a given array of positive integers in linear time
     * <p>
     * Given an unordered array of size n . All the elements in the array are in the range of [0,n].
     * Sort the above given array in linear time complexity
     * <p>
     * Example:
     * <p>
     * Input: arr[] = {1, 9, 8, 2, 5, 8,1,3,6,4}
     * <p>
     * Output: arr[] = { 1,1, 2, 3, 4, 5, 6, 8, 8, 9}
     */

    public static void sort(int[] arr, int n) {
        int[] output = new int[arr.length];

        int count[] = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            count[i] = 0;
        for (int i = 0; i < arr.length; ++i)
            ++count[arr[i]];
        for (int i = 1; i <= n; ++i)
            count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }
        for (int i = 0; i < arr.length; ++i)
            arr[i] = output[i];
    }

    /**
     * Number of non-negative integral solutions of sum equation
     */
    public static int countOfPossibleSolutions(int n, int sum) {
        int total = 0;

        if (n == 1 && sum >= 0)
            return 1;

        for (int i = 0; i <= sum; i++) {

            total += countOfPossibleSolutions(n - 1, sum - i);
        }

        return total;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node7.setNext(node8);

        printAlternateNodes(head, true);

        System.out.println();

        System.out.println(countOfPossibleSolutions(5, 4));

        int[] arr = {5, 1, 2, 9, 9, 6, 3, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr, 9);
        System.out.println(Arrays.toString(arr));
    }
}
