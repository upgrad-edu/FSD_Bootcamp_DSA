package LinkedList.session1;

public class TraverseLL {

    public static void traverse(ListNode head){
        while(head !=null){
            System.out.print(head.getData()+ " ");
            head= head.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));

        traverse(head);
    }
}
