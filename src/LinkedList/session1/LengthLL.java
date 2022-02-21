package LinkedList.session1;

public class LengthLL {

    public static int length(ListNode head){
        int len =0;
        while(head!=null){
            head = head.getNext();
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        System.out.println(length(head));
    }
}
