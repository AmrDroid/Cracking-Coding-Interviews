package amazon.done;

import java.util.Arrays;

public class AllUniqueTripletsthatSumuptoGivenValue
//        Time Complexity: O(n2).
//        Since two nested loops is required, so the time complexity is O(n2).
//        Auxiliary Space: O(1).

{
    // Function to all find unique triplets
    // without using extra space
    public static void findTriplets(int a[], int n, int sum)
    {
        int i;

        // Sort the input array
        Arrays.sort(a);

        // For handling the cases when no such
        // triplets exits.
        boolean flag = false;

        // Iterate over the array from start to n-2.
        for (i = 0; i < n - 2; i++)
        {
            if (i == 0 || a[i] > a[i - 1])
            {
                // Index of the first element in
                // remaining range.
                int start = i + 1;

                // Index of the last element
                int end = n - 1;

                // Setting our new target
                int target = sum - a[i];

                while (start < end)
                {
                    // Checking if current element
                    // is same as previous
                    if (start > i + 1 && a[start] == a[start - 1])
                    {
                        start++;
                        continue;
                    }
                    // Checking if current element is
                    // same as previous
                    if (end < n - 1 && a[end] == a[end + 1])
                    {
                        end--;
                        continue;
                    }
                    // If we found the triplets then print it
                    // and set the flag
                    if (target == a[start] + a[end])
                    {
                        System.out.print("[" + a[i] + "," + a[start] + "," + a[end] + "] ");
                        flag = true;
                        start++;
                        end--;
                    }
                    // If target is greater then
                    //  increment the start index
                    else if (target > (a[start] + a[end]))
                    {
                        start++;
                    }
                    // If target is smaller than
                    // decrement the end index
                    else {
                        end--;
                    }
                }
            }
        }

        // If no such triplets found
        if (flag == false) {
            System.out.print("No Such Triplets Exist");
        }
    }

    public static void main(String[] args) {
        int a[] = { 12, 3, 6, 1, 6, 9 };
        int n = a.length;
        int sum = 24;

        // Function call
        findTriplets(a, n, sum);
    }
}

// This code is contributed by divyeshrabadiy