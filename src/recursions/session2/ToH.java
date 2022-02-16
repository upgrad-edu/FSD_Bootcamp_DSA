package recursions.session2;

public class ToH {


    public int moves(int n, char start, char end, char aux) {
        if (n == 0 || n == 1) {
            return n;
        }

        return moves(n - 1, start, aux, end) + 1 + moves(n - 1, aux, end, start);
    }


    public static void main(String[] args) {
        ToH t = new ToH();
        t.moves(3,'S', 'E', 'A');
    }
}