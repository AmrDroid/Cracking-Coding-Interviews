package amazon;
class btNode {
    int data;
    btNode left, right;

    public btNode(int item) {
        data = item;
        left = right = null;
    }
}
public class BSTOrNot {



    // Root of the Binary Tree
    btNode root;

    // To keep tract of previous btNode in Inorder Traversal
    btNode prev;

    boolean isBST() {
        prev = null;
        return isBST(root);
    }

    /* Returns true if given search tree is binary
       search tree (efficient version) */
    boolean isBST(btNode btNode) {
        // traverse the tree in inorder fashion and
        // keep a track of previous btNode
        if (btNode != null) {
            if (!isBST(btNode.left))
                return false;

            // allows only distinct values btNode
            if (prev != null && btNode.data <= prev.data)
                return false;
            prev = btNode;
            return isBST(btNode.right);
        }
        return true;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BSTOrNot tree = new BSTOrNot();
        tree.root = new btNode(4);
        tree.root.left = new btNode(2);
        tree.root.right = new btNode(5);
        tree.root.left.left = new btNode(1);
        tree.root.left.right = new btNode(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

    }
}
