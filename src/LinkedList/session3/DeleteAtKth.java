package LinkedList.session3;



public class DeleteAtKth {

    private static int length(DLLNode head){
        if(head==null){
            return 0;
        }
        return 1 + length(head.getNext());
    }



    public static DLLNode deleteKthNode(DLLNode head, int k){
        if(head ==null){
            return head ;
        }
        if(k<0 || k>=length(head)){
            throw new RuntimeException("k passed is out of range");
        }

        if(k==0){
            head = head.getNext();
            head.setPrev(null);
        }else{
            DLLNode temp = head ;
            int index =0;
            while(index < k-1){
               temp = temp.getNext();
               index++;
            }
            DLLNode next = temp.getNext().getNext();
            next.setPrev(temp);
            temp.getNext().setNext(null);
            temp.getNext().setPrev(null);
            temp.setNext(next);
        }
        return head ;
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
        deleteKthNode(node1, 3);
        TraverseDLL.traverse(node1);

    }


}
