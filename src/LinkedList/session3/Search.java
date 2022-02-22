package LinkedList.session3;

public class Search {

    public static boolean isPresent(DLLNode head , int num){
        while(head !=null){
            if(head.getData()==num){
                return true;
            }
            head = head.getNext();
        }

        return false;
    }

    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(1);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(3);
        DLLNode node4 = new DLLNode(4);
        DLLNode node5 = new DLLNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node2.setPrev(node1);
        node3.setPrev(node2);
        node4.setPrev(node3);
        node5.setPrev(node4);

        System.out.println(isPresent(node1, 4));
        System.out.println(isPresent(node1, 5));
        System.out.println(isPresent(node1, 6));
    }
}
