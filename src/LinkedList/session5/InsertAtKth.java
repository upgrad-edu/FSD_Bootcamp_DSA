package LinkedList.session5;

import LinkedList.session1.ListNode;

public class InsertAtKth {

    public static ListNode insert(ListNode headNode, int position, int data) {
        ListNode head = headNode;

        if (position < 0 || position >length(headNode)) {
            System.out.println("Invalid position");
            return headNode;
        }
        if (position == 0) {
            ListNode newNode = new ListNode(data);
            ListNode curr = headNode;
            while(curr.getNext().getData() != head.getData()){
                curr = curr.getNext();
            }
            curr.setNext(newNode);
            newNode.setNext(headNode);
            head = newNode;
        } else {
            while (position-- != -1) {
                if (position == 0) {
                    ListNode newNode = new ListNode(data);

                    newNode.setNext(headNode.getNext());

                    headNode.setNext(newNode);
                    break;
                }
                headNode = headNode.getNext();
            }
            if (position != 0)
                System.out.println("Position out of range");
        }
        return head;
    }



    private static int length(ListNode head){
        if(head ==null){
            return 0;
        }
        int len =1 ;
        ListNode current = head.getNext();

        while(current!=null && current !=head){
            len++;
            current = current.getNext();
        }
        return len;
    }
    public static void main(String[] args) {


        ListNode head = CircularLinkedList.createCLL();

        IterateCircularLL.iterate(head);

        IterateCircularLL.iterate(insert(head, 0, 12));


    }
}
