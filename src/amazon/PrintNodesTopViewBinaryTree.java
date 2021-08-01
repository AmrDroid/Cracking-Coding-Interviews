package amazon;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

// class to create a nodeee
class nodeee {
    int data;
    nodeee left, right;

    public nodeee(int data) {
        this.data = data;
        left = right = null;
    }
}

// class of binary tree
class PrintNodesTopViewBinaryTree {
    nodeee root;

    public PrintNodesTopViewBinaryTree() {
        root = null;
    }

    // function should print the topView of
    // the binary tree
    private void TopView(nodeee root) {
        class QueueObj {
            nodeee nodeee;
            int hd;

            QueueObj(nodeee nodeee, int hd) {
                this.nodeee = nodeee;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, nodeee> topViewMap
                = new TreeMap<Integer, nodeee>();

        if (root == null) {
            return;
        } else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println(
                "The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpnodeee = q.poll();
            if (!topViewMap.containsKey(tmpnodeee.hd)) {
                topViewMap.put(tmpnodeee.hd, tmpnodeee.nodeee);
            }

            if (tmpnodeee.nodeee.left != null) {
                q.add(new QueueObj(tmpnodeee.nodeee.left,
                        tmpnodeee.hd - 1));
            }
            if (tmpnodeee.nodeee.right != null) {
                q.add(new QueueObj(tmpnodeee.nodeee.right,
                        tmpnodeee.hd + 1));
            }
        }
        for (Entry<Integer, nodeee> entry :
                topViewMap.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        /* Create following Binary Tree
            1
        / \
        2 3
        \
            4
            \
            5
            \
                6*/
        PrintNodesTopViewBinaryTree tree = new PrintNodesTopViewBinaryTree();
        tree.root = new nodeee(1);
        tree.root.left = new nodeee(2);
        tree.root.right = new nodeee(3);
        tree.root.left.right = new nodeee(4);
        tree.root.left.right.right = new nodeee(5);
        tree.root.left.right.right.right = new nodeee(6);
        System.out.println(
                "Following are nodeees in top view of Binary Tree");
        tree.TopView(tree.root);
    }
}
