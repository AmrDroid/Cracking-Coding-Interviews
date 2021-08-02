package amazon;

import java.util.*;

public class FourArraySumElementEqualX {
    static int countQuadruples(int arr1[], int arr2[], int arr3[],
                               int arr4[], int n, int x)
    {
        int count = 0;

        // unordered_map 'um' implemented as hash table
        // for <sum, frequency> tuples
        Map<Integer,Integer> m = new HashMap<>();

        // count frequency of each sum obtained from the
        // pairs of arr1[] and arr2[] and store them in 'um'
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(m.containsKey(arr1[i] + arr2[j]))
                    m.put((arr1[i] + arr2[j]), m.get((arr1[i] + arr2[j]))+1);
                else
                    m.put((arr1[i] + arr2[j]), 1);

        // generate pair from arr3[] and arr4[]
        for (int k = 0; k < n; k++)
            for (int l = 0; l < n; l++)
            {

                // calculate the sum of elements in
                // the pair so generated
                int p_sum = arr3[k] + arr4[l];

                // if 'x-p_sum' is present in 'um' then
                // add frequency of 'x-p_sum' to 'count'
                if (m.containsKey(x - p_sum))
                    count += m.get(x - p_sum);
            }

        // required count of quadruples
        return count;
    }

    // Driver program to test above
    public static void main(String[] args)
    {
        // four sorted arrays each of size 'n'
        int arr1[] = { 1, 4, 5, 6 };
        int arr2[] = { 2, 3, 7, 8 };
        int arr3[] = { 1, 4, 6, 10 };
        int arr4[] = { 2, 4, 7, 8 };

        int n = arr1.length;
        int x = 30;
        System.out.println("Count = "
                + countQuadruples(arr1, arr2, arr3, arr4, n, x));
    }

}
