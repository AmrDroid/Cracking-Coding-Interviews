package amazon;

import java.util.*;

public class CountAnagerm {
    static String sortString(String inputString) {

        // Convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // Sort tempArray
        Arrays.sort(tempArray);

        // Return new sorted string
        return new String(tempArray);
    }

    // Function to return the
// count of anagrams
    static void count(String arr1[],
                      String arr2[],
                      int n, int m) {

        // Store the frequencies
        // of Strings in arr1[]
        HashMap<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {

            // Sort the String
            arr1[i] = sortString(arr1[i]);

            // Increase its frequency
            // in the map
            if (freq.containsKey(arr1[i])) {
                freq.put(arr1[i],
                        freq.get(arr1[i]) + 1);
            } else {
                freq.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < m; i++) {

            // Sort the String
            arr2[i] = sortString(arr2[i]);

            // Display its anagrams
            // in arr1[]
            System.out.print(freq.get(arr2[i]) + " ");
        }
    }

    // Driver Code
    public static void main(String[] args) {
        String arr1[] = {"geeks", "learn", "for", "egeks", "ealrn"};
        int n = arr1.length;

        String arr2[] = {"kgees", "rof", "nrael"};
        int m = arr2.length;

        count(arr1, arr2, n, m);
    }

}
