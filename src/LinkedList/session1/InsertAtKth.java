package LinkedList.session1;

public class InsertAtKth {

    public static ListNode insert(ListNode headNode, int position, int data) {
        ListNode head = headNode;

        if (position < 0 || position >length(headNode)) {
            System.out.println("Invalid position");
            return headNode;
        }
        if (position == 0) {
            ListNode newNode = new ListNode(data);
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

    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.getData());
            head = head.getNext();
            if (head != null)
                System.out.print(",");
        }
        System.out.println();
    }

    private static int length(ListNode head){
        if(head==null){
            return 0;
        }
        return 1 + length(head.getNext());
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        printLL(head);

        ListNode newHead = insert(head, 1, 9);

        printLL(newHead);

    }
}
