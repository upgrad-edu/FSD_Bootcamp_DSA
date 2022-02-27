package Strings.session1;

import java.util.Arrays;
import java.util.Locale;

public class CountVnC {

    public static void countVnC(String str){
        if(str== null || str.isEmpty()){
            return;
        }
        str = str.toLowerCase();
        char[] arr = str.toCharArray();

        int vowelCount = 0;
        int consonantCount = 0;

        for(char c : arr){
            if(c=='a' || c=='e'|| c=='i'|| c=='o'|| c=='u'){
                vowelCount++;
            }else{
                consonantCount++;
            }
        }

        System.out.println("Vowel count is equal to : [ "+ vowelCount + " ]");
        System.out.println("Consonant count is equal to : [ "+ consonantCount + " ]");
    }

    public static void main(String[] args) {
        countVnC("Vishwa Mohan");
    }
}
