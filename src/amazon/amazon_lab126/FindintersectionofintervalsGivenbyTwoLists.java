package amazon.amazon_lab126;

public class FindintersectionofintervalsGivenbyTwoLists
{
//Intersection of two arrays (...optimize it)

    // Function to print intersecting intervals
    static void printIntervals(int arr1[][],
                               int arr2[][])
    {

        // i and j pointers for arr1 and
        // arr2 respectively
        int i = 0, j = 0;

        int n = arr1.length, m = arr2.length;

        // Loop through all intervals unless
        // one of the interval gets exhausted
        while (i < n && j < m)
        {

            // Left bound for intersecting segment
            int l = Math.max(arr1[i][0], arr2[j][0]);

            // Right bound for intersecting segment
            int r = Math.min(arr1[i][1], arr2[j][1]);

            // If segment is valid print it
            if (l <= r)
                System.out.println("{" + l + ", " +
                        r + "}");

            // If i-th interval's right bound is
            // smaller increment i else increment j
            if (arr1[i][1] < arr2[j][1])
                i++;
            else
                j++;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr1[][] = { { 0, 4 }, { 5, 10 },
                { 13, 20 }, { 24, 25 } };

        int arr2[][] = { { 1, 5 }, { 8, 12 },
                { 15, 24 }, { 25, 26 } };

        printIntervals(arr1, arr2);
    }
}
