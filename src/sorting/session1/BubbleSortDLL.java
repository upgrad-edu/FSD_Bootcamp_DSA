package sorting.session1;

import LinkedList.session3.DLLNode;
import LinkedList.session3.TraverseDLL;

public class BubbleSortDLL {


    static DLLNode bubbleSort(DLLNode head)
    {
        int swapped, i;
        DLLNode ptr1;
        DLLNode lptr = null;

        if (head == null)
            return null;

        do
        {
            swapped = 0;
            ptr1 = head;

            while (ptr1.getNext() != lptr)
            {
                if (ptr1.getData() > ptr1.getNext().getData())
                {
                    int t = ptr1.getData();
                    ptr1.setData(ptr1.getNext().getData());
                    ptr1.getNext().setData(t);
                    swapped = 1;
                }
                ptr1 = ptr1.getNext();
            }
            lptr = ptr1;
        }
        while (swapped != 0);
        return head;
    }

    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(3);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(1);
        DLLNode node4 = new DLLNode(5);
        DLLNode node5 = new DLLNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node2.setPrev(node1);
        node3.setPrev(node2);
        node4.setPrev(node3);
        node5.setPrev(node4);

        TraverseDLL.traverse(node1);

        TraverseDLL.traverse(bubbleSort(node1));
    }
}
