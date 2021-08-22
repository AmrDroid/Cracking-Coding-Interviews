package amazon.done;

class mNode {

    int data;
    mNode left, right;

    mNode(int d)
    {
        data = d;
        left = right = null;
    }
}

class BinarySearchTree {

    // Root of BST
    mNode root;

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    // function to insert mNodes
    public void insert(int data)
    {
        this.root = this.insertRec(this.root, data);
    }

    /* A utility function to insert a new mNode
    with given key in BST */
    mNode insertRec(mNode mNode, int data)
    {
        /* If the tree is empty, return a new mNode */
        if (mNode == null) {
            this.root = new mNode(data);
            return this.root;
        }

        if (data == mNode.data) {
            return mNode;
        }

        /* Otherwise, recur down the tree */
        if (data < mNode.data) {
            mNode.left = this.insertRec(mNode.left, data);
        } else {
            mNode.right = this.insertRec(mNode.right, data);
        }
        return mNode;
    }

    // class that stores the value of count
    public class count {
        int c = 0;
    }

    // utility function to find kth largest no in
    // a given tree
    void kthLargestUtil(mNode mNode, int k, count C)
    {
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (mNode == null || C.c >= k)
            return;

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        this.kthLargestUtil(mNode.right, k, C);

        // Increment count of visited mNodes
        C.c++;

        // If c becomes k now, then this is the k'th largest
        if (C.c == k) {
            System.out.println(k + "th largest element is " + mNode.data);
            return;
        }

        // Recur for left subtree
        this.kthLargestUtil(mNode.left, k, C);
    }

    // Method to find the kth largest no in given BST
    void kthLargest(int k)
    {
        count c = new count(); // object of class count
        this.kthLargestUtil(this.root, k, c);
    }

    // Driver function
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

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

        for (int i = 1; i <= 7; i++) {
            tree.kthLargest(i);
        }
    }
}
