package LinkedList.session5;

import LinkedList.session1.ListNode;

public class IterateCircularLL {

    public static void iterate(ListNode head){
        if(head ==null){
            return ;
        }
        System.out.print(head.getData() +" ");

        ListNode current = head.getNext();

        while(current!=null && current !=head){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        iterate(CircularLinkedList.createCLL());
    }
}
