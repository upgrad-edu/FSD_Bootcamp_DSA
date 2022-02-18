package arrays.session1;

import java.util.Arrays;

public class ReverseArray {

    public void reverse(int[] arr){
        int i =0 ;
        int j = arr.length-1;

        while(i<j){
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j]=temp;
           i++;
           j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5};

        print(arr);

        ReverseArray obj = new ReverseArray();
        obj.reverse(arr);
        print(arr);

    }

    private static void print(int[] arr){
        Arrays.stream(arr).forEach(e->{
            System.out.print(e + " ");
        });

        System.out.println();
    }
}
