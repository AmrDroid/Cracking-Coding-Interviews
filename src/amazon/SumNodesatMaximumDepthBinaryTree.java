package amazon;

//https://www.geeksforgeeks.org/sum-of-nodes-at-maximum-depth-of-a-binary-tree-set-2/
public class SumNodesatMaximumDepthBinaryTree {

    // Variables to store sum and
// maximum level
    static int sum = 0,
            max_level = Integer.MIN_VALUE;

    // Binary Tree Node
    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    // Utility function to create and
// return a new Binary Tree Node
    static Node createNode(int val)
    {

        Node node = new Node();
        node.data = val;
        node.left = null;
        node.right = null;

        return node;
    }

    // Function to find the sum of
// the node which are present
// at the maximum depth
    static void sumOfNodesAtMaxDepth(Node root,
                                     int level)
    {
        if (root == null)
            return;

        // If the current level exceeds the
        // maximum level, update the max_level
        // as current level.
        if (level > max_level)
        {
            sum = root.data;
            max_level = level;
        }

        // If the max level and current level
        // are same, add the root data to
        // current sum.
        else if (level == max_level)
        {
            sum = sum + root.data;
        }

        // Traverse the left and right subtrees
        sumOfNodesAtMaxDepth(root.left, level + 1);
        sumOfNodesAtMaxDepth(root.right, level + 1);
    }

    // Driver Code
    public static void main(String[] args)
    {
        Node root = null;
        root = createNode(1);
        root.left = createNode(2);
        root.right = createNode(3);
        root.left.left = createNode(4);
        root.left.right = createNode(5);
        root.right.left = createNode(6);
        root.right.right = createNode(7);

        sumOfNodesAtMaxDepth(root, 0);
        System.out.println(sum);
    }
}
