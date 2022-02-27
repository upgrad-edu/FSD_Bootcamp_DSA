package Strings.session1;

public class CheckPalindrome {

    public static boolean isPalindrome(String str){
        if(str==null || str.isBlank() || str.length()==1){
            return true;
        }

        String reverse = ReverseString.reverse(str);

        return reverse.equals(str);

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Vishwa"));
        System.out.println(isPalindrome("aaabcbaaa"));
    }
}
