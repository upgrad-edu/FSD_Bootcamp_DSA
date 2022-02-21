package arrays.session1;

public class DynamicArray {
    private int arr[];
    private int count;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
    }

    public void insert(int num) {
        if (arr.length == count) {

            int newArr[] = new int[2 * count];
            for (int i = 0; i < count; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[count++] = num;
    }

    public void insert(int num , int index){
        if (arr.length == count) {

            int newArr[] = new int[2 * count];
            for (int i = 0; i < count; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        if(index <0 || index >=arr.length){
            throw new RuntimeException("Index passed is not correct");
        }
        int i = count;
        while(i>index){
            arr[i]=arr[i-1];
            i--;
        }
        arr[i]= num;
        count++;
    }

    public void delete(int index){
        if(index <0 || index >=arr.length){
            throw new RuntimeException("Index passed is not correct");
        }

        int i = index;
        while(i<count-1){
            arr[i]=arr[i+1];
            i++;
        }
        arr[count-1]=0;
        count--;
    }

    public void print(){
        for(int i=0;i<this.arr.length;i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public int smallestElement(){
        int smallest = arr[0];
        for(int i =1;i<count;i++){
            if(arr[i] <smallest){
                smallest = arr[i];
            }
        }

        return smallest ;
    }

    public int gcd(){
        int gcd = this.arr[0];
        for(int i=0;i<count;i++){
            gcd = gcd(gcd, arr[i]);

            if(gcd==1){
                return 1;
            }
        }
        return gcd;
    }

    private int gcd(int a , int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }


    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(4);
        arr.print();

        arr.insert(4);
        arr.insert(24);
        arr.insert(16);
        arr.insert(12);
        arr.print();

        arr.insert(8,2);

        arr.print();

        arr.delete(3);
        arr.print();

        System.out.println(arr.smallestElement());

        System.out.println(arr.gcd());



    }
}

