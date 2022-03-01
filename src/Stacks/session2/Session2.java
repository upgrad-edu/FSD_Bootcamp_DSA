package Stacks.session2;

import java.util.Stack;

public class Session2 {

    /**
     * Inverse a stack using recursion
     */

    private static void insert_at_bottom(Stack<Character> stack, char x) {

        if (stack.isEmpty())
            stack.push(x);

        else {
            char a = stack.peek();
            stack.pop();
            insert_at_bottom(stack, x);

            stack.push(a);
        }
    }

    public static void reverse(Stack<Character> stack) {
        if (stack.size() > 0) {
            char x = stack.peek();
            stack.pop();
            reverse(stack);
            insert_at_bottom(stack, x);
        }
    }

    /**
     * Balanced expression with replacement
     */

    private static boolean isMatchingBrackets(char a,
                                              char b) {
        if ((a == '{' && b == '}')
                || (a == '[' && b == ']')
                || (a == '(' && b == ')') || a == 'X') {
            return true;
        }
        return false;
    }

    public static boolean isBalancedExpression(String str, Stack<Character> elementStack, int ind) {

        if (ind == str.length()) {
            if (elementStack.size() == 0) {
                return true;
            } else {
                return false;
            }
        }

        char topEle;

        boolean res;

        if (str.charAt(ind) == '{'
                || str.charAt(ind) == '('
                || str.charAt(ind) == '[') {
            elementStack.push(str.charAt(ind));
            return isBalancedExpression(str, elementStack, ind + 1);
        } else if (str.charAt(ind) == '}'
                || str.charAt(ind) == ')'
                || str.charAt(ind) == ']') {

            if (elementStack.size() == 0) {
                return false;
            }

            topEle = elementStack.peek();
            elementStack.pop();

            if (!isMatchingBrackets(topEle, str.charAt(ind))) {
                return false;
            }

            return isBalancedExpression(str, elementStack, ind + 1);
        } else if (str.charAt(ind) == 'X') {
            Stack<Character> tmp = new Stack<>();
            tmp.addAll(elementStack);
            tmp.push(str.charAt(ind));
            res = isBalancedExpression(str, tmp, ind + 1);
            if (res) {
                return true;
            }
            if (elementStack.size() == 0) {
                return false;
            }
            elementStack.pop();
            return isBalancedExpression(str, elementStack, ind + 1);
        }
        return true;
    }

    /**
     * Largest rectangular area in a histogram
     */
    static int calculateMaxArea(int hist[]) {
        Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        int tp;
        int areaWithTop;

        int i = 0;
        while (i < hist.length) {
            if (s.empty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                tp = s.peek();
                s.pop();

                areaWithTop = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while (!s.empty()) {
            tp = s.peek();
            s.pop();
            areaWithTop = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;

    }


    public static void main(String[] args) {

        Stack<Character> st = new Stack<>();
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');

        System.out.println(st);

        reverse(st);

        System.out.println(st);

        String s = "{(X}[]";

        System.out.println(isBalancedExpression(s, new Stack<>(), 0));
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + calculateMaxArea(hist));



    }
}
