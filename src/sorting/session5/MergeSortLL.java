package sorting.session5;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;

public class MergeSortLL {

    public static ListNode sortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        }
        else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }

    public static ListNode mergeSort(ListNode h)
    {
        // Base case : if head is null
        if (h == null || h.getNext() == null) {
            return h;
        }

        // get the middle of the list
        ListNode middle = getMiddle(h);
        ListNode nextofmiddle = middle.getNext();

        // set the next of middle node to null
        middle.setNext(null);

        // Apply mergeSort on left list
        ListNode left = mergeSort(h);

        // Apply mergeSort on right list
        ListNode right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        ListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    public static ListNode getMiddle(ListNode head)
    {
        if (head == null)
            return head;

        ListNode slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext()!= null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(1));
        head.getNext().getNext().setNext(new ListNode(8));

        TraverseLL.traverse(head);

        TraverseLL.traverse(mergeSort(head));
    }
}
