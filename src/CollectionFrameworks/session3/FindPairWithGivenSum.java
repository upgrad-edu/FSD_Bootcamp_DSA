package CollectionFrameworks.session3;

import java.util.Hashtable;

public class FindPairWithGivenSum {

    public static void printPairs(int arr[], int sum)
    {
        Hashtable<Integer, Integer> s = new Hashtable<>();
        for (int i = 0; i < arr.length; ++i)
        {
            int temp = sum - arr[i];

            if (s.keySet().contains(temp)) {
                System.out.println(
                        "Pair with given sum "
                                + sum + " is (" + arr[i]
                                + ", " + temp + ")");
            }
            s.put(arr[i],1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int sum = 16;
        printPairs(arr, sum);
    }
}
