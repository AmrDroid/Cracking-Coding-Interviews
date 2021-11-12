package amazon.done;


class evNode {

    int data;
    evNode left, right;

    evNode(int d)
    {
        data = d;
        left = right = null;
    }
}

class AddAllGreaterValuesEveryNodeGivenBST {

    // Root of BST
    evNode root;

    // Constructor
    AddAllGreaterValuesEveryNodeGivenBST()
    {
        root = null;
    }

    // Inorder traversal of the tree
    void inorder()
    {
        inorderUtil(this.root);
    }

    // Utility function for inorder traversal of
    // the tree
    void inorderUtil(evNode evNode)
    {
        if (evNode == null)
            return;

        inorderUtil(evNode.left);
        System.out.print(evNode.data + " ");
        inorderUtil(evNode.right);
    }

    // adding new evNode
    public void insert(int data)
    {
        this.root = this.insertRec(this.root, data);
    }

    /* A utility function to insert a new evNode with
    given data in BST */
    evNode insertRec(evNode evNode, int data)
    {
        /* If the tree is empty, return a new evNode */
        if (evNode == null) {
            this.root = new evNode(data);
            return this.root;
        }

        /* Otherwise, recur down the tree */
        if (data <= evNode.data) {
            evNode.left = this.insertRec(evNode.left, data);
        }
        else {
            evNode.right = this.insertRec(evNode.right, data);
        }
        return evNode;
    }

    // This class initialises the value of sum to 0
    public class Sum {
        int sum = 0;
    }

    // Recursive function to add all greater values in
    // every evNode
    void modifyBSTUtil(evNode evNode, Sum S)
    {
        // Base Case
        if (evNode == null)
            return;

        // Recur for right subtree
        this.modifyBSTUtil(evNode.right, S);

        // Now *sum has sum of evNodes in right subtree, add
        // root->data to sum and update root->data
        S.sum = S.sum + evNode.data;
        evNode.data = S.sum;

        // Recur for left subtree
        this.modifyBSTUtil(evNode.left, S);
    }

    // A wrapper over modifyBSTUtil()
    void modifyBST(evNode evNode)
    {
        Sum S = new Sum();
        this.modifyBSTUtil(evNode, S);
    }

    // Driver Function
    public static void main(String[] args)
    {
        AddAllGreaterValuesEveryNodeGivenBST tree = new AddAllGreaterValuesEveryNodeGivenBST();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.modifyBST(tree.root);

        // print inorder traversal of the modified BST
        tree.inorder();
    }
}

