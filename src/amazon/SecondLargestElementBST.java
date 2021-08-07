package amazon;
class fNode {

    int data;
    fNode left, right;

    fNode(int d)
    {
        data = d;
        left = right = null;
    }
}

class SecondLargestElementBST {

    // Root of BST
    fNode root;

    // Constructor
    SecondLargestElementBST()
    {
        root = null;
    }

    // function to insert new fNodes
    public void insert(int data)
    {
        this.root = this.insertRec(this.root, data);
    }

    /* A utility function to insert a new fNode with given
    key in BST */
    fNode insertRec(fNode fNode, int data)
    {
        /* If the tree is empty, return a new fNode */
        if (fNode == null) {
            this.root = new fNode(data);
            return this.root;
        }

        /* Otherwise, recur down the tree */
        if (data < fNode.data) {
            fNode.left = this.insertRec(fNode.left, data);
        } else {
            fNode.right = this.insertRec(fNode.right, data);
        }
        return fNode;
    }

    // class that stores the value of count
    public class count {
        int c = 0;
    }

    // Function to find 2nd largest element
    void secondLargestUtil(fNode fNode, count C)
    {
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (fNode == null || C.c >= 2)
            return;

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        this.secondLargestUtil(fNode.right, C);

        // Increment count of visited fNodes
        C.c++;

        // If c becomes k now, then this is the 2nd largest
        if (C.c == 2) {
            System.out.print("2nd largest element is "+
                    fNode.data);
            return;
        }

        // Recur for left subtree
        this.secondLargestUtil(fNode.left, C);
    }

    // Function to find 2nd largest element
    void secondLargest(fNode fNode)
    {
        // object of class count
        count C = new count();
        this.secondLargestUtil(this.root, C);
    }

    // Driver function
    public static void main(String[] args)
    {
        SecondLargestElementBST tree = new SecondLargestElementBST();

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

        tree.secondLargest(tree.root);
    }
}

