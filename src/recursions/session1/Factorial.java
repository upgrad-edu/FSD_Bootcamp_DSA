package recursions.session1;

public class Factorial {

    public int factRec(int num) {
        if (num < 0) {
            throw new RuntimeException("Input can't be negative");
        }
        if (num <= 1) {
            return 1;
        }

        return num * factRec(num - 1);
    }


    public int factItr(int num) {
        if (num < 0) {
            throw new RuntimeException("Input can't be negative");
        }
        if (num <= 1) {
            return 1;
        }

        int fact = 1;

        for (int i = 2; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        System.out.println(factorial.factRec(5));
        System.out.println(factorial.factItr(5));
    }
}
