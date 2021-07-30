package amazon;

import java.util.Vector;

public class PermutationsOf2NumsUpTo10Digits {

    // Function to generate permutations of
// at most X elements from array arr[]
    static void differentFlagPermutations(int X,
                                          String[] arr)
    {
        String[] ml = arr;

        for(int i = 0; i < ml.length; i++)
        {
            System.out.print(ml[i] + " ");
        }

        int count = ml.length;

        // Traverse all possible lengths
        for(int z = 0; z < X - 1; z++)
        {

            // Stores all combinations
            // of length z
            Vector<String> tmp = new Vector<String>();

            // Traverse the array
            for(int i = 0; i < arr.length; i++)
            {
                for(int k = 0; k < ml.length; k++)
                {
                    if (arr[i] != ml[k])
                    {

                        // Generate all
                        // combinations of length z
                        tmp.add(ml[k] + arr[i]);
                        count += 1;
                    }
                }
            }

            // Print all combinations of length z
            for(int i = 0; i < tmp.size(); i++)
            {
                System.out.print(tmp.get(i) + " ");
            }

            // Replace all combinations of length z - 1
            // with all combinations of length z
            ml = tmp.toArray(new String[tmp.size()]);;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Given array
        String[]arr = { "1", "2" };

        // Given X
        int X = 10;
        differentFlagPermutations(X, arr);
    }

}
