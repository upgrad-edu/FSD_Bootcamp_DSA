package recursions;

public class PowerFour {

    public boolean isPowerOfFourItr(int n) {
        if (n == 0)
            return true;
        while (n != 1) {
            if (n % 4 != 0)
                return false;
            n = n / 4;
        }
        return true;
    }

    public boolean isPowerOfFourRec(int n) {
        if (n == 0)
            return true;

        return n % 4 == 0 && isPowerOfFourItr((n / 4));

    }

    public static void main(String[] args) {
        PowerFour powerFour = new PowerFour();

        System.out.println(powerFour.isPowerOfFourItr(16));
        System.out.println(powerFour.isPowerOfFourRec(16));
        System.out.println(powerFour.isPowerOfFourRec(24));
        System.out.println(powerFour.isPowerOfFourRec(24));
    }
}
