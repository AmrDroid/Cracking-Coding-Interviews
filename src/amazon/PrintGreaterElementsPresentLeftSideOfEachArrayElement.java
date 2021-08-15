package amazon;

import java.util.Collections;
import java.util.TreeSet;

public class PrintGreaterElementsPresentLeftSideOfEachArrayElement {

    // Function to print all greater elements
// on the left of each array element
    static void printGreater(int arr[])
    {
        int n = arr.length;

        // Set to implement
        // self-balancing BSTs
        TreeSet<Integer> s = new TreeSet<>(
                Collections.reverseOrder());

        // Traverse the array
        for(int i = 0; i < n; i++)
        {

            // Insert the current
            // element into the set
            s.add(arr[i]);

            System.out.print(arr[i] + ": ");

            // Iterate through the set
            for(int v : s)
            {
                if (v == arr[i])
                    break;

                // Print the element
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 5, 3, 9, 0, 16, 12 };
        printGreater(arr);
    }
}
