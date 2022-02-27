package Strings.session1;

import java.util.Arrays;
import java.util.Locale;

public class CheckAnagrams {

    public static boolean isAnagram(String str1 , String str2){

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        if (arr1 != arr2)
            return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i])
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("test", "ttew"));
    }
}
