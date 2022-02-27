package PrefixPostfix;

import java.util.Stack;

public class EvaluatePostfixExpression {

    private static boolean isCharTheOperand(char c) {
        return c >= 48 && c <= 57;

    }

    public static double evaluatePostfix(String exp) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (isCharTheOperand(c)){
                stack.push((double) (c - 48));
            }

            else {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp="231*+9-";
        System.out.println(evaluatePostfix(exp));
    }
}
