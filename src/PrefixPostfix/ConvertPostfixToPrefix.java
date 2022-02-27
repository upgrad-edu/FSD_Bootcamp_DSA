package PrefixPostfix;

import java.util.Stack;

public class ConvertPostfixToPrefix {

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

    public static String convertPostfixToPrefix(String postfixExp) {
        Stack<String> s = new Stack<String>();

        int length = postfixExp.length();

        for (int i = 0; i < length; i++) {

            if (isAnOperator(postfixExp.charAt(i))) {

                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                String temp
                        = postfixExp.charAt(i) + op2 + op1;

                s.push(temp);
            } else {

                s.push(postfixExp.charAt(i) + "");
            }
        }

        String ans = "";
        for (String i : s)
            ans += i;
        return ans;
    }

    public static void main(String[] args) {
        String postFixExp = "ABC/-AK/L-*";
        System.out.println(convertPostfixToPrefix(postFixExp));
    }

}
