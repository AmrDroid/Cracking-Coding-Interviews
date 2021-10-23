package amazon.done;

class bstNode
{
    int data;
    bstNode left, right;

    // A utility function to create a new Binary Tree bstNode
    bstNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class GFG22
{

    static int sum = 0;
    static bstNode Root;

    // Recursive function to transform a BST to sum tree.
    // This function traverses the tree in reverse inorder so
    // that we have visited all greater key bstNodes of the currently
    // visited bstNode
    static void transformTreeUtil(bstNode root)
    {

        // Base case
        if (root == null)
            return;

        // Recur for right subtree
        transformTreeUtil(root.right);

        // Update sum
        sum = sum + root.data;

        // Store old sum in current bstNode
        root.data = sum - root.data;

        // Recur for left subtree
        transformTreeUtil(root.left);
    }

    // A wrapper over transformTreeUtil()
    static void transformTree(bstNode root)
    {

        transformTreeUtil(root);
    }

    // A utility function to print indorder traversal of a
    // binary tree
    static void printInorder(bstNode root)
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // Driver Program to test above functions
    public static void main (String[] args) {

        GFG22.Root = new bstNode(11);
        GFG22.Root.left = new bstNode(2);
        GFG22.Root.right = new bstNode(29);
        GFG22.Root.left.left = new bstNode(1);
        GFG22.Root.left.right = new bstNode(7);
        GFG22.Root.right.left = new bstNode(15);
        GFG22.Root.right.right = new bstNode(40);
        GFG22.Root.right.right.left = new bstNode(35);

        System.out.println("Inorder Traversal of given tree");
        printInorder(Root);

        transformTree(Root);
        System.out.println("\n\nInorder Traversal of transformed tree");
        printInorder(Root);
    }
}
