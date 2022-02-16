package recursions.session2;

public class PrintArrayReverseNonTailWay {

    public void print(int[] arr , int sI){
        if(sI>=arr.length){
            return;
        }

        print(arr, sI+1);
        System.out.println(arr[sI]);


    }
}
