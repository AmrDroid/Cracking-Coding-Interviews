package amazon;

class bNode {
    int data;
    bNode left, right;

    bNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class BoundaryTraversalOfBinaryTree {
    bNode root;

    // A simple function to print leaf bNodes of a binary tree
    void printLeaves(bNode bNode)
    {
        if (bNode == null)
            return;

        printLeaves(bNode.left);
        // Print it if it is a leaf bNode
        if (bNode.left == null && bNode.right == null)
            System.out.print(bNode.data + " ");
        printLeaves(bNode.right);
    }

    // A function to print all left boundary bNodes, except a leaf bNode.
    // Print the bNodes in TOP DOWN manner
    void printBoundaryLeft(bNode bNode)
    {
        if (bNode == null)
            return;

        if (bNode.left != null) {
            // to ensure top down order, print the bNode
            // before calling itself for left subtree
            System.out.print(bNode.data + " ");
            printBoundaryLeft(bNode.left);
        }
        else if (bNode.right != null) {
            System.out.print(bNode.data + " ");
            printBoundaryLeft(bNode.right);
        }

        // do nothing if it is a leaf bNode, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary bNodes, except a leaf bNode
    // Print the bNodes in BOTTOM UP manner
    void printBoundaryRight(bNode bNode)
    {
        if (bNode == null)
            return;

        if (bNode.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this bNode
            printBoundaryRight(bNode.right);
            System.out.print(bNode.data + " ");
        }
        else if (bNode.left != null) {
            printBoundaryRight(bNode.left);
            System.out.print(bNode.data + " ");
        }
        // do nothing if it is a leaf bNode, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(bNode bNode)
    {
        if (bNode == null)
            return;

        System.out.print(bNode.data + " ");

        // Print the left boundary in top-down manner.
        printBoundaryLeft(bNode.left);

        // Print all leaf bNodes
        printLeaves(bNode.left);
        printLeaves(bNode.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(bNode.right);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        BoundaryTraversalOfBinaryTree tree = new BoundaryTraversalOfBinaryTree();
        tree.root = new bNode(20);
        tree.root.left = new bNode(8);
        tree.root.left.left = new bNode(4);
        tree.root.left.right = new bNode(12);
        tree.root.left.right.left = new bNode(10);
        tree.root.left.right.right = new bNode(14);
        tree.root.right = new bNode(22);
        tree.root.right.right = new bNode(25);
        tree.printBoundary(tree.root);
    }
}
