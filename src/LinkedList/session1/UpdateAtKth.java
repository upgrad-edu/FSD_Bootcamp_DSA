package LinkedList.session1;

public class UpdateAtKth {

    public static ListNode updateAtKth(ListNode head, int k, int data){
        if(head == null){
            return head;
        }
        if(k<0 ||k>=length(head)){
            throw new RuntimeException("K passed is out of range");
        }

        ListNode node = head;
        int index =0;

        while(index <k){
            node = node.getNext();
            index++;
        }

        node.setData(data);

        return head ;
    }

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        printLL(head);

        ListNode newHead = updateAtKth(head, 5, 14);
        printLL(newHead);
    }
}
