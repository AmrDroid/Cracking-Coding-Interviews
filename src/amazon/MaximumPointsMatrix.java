package amazon;

public class MaximumPointsMatrix {

    // Function to collect maximum value from the first cell `(0, 0)`
    public static int findMaximum(int[][] mat)
    {
        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;

        // `T[i][j]` stores the maximum value that can be collected
        // from any cell to cell `(i-1, j-1)`
        int[][] T = new int[M+1][N+1];

        // process each row one by one and fill the lookup table `T`
        for (int i = 1; i<= M; i++)
        {
            // handle odd and even row separately
            if ((i & 1) == 1)
            {
                // process current row from left to right
                for (int j = 1; j <= N; j++)
                {
                    if (mat[i-1][j-1] != -1)
                    {
                        T[i][j] = mat[i-1][j-1]
                                + Integer.max(T[i][j-1], T[i-1][j]);
                    }
                }
            }
            else {
                // process current row from right to left
                for (int j = N - 1; j >= 1; j--)
                {
                    if (mat[i-1][j-1] != -1)
                    {
                        T[i][j] = mat[i-1][j-1]
                                + Integer.max(T[i][j+1], T[i-1][j]);
                    }
                }
            }
        }

        // trace maximum ones starting from the first cell
        int i = 1, j = 1;
        int result = T[i][j];

        while (i <= M && j >= 0 && j <= N)
        {
            if (T[i][j] == T[i+1][j] || T[i][j] + 1 == T[i+1][j]) {
                i++;
            }
            else if (T[i][j] == T[i][j+1] || T[i][j] + 1 == T[i][j+1]) {
                j++;
            }
            else if (T[i][j] == T[i][j-1] || T[i][j] + 1 == T[i][j-1]) {
                j--;
            }
            else {
                break;
            }

            result = T[i][j];
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 1, 1, -1, 1, 1 },
                        { 1, 0, 0, -1, 1 },
                        { 1, 1, 1, 1, -1 },
                        { -1, -1, 1, 1, 1 },
                        { 1, 1, -1, -1, 1 }
                };

        System.out.println("The maximum value collected is "
                + findMaximum(mat));
    }

}
