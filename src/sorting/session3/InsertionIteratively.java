package sorting.session3;

import java.util.Arrays;

public class InsertionIteratively {

    public static void insertionSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            int v = arr[i];
            int j=i;
            while(j-1>=0 &&arr[j-1]>v){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=v;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,1,9,2,3,5,-1};

        System.out.println(Arrays.toString(arr));

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
