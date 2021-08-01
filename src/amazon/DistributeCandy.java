package amazon;

public class DistributeCandy {

    // Function to find out the number of
    // candies every person received
    static void candies(int n, int k)
    {

        // Count number of complete turns
        int count = 0;

        // Get the last term
        int ind = 1;

        // Stores the number of candies
        int []arr=new int[k];

        for(int i=0;i<k;i++)
            arr[i]=0;


        int low = 0, high = n;

        // Do a binary search to find the number whose
        // sum is less than N.
        while (low <= high) {

            // Get mide
            int mid = (low + high) >> 1;
            int sum = (mid * (mid + 1)) >> 1;

            // If sum is below N
            if (sum <= n) {

                // Find number of complete turns
                count = mid / k;

                // Right halve
                low = mid + 1;
            }
            else {

                // Left halve
                high = mid - 1;
            }
        }

        // Last term of last complete series
        int last = (count * k);

        // Subtract the sum till
        n -= (last * (last + 1)) / 2;

        int j = 0;

        // First term of incomplete series
        int term = (count * k) + 1;

        while (n > 0) {
            if (term <= n) {
                arr[j++] = term;
                n -= term;
                term++;
            }
            else {
                arr[j] += n;
                n = 0;
            }
        }

        // Count the total candies
        for (int i = 0; i < k; i++)
            arr[i] += (count * (i + 1))
                    + (k * (count * (count - 1)) / 2);

        // Print the total candies
        for (int i = 0; i < k; i++)
            System.out.print( arr[i] + " " );
    }

    // Driver Code
    public static void main(String []args)
    {
        int n = 7, k = 4;
        candies(n, k);

    }

//https://leetcode.com/problems/candy/
    public int candy(int[] ratings) {
        int sum = 0;
        if (ratings.length == 0)
            return sum;
        int[] lc = new int[ratings.length];
        int[] rc = new int[ratings.length];
        for (int i = 0 ; i < ratings.length; i++)
            lc[i] = rc[i] = 1;
        for (int i = 0 ; i < ratings.length-1; i++){
            if (ratings[i] < ratings[i+1])
                lc[i+1] = lc[i] + 1;
        }
        for (int i = ratings.length-1 ; i > 0 ; i--){
            if (ratings[i-1] > ratings[i])
                rc[i-1] = rc[i] + 1;
        }
        for (int i = 0 ; i < ratings.length ; i++){
            sum += max(lc[i] , rc[i]);
        }
        return sum;
    }

    private int max(int a , int b){
        return a > b ? a : b;
    }


}
