package amazon_lab126.done;

import java.util.TreeMap;

class nTreeNode {
    // data members
    private int key;
    private nTreeNode left;
    private nTreeNode right;

    // Accessor methods
    public int key() {
        return key;
    }

    public nTreeNode left() {
        return left;
    }

    public nTreeNode right() {
        return right;
    }

    // Constructor
    public nTreeNode(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    // Methods to set left and right subtrees
    public void setLeft(nTreeNode left) {
        this.left = left;
    }

    public void setRight(nTreeNode right) {
        this.right = right;
    }
}

// Class for a Binary Tree
class VerticalSumTree {

    private nTreeNode root;

    // Constructors
    public VerticalSumTree() {
        root = null;
    }

    public VerticalSumTree(nTreeNode n) {
        root = n;
    }

    // Method to be called by the consumer classes
    // like amazon_lab126.done.Main class
    public void VerticalSumMain() {
        VerticalSum(root);
    }

    // A wrapper over VerticalSumUtil()
    private void VerticalSum(nTreeNode root) {// base case
        if (root == null) {
            return;
        }
        // Creates an empty TreeMap hM
        TreeMap<Integer, Integer> hM = new TreeMap<Integer, Integer>();
        // Calls the VerticalSumUtil() to store the// vertical sum values in hM
        VerticalSumUtil(root, 0, hM);
        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            System.out.println(hM.entrySet());
        }
    }

    // Traverses the tree in in-order form and builds
    // a hashMap hM that contains the vertical sum
    private void VerticalSumUtil(nTreeNode root, int hD, TreeMap<Integer, Integer> hM) {

        // base case
        if (root == null) {
            return;
        }

        // Store the values in hM for left subtree
        VerticalSumUtil(root.left(), hD - 1, hM);
        // Update vertical sum for hD of this node

        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.key());

        // Store the values in hM for right subtree
        VerticalSumUtil(root.right(), hD + 1, hM);
    }
}

// Driver class to test the verticalSum methods
class Main {

    public static void main(String[] args) {
        /* Create the following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        */
        nTreeNode root = new nTreeNode(1);
        root.setLeft(new nTreeNode(2));
        root.setRight(new nTreeNode(3));
        root.left().setLeft(new nTreeNode(4));
        root.left().setRight(new nTreeNode(5));
        root.right().setLeft(new nTreeNode(6));
        root.right().setRight(new nTreeNode(7));
        VerticalSumTree t = new VerticalSumTree(root);

        System.out.println("Following are the values of" +
                " vertical sums with the positions" +
                " of the columns with respect to root ");
        t.VerticalSumMain();
        vSum(root);
    }

    static void vSum(nTreeNode root) {
        if (root == null) return;


        TreeMap<Integer, Integer> map = new TreeMap<>();
        vSumUtil(root, 0, map);
        if (map.size() > 0)
            System.out.println(map.entrySet());
    }

    private static void vSumUtil(nTreeNode root, int hd, TreeMap<Integer, Integer> map) {

        if (root == null) return;

        vSumUtil(root.left(), hd - 1, map);
        int current = map.get(hd) == null ? 0 : map.get(hd);
        map.put(hd, current + root.key());
        vSumUtil(root.right(), hd + 1, map);


    }

}

