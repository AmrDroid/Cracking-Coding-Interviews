package amazon.done;

import java.util.Arrays;

public class Maximizesumofgivenarraybyrearrangingarraysuchthatthedifferencebetweenadjacentelements {

    // Function to find maximum possible
    // sum after changing the array elements
    // as per the given constraints
    static long maxSum(int[] a) {
        // Length of given array
        int n = a.length;

        // Stores the frequency of
        // elements in given array
        int[] count = new int[n + 1];

        // Update frequency
        for (int x : a)
            count[Math.min(x, n)]++;

        // stores the previously
        // selected integer
        int size = 0;

        // Stores the maximum possible sum
        long ans = 0;
        System.out.println(Arrays.toString(count));
        // Traverse over array count[]
        for (int k = 1; k <= n; k++) {
            // Run loop for each k
            while (count[k] > 0 && size < k) {
                size++;
                ans += size;
                count[k]--;
            }
            // Update ans
            ans += k * count[k];
        }

        // Return maximum possible sum
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        // Given array arr[]
        int[] arr = {3, 5, 1};

        // Function Call
        System.out.println(maxSum(arr));
    }
}
