package recursions;

public class Fibonacci {

    /**
     * Sample Input: 4
     * Sample Output: 3
     * Explanation: (F0 = 0, F1 = 1, F2 = 1, F3 = 2, F4 = 3)
     */
    public int fibNthTermItr(int n) {
        if (n < 0) {
            throw new RuntimeException("Input number can't be negative");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int prev1 = 0;
        int prev2 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;

    }

    public int fibNthTermRec(int n) {

        if (n < 0) {
            throw new RuntimeException("Input number can't be negative");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        return fibNthTermRec(n - 1) + fibNthTermRec(n - 2);

    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibNthTermItr(5));
        System.out.println(fibonacci.fibNthTermRec(5));
    }

}
