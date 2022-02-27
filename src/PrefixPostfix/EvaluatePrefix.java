package PrefixPostfix;

import java.util.Stack;

public class EvaluatePrefix {

    private static boolean isCharTheOperand(char c) {
        return c >= 48 && c <= 57;

    }

    public static double evaluatePrefix(String expr) {
        Stack<Double> stack = new Stack<Double>();

        for (int j = expr.length() - 1; j >= 0; j--) {

            if (isCharTheOperand(expr.charAt(j)))
                stack.push((double) (expr.charAt(j) - 48));

            else {

                double o1 = stack.peek();
                stack.pop();
                double o2 = stack.peek();
                stack.pop();

                switch (expr.charAt(j)) {
                    case '+':
                        stack.push(o1 + o2);
                        break;
                    case '-':
                        stack.push(o1 - o2);
                        break;
                    case '*':
                        stack.push(o1 * o2);
                        break;
                    case '/':
                        stack.push(o1 / o2);
                        break;
                }
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String expr = "+7*29";
        System.out.println(evaluatePrefix(expr));
    }
}
