package amazon.done;

import java.util.*;
import java.util.LinkedList;

public class AntiClockwiseSpiralRraversalOfBinaryTree {
    // Structure of each node
    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private void work(Node root) {
        // Initialize queue
        Queue<Node> q = new LinkedList<>();

        // Add the root node
        q.add(root);

        // Initialize the vector
        Vector<Node> topone = new Vector<>();

        // Until queue is not empty
        while (!q.isEmpty()) {
            int len = q.size();

            // len is greater than zero
            while (len > 0) {
                Node nd = q.poll();
                if (nd != null) {
                    topone.add(nd);
                    if (nd.right != null)
                        q.add(nd.right);
                    if (nd.left != null)
                        q.add(nd.left);
                }
                len--;
            }
            topone.add(null);
        }
        boolean top = true;
        int l = 0, r = topone.size() - 2;
//        for (Node j : topone)
//            if(j==null) System.out.println("null");
//            else System.out.println(j.val);

        while (l < r) {
            if (top) {
                while (l < topone.size()) {
                    Node nd = topone.get(l++);
                    if (nd == null) {
                        break;
                    }
                    System.out.print(nd.val + " ");
                }
            } else {
                while (r >= l) {
                    Node nd = topone.get(r--);
                    if (nd == null)
                        break;
                    System.out.print(nd.val + " ");
                }
            }
            top = !top;
        }
    }

    // Build Tree
    public void solve() {
        /*
                            1
                         2     3
                       4     5   7
                     10 11        8
                    */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.left.left.left = new Node(10);
        root.left.left.right = new Node(11);
        root.right.right.left = new Node(8);

        // Function call
        work(root);
    }

    // Driver Code
    public static void main(String[] args) {
        AntiClockwiseSpiralRraversalOfBinaryTree t = new AntiClockwiseSpiralRraversalOfBinaryTree();
        t.solve();
    }
}
