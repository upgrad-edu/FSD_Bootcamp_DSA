package recursions.session2;

public class FactorialTailRecursion {

    public int fact(int num , int out){
        if(num==0){
            return out;
        }

        return fact(num-1, out*num);
    }

    public static void main(String[] args) {
        FactorialTailRecursion f = new FactorialTailRecursion();
        f.fact(5,1);
    }
}
