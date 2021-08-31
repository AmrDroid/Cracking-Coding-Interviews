package amazon.done;

import java.util.Queue;
        import java.util.LinkedList;

/* Class to represent Tree bfsNode */
class bfsNode {
    int data;
    bfsNode left, right;

    public bfsNode(int item) {
        data = item;
        left = null;
        right = null;
    }
}

/* Class to print Level Order Traversal */
class BFSLevelOrderBinaryTreeTraversal {

    bfsNode root;

    /* Given a binary tree. Print
     its nodes in level order
     using array for implementing queue  */
    void printLevelOrder()
    {
        Queue<bfsNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm */
            bfsNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        BFSLevelOrderBinaryTreeTraversal tree_level = new BFSLevelOrderBinaryTreeTraversal();
        tree_level.root = new bfsNode(1);
        tree_level.root.left = new bfsNode(2);
        tree_level.root.right = new bfsNode(3);
        tree_level.root.left.left = new bfsNode(4);
        tree_level.root.left.right = new bfsNode(5);

        System.out.println("Level order traversal of binary tree is - ");
                tree_level.printLevelOrder();
    }
}
