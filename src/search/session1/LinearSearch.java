package search.session1;

public class LinearSearch {


    public static boolean isPresent(int[] arr , int num){
        for(int i=0;i<arr.length;i++){
            if(arr[i] ==num){
                return true;
            }
        }
        return false;
    }
}
