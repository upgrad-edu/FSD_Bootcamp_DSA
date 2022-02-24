package sorting.session1;

public class EnhancedBubbleSort {

    public static void enhancedBubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {

            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (isSorted) {
                return;
            }
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
        enhancedBubbleSort(arr);
        print(arr);
    }
}
