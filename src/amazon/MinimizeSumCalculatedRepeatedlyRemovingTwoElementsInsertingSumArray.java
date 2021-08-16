package amazon;

import java.util.PriorityQueue;

public class MinimizeSumCalculatedRepeatedlyRemovingTwoElementsInsertingSumArray {
    // Function to return the minimized sum
    static int getMinSum(int arr[], int n)
    {
        int i, sum = 0;

        // Priority queue to store the elements of the array
        // and retrieve the minimum element efficiently
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all the elements
        // to the prioriry queue
        for (i = 0; i < n; i++)
            pq.add(arr[i]);

        // While there are more than 1 elements
        // left in the queue
        while (pq.size() > 1)
        {

            // Remove and get the minimum
            // element from the queue
            int min = pq.poll();

            // Remove and get the second minimum
            // element (currently minimum)
            int secondMin = pq.poll();

            // Update the sum
            sum += (min + secondMin);

            // Add the sum of the minimum
            // elements to the queue
            pq.add(min + secondMin);
        }

        // Return the minimized sum
        return sum;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {1, 4, 7, 10} ;
        int n = arr.length;
        System.out.print(getMinSum(arr, n));
    }

}
