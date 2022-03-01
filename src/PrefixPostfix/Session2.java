package PrefixPostfix;

import java.util.Arrays;
import java.util.Stack;

public class Session2 {

    /**
     * Stock span problem
     */

    static void calculateStockSpan(int[] stockPrice, int stockSpan[]) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        stockSpan[0] = 1;

        for (int i = 1; i < stockPrice.length; i++) {

            while (!st.empty() && stockPrice[st.peek()] <= stockPrice[i])
                st.pop();

            stockSpan[i] = (st.empty()) ? (i + 1) : (i - st.peek());

            st.push(i);
        }
    }

    /**
     * Celebrity problem
     */

    private static boolean[][] relationMatrix = {{false, false, true, false},
            {false, false, true, false},
            {false, false, false, false},
            {false, false, true, false}};

    public static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        int c;

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if (relationMatrix[a][b]) {
                st.push(b);
            } else
                st.push(a);
        }

        if (st.empty())
            return -1;

        c = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != c && (relationMatrix[c][i] ||
                    !relationMatrix[i][c]))
                return -1;
        }
        return c;
    }

    /**
     * Minimum number of reversals required to balance the brackets
     *
     */
    public static int countReversals(String expr)
    {
        int len = expr.length();

        if (len%2 != 0)
            return -1;

        Stack<Character> s=new Stack<>();

        for (int i=0; i<len; i++)
        {
            char c = expr.charAt(i);
            if (c =='}' && !s.empty())
            {
                if (s.peek()=='{')
                    s.pop();
                else
                    s.push(c);
            }
            else
                s.push(c);
        }

        int redLen = s.size();

        int n = 0;
        while (!s.empty() && s.peek() == '{')
        {
            s.pop();
            n++;
        }

        return (redLen/2 + n%2);
    }

    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};

        int stockSpan[] = new int[price.length];

        calculateStockSpan(price, stockSpan);

        System.out.println(Arrays.toString(stockSpan));


        System.out.println(findCelebrity(4));


        String expr = "}}{{";

        System.out.println(countReversals(expr));

    }
}
