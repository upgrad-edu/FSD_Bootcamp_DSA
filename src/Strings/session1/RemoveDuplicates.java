package Strings.session1;

import java.util.Arrays;

public class RemoveDuplicates {

    public static String removeDuplicate(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] arr = str.toCharArray();

        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            int j;
            for (j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }

            if (j == i) {
                arr[index++] = arr[i];
            }
        }
        return String.valueOf(Arrays.copyOf(arr, index));
    }

    public static void main(String[] args) {
        String str = "I am Vishwa Mohan";

        System.out.println(removeDuplicate(str));
    }
}
