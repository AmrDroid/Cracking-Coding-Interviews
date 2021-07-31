package amazon;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode(int v)
    {
        val = v;
        children = new ArrayList<TreeNode>();
    }
}

class GFG {

    // Stores the result
    static double ans = 0.0;

    // Function for finding maximum
    // subtree average
    public static double[] MaxAverage(
            TreeNode root) {

        // Checks if current node is not
        // null and doesn't have any children
        if (root.children != null
                && root.children.size() == 0) {
            ans = Math.max(ans, root.val);
            return new double[]{root.val, 1};
        }

        // Stores sum of its subtree in index 0
        // and count number of nodes in index 1
        double[] childResult = new double[2];

        // Traverse all children of the current node
        for (TreeNode child : root.children) {

            // Recursively calculate max average
            // of subtrees among its children
            double[] childTotal
                    = MaxAverage(child);

            // Increment sum by sum
            // of its child's subtree
            childResult[0]
                    = childResult[0] + childTotal[0];

            // Increment number of nodes
            // by its child's node
            childResult[1]
                    = childResult[1] + childTotal[1];
        }

        // Increment sum by current node's value
        double sum = childResult[0] + root.val;

        // Increment number of
        // nodes by one
        double count = childResult[1] + 1;

        // Take maximum of ans and
        // current node's average
        ans = Math.max(ans, sum / count);

        // Finally return pair of {sum, count}
        return new double[]{sum, count};
    }

    // Driver Code
    public static void main(String[] args) {

        // Given tree
        TreeNode root = new TreeNode(20);
        TreeNode left = new TreeNode(12);
        TreeNode right = new TreeNode(18);
        root.children.add(left);
        root.children.add(right);
        left.children.add(new TreeNode(11));
        left.children.add(new TreeNode(3));
        right.children.add(new TreeNode(15));
        right.children.add(new TreeNode(8));

        // Function call
        MaxAverage(root);

        // Print answer
        System.out.println(ans);
    }
}