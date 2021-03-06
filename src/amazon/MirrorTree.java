package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    static class Node
    {
        int data;
        Node left;
        Node right;
    };

    /* Helper function that allocates a new node
    with the given data and null left and right
    pointers. */
    static Node newNode(int data)

    {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return(node);
    }

    /* Change a tree so that the roles of the left and
        right pointers are swapped at every node.
    So the tree...
        4
        / \
        2 5
        / \
    1 3

    is changed to...
        4
        / \
        5 2
            / \
        3 1
    */
    static void mirror(Node root)
    {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Do BFS. While doing BFS, keep swapping
        // left and right children
        while (q.size() > 0)
        {
            // pop top node from queue
            Node curr = q.peek();
            q.remove();

            // swap left child with right child
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;;

            // push left and right children
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }


    /* Helper function to print Inorder traversal.*/
    static void inOrder( Node node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print( node.data + " ");
        inOrder(node.right);
    }


    /* Driver code */
    public static void main(String args[])
    {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        /* Print inorder traversal of the input tree */
        System.out.print( "\n Inorder traversal of the"
                +" coned tree is \n");
        inOrder(root);

        /* Convert tree to its mirror */
        mirror(root);

        /* Print inorder traversal of the mirror tree */
        System.out.print( "\n Inorder traversal of the "+
                "mirror tree is \n");
        inOrder(root);
    }

}
