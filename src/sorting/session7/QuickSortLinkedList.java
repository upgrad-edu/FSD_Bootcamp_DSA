package sorting.session7;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;

public class QuickSortLinkedList {


    static ListNode partitionLast(ListNode start, ListNode end)
    {
        if (start == end || start == null || end == null)
            return start;

        ListNode pivot_prev = start;
        ListNode curr = start;
        int pivot = end.getData();

        while (start != end) {
            if (start.getData() < pivot) {
                pivot_prev = curr;
                int temp = curr.getData();
                curr.setData(start.getData());
                start.setData(temp);
                curr = curr.getNext();
            }
            start = start.getNext();
        }

        int temp = curr.getData();
        curr.setData(pivot);
        end.setData(temp);

        return pivot_prev;
    }

    static void quickSort(ListNode start, ListNode end)
    {
        if(start == null || start == end|| start == end.getNext() )
            return;

        ListNode pivot_prev = partitionLast(start, end);
        quickSort(start, pivot_prev);

        if (pivot_prev != null && pivot_prev == start)
            quickSort(pivot_prev.getNext(), end);

       else if (pivot_prev != null
                && pivot_prev.getNext() != null)
            quickSort(pivot_prev.getNext().getNext(), end);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        TraverseLL.traverse(head);

        quickSort(head,node5);
        TraverseLL.traverse(head);


    }

}
