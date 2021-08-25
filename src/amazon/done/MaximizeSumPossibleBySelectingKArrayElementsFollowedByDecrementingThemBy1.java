package amazon.done;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.PriorityQueue;

public class MaximizeSumPossibleBySelectingKArrayElementsFollowedByDecrementingThemBy1 {

    public static long maxSum2(int[] arr, int k)
    {
        // Stores the maximum sum
        long max_sum = 0;
        // Create max_heap to get
        // the maximum element
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

        // Update the max_heap
        for (int t : arr)
            max_heap.add(t);

        // Calculate the max_sum
        while (k-- > 0) {
            int tmp = max_heap.poll();
            max_sum += tmp;
            max_heap.add(tmp - 1);
        }

        // Return the maximum sum
        return max_sum;
    }




    // Driver Code
    public static void main(String[] args)
    {
        // Given array arr[]
        int[] arr = { 2, 5 };

        // Given K
        int K = 4;

        // Function Call
        System.out.println(maxSum(arr, K));
    }


    // Function to find maximum possible
    // after adding elements K times and
    // decrementing each added value by 1
    public static long maxSum(int[] arr, int k)
    {
        // Stores the maximum sum
        long max_sum = 0;

       OptionalInt max_element=(Arrays.stream(arr).max());
        // Stores freqency of element
        int[] freq = new int[ max_element.getAsInt()+ 1];

        // Update freqency of array element
        for (int t : arr)
            freq[t]++;
        // Traverse from right to left in
        // freq[] to find maximum sum
        int x=0;
        for (int i = max_element.getAsInt(); i > 0; i--) {
            if (k >= freq[i]) {

                // Update max_sum
                max_sum += i * freq[i];

                // Decrement k
                k -= freq[i];
                freq[i - 1] += freq[i];
            }

            // Update max_sum and break
            else {
                max_sum += i * k;
                break;
            }
        }

        // Return the maximum sum
        return max_sum;
    }
}
