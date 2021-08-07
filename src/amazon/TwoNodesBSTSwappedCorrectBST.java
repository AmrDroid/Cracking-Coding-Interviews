package amazon;

import java.util.*;
import java.lang.*;
import java.io.*;

class swNode {

    int data;
    swNode left, right;

    swNode(int d) {
        data = d;
        left = right = null;
    }
}

class TwoNodesBSTSwappedCorrectBST {

    swNode first, last, prev;

    // This function does inorder traversal
    // Using Morris Traversal to find out the two
    // swapped swNodes.
    void MorrisTraversal(swNode root) {
        // current swNode
        swNode curr = root;
        swNode pre = null;
        while (curr != null) {
            if (curr.left == null) {

                // If this swNode is smaller than
                // the previous swNode, it's
                // violating the BST rule.

                if (first == null && prev != null &&
                        prev.data > curr.data) {
                    // If this is first violation,
                    // mark these two swNodes as
                    // 'first' and 'last'
                    first = prev;
                    last = curr;
                }

                if (first != null &&
                        prev.data > curr.data) {
                    // If this is second violation,
                    // mark this swNode as last
                    last = curr;
                }
                prev = curr;

                curr = curr.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = curr.left;
                while (pre.right != null &&
                        pre.right != curr) {
                    pre = pre.right;
                }

                // Make current as right child of
                // its inorder predecessor */
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // If this swNode is smaller than
                    // the previous swNode, it's
                    // violating the BST rule.
                    if (first == null && prev != null &&
                            prev.data > curr.data) {
                        // If this is first violation,
                        // mark these two swNodes as
                        // 'first' and 'last'
                        first = prev;
                        last = curr;
                    }

                    if (first != null &&
                            prev.data > curr.data) {
                        // If this is second violation,
                        // mark this swNode as last
                        last = curr;
                    }
                    prev = curr;

                      /* Revert the changes made in the
                    'if' part to restore the
                    original tree i.e., fix the
                    right child of predecessor*/
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    }


    // A function to fix a given BST where
    // two swNodes are swapped. This function
    // uses correctBSTUtil() to find out
    // two swNodes and swaps the swNodes to
    // fix the BST
    void correctBST(swNode root) {
        // Initialize pointers needed
        // for correctBSTUtil()
        first = last = prev = null;

        // Set the pointers to find out
        // two swNodes
        MorrisTraversal(root);

        // Fix (or correct) the tree
        int temp = first.data;
        first.data = last.data;
        last.data = temp;
    }


    /* A utility function to print
  Inorder traversal */
    void printInorder(swNode swNode) {
        if (swNode == null)
            return;
        printInorder(swNode.left);
        System.out.print(" " + swNode.data);
        printInorder(swNode.right);
    }

    // Driver Code
    public static void main(String[] args) {
        /*   6
            / \
           10  2
          / \ / \
         1  3 7 12

        10 and 2 are swapped
        */

        swNode root = new swNode(6);
        root.left = new swNode(10);
        root.right = new swNode(2);
        root.left.left = new swNode(1);
        root.left.right = new swNode(3);
        root.right.right = new swNode(12);
        root.right.left = new swNode(7);

        System.out.println("Inorder Traversal" +
                " of the original tree");
        TwoNodesBSTSwappedCorrectBST tree = new TwoNodesBSTSwappedCorrectBST();
        tree.printInorder(root);

        tree.correctBST(root);

        System.out.println("\nInorder Traversal" +
                " of the fixed tree");
        tree.printInorder(root);
    }
}
// This code is contributed by
// Naresh Saharan and Sagara Jangra

