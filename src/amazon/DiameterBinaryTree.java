package amazon;

class dNode {
    int data;
    dNode left, right;

    public dNode(int item)
    {
        data = item;
        left = right = null;
    }
}

// A utility class to pass heigh object
class Height {
    int h;
}

// Class to print the Diameter
class DiameterBinaryTree {
    dNode root;

    // define height =0 globally and  call
    // diameterOpt(root,height) from main
    int diameterOpt(dNode root, Height height)
    {
        // lh --> Height of left subtree
        // rh --> Height of right subtree
        Height lh = new Height(), rh = new Height();

        if (root == null) {
            height.h = 0;
            return 0; // diameter is also 0
        }
/*
        ldiameter  --> diameter of left subtree
        rdiameter  --> Diameter of right subtree
        Get the heights of left and right subtrees in lh and rh.
        And store the returned values in ldiameter and ldiameter*/
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);

        // Height of current dNode is max of heights of left
        // and right subtrees plus 1
        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1,
                Math.max(ldiameter, rdiameter));
    }

    // A wrapper over diameter(dNode root)
    int diameter()
    {
        Height height = new Height();
        return diameterOpt(root, height);
    }

    // The function Compute the "height" of a tree. Height
    // is
    //  the number f dNodes along the longest path from the
    //  root dNode down to the farthest leaf dNode.
    static int height(dNode dNode)
    {
        // base case tree is empty
        if (dNode == null)
            return 0;

        // If tree is not empty then height = 1 + max of
        // left height and right heights
        return (1
                + Math.max(height(dNode.left),
                height(dNode.right)));
    }

    // Driver Code
    public static void main(String args[])
    {
        // creating a binary tree and entering the dNodes
        DiameterBinaryTree tree = new DiameterBinaryTree();
        tree.root = new dNode(1);
        tree.root.left = new dNode(2);
        tree.root.right = new dNode(3);
        tree.root.left.left = new dNode(4);
        tree.root.left.right = new dNode(5);

        // Function Call
        System.out.println(
                "The diameter of given binary tree is : "
                        + tree.diameter());
    }
}
