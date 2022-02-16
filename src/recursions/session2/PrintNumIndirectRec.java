package recursions.session2;

public class PrintNumIndirectRec {


    public void print1(int num, int cN) {
        if (cN > num) {
            return;
        }
        System.out.println(cN);

        print2(num, cN + 1);
    }

    private void print2(int num, int cN) {
        if (cN > num) {
            return;
        }

        System.out.println(cN);

        print1(num, cN + 1);

    }


    public static void main(String[] args) {
        PrintNumIndirectRec p = new PrintNumIndirectRec();

        p.print1(10, 1);
    }
}
