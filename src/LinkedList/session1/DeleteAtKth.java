package LinkedList.session1;

public class DeleteAtKth {

    private static int length(ListNode head){
        if(head==null){
            return 0;
        }
        return 1 + length(head.getNext());
    }

    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.getData());
            head = head.getNext();
            if (head != null)
                System.out.print(",");
        }
        System.out.println();
    }

    public static ListNode deleteKthNode(ListNode head, int k){
        if(head ==null){
            return head ;
        }
        if(k<0 || k>=length(head)){
            throw new RuntimeException("k passed is out of range");
        }

        if(k==0){
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
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        printLL(head);

        ListNode newHead = deleteKthNode(head, 2);

        printLL(newHead);
    }


}
