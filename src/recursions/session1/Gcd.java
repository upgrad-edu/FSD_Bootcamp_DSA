package recursions.session1;

public class Gcd {

    public int gcdRec(int num1, int num2) {

        if (num1 < 0 || num2 < 0) {
            throw new RuntimeException("Numbers can't be negative");
        }
        if (num1 == 0)
            return num2;
        if (num2 == 0)
            return num1;
        if (num1 == num2)
            return num1;

        if (num1 > num2)
            return gcdRec(num1 - num2, num2);

        return gcdRec(num1, num2 - num1);
    }

    public int gcdIter(int num1, int num2) {

        if (num1 < 0 || num2 < 0) {
            throw new RuntimeException("Numbers can't be negative");
        }
        if (num1 == 0)
            return num2;
        if (num2 == 0)
            return num1;
        if (num1 == num2)
            return num1;

        int gcd = 1;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }


    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        System.out.println(gcd.gcdRec(5, -5));
        System.out.println(gcd.gcdRec(5, 0));
        System.out.println(gcd.gcdIter(5, 0));
        System.out.println(gcd.gcdRec(4, 24));
        System.out.println(gcd.gcdIter(4, 24));
    }


}
