package LinkedList.session4;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;

public class Session4 {

    /**
     * Reverse a linked list
     */

    public static ListNode reverse(ListNode head){
        if(head ==null || head.getNext()==null){
            return head ;
        }

        ListNode prev = null;
        ListNode curr = head ;
        while(curr!=null){
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr ;
            curr = next;
        }

        return prev;
    }

    /**
     * Merge a linkedlist into another linked list at alternate positions
     * 5->7->17->13->11
     * 12->10->2->4->6
     *
     * Final : 5->12->7->10->17->2->13->4->11->6
     *
     *
     * 1->2->3 + 4->5->6->7->8
     *
     *
     */

    public static ListNode mergeSecondInFirst(ListNode head1, ListNode head2){

        ListNode current = head1;

        while(current!=null && head2!=null){
            ListNode next = head2.getNext();
            head2.setNext(current.getNext());
            current.setNext(head2);
            head2 = next;
            current = current.getNext().getNext();
        }

        return head1;

    }

    /**
     * Rotate a linked list k times
     * 10  20  30  40  50  60
     *
     * k= 4  After rotating 4 times right to left direction
     *
     * 50  60  10  20  30  40
     */

    public static ListNode rotate(ListNode head, int k){
        if (k == 0)
            return head;

        ListNode current = head;

        while (current.getNext() != null)
            current = current.getNext();

        current.setNext(head); // Made circular
        current = head;
        for (int i = 0; i < k - 1; i++)
            current = current.getNext();

        head = current.getNext();
        current.setNext(null);
        return head;
    }

    /**
     * Check if the single LL is Palindrome
     *
     */
    public static boolean isPalindrome(WrapperNode left, ListNode right){

        if (right == null) {
            return true;
        }

        if (!isPalindrome(left, right.getNext())) {
            return false;
        }

        ListNode prevLeft = left.node;

        left.node = left.node.getNext();

        return prevLeft.getData() == right.getData();
    }

    static class WrapperNode
    {
        public ListNode node;

        public WrapperNode(ListNode node) {
            this.node = node;
        }
    }


    /**
     * Reverse a linkedlist in the group of k
     * @param
     */

    public static ListNode reverseK(ListNode head, int k ){

        if(head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.setNext(reverseK(next, k));

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));

        TraverseLL.traverse(head);

        TraverseLL.traverse(reverse(head));

        ListNode head1 = new ListNode(1);
        head1.setNext(new ListNode(2));
        head1.getNext().setNext(new ListNode(3));

        ListNode head2 = new ListNode(4);
        head2.setNext(new ListNode(5));
        head2.getNext().setNext(new ListNode(6));
        head2.getNext().getNext().setNext(new ListNode(7));
        head2.getNext().getNext().getNext().setNext(new ListNode(8));


        TraverseLL.traverse(mergeSecondInFirst(head1, head2));

        ListNode head3 = new ListNode(10);
        head3.setNext(new ListNode(20));
        head3.getNext().setNext(new ListNode(30));
        head3.getNext().getNext().setNext(new ListNode(40));
        head3.getNext().getNext().getNext().setNext(new ListNode(50));
        head3.getNext().getNext().getNext().getNext().setNext(new ListNode(60));
        TraverseLL.traverse(rotate(head3,4));


        ListNode head4 = new ListNode(10);
        head4.setNext(new ListNode(20));
        head4.getNext().setNext(new ListNode(30));
        head4.getNext().getNext().setNext(new ListNode(20));
        head4.getNext().getNext().getNext().setNext(new ListNode(10));

        System.out.println(isPalindrome(new WrapperNode(head4), head4));

        ListNode head5 = new ListNode(1);
        head5.setNext(new ListNode(2));
        head5.getNext().setNext(new ListNode(3));
        head5.getNext().getNext().setNext(new ListNode(4));
        head5.getNext().getNext().getNext().setNext(new ListNode(5));
        head5.getNext().getNext().getNext().getNext().setNext(new ListNode(6));
        head5.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(7));
        head5.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(8));
        head5.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(9));
        head5.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(10));

        TraverseLL.traverse(reverseK(head5,3));






    }
}
