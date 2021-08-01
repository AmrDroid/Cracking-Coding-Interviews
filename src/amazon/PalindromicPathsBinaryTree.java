package amazon;

public class PalindromicPathsBinaryTree {

    static class Node {
        int key;
        Node left, right;
    };

    // Utility function to
// create a new node
    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return (temp);
    }

    // Function to calculate
// the height of the tree
    static int findHeight(Node node)
    {
        // Base Case
        if (node == null)
            return 0;

        // Recursive call to find the height
        // of the left and right child nodes
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return 1 + (leftHeight > rightHeight ?
                leftHeight : rightHeight);
    }

    // Function to check that a String
// is a palindrom  or not
    static boolean isPalindrome(String str)
    {
        // Start from leftmost and
        // rightmost corners of str
        int l = 0;
        int h = str.length() - 1;

        // Keep comparing characters
        // while they are same
        while (h > l)
        {
            if (str.charAt(l++) != str.charAt(h--))
            {
                return false;
            }
        }
        return true;
    }

    // Function to check whether a path
// is a palindromic path or not
    static boolean isPathPal(int []path, int index)
    {
        int i = 0;
        String s = "";

        // Loop to concatenate the
        // data of the tree
        while (i <= index) {
            s += String.valueOf(path[i]);
            i += 1;
        }
        return isPalindrome(s);
    }

    // Function to print the palindromic path
    static void printPalPath(int []path, int index)
    {
        // Loop to print the path
        for (int i = 0; i < index; i++) {
            System.out.print(path[i]+ ", ");
        }
        System.out.println();
    }

    // Function to print all the palindromic
// paths of the binary tree
    static void printPath(Node node,
                          int []path, int index)
    {
        // Base condition
        if (node == null) {
            return;
        }

        // Inserting the current node
        // into the current path
        path[index] = node.key;

        // Recursive call for
        // the left sub tree
        printPath(node.left, path,
                index + 1);

        // Recursive call for
        // the right sub tree
        printPath(node.right, path,
                index + 1);

        // Condition to check that current
        // node is a leaf node or not
        if (node.left == null &&
                node.right == null) {

            // Condition to check that
            // path is palindrome or not
            if (isPathPal(path, index)) {
                printPalPath(path, index + 1);
            }
        }
    }

    // Function to find all the
// palindromic paths of the tree
    static void PalindromicPath(Node node)
    {
        // Calculate the height
        // of the tree
        int height = findHeight(node);
        int []path = new int[height];
        printPath(node, path, 0);
    }

    // Function to create a binary tree
// and print all the Palindromic paths
    static void createAndPrintPalPath(){
    /*       2
          /    \
         6     8
            / \
           8   5
          / \ / \
          1 2 3 8
               /
              2
    */

        // Creation of tree
        Node root = newNode(2);
        root.left = newNode(6);
        root.right = newNode(8);

        root.right.left = newNode(8);
        root.right.right = newNode(5);

        root.right.left.left = newNode(1);
        root.right.left.right = newNode(2);
        root.right.right.left = newNode(3);
        root.right.right.right = newNode(8);
        root.right.right.right.left = newNode(2);

        // Function Call
        PalindromicPath(root);
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Function Call
        createAndPrintPalPath();
    }

}
