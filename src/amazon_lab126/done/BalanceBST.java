package amazon_lab126.done;

import java.util.*;

/* A binary tree balanceNode has data, pointer to left child
   and a pointer to right child */
class balanceNode
{
    int data;
    balanceNode left, right;

    public balanceNode(int data)
    {
        this.data = data;
        left = right = null;
    }
}

class BalanceBST
{
    balanceNode root;

    /* This function traverse the skewed binary tree and
       stores its balanceNodes pointers in vector balanceNodes[] */
    void storeBSTbalanceNodes(balanceNode root, Vector<balanceNode> balanceNodes)
    {
        // Base case
        if (root == null)
            return;

        // Store balanceNodes in Inorder (which is sorted
        // order for BST)
        storeBSTbalanceNodes(root.left, balanceNodes);
        balanceNodes.add(root);
        storeBSTbalanceNodes(root.right, balanceNodes);
    }

    /* Recursive function to construct binary tree */
    balanceNode buildTreeUtil(Vector<balanceNode> balanceNodes, int start, int end)
    {
        // base case
        if (start > end)
            return null;

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        balanceNode balanceNode = balanceNodes.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtress */
        balanceNode.left = buildTreeUtil(balanceNodes, start, mid - 1);
        balanceNode.right = buildTreeUtil(balanceNodes, mid + 1, end);

        return balanceNode;
    }

    // This functions converts an unbalanced BST to
    // a balanced BST
    balanceNode buildTree(balanceNode root)
    {
        // Store balanceNodes of given BST in sorted order
        Vector<balanceNode> balanceNodes = new Vector<balanceNode>();
        storeBSTbalanceNodes(root, balanceNodes);

        // Constucts BST from balanceNodes[]
        int n = balanceNodes.size();
        return buildTreeUtil(balanceNodes, 0, n - 1);
    }

    /* Function to do preorder traversal of tree */
    void preOrder(balanceNode balanceNode)
    {
        if (balanceNode == null)
            return;
        System.out.print(balanceNode.data + " ");
        preOrder(balanceNode.left);
        preOrder(balanceNode.right);
    }

    // Driver program to test the above functions
    public static void main(String[] args)
    {
         /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        BalanceBST tree = new BalanceBST();
        tree.root = new balanceNode(10);
        tree.root.left = new balanceNode(8);
        tree.root.left.left = new balanceNode(7);
        tree.root.left.left.left = new balanceNode(6);
        tree.root.left.left.left.left = new balanceNode(5);

        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }
}


