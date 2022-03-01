package Queue.session2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Session2 {

    /**
     * Implement queue using stack
     */

    static class QueueCustom
    {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        static void enQueue(int x)
        {
            while (!s1.isEmpty())
            {
                s2.push(s1.pop());
            }

            s1.push(x);

            while (!s2.isEmpty())
            {
                s1.push(s2.pop());
            }
        }

        static int deQueue()
        {
            if (s1.isEmpty())
            {
                throw new RuntimeException("Queue underflow exception");
            }

            int x = s1.peek();
            s1.pop();
            return x;
        }
    };


    /**
     * Implement stack using queue
     *
     */

    static class StackCustom {

        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();

       static int currSize;

        StackCustom()
        {
            currSize = 0;
        }

        static void push(int x)
        {
            currSize++;

            q2.add(x);

            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }

            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static int pop()
        {
            if (q1.isEmpty())
                throw new RuntimeException("Stack underflow exception");
            int data = q1.remove();
            currSize--;
            return data;
        }

        static int top()
        {
            if (q1.isEmpty())
                throw new RuntimeException("Stack underflow exception");
            return q1.peek();
        }

        static int size()
        {
            return currSize;
        }
    }

    /**
     * Minimum time required to rot all the oranges
     * @param
     */

    static boolean isSafe(int[][]arr, int i, int j)
    {
        return (i >= 0 && i < arr.length &&
                j >= 0 && j < arr[0].length);

    }

    static int timeToRotOranges(int oranges[][])
    {
        boolean changed = false;
        int no = 2;

        while (true)
        {
            for(int i = 0; i < oranges.length; i++)
            {
                for(int j = 0; j < oranges[0].length; j++)
                {

                    // Rot all other oranges present at
                    // (i+1, j), (i, j-1), (i, j+1), (i-1, j)
                    if (oranges[i][j] == no)
                    {
                        if (isSafe(oranges,i + 1, j) &&
                                oranges[i + 1][j] == 1)
                        {
                            oranges[i + 1][j] = oranges[i][j] + 1;
                            changed = true;
                        }
                        if (isSafe(oranges,i, j + 1) &&
                                oranges[i][j + 1] == 1)
                        {
                            oranges[i][j + 1] = oranges[i][j] + 1;
                            changed = true;
                        }
                        if (isSafe(oranges,i - 1, j) &&
                                oranges[i - 1][j] == 1)
                        {
                            oranges[i - 1][j] = oranges[i][j] + 1;
                            changed = true;
                        }
                        if (isSafe(oranges,i, j - 1) &&
                                oranges[i][j - 1] == 1)
                        {
                            oranges[i][j - 1] = oranges[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }
            if (!changed)
                break;

            changed = false;
            no++;
        }

        for(int i = 0; i < oranges.length; i++)
        {
            for(int j = 0; j < oranges[0].length; j++)
            {

               if (oranges[i][j] == 1)
                    return -1;
            }
        }

        return no - 2;
    }

    public static void main(String[] args) {
        QueueCustom q = new QueueCustom();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        //System.out.println(q.deQueue()); this line will throw the exception

        StackCustom s = new StackCustom();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        int oranges[][] = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };

        System.out.println(timeToRotOranges(oranges));



    }

}
