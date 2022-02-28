package Strings.session2;

import java.util.HashMap;
import java.util.Map;

public class Session2 {


    /**
     * Find the pattern in the given matrix
     */
    private static boolean searchInMatrix(char[][] matrix, int row,
                                  int col, String word) {
        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
        int R = matrix.length;
        int C = matrix[0].length;
        if (matrix[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int k, rd = row + x[dir], cd = col + y[dir];

            for (k = 1; k < len; k++) {
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;
                if (matrix[rd][cd] != word.charAt(k))
                    break;

                rd += x[dir];
                cd += y[dir];
            }

            if (k == len)
                return true;
        }
        return false;
    }

    /**
     * Minimum window substring
     */
    public static String minimumWindowSubstring(String str)
    {
        int n = str.length();
        int distCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (map.containsKey(str.charAt(i)))
            {
                Integer a = map.get(str.charAt(i));
                map.put(str.charAt(i),a+1);
            }
            else
            {
                map.put(str.charAt(i), 1);
            }
        }
        distCount = map.size();
        int size = Integer.MAX_VALUE;
        String res = "";

        for (int i = 0; i < n; i++)
        {
            int count = 0;
            int visited[] = new int[256];
            for(int j = 0; j < 256; j++)
                visited[j] = 0;
            String subStr = "";
            for (int j = i; j < n; j++)
            {
                if (visited[str.charAt(j)] == 0)
                {
                    count++;
                    visited[str.charAt(j)] = 1;
                }
                subStr += str.charAt(j);
                if (count == distCount)
                    break;
            }
            if (subStr.length() < size && count == distCount)
            {
                res = subStr;
                size=res.length();
            }
        }
        return res;
    }
    static void patternSearch(
            char[][] grid,
            String word) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == word.charAt(0) &&
                        searchInMatrix(grid, row, col, word))
                    System.out.println(
                            "pattern found at " + row + ", " + col);
            }
        }
    }

    /**
     * Find all the permutations of a String
     */

    public static void permutation(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swapCharacters(str,l,i);
                permutation(str, l+1, r);
                str = swapCharacters(str,l,i);
            }
        }
    }

    private static  String swapCharacters(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        char[][] arr = {
                {  'A' , 'C' , 'P' , 'R' , 'C' },
                {  'A' , 'C' , 'P' , 'R' , 'C' },
                {  'V' , 'O' , 'V' , 'N' , 'I'  },
                { 'W' , 'G' , 'F' , 'M' , 'N' },
                { 'Q' ,  'A' , 'T' ,  'I' ,  'T' }

        };

        patternSearch(arr, "AAVW");


        String str = "aabcbcdbca";

        System.out.println(minimumWindowSubstring(str));

        String str2 = "ABC";
        permutation(str2, 0 ,str2.length()-1);

    };
}
