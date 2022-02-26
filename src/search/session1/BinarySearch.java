package search.session1;

public class BinarySearch {


    public static boolean binarySearchItr(int[] arr, int data) {
        int start =0 , end =arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==data){
                return true;
            }else if(arr[mid]>data){
                end=mid-1;
            }else{
                start = mid+1;
            }
        }
        return false ;
    }

    public static boolean binarySearchRec(int[] arr,int start, int end, int data){
        if(start>end){
            return false;
        }

        int mid = start + (end-start)/2;
        if(arr[mid]==data) {
            return true;
        }else if(arr[mid]>data){
            return binarySearchRec(arr, start, mid-1, data);
        }else{
            return binarySearchRec(arr, mid+1, end, data);
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5,6};

        System.out.println(binarySearchItr(arr1, 2));
        System.out.println(binarySearchItr(arr1, 7));

        System.out.println(binarySearchItr(arr2, 2));
        System.out.println(binarySearchItr(arr2, 7));


        System.out.println(binarySearchRec(arr1, 0,arr1.length-1,2));
        System.out.println(binarySearchRec(arr1, 0,arr1.length-1,7));

        System.out.println(binarySearchRec(arr2, 0,arr1.length-1,2));
        System.out.println(binarySearchRec(arr2, 0,arr1.length-1,7));
    }
}
