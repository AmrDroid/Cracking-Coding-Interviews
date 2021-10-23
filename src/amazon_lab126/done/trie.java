package amazon_lab126.done;


public class trie {

    static class Trie {
        boolean eow;
        Trie[] children = new Trie[26];

        Trie() {
            for (int i = 0; i < 26; i++)
                children[i] = null;
            eow = false;
        }
    }

    Trie root;
    int index;

    void insert(String str) {
        Trie pCrawl = root;
        for (int i = 0; i < str.length(); i++) {
            int index = (str.charAt(i) - 'a');
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new Trie();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.eow = true;
    }

    boolean search(String str) {
        Trie pCrawl = root;
        for (int i = 0; i < str.length(); i++) {
            int index = (str.charAt(i) - 'a');
            if (pCrawl.children[index] == null) return false;
        }
        return true;
    }

    void construct(String arr[]) {
        root = new Trie();
        for (String w : arr)
            insert(w);
        System.out.println(walkTrie());
    }

    int countChild(Trie pCrawl) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (pCrawl.children[i] != null) {
                index = i;
                count++;
            }
        }
        return count;
    }

    String walkTrie() {
        String res = "";
        Trie pCrawl = root;
        while (countChild(pCrawl) == 1 && pCrawl.eow == false) {
            res += (char) (index + 'a');
            pCrawl=pCrawl.children[index];
        }
        return res;
    }


    public static void main(String args[]) {
        String arr[] = {"geksforgeeks", "gekeks", "gek", "geezer"};
        int n = arr.length;
        trie t = new trie();
        t.construct(arr);


    }


}
