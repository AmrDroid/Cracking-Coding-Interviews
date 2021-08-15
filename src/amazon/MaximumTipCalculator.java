package amazon;

public class MaximumTipCalculator {
    // Function that finds the maximum tips
// from the given arrays as per the
// given conditions
    //https://www.geeksforgeeks.org/maximum-tip-calculator-2/
    static int maximumTip(int []arr1,int []arr2,
                          int n, int x, int y)
    {

        // Base Condition
        if (n == 0)
            return 0;

        // If both have non-zero count then
        // return max element from both array
        if (x != 0 && y != 0)
            return Math.max(
                    arr1[n - 1] + maximumTip(arr1, arr2, n - 1,
                            x - 1, y),
                    arr2[n - 1] + maximumTip(arr1, arr2, n - 1, x,
                            y - 1));

        // Traverse first array, as y
        // count has become 0
        if (y == 0)
            return arr1[n - 1] + maximumTip(arr1, arr2, n - 1,
                    x - 1, y);

            // Traverse 2nd array, as x
            // count has become 0
        else
            return arr2[n - 1] + maximumTip(arr1, arr2, n - 1,
                    x, y - 1);
    }

    // Drive Code
    public static void main (String[] args) {
        int N = 5;
        int X = 3;
        int Y = 3;

        int A[] = { 1, 2, 3, 4, 5 };
        int B[] = { 5, 4, 3, 2, 1 };

        // Function Call

        System.out.println(maximumTip(A, B, N, X, Y));
    }
}

