package amazon;

import java.util.*;

/* A binary tree Node has key, pointer to left and right
 * children */
class TNode {
    int val;
    TNode left;
    TNode right;
    TNode(int x) { val = x; }
}

class SerializeDeserializeBinaryTree {
    TNode root;

    // Encodes a tree to a single string.
    public static String serialize(TNode root)
    {
        if (root == null) {
            return null;
        }
        Stack<TNode> s = new Stack<>();
        s.push(root);

        List<String> l = new ArrayList<>();
        while (!s.isEmpty()) {
            TNode t = s.pop();
            // If current node is NULL, store marker
            if (t == null) {
                l.add("#");
            }
            else {
                // Else, store current node and recur for
                // its children
                l.add("" + t.val);
                s.push(t.right);
                s.push(t.left);
            }
        }
        return String.join(",", l);
    }

    static int t;

    // Decodes your encoded data to tree.
    public static TNode deserialize(String data)
    {
        if (data == null)
            return null;
        t = 0;
        String[] arr = data.split(",");
        return helper(arr);
    }

    public static TNode helper(String[] arr)
    {
        if (arr[t].equals("#"))
            return null;
        // create node with this item and recur for children
        TNode root
                = new TNode(Integer.parseInt(arr[t]));
        t++;
        root.left = helper(arr);
        t++;
        root.right = helper(arr);
        return root;
    }

    // A simple inorder traversal used for testing the
    // constructed tree
    static void inorder(TNode root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    /* Driver program to test above functions*/
    public static void main(String args[])
    {
        // Let us construct a tree shown in the above figure
        SerializeDeserializeBinaryTree tree = new SerializeDeserializeBinaryTree();
        tree.root = new TNode(20);
        tree.root.left = new TNode(8);
        tree.root.right = new TNode(22);
        tree.root.left.left = new TNode(4);
        tree.root.left.right = new TNode(12);
        tree.root.left.right.left = new TNode(10);
        tree.root.left.right.right = new TNode(14);

        String serialized = serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Let us deserialize the storeed tree into root1
        TNode t = deserialize(serialized);

        System.out.println(
                "Inorder Traversal of the tree constructed from serialized String:");
        inorder(t);
    }
}
