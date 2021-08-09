package amazon;

class dfsNode
{
    int key;
    dfsNode left, right;

    public dfsNode(int item)
    {
        key = item;
        left = right = null;
    }
}

class DFSTraversalTree
{
    // Root of Binary Tree
    dfsNode root;

    DFSTraversalTree()
    {
        root = null;
    }

    /* Given a binary tree, print its dfsNodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(dfsNode dfsNode)
    {
        if (dfsNode == null)
            return;

        // first recur on left subtree
        printPostorder(dfsNode.left);

        // then recur on right subtree
        printPostorder(dfsNode.right);

        // now deal with the dfsNode
        System.out.print(dfsNode.key + " ");
    }

    /* Given a binary tree, print its dfsNodes in inorder*/
    void printInorder(dfsNode dfsNode)
    {
        if (dfsNode == null)
            return;

        /* first recur on left child */
        printInorder(dfsNode.left);

        /* then print the data of dfsNode */
        System.out.print(dfsNode.key + " ");

        /* now recur on right child */
        printInorder(dfsNode.right);
    }

    /* Given a binary tree, print its dfsNodes in preorder*/
    void printPreorder(dfsNode dfsNode)
    {
        if (dfsNode == null)
            return;

        /* first print data of dfsNode */
        System.out.print(dfsNode.key + " ");

        /* then recur on left sutree */
        printPreorder(dfsNode.left);

        /* now recur on right subtree */
        printPreorder(dfsNode.right);
    }

    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }

    // Driver method
    public static void main(String[] args)
    {
        DFSTraversalTree tree = new DFSTraversalTree();
        tree.root = new dfsNode(1);
        tree.root.left = new dfsNode(2);
        tree.root.right = new dfsNode(3);
        tree.root.left.left = new dfsNode(4);
        tree.root.left.right = new dfsNode(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}
