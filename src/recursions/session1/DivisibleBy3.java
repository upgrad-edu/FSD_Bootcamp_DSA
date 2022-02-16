package recursions.session1;

public class DivisibleBy3 {


    public int sumDigits(int num){
        if(num/10 == 0){
            return num ;
        }

        return num%10 + sumDigits(num/10);
    }

    public boolean isDivisibleBy3(int num){
        int sumOfDigits = sumDigits(num);

        return sumOfDigits%3==0;
    }


    public static void main(String[] args) {

        DivisibleBy3 obj = new DivisibleBy3();
        System.out.println(obj.sumDigits(87));
        System.out.println(obj.isDivisibleBy3(79));
        System.out.println(obj.isDivisibleBy3(144));
    }
}
