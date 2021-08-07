package amazon;

public class MaximumProductTripletsubsequenceSize3 {
    // Function to find a maximum product of
// a triplet in array of integers of size n
    static int maxProduct(int []arr, int n)
    {

        // If size is less than 3, no triplet exists
        if (n < 3)
            return -1;

        // Initialize Maximum, second maximum
        // and third maximum element
        int maxA = Integer.MIN_VALUE,
                maxB = Integer.MIN_VALUE,
                maxC = Integer.MIN_VALUE;

        // Initialize Minimum and
        // second mimimum element
        int minA = Integer.MAX_VALUE,
                minB = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {

            // Update Maximum, second maximum
            // and third maximum element
            if (arr[i] > maxA)
            {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            }

            // Update second maximum and
            // third maximum element
            else if (arr[i] > maxB)
            {
                maxC = maxB;
                maxB = arr[i];
            }

            // Update third maximum element
            else if (arr[i] > maxC)
                maxC = arr[i];

            // Update Minimum and second
            // mimimum element
            if (arr[i] < minA)
            {
                minB = minA;
                minA = arr[i];
            }

            // Update second mimimum element
            else if(arr[i] < minB)
                minB = arr[i];
        }

        return Math.max(minA * minB * maxA,
                maxA * maxB * maxC);
    }

    // Driver code
    public static void main(String[] args)
    {
        int []arr = { 1, -4, 3, -6, 7, 0 };
        int n = arr.length;

        int max = maxProduct(arr, n);

        if (max == -1)
            System.out.print("No Triplet Exists");
        else
            System.out.print("Maximum product is " + max);
    }

}
