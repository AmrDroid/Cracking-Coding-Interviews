package amazon;

import java.util.HashSet;

public class Checkcontainscontiguous {
    static Boolean areElementsContiguous(int arr[], int n)
    {
        // Storing elements of 'arr[]' in
        // a hash table 'us'
        HashSet<Integer> us = new HashSet<Integer>();

        for (int i = 0; i < n; i++)
            us.add(arr[i]);

        // As arr[0] is present in 'us'
        int count = 1;

        // Starting with previous smaller
        // element of arr[0]
        int curr_ele = arr[0] - 1;

        // If 'curr_ele' is present in 'us'
        while (us.contains(curr_ele) == true) {

            // increment count
            count++;

            // update 'curr_ele"
            curr_ele--;
        }

        // Starting with next greater
        // element of arr[0]
        curr_ele = arr[0] + 1;

        // If 'curr_ele' is present in 'us'
        while (us.contains(curr_ele) == true) {

            // increment count
            count++;

            // update 'curr_ele"
            curr_ele++;
        }

        // Returns true if array contains a set of
        // contiguous integers else returns false
        return (count == (us.size()));
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 5, 2, 3, 6, 4, 4, 6, 6 };
        int n = arr.length;

        if (areElementsContiguous(arr, n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
