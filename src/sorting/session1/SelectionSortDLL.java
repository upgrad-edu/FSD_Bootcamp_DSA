package sorting.session1;

import LinkedList.session3.DLLNode;
import LinkedList.session3.TraverseDLL;

public class SelectionSortDLL {

    public static DLLNode selectionSort(DLLNode head)
    {
        DLLNode temp = head;

        while (temp!=null) {
            DLLNode min = temp;
            DLLNode r = temp.getNext();

            // Traverse the unsorted sublist
            while (r!=null) {
                if (min.getData() > r.getData())
                    min = r;

                r = r.getNext();
            }

            int x = temp.getData();
            temp.setData(min.getData());
            min.setData(x);
            temp = temp.getNext();
        }
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

        TraverseDLL.traverse(selectionSort(node1));
    }
}
