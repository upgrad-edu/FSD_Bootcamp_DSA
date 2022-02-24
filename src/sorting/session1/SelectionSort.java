package sorting.session1;

public class SelectionSort {


    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j =i+1;j<arr.length;j++ ){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }

            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {5, 6, 1, 23, 4};
        print(arr);
        selectionSort(arr);
        print(arr);

    }
}
