package amazon.amazon_lab126;


import java.util.Arrays;

public class Longest_common_prefix {


    static public String longestCommonPrefix(String[] a) {
        int size = a.length;
        /* if size is 0, return empty string */
        if (size == 0)
            return "";
        if (size == 1)
            return a[0];
        /* sort the array of strings */
        Arrays.sort(a);
        /* find the minimum length from first and last string */
        int end = Math.min(a[0].length(), a[size - 1].length());
        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size - 1].charAt(i))
            i++;

        String pre = a[0].substring(0, i);
        return pre;
    }

    // Driver program to test above function
    public static void main(String args[]) {
        String arr[] = {"geksforgeeks", "gkeks",
                "gek", "geezer"};
        int n = arr.length;

        System.out.println(longestCommonPrefix(arr));
////////////////////////////////////////////////////////////////
        String ans = commonPrefix(arr, n);

        if (ans.length() != 0)
            System.out.println("The longest common prefix is " + ans);
        else
            System.out.println("There is no common prefix");


    }


//Time Complexity : Inserting all the words in the trie takes O(MN) time and performing a walk on the trie takes O(M) time, where-
//
//        N = Number of strings
//        M = Length of the largest string
//        Auxiliary Space: To store all the strings we need to allocate O(26*M*N) ~ O(MN) space for the Trie.


    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isLeaf is true if the node represents
        // end of a word
        boolean isLeaf;

        // constructor
        public TrieNode() {
            isLeaf = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    ;

    static TrieNode root;
    static int indexs;

    // If not present, inserts the key into the trie
    // If the key is a prefix of trie node, just marks
    // leaf node
    static void insert(String key) {
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isLeaf = true;
    }

    // Counts and returns the number of children of the
    // current node
    static int countChildren(TrieNode node) {
        int count = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                count++;
                indexs = i;
            }
        }
        return (count);
    }

    // Perform a walk on the trie and return the
    // longest common prefix string
    static String walkTrie() {
        TrieNode pCrawl = root;
        indexs = 0;
        String prefix = "";

        while (countChildren(pCrawl) == 1 && pCrawl.isLeaf == false) {
            pCrawl = pCrawl.children[indexs];
            prefix += (char) ('a' + indexs);
        }
        return prefix;
    }

    // A Function to construct trie
    static void constructTrie(String arr[], int n) {
        for (int i = 0; i < n; i++)
            insert(arr[i]);
        return;
    }

    // A Function that returns the longest common prefix
    // from the array of strings
    static String commonPrefix(String arr[], int n) {
        root = new TrieNode();
        constructTrie(arr, n);

        // Perform a walk on the trie
        return walkTrie();
    }

}
