package amazon;

import java.util.Arrays;

public class ValueToBeSubtractedFromArrayElementsToMakeSumOfAllElementsEqualsK {

    static int[] height = new int[]{ 1, 2, 1, 2 };

    // Function to return the amount of wood
    // collected if the cut is made at height m
    public static int woodCollected(int n, int m)
    {
        System.out.println(" a "+m );
        int sum = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            if (height[i] - m <= 0)
                break;
            sum += (height[i] - m);
        }
        return sum;
    }

    // Function that returns Height at
    // which cut should be made
    public static int collectKWood(int n, int k)
    {
        // Sort the heights of the trees
        Arrays.sort(height);

        // The minimum and the maximum// cut that can be made
        int low = 0, high = height[n - 1];

        // Binary search to find the answer
        while (low <= high)
        {
            int mid = low + ((high - low) / 2);
            System.out.println(" aa "+mid );

            // The amount of wood collected
            // when cut is made at the mid
            int collected = woodCollected(n, mid);

            // If the current collected wood is
            // equal to the required amount
            if (collected == k)
                return mid;

            // If it is more than the required amount
            // then the cut needs to be made at a
            // height higher than the current height
            if (collected > k)
                low = mid + 1;

                // Else made the cut at a lower height
            else
                high = mid - 1;
        }
        return -1;
    }

    // Driver code
    public static void main(String[] args)
    {
        int k = 2;
        int n = height.length;
        System.out.print(collectKWood(n,k));
    }

}
