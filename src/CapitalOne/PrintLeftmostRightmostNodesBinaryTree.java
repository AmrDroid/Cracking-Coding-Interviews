package CapitalOne;

import java.util.LinkedList;
import java.util.Queue;

class Node
    {
        int key;
        Node left, right;

        public Node(int key)
        {
            this.key = key;
            left = right = null;
        }
    }

    class PrintLeftmostRightmostNodesBinaryTree
    {
        Node root;

        /* Function to print corner node at each level */
        void printCorner(Node root)
        {
            //  star node is for keeping track of levels
            Queue<Node> q = new LinkedList<>();

            // pushing root node and star node
            q.add(root);
            // Do level order traversal of Binary Tree
            while (!q.isEmpty())
            {
                // n is the no of nodes in current Level
                int n = q.size();
                for(int i = 0 ; i < n ; i++){
                    // dequeue the front node from the queue
                    Node temp = q.peek();
                    q.poll();
                    //If it is leftmost corner value or rightmost corner value then print it
                    if(i==0 || i==n-1)
                        System.out.print(temp.key + "  ");
                    //push the left and right children of the temp node
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                }
            }

        }

        // Driver program to test above functions
        public static void main(String[] args)
        {
            PrintLeftmostRightmostNodesBinaryTree tree = new PrintLeftmostRightmostNodesBinaryTree();
            tree.root = new Node(15);
            tree.root.left = new Node(10);
            tree.root.right = new Node(20);
            tree.root.left.left = new Node(8);
            tree.root.left.right = new Node(12);
            tree.root.right.left = new Node(16);
            tree.root.right.right = new Node(25);

            tree.printCorner(tree.root);
        }
    }

