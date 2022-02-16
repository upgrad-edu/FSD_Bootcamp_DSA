package recursions.session2;

public class PrintArrayTailWay {

    public void print(int[] arr , int sI){
        if(sI>=arr.length){
            return;
        }
        System.out.println(arr[sI]);

        //Last step
        print(arr, sI+1);
    }
}
