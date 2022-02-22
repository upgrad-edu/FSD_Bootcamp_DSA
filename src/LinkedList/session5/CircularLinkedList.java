package LinkedList.session5;

import LinkedList.session1.ListNode;

public class CircularLinkedList {

    /**
     * Creating a circular linkedList
     * @return
     */
    public static ListNode createCLL(){
        ListNode head = new ListNode(1);

        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));

        //Making it circular : tail -> head
        head.getNext().getNext().getNext().setNext(head);

        return head;
    }


    public static void main(String[] args) {

    }
}
