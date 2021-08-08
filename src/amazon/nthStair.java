package amazon;

public class nthStair {
    //Count ways to reach nth stair. It is similar to fibonacci series. Interviewer
    //
    // asked various ways to implement the same -Recursion, 1-D array, with 3 variables and complexity of each.
    // A recursive function used by countWays
    public static int countWays(int n)
    {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2]
                    + res[i - 3];

        return res[n];
    }

    // Driver function
    public static void main(String argc[])
    {
        int n = 4;
        System.out.println(countWays(n));
    }
}
