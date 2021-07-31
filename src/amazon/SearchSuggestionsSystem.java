package amazon;

import java.util.*;

class Node1 {
    char c;
    Map<Character, Node1> children;
    PriorityQueue<String> possibleWords;

    public Node1(char c) {
        this.c = c;
        children = new HashMap<>();
        possibleWords = new PriorityQueue<>(Comparator.reverseOrder());
    }
}
public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node1 root = new Node1('-');
        for (String product : products) {
            addProduct(product, root);
        }
        List<List<String>> list = new ArrayList<>();
        Node1 curr = root;
        boolean notFound = false;
        for (char c : searchWord.toCharArray()) {
            if (notFound) {
                list.add(new ArrayList<>());
            }
            else {
                if (!curr.children.containsKey(c)) {
                    notFound = true;
                    list.add(new ArrayList<>());
                    continue;
                }
                curr = curr.children.get(c);
                List<String> temp = new ArrayList<>();
                PriorityQueue<String> words = new PriorityQueue<>(curr.possibleWords);
                for (int i = 0; i < 3 && !words.isEmpty(); i++) {
                    temp.add(words.poll());
                }
                Collections.reverse(temp);
                list.add(temp);
            }
        }
        return list;
    }

    private void addProduct(String product, Node1 root) {
        Node1 curr = root;
        for (int i = 0; i < product.length(); i++) {
            if (!curr.children.containsKey(product.charAt(i))) {
                curr.children.put(product.charAt(i), new Node1(product.charAt(i)));
            }
            curr = curr.children.get(product.charAt(i));
            curr.possibleWords.add(product);
            if (curr.possibleWords.size() > 3) {
                curr.possibleWords.poll();
            }
        }
    }
}

