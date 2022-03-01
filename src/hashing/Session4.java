package hashing;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Session4 {

    /**
     * Find whether an array is subset of another array
     * <p>
     * Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
     * Output: arr2[] is a subset of arr1[]
     */

    static boolean isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            if (!set.contains(arr1[i])) {
                set.add(arr1[i]);
            }

        }
        for (int i = 0; i < arr2.length; i++) {
            if (!set.contains(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get the Union of a two Linked Lists
     */
    public static ListNode getUnion(ListNode head1, ListNode head2) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode n1 = head1;
        ListNode n2 = head2;

        //Setting the values inside the map
        while (n1 != null) {
            if (map.containsKey(n1.getData())) {
                int val = map.get(n1.getData());
                map.put(n1.getData(), val + 1);
            } else {
                map.put(n1.getData(), 1);
            }
            n1 = n1.getNext();
        }

        while (n2 != null) {
            if (map.containsKey(n2.getData())) {
                int val = map.get(n2.getData());
                map.put(n2.getData(), val + 1);
            } else {
                map.put(n2.getData(), 1);
            }
            n2 = n2.getNext();
        }
        ListNode resultHead = null;
        ListNode current = resultHead;
        for (int data : map.keySet()) {
            if (resultHead == null) {
                resultHead = new ListNode(data);
                current = resultHead;
            } else {
                current.setNext(new ListNode(data));
                current = current.getNext();
            }

        }
        return resultHead;
    }

    /**
     * Find four elements a, b, c and d in an array such that a+b = c+d
     * Input:   {3, 4, 7, 1, 2, 9, 8}
     * Output:  (3, 8) and (4, 7)
     * Explanation: 3+8 = 4+7
     */
    private static class Pair {
        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    ;

    boolean findPairs(int arr[]) {

        Map<Integer, Pair> map = new HashMap<Integer, Pair>();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new Pair(i, j));

                else {
                    Pair p = map.get(sum);

                    System.out.println("(" + arr[p.first] + ", " + arr[p.second] +
                            ") and (" + arr[i] + ", " + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Count distinct elements in every window of size k
     * <p>
     * Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
     * k = 4
     * Output: 3 4 4 3
     */

    public static void countDistinctElements(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(map.size());

        for (int i = k; i < arr.length; i++) {

            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            System.out.println(map.size());
        }
    }


    public static void main(String[] args) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};

        System.out.println(isSubset(arr1, arr2));

        ListNode head1 = new ListNode(1);
        head1.setNext(new ListNode(2));
        head1.getNext().setNext(new ListNode(3));
        head1.getNext().getNext().setNext(new ListNode(4));

        ListNode head2 = new ListNode(1);
        head2.setNext(new ListNode(2));
        head2.getNext().setNext(new ListNode(3));
        head2.getNext().getNext().setNext(new ListNode(5));

        TraverseLL.traverse(getUnion(head1, head2));
    }
}
