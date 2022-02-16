package recursions.session1;

public class Palindrome {

    public int reverse(int num, int temp) {
        if (num == 0)
            return temp;

        temp = (temp * 10) + (num % 10);

        return reverse(num / 10, temp);
    }

    public boolean isPalindrome(int num) {
        return num == reverse(num, 0);
    }


    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.reverse(-12345, 0));
        System.out.println(palindrome.reverse(12345, 0));

        System.out.println(palindrome.isPalindrome(123321));
        System.out.println(palindrome.isPalindrome(12345));

    }

}
