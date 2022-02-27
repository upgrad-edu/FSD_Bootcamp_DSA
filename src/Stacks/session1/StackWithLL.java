package Stacks.session1;

import LinkedList.session1.ListNode;

public class StackWithLL {

    private ListNode head ;
    private int count =0;

    public boolean isEmpty(){
        return head==null;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack underflow");
        }
        int data = head.getData();
        head = head.getNext();
        count--;
        return data ;
    }

    public void push(int data){
        if(isEmpty()){
            head = new ListNode(data);
        }

        ListNode node = new ListNode(data);
        node.setNext(head);
        head = node;
        count++;
    }

    private int top(){
        if(isEmpty()){
            throw new RuntimeException("Stack underflow");
        }

        return head.getData();
    }

    private int size(){
        return count;
    }

    public static void main(String[] args) {
        StackWithLL s = new StackWithLL();
        //s.pop(); this will throw exception
        System.out.println(s.isEmpty());

        s.push(5);
        s.push(7);
        System.out.println(s.pop());
        s.push(11);
        s.push(12);
        s.push(1);
        s.push(13); // this will throw exception

    }

}
