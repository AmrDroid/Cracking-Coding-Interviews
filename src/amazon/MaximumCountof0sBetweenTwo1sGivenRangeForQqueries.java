package amazon;
//https://www.geeksforgeeks.org/maximum-count-of-0s-between-two-1s-in-given-range-for-q-queries/
//Time Complexity: O(N + M)
//        Auxiliary Space: O(N)
//

public class MaximumCountof0sBetweenTwo1sGivenRangeForQqueries {


    // Function to count the number of
    // 0s lying between the two 1s for
    // each query
    static void countOsBetween1s(
            String S, int N, int[][] Q)
    {

        // Stores count of 0's that are
        // right to the most recent 1's
        int[] leftBound = new int[N];

        // Stores count of 0's that are
        // left to the most recent 1's
        int[] rightBound = new int[N];

        // Stores the count of zeros
        // in a prefix/suffix of array
        int count = 0;

        // Stores the count of total 0s
        int total = 0;

        // Traverse the string S
        for (int i = 0; i < N; i++) {

            // If current character is
            // '1'
            if (S.charAt(i) == '1') {
                count = total;
            }

            // Otherwise
            else if (S.charAt(i) == '0') {
                total++;
            }

            // Update the rightBound[i]
            rightBound[i] = count;
        }

        // Update count and total to 0
        count = 0;
        total = 0;

        // Traverse the string S in
        // reverse manner
        for (int i = N - 1; i >= 0; i--) {

            // If current character is
            // '1'
            if (S.charAt(i) == '1') {
                count = total;
            }

            // Otherwise
            else if (S.charAt(i) == '0') {
                total++;
            }

            // Update the leftBound[i]
            leftBound[i] = count;
        }

        // Traverse given query array
        for (int q = 0; q < Q.length; q++) {

            int L = Q[q][0];
            int R = Q[q][1];

            // Update the value of count
            count = leftBound[L] + rightBound[R] - total;

            // Print the count as the
            // result to the current
            // query [L, R]
            System.out.print(count + " ");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        String S = "1001010";
        int Q[][] = { { 0, 4 }, { 0, 5 } };
        int N = S.length();
        countOsBetween1s(S, N, Q);
    }

}
