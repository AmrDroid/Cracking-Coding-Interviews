package amazon.done;

public class FindInstancesAtEndOfTimeFrameAfterAutoCcaling {

    public static void finalInstances(int instances, int[] arr)
    {
        int i = 0;

        // Traverse the array, arr[]
        while (i < arr.length)
        {

            // If current element is less
            // than 25
            if (arr[i] < 25 && instances > 1)
            {

                // Divide instances by 2
                instances = (instances / 2);
                i = i + 10;
            }
            // If the current element is
            // greater than 60
            else if (arr[i] > 60 && instances <= Math.pow(10, 8))
            {

                // Double the instances
                instances = instances * 2;
                i = i + 10;
            }
            i = i + 1;
        }

        // Print the instances at the end
        // of the traversal
        System.out.println(instances);
    }

    // Driver Code
    public static void main(String args[])
    {
        int instances = 2;
        int[] arr = { 25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80 };

        // Function Call
        finalInstances(instances, arr);
    }

}
