package LinkedList.session1;

public class SearchInLL {

    public static boolean isPresent(ListNode head , int data){
        if(head ==null){
            return false ;
        }

        ListNode temp = head;

        while(temp !=null){
            if(temp.getData() == data){
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        System.out.println(isPresent(head, 3));
        System.out.println(isPresent(head, 7));
    }
}
