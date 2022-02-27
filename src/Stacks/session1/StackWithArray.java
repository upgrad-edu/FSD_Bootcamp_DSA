package Stacks.session1;

public class StackWithArray {

    private int[] arr ;
    private int capacity ;
    private int top ;

    public StackWithArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top == capacity-1;
    }

    public void push(int data){
        if(isFull()){
            throw new RuntimeException("StackWithArray overflow");
        }
        this.arr[++top] = data;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("StackWithArray Underflow");
        }
        return  this.arr[top--];
    }

    public static void main(String[] args) {
        StackWithArray s = new StackWithArray(4);

        //s.pop(); //should throw execption
        System.out.println(s.isEmpty());
        System.out.println(s.isFull());

        s.push(5);
        s.push(7);
        System.out.println(s.pop());
        s.push(11);
        s.push(12);
        s.push(1);
        s.push(13); // this will throw exception
    }
}
