package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodesMaximumDepthBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    };

    // Function to return a new node
    static TreeNode createNode(int d)
    {
        TreeNode node;
        node = new TreeNode();
        node.val = d;
        node.left = null;
        node.right = null;
        return node;
    }
    // Iterative function to fnd the sum of the deepest
    // nodes.
    public static int deepestLeavesSum(TreeNode root)
    {
        // if the root is null then return 0
        if (root== null) {
            return 0;
        }
        // Initialize an empty queue.
        Queue<TreeNode> qu= new LinkedList<>();
        // push the root of the tree into the queue
        qu.offer(root);
        // initialize sum of current level to 0
        int sumOfCurrLevel= 0;
        // loop until the queue is not empty
        while (!qu.isEmpty()) {
            int size = qu.size();
            sumOfCurrLevel = 0;
            while (size-- > 0) {
                TreeNode head = qu.poll();
                sumOfCurrLevel += head.val;
                // if the left child of the head is not null
                if (head.left!= null) {
                    //push the child into the queue
                    qu.offer(head.left);
                }
                // if the right child is not null
                if (head.right!= null) {
                    // push the child into the queue
                    qu.offer(head.right);
                }
            }
        }
        return sumOfCurrLevel;
    }
    public static void main(String[] args)
    {

        TreeNode root;
        root = createNode(1);
        root.left = createNode(2);
        root.right = createNode(3);
        root.left.left = createNode(4);
        root.left.right = createNode(5);
        root.right.left = createNode(6);
        root.right.right = createNode(7);
        System.out.println(deepestLeavesSum(root));
    }
}
