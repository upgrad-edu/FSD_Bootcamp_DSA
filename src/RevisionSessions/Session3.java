package RevisionSessions;

import java.util.*;

public class Session3 {

    /**
     * |Problem 4 : Find all the symmetric pairs in an array
     * <p>
     * Given a two dimensional array ( an array of pairs ).
     * <p>
     * A pair is said to be symmetrical when
     * <p>
     * (a,b)  (c,d) :  b==c and a==d
     * <p>
     * Find all such pairs
     * <p>
     * For example :
     * <p>
     * Input: arr[] = {{21, 30}, {40, 50}, {15, 20}, {50, 40}, {20, 15}}
     * Output: Following pairs have symmetric pairs
     * (40, 50)
     * (15, 20)
     */


    public static void findSymmetricPairs(int[][] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int sec = arr[i][1];

            Integer val = map.get(sec);

            if (val != null && val == first) {
                System.out.println("(" + sec + ", " + first + ")");
            } else {
                map.put(first, sec);
            }
        }
    }

    public static void main(String[] args) {
        Stacks ts = new Stacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is "
                + " : " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is "
                + ": " + ts.pop2());

        System.out.println(" ############################  ");

        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(5);
        s.push(30);
        System.out.println(s.getMin());
        s.push(45);
        System.out.println(s.getMin());

        System.out.println(" ############################  ");

        StackUsingQueue st = new StackUsingQueue();
        st.push(20);
        st.push(30);
        System.out.println("Top element :" + st.top());
        st.pop();
        st.push(40);
        st.pop();
        System.out.println("Top element :" + st.top());


        System.out.println(" ############################  ");

        int[][] arr = new int[5][2];
        arr[0][0] = 21; arr[0][1] = 30;
        arr[1][0] = 40; arr[1][1] = 50;
        arr[2][0] = 15;  arr[2][1] = 20;
        arr[3][0] = 50;  arr[3][1] = 40;
        arr[4][0] = 20;  arr[4][1] = 15;
        findSymmetricPairs(arr);

    }

}

/**
 * Problem 1 : Implement two stacks in an array
 * <p>
 * Create a data structure that represents two stacks, using only a single array for the data storage.
 * We should be able to support the following functions :
 * push1( data ) -> push data in the first stack
 * push2(data) -> push data in the second stack
 * pop1() -> pop data from the first stack
 * pop2() -> pop data from the second stack
 */
class Stacks {
    private int[] arr;
    private int capacity;
    int top1, top2;

    public Stacks(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity];
        top1 = (this.capacity / 2) + 1;
        top2 = this.capacity / 2;
    }

    public void push1(int data) {
        if (top1 > 0) {
            top1--;
            arr[top1] = data;
        } else {
            System.out.print("Stack Overflow"
                    + " By element :" + data + "\n");
            return;
        }
    }

    public void push2(int data) {
        if (top2 < this.capacity - 1) {
            top2++;
            arr[top2] = data;
        } else {
            System.out.print("Stack Overflow"
                    + " By element :" + data + "\n");
            return;
        }
    }

    public int pop1() {
        if (top1 <= this.capacity / 2) {
            int x = arr[top1];
            top1++;
            return x;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 0;
    }

    int pop2() {
        if (top2 >= this.capacity / 2 + 1) {
            int x = arr[top2];
            top2--;
            return x;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 1;
    }
};


/**
 * Problem 2  : Design a stack data structure which can return the minimum element in O(1) TC
 * Design a special stack data structure which can support following operations :
 * <p>
 * push
 * pop
 * isEmpty
 * isFull
 * getMin
 * All the above methods should have O(1) time complexity. Also no other data structure than Stack is allowed to solve this problem
 */

class SpecialStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int data) {
        if (isEmpty() == true) {
            stack.push(data);
            minStack.push(data);
        } else {
            stack.push(data);
            int top = minStack.pop();
            minStack.push(top);
            if (data < top)
                minStack.push(data);
            else
                minStack.push(top);
        }
    }

    public int pop() {
        int data = stack.pop();
        minStack.pop();
        return data;
    }

    public int getMin() {
        int data = minStack.peek();
        return data;
    }

    private boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Problem 3 : Implement a Stack using the single queue
 * <p>
 * Implement a stack data structure using just a single queue
 */

class StackUsingQueue {

    Queue<Integer> q = new LinkedList<Integer>();

    void push(int data) {
        int size = q.size();

        q.add(data);

        for (int i = 0; i < size; i++) {
            int x = q.remove();
            q.add(x);
        }
    }

    int pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
            return -1;
        }
        int data = q.remove();
        return data;
    }

    int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    boolean isEmpty() {
        return q.isEmpty();
    }
}
