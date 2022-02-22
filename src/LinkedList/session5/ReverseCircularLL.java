package LinkedList.session5;

import LinkedList.session1.ListNode;

public class ReverseCircularLL {

    public static ListNode reverse(ListNode head){

        if(head ==null || head.getNext()==null){
            return head ;
        }
        ListNode temp = head;
        while(temp.getNext().getData() != head.getData()){
            temp = temp.getNext();
        }

        ListNode prev = temp;
        ListNode curr = head ;
        while(curr.getNext()!= head){
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr ;
            curr = next;
        }
        curr.setNext(prev);
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = CircularLinkedList.createCLL();

        IterateCircularLL.iterate(head);

        IterateCircularLL.iterate(reverse(head));
    }

}
