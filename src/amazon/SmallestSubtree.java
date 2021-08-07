package amazon;

public class SmallestSubtree {

    // Structure of a Node
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data)
        {
            this.val = data;
            left = null;
            right = null;
        }
    };

    // Function to return depth of
// the Tree from root
    static int find_ht(TreeNode root)
    {
        if (root == null)
            return 0;

        // If current node is a leaf node
        if (root.left == null
                && root.right == null)
            return 1;
        return Math.max(find_ht(root.left),
                find_ht(root.right))
                + 1;
    }

    // Function to find the root of the smallest
// subtree consisting of all deepest nodes
    static TreeNode find_node(TreeNode root, TreeNode req_node)
    {
        if (root == null)
            return req_node;

        // Stores height of left subtree
        int left_ht = find_ht(root.left);

        // Stores height of right subtree
        int right_ht = find_ht(root.right);

        // If height of left subtree exceeds
        // that of the right subtree
        if (left_ht > right_ht)
        {

            // Traverse left subtree
            req_node = find_node(root.left, req_node);
        }

        // If height of right subtree exceeds
        // that of the left subtree
        else if (right_ht > left_ht)
        {
            req_node = find_node(root.right, req_node);
        }

        // Otherwise
        else
        {

            // Return current node
            req_node = root;
            return req_node;
        }
        return req_node;
    }

    // Driver Code
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode req_node = null;
        req_node = find_node(root, req_node);
        System.out.print(req_node.val);
    }

}
