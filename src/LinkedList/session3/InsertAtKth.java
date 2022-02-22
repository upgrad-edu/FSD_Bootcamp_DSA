package LinkedList.session3;


public class InsertAtKth {

    public static DLLNode insert(DLLNode headNode, int position, int data) {
        DLLNode head = headNode;

        if (position < 0 || position >length(headNode)) {
            System.out.println("Invalid position");
            return headNode;
        }
        if (position == 0) {
            DLLNode newNode = new DLLNode(data);
            newNode.setNext(headNode);
            headNode.setPrev(newNode);
            head = newNode;
        } else {
            while (position-- != -1) {
                if (position == 0) {
                    DLLNode newNode = new DLLNode(data);

                    newNode.setNext(headNode.getNext());
                    headNode.getNext().setPrev(newNode);
                    newNode.setPrev(headNode);

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



    private static int length(DLLNode head){
        if(head==null){
            return 0;
        }
        return 1 + length(head.getNext());
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

        TraverseDLL.traverse(node1);

        insert(node1, 3, 81);

        TraverseDLL.traverse(node1);
    }
}
