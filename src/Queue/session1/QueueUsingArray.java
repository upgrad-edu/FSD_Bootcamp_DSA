package Queue.session1;

public class QueueUsingArray {

    private int front;
    private int rear ;
    private int capacity;
    private int[] arr;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull(){
        return (rear+1)%capacity == front;
    }

    public int size(){
        return ( capacity - front+rear+1)%capacity;
    }

    public void enQueue(int data){
        if(isFull()){
            throw new RuntimeException("Queue Overflow exception");
        }else{
            rear = (rear+1)%capacity;
            arr[rear]=data;
            if(front==-1){
                front = rear;
            }
        }
    }

    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow exception");
        }
        int data = arr[front];
        if(front==rear){
            front = rear-1;
        }else{
            front = (front+1)%capacity;
        }
        return data;
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(4);
        //q.deQueue(); This line will throw exception
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(11);
        System.out.println(q.deQueue());
        q.enQueue(12);
        q.enQueue(11);
        q.enQueue(17);// this line will throw exception
    }
}
