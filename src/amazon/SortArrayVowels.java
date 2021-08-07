package amazon;

import java.util.ArrayList;
import java.util.Collections;

public class SortArrayVowels
{

    static class pair
    {
        int first;
        String second;

        pair(int first,String second)
        {
            this.first = first;
            this.second = second;
        }
    }

    // Function to check the Vowel
    static boolean isVowel(char ch)
    {
        ch = Character.toUpperCase(ch);
        return (ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' ||
                ch == 'U');
    }

    // Returns count of vowels in str
    static int countVowels(String str)
    {
        int count = 0;
        for(int i = 0; i < str.length(); i++)

            // Check for vowel
            if (isVowel(str.charAt(i)))
                ++count;

        return count;
    }

    // Function to sort the array according to
// the number of the vowels
    static void sortArr(String arr[], int n)
    {

        // Vector to store the number of vowels
        // with respective elements
        ArrayList<pair> vp = new ArrayList<>();

        // Inserting number of vowels
        // with respective strings
        // in the vector pair
        for(int i = 0; i < n; i++)
        {
            vp.add(new pair(countVowels(arr[i]),
                    arr[i]));
        }

        // Sort the vector, this will sort the pair
        // according to the number of vowels
        Collections.sort(vp, (a, b) -> a.first - b.first);

        // Print the sorted vector content
        for(int i = 0; i < vp.size(); i++)
            System.out.print(vp.get(i).second + " ");
    }

    // Driver code
    public static void main(String[] args)
    {
        String arr[] = { "lmno", "pqrst",
                "aeiou", "xyz" };
        int n = arr.length;

        sortArr(arr, n);
    }

}
