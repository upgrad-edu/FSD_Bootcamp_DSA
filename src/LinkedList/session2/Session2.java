package LinkedList.session2;

import LinkedList.session1.ListNode;
import LinkedList.session1.TraverseLL;

public class Session2 {


    /**
     * Delete the middle node
     */

    public static ListNode deleteMiddle(ListNode head){

        if(head==null || head.getNext()==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast !=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            prev = slow;
            slow= slow.getNext();
        }

        //Deleting the middle node
        prev.setNext(slow.getNext());
        slow.setNext(null);

        return head ;
    }


    public static boolean hasLoop(ListNode head){
        if(head ==null || head.getNext()==null){
            return false ;
        }

        ListNode slow = head ;
        ListNode fast = head ;

        while(fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    /**
     * Find the start node of the loop
     */

    public static ListNode startOfLoop(ListNode head){

        if(head ==null || head.getNext()==null){

        }

        ListNode slow = head ;
        ListNode fast = head ;
        boolean hasLoop = false;
        while(fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if(fast == slow){
                hasLoop = true;
                break;
            }
        }

        if(!hasLoop){
            System.out.println("No loop found");
            return null;
        }

        ListNode first = head;
        ListNode second = slow ;
        while(first.getData()!=second.getData()){
            first = first.getNext();
            second = second.getNext();
        }

        return first;
    }

    /**
     *  Partition the linked list
     *
     */
    public static ListNode partition(ListNode head, int part)
    {
     /**
        1) Linked list of values smaller than x.
        2) Linked list of values equal to x.
        3) Linked list of values greater than x.
      */
        ListNode sHead = null, sTail = null;
        ListNode gHead = null, gTail = null;
        ListNode eHead = null, eTail =null;

        while (head != null)
        {
            if (head.getData() == part)
            {
                if (eHead == null)
                    eHead = eTail = head;
                else
                {
                    eTail.setNext(head);
                    eTail = eTail.getNext();
                }
            }

            else if (head.getData() < part)
            {
                if (sHead == null)
                    sTail = sHead = head;
                else
                {
                    sTail.setNext(head);
                    sTail = head;
                }
            }
            else
            {
                if (gHead == null)
                    gTail = gHead = head;
                else
                {
                    gTail.setNext(head);
                    gTail = head;
                }
            }
            head = head.getNext();
        }

        if (gTail != null)
            gTail.setNext(null);

        if (sHead == null)
        {
            if (eHead == null)
                return gHead;
            eTail.setNext(gHead);
            return eHead;
        }

        if (eHead == null)
        {
            sTail.setNext(gHead);
            return sHead;
        }

        sTail.setNext(eHead);
        eTail.setNext(gHead);
        return sHead;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));

        TraverseLL.traverse(head);
        ListNode newNode = deleteMiddle(head);
        TraverseLL.traverse(head);


        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);

        System.out.println(hasLoop(head));
        System.out.println(hasLoop(head1));


        System.out.println(startOfLoop(head));
        System.out.println(startOfLoop(head1).getData());


        ListNode head2 = new ListNode(10);
        head2.setNext(new ListNode(4));
        head2.getNext().setNext(new ListNode(5));
        head2.getNext().getNext().setNext(new ListNode(30));
        head2.getNext().getNext().getNext().setNext(new ListNode(2));
        head2.getNext().getNext().getNext().getNext().setNext(new ListNode(50));
        TraverseLL.traverse(head2);
        ListNode h = partition(head2, 5);

        TraverseLL.traverse(h);


    }
}
