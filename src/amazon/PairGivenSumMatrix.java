package amazon;

import java.util.*;

public class PairGivenSumMatrix {
    // Function to check if a pair with
// given sum exists in the matrix
    static final int N = 4;
    static final int M = 4;
    static boolean isPairWithSum(int [][]mat,
                                 int sum)
    {
        // hash to store elements
        Set<Integer> s = new HashSet<Integer>();

        // looping through elements
        // if present in the matrix
        // return true, else push
        // the element in matrix
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (s.contains(sum - mat[i][j]))
                {
                    return true;
                }
                else
                {
                    s.add(mat[i][j]);
                }
            }
        }

        return false;
    }

    // Driver code
    public static void main(String []args)
    {

        // Input matrix
        int [][]mat = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        // given sum
        int sum = 11;

        if (isPairWithSum(mat, sum))
        {
            System.out.println("YES");
        }
        else
            System.out.println("NO");
    }

}
