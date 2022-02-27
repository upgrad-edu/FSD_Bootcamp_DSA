package sorting.session6;

import LinkedList.session3.DLLNode;
import LinkedList.session3.TraverseDLL;

import java.util.Arrays;

public class Session6 {

    /**
     * Merge sort a doubly linked list
     */

    public static DLLNode split(DLLNode head) {
        DLLNode fast = head, slow = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        DLLNode temp = slow.getNext();
        slow.setNext(null);
        return temp;
    }

    public static DLLNode mergeSort(DLLNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        DLLNode second = split(node);

        node = mergeSort(node);
        second = mergeSort(second);

        return merge(node, second);
    }

    public static DLLNode merge(DLLNode first, DLLNode second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.getData() < second.getData()) {
            first.setNext(merge(first.getNext(), second));
            first.getNext().setPrev(first);
            first.setPrev(null);
            return first;
        } else {
            second.setNext(merge(first, second.getNext()));
            second.getNext().setPrev(second);
            second.setPrev(null);
            return second;
        }
    }


    /**
     * Merge an array of size n into another array of size m+n
     */

    public static void merge(int[] big, int m, int[] s, int n) {
        int i = m + n - 1;//last index

        int bL = m - 1;
        int sL = n - 1;

        while (bL >= 0 && sL >= 0) {
            if (big[bL] > s[sL]) {
                big[i--] = big[bL--];
            } else {
                big[i--] = s[sL--];
            }
        }

        while (bL >= 0) {
            big[i--] = big[bL--];
        }

        while (sL >= 0) {
            big[i--] = s[sL--];
        }
    }


    /**
     * Count inversions in an array
     */

    public static int countInversionsArr(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;

        int leftCount = countInversionsArr(arr, start, mid);
        int rightCount = countInversionsArr(arr, mid + 1, end);
        int mergeCount = mergeCount(arr, start, mid, end);
        return leftCount + rightCount + mergeCount;
    }

    private static int mergeCount(int[] arr, int start, int mid, int end) {

        int[] temp = new int[arr.length];
        int tIndex = start;
        int leftS = start;
        int rightS = mid + 1;
        int count = 0;

        while (leftS <= mid && rightS <= end) {
            if (arr[leftS] <= arr[rightS]) {
                temp[tIndex++] = arr[leftS++];
            } else {
                temp[tIndex++] = arr[rightS++];
                count = count + mid - leftS + 1;
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

        return count;
    }


    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(5);
        DLLNode node2 = new DLLNode(4);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(2);
        DLLNode node5 = new DLLNode(1);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node2.setPrev(node1);
        node3.setPrev(node2);
        node4.setPrev(node3);
        node5.setPrev(node4);

        TraverseDLL.traverse(node1);

        TraverseDLL.traverse(mergeSort(node1));


        int[] arr1 = {2, 4, 6, 0, 0};
        int[] arr2 = {1, 9};

        merge(arr1, 3, arr2, 2);

        System.out.println(Arrays.toString(arr1));

        int[] arr = {1, 20, 6, 4, 5};

        System.out.println(countInversionsArr(arr, 0, arr.length - 1));
    }
}
