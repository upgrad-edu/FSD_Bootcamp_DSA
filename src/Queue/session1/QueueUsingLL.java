package Queue.session1;

import LinkedList.session1.ListNode;

public class QueueUsingLL {

    private ListNode frontNode;
    private ListNode rearNode;
    int count = 0;

    public boolean isEmpty(){
        return frontNode==null;
    }

    public void enQueue(int data){
        if(isEmpty()){
            rearNode = new ListNode(data);
            frontNode=rearNode;
        }else{
            ListNode node = new ListNode(data);
            rearNode.setNext(node);
            rearNode = node;
        }
        count ++;

    }

    public int deQueue(){
        if(isEmpty()){
            if(isEmpty()){
                throw new RuntimeException("Queue Underflow exception");
            }
        }
        int data = frontNode.getData();
        frontNode = frontNode.getNext();
        count--;
        return  data;
    }

    public int size(){
        return  count;
    }

    public static void main(String[] args) {
        QueueUsingLL q = new QueueUsingLL();
        //q.deQueue(); This line will throw exception
        System.out.println(q.isEmpty());
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(11);
        System.out.println(q.deQueue());
        q.enQueue(12);
        q.enQueue(11);
        q.enQueue(17);// this line will throw exception
    }
}
