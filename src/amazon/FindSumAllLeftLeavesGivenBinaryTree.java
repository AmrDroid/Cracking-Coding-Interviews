package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class FindSumAllLeftLeavesGivenBinaryTree
{


    // A binary tree node
    static class Node
    {
        int key;
        Node left, right;

        // constructor to create a new Node
        Node(int key_)
        {
            key = key_;
            left = null;
            right = null;
        }
    };
    static class pair
    {
        Node first;
        boolean second;
        public pair(Node first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
    }

    // Return the sum of left leaf nodes
    static int sumOfLeftLeaves(Node root)
    {
        if (root == null)
            return 0;

        // A queue of pairs to do bfs traversal
        // and keep track if the node is a left
        // or right child if boolean value
        // is true then it is a left child.
        Queue<pair > q = new LinkedList<>();
        q.add(new pair( root, false ));
        int sum = 0;

        // do bfs traversal
        while (!q.isEmpty())
        {
            Node temp = q.peek().first;
            boolean is_left_child =
                    q.peek().second;
            q.remove();

            // if temp is a leaf node and
            // left child of its parent
            if (is_left_child)
                sum = sum + temp.key;
            if(temp.left != null && temp.right != null && is_left_child)
                sum = sum-temp.key;

            // if it is not leaf then
            // push its children nodes
            // into queue
            if (temp.left != null)
            {

                // boolean value is true
                // here because it is left
                // child of its parent
                q.add(new pair( temp.left, true));
            }
            if (temp.right != null)
            {

                // boolean value is false
                // here because it is
                // right child of its parent
                q.add(new pair( temp.right, false));
            }
        }
        return sum;
    }

    // Driver Code
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(49);
        root.right.left = new Node(23);
        root.right.right = new Node(52);
        root.right.right.left = new Node(50);
        root.left.left = new Node(5);
        root.left.right = new Node(12);
        root.left.right.right = new Node(12);

        System.out.print("Sum of left leaves is "
                + sumOfLeftLeaves(root) +"\n");
    }
}
