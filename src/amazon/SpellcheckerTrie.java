package amazon;
import java.io.*;

// Structure of a Trie node
class TrieNod
{

    // Store address of a character
    TrieNod Trie[];

    // Check if the character is
    // last character of a string or not
    boolean isEnd;

    // Constructor function
    public TrieNod()
    {
        Trie = new TrieNod[256];
        for(int i = 0; i < 256; i++)
        {
            Trie[i] = null;
        }
        isEnd = false;
    }
}

class SpellcheckerTrie{

    // Function to insert a string into Trie
    static void InsertTrie(TrieNod root, String s)
    {
        TrieNod temp = root;

        // Traverse the string, s
        for(int i = 0; i < s.length(); i++)
        {
            if (temp.Trie[s.charAt(i)] == null)
            {

                // Initialize a node
                temp.Trie[s.charAt(i)] = new TrieNod();
            }

            // Update temp
            temp = temp.Trie[s.charAt(i)];
        }

        // Mark the last character of
        // the string to true
        temp.isEnd = true;
    }

    // Function to print suggestions of the string
    static void printSuggestions(TrieNod root, String res)
    {

        // If current character is
        // the last character of a string
        if (root.isEnd == true)
        {
            System.out.print(res + " ");
        }

        // Iterate over all possible
        // characters of the string
        for(int i = 0; i < 256; i++)
        {

            // If current character
            // present in the Trie
            if (root.Trie[i] != null)
            {

                // Insert current character
                // into Trie
                res += (char)i;
                printSuggestions(root.Trie[i], res);
                res = res.substring(0, res.length() - 2);
            }
        }
    }

    // Function to check if the string
// is present in Trie or not
    static boolean checkPresent(TrieNod root, String key)
    {

        // Traverse the string
        for(int i = 0; i < key.length(); i++)
        {

            // If current character not
            // present in the Trie
            if (root.Trie[key.charAt(i)] == null)
            {
                printSuggestions(root, key.substring(0, i));
                return false;
            }

            // Update root
            root = root.Trie[key.charAt(i)];
        }
        if (root.isEnd == true)
        {
            return true;
        }
        printSuggestions(root, key);

        return false;
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Given array of strings
        String str[] = { "gee", "geeks", "ape", "apple",
                "geeksforgeeks" };

        String key = "geeks";

        // Initialize a Trie
        TrieNod root = new TrieNod();

        // Insert strings to trie
        for(int i = 0; i < str.length; i++)
        {
            InsertTrie(root, str[i]);
        }

        if (checkPresent(root, key))
        {
            System.out.println("YES");
        }
    }
}
