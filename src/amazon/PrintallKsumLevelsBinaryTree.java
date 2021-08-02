package amazon;

import java.util.Queue;
import java.util.Vector;
import java.util.LinkedList;

public class PrintallKsumLevelsBinaryTree {
    // Vector to store the
// elements of a level
    static Vector<Integer> level = new Vector<Integer>();

    // Binary Tree Node
    static class node {
        node left;
        int data;
        node right;
    };

    // Function to display elements
    static void display(boolean flag)
    {

        // Check if boolean variable is true
        // then print the level
        if (flag) {

            for (Integer x : level)
                System.out.print(x+ " ");
        }

        else

            System.out.print("Not Possible\n");
    }

    // Function to find sum of
// elements by level order traversal
    static void SumlevelOrder(node root, int k)
    {

        if (root == null)
            return;

        // Queue data structure for
        // level order traversal
        Queue<node> q = new LinkedList<>();

        // Enqueue Root in Queue
        q.add(root);

        boolean flag = false;

        while (q.isEmpty() == false) {

            // number of nodes at current level
            int nodeCount = q.size();

            int Present_level_sum = 0;

            // Dequeue all nodes of current level and
            // Enqueue all nodes of next level
            while (nodeCount > 0) {

                node node = q.peek();

                // To add node data
                Present_level_sum += node.data;

                level.add(node.data);

                q.remove();

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);

                nodeCount--;
            }

            if (Present_level_sum == k) {

                flag = true;
                break;
            }

            level.clear();
        }

        display(flag);
    }

    // Function to create a new tree node
    static node newNode(int data)
    {
        node temp = new node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // Driver code
    public static void main(String[] args)
    {
        // Create binary tree
        node root = newNode(1);

        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.right = newNode(6);

        int K = 15;

        SumlevelOrder(root, K);

    }

}
