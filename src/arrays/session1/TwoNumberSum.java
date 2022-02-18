package arrays.session1;

public class TwoNumberSum {


    public void findTwoNum(int arr[],int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println("Pair with a given sum " + sum +
                            " is (" + arr[i] + ", " + arr[j] + ")");

                }
            }
        }

    }


    public static void main(String[] args) {
        int [] arr = {3,6,1,3,9,4};

        TwoNumberSum tns = new TwoNumberSum();

        tns.findTwoNum(arr, 15);
    }
}
