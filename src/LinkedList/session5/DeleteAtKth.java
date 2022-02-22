package LinkedList.session5;

import LinkedList.session1.ListNode;

public class DeleteAtKth {

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



    public static ListNode deleteKthNode(ListNode head, int k){
        if(head ==null){
            return head ;
        }
        if(k<0 || k>=length(head)){
            throw new RuntimeException("k passed is out of range");
        }

        if(k==0){
            ListNode curr = head;
            while(curr.getNext().getData() != head.getData()){
                curr = curr.getNext();
            }
            curr.setNext(head.getNext());
            head = head.getNext();

        }else{
            ListNode temp = head ;
            int index =0;
            while(index < k-1){
               temp = temp.getNext();
               index++;
            }
            ListNode next = temp.getNext().getNext();
            temp.getNext().setNext(null);
            temp.setNext(next);
        }
        return head ;
    }

    public static void main(String[] args) {
        ListNode head = CircularLinkedList.createCLL();

        IterateCircularLL.iterate(head);

        IterateCircularLL.iterate(deleteKthNode(head,2));


    }


}
