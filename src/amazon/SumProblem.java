package amazon;

import java.util.Arrays;

class SumProblem
{

    // Function to find pair with largest
// sum which is less than K in the array
    static void Max_Sum(int arr[], int n, int k)
    {
        // To store the break point
        int p = n;

        // Sort the given array
        Arrays.sort(arr);

        // Find the break point
        for (int i = 0; i < n; i++)
        {
            // No need to look beyond i'th index
            if (arr[i] >= k)
            {
                p = i;
                break;
            }
        }

        int maxsum = 0, a = 0, b = 0;

        // Find the required pair
        for (int i = 0; i < p; i++)
        {
            for (int j = i + 1; j < p; j++)
            {
                if (arr[i] + arr[j] < k )//&& arr[i] + arr[j] > maxsum)
                {
                    maxsum = arr[i] + arr[j];
                    System.out.println(arr[i]+"  "+arr[j]);
                }
            }
        }
    }

    // Driver code
    public static void main (String[] args)
    {
        int []arr = {5, 20, 110, 100, 10};
        int k = 85;

        int n = arr.length;

        // Function call
        Max_Sum(arr, n, k);
    }
}
