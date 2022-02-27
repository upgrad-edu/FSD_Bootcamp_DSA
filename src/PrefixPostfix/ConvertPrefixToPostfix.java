package PrefixPostfix;

import java.util.Stack;

public class ConvertPrefixToPostfix {

    public static String convertPrefixToPostfix(String preExp) {
        Stack<String> s = new Stack<String>();

        int length = preExp.length();

        for (int i = length - 1; i >= 0; i--) {
            if (isAnOperator(preExp.charAt(i))) {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                String temp = op1 + op2 + preExp.charAt(i);

                s.push(temp);
            } else {
                s.push(preExp.charAt(i) + "");
            }
        }

        return s.peek();
    }

    private static boolean isAnOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String pre_exp = "*-A/BC-/AKL";
        System.out.println("Postfix : "
                + convertPrefixToPostfix(pre_exp));
    }

}
