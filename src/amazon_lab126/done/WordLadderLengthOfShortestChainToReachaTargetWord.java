package amazon_lab126.done;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderLengthOfShortestChainToReachaTargetWord {

//    Time complexity: O(n²m), where m is the number of entries originally in the dictionary and n is the size of the string.
//
//    Auxiliary Space:O(m*n), where m are the strings are stored in queue.
//    So the space Complexity is O(m*n).

    // Returns length of shortest chain
// to reach 'target' from 'start'
// using minimum number of adjacent moves.
// D is dictionary
    static int shortestChainLen(String start, String target, Set<String> D) {

        if (start == target)
            return 0;
        // If the target String is not
        // present in the dictionary
        if (!D.contains(target))
            return 0;

        // To store the current chain length// and the length of the words
        int level = 0, wordlength = start.length();

        // Push the starting word into the queue
        Queue<String> Q = new LinkedList<>();
        Q.add(start);

        // While the queue is non-empty
        while (!Q.isEmpty()) {
            // Increment the chain length
            ++level;
            int sizeofQ = Q.size();
            // Since the queue is being updated while// it is being traversed so only the// elements which were already present// in the queue before the start of this// loop will be traversed for now
            for (int i = 0; i < sizeofQ; ++i) {
                // Remove the first word from the queue
                char[] word = Q.peek().toCharArray();
                Q.remove();
                // For every character of the word
                for (int pos = 0; pos < wordlength; ++pos) {
                    // Retain the original character// at the current position
                    char orig_char = word[pos];
                    // Replace the current character with// every possible lowercase alphabet
                    for (char c = 'a'; c <= 'z'; ++c) {
                        word[pos] = c;
                        // If the new word is equal// to the target word
                        if (String.valueOf(word).equals(target))
                            return level + 1;
                        // Remove the word from the set// if it is found in it
                        if (!D.contains(String.valueOf(word)))
                            continue;
                        D.remove(String.valueOf(word));
                        // And push the newly generated word// which will be a part of the chain
                        Q.add(String.valueOf(word));
                    }
                    // Restore the original character// at the current position
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }

    // Driver code
    public static void main(String[] args) {
        // make dictionary
        Set<String> D = new HashSet<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        //  System.out.println("Length of shortest chain is: " + shortestChainLen(start, target, D));
        System.out.print("Length of shortest chain is: " + shortest(start, target, D));
    }

    static int shortest(String source, String targer, Set<String> set) {

        Queue<String> q = new LinkedList<>();
        q.add(source);
        int level = 0;
        int wordlen = source.length();
        while (!q.isEmpty()) {
            int qSize = q.size();
            level++;
            for (int i = 0; i < qSize; i++) {
                char[] word = q.peek().toCharArray();
                q.remove();
                for (int j = 0; j < wordlen; j++) {
                    char temp = word[j];
                    for (char z = 'a'; z <= 'z'; z++) {


                        word[j] = (char) z;
                        if (String.valueOf(word).equals(targer))
                            return level + 1;

                        if (!set.contains(String.valueOf(word)))
                            continue;
                        set.remove(String.valueOf(word));
                        q.add(String.valueOf(word));
                    }
                    word[j] = temp;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
