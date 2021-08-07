package amazon;

// Java implementation to find lowest common ancestor of
// n1 and n2 using one traversal of binary tree
// It also handles cases even when n1 and n2 are not there in Tree

/* Class containing left and right child of current ancNode and key */
class ancNode
{
    int data;
    ancNode left, right;

    public ancNode(int item)
    {
        data = item;
        left = right = null;
    }
}

public class LowestCommonAncestor
{
    // Root of the Binary Tree
    ancNode root;
    static boolean v1 = false, v2 = false;

    // This function returns pointer to LCA of two given
    // values n1 and n2.
    // v1 is set as true by this function if n1 is found
    // v2 is set as true by this function if n2 is found
    ancNode findLCAUtil(ancNode ancNode, int n1, int n2)
    {
        // Base case
        if (ancNode == null)
            return null;

        //Store result in temp, in case of key match so that we can search for other key also.
        ancNode temp=null;

        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (ancNode.data == n1)
        {
            v1 = true;
            temp = ancNode;
        }
        if (ancNode.data == n2)
        {
            v2 = true;
            temp = ancNode;
        }

        // Look for keys in left and right subtrees
        ancNode left_lca = findLCAUtil(ancNode.left, n1, n2);
        ancNode right_lca = findLCAUtil(ancNode.right, n1, n2);

        if (temp != null)
            return temp;

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this ancNode is the LCA
        if (left_lca != null && right_lca != null)
            return ancNode;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    // Finds lca of n1 and n2 under the subtree rooted with 'ancNode'
    ancNode findLCA(int n1, int n2)
    {
        // Initialize n1 and n2 as not visited
        v1 = false;
        v2 = false;

        // Find lca of n1 and n2 using the technique discussed above
        ancNode lca = findLCAUtil(root, n1, n2);

        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca;

        // Else return NULL
        return null;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new ancNode(1);
        tree.root.left = new ancNode(2);
        tree.root.right = new ancNode(3);
        tree.root.left.left = new ancNode(4);
        tree.root.left.right = new ancNode(5);
        tree.root.right.left = new ancNode(6);
        tree.root.right.right = new ancNode(7);

        ancNode lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }
}
