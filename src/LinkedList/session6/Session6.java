package LinkedList.session6;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;
import LinkedList.session3.TraverseDLL;
import LinkedList.session4.Session4;

public class Session6 {

    /**
     * Multiple two numbers as linked list
     * Input : 9->4->6
     *         8->4
     * Output : 79464
     *
     */

    public static long multiplyTwoLL(ListNode head1, ListNode head2)
    {
        long bigNum = 1000000000; //Take very bif number
        long num1 = 0, num2 = 0;

        while (head1 != null || head2 !=  null){

            if(head1 != null){
                num1 = ((num1)*10)%bigNum + head1.getData();
                head1 = head1.getNext();
            }

            if(head2 != null)
            {
                num2 = ((num2)*10)%bigNum + head2.getData();
                head2 = head2.getNext();
            }

        }
        return ((num1%bigNum)*(num2%bigNum))%bigNum;
    }


    /**
     *
     * Adding 1 to a number represented as LL
     *
     * 1-> 9-> 9 -> 9 + 1 = 2->0->0->0
     */

    public static ListNode addOneToTheList(ListNode head){

         head = Session4.reverse(head);
         head = addOneUtil(head);
         return Session4.reverse(head);


    }

    private static ListNode addOneUtil(ListNode head){
        ListNode res = head;
        ListNode temp = null, prev = null;
        int carry = 1, sum;
        while (head != null)
        {
            sum = carry + head.getData();
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            head.setData(sum);

            temp = head;
            head = head.getNext();
        }
        if (carry > 0)
            temp.setNext(new ListNode(carry));
        return res;
    }


    /**
     * Clone a LL without using extra space
     *
     */

    static class ListNodeModified {
        private int data ;
        private ListNodeModified next ;
        private ListNodeModified random ;

        public ListNodeModified(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNodeModified getNext() {
            return next;
        }

        public void setNext(ListNodeModified next) {
            this.next = next;
        }

        public ListNodeModified getRandom() {
            return random;
        }

        public void setRandom(ListNodeModified random) {
            this.random = random;
        }

        @Override
        public String toString() {
            return "ListNodeModified{" +
                    "data=" + data +
                    ", random=" + random.getData() +
                    '}';
        }
    }

    public static ListNodeModified clone(ListNodeModified start)
    {
        ListNodeModified curr = start, temp = null;

        while (curr != null) {
            temp = curr.getNext();

            curr.setNext(new ListNodeModified(curr.getData()));
            curr.getNext().setNext(temp);
            curr = temp;
        }
        curr = start;

        while (curr != null) {
            if (curr.getNext() != null)
                curr.getNext().setRandom(curr.getRandom()!=null ? curr.getRandom().getNext(): curr.getRandom());
            curr = curr.getNext().getNext();
        }

        ListNodeModified original = start, copy = start.getNext();

        temp = copy;

        // now separate the original list and copied list
        while (original != null) {
            original.setNext(original.getNext().getNext());
            copy.setNext((copy.getNext()!= null) ? copy.getNext().getNext()
                    : copy.getNext());
            original = original.getNext();
            copy = copy.getNext();
        }
        return temp;
    }

    private static void traverse(ListNodeModified head){
        while(head !=null){
            System.out.println(head);
            head= head.getNext();
        }

    }


    /**
     * Pairwise swap elements of given LL by changing link
     *  Input :  1->2->3->4->5->6->7
     *  Output : 2->1->4->3->6->5->7
     *
     */

    public static ListNode pairWiseSwap(ListNode head)
    {

        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.getNext();

        head = curr;

        while (true) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            if (next == null || next.getNext() == null) {
                prev.setNext(next);
                break;
            }

            prev.setNext(next.getNext());

            prev = next;
            curr = prev.getNext();
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(9);
        head1.setNext(new ListNode(4));
        head1.getNext().setNext(new ListNode(6));

        ListNode head2 = new ListNode(8);
        head2.setNext(new ListNode(4));


        System.out.println(multiplyTwoLL(head1, head2));

        System.out.println("####################");


        ListNode head3 = new ListNode(1);
        head3.setNext(new ListNode(9));
        head3.getNext().setNext(new ListNode(9));
        head3.getNext().getNext().setNext(new ListNode(9));

        TraverseLL.traverse(head3);

        TraverseLL.traverse(addOneToTheList(head3));

        System.out.println("####################");

        ListNodeModified node1  = new ListNodeModified(1);
        ListNodeModified node2  = new ListNodeModified(2);
        ListNodeModified node3  = new ListNodeModified(3);
        ListNodeModified node4  = new ListNodeModified(4);
        ListNodeModified node5  = new ListNodeModified(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node1.setRandom(node3);
        node2.setRandom(node1);
        node3.setRandom(node5);
        node4.setRandom(node5);
        node5.setRandom(node2);

        traverse(node1);

        System.out.println("After cloning");

        traverse(clone(node1));
        //Confirm that the LL is cloned
        System.out.println(node1.hashCode() + "  -  "+ clone(node1).hashCode());

        System.out.println("####################");

        ListNode head4 = new ListNode(1);
        head4.setNext(new ListNode(2));
        head4.getNext().setNext(new ListNode(3));
        head4.getNext().getNext().setNext(new ListNode(4));
        head4.getNext().getNext().getNext().setNext(new ListNode(5));
        head4.getNext().getNext().getNext().getNext().setNext(new ListNode(6));
        head4.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(7));

        TraverseLL.traverse(head4);
        TraverseLL.traverse(pairWiseSwap(head4));







    }
}
