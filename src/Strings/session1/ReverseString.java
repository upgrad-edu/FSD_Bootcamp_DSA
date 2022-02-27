package Strings.session1;

public class ReverseString {

    public static String reverse(String inputStr){
        char[] arr = inputStr.toCharArray();

        int i=0, j=arr.length-1;
        while(i<j){
            char temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverse("Vishwa"));
    }
}
