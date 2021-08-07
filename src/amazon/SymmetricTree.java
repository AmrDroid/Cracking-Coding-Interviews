package amazon;

class sNode {
    int key;
    sNode left, right;

    sNode(int item)
    {
        key = item;
        left = right = null;
    }
}

class SymmetricTree {
    sNode root;

    // returns true if trees
    //  with roots as root1 and root2are mirror
    boolean isMirror(sNode sNode1, sNode sNode2)
    {
        // if both trees are empty,
        //  then they are mirror image
        if (sNode1 == null && sNode2 == null)
            return true;

        // For two trees to be mirror images, the following
        // three conditions must be true 1 - Their root
        // sNode's key must be same 2 - left subtree of left
        // tree and right subtree
        //      of right tree have to be mirror images
        // 3 - right subtree of left tree and left subtree
        //      of right tree have to be mirror images
        if (sNode1 != null && sNode2 != null
                && sNode1.key == sNode2.key)
            return (isMirror(sNode1.left, sNode2.right)
                    && isMirror(sNode1.right, sNode2.left));

        // if none of the above conditions is true then
        // root1 and root2 are not mirror images
        return false;
    }

    // returns true if the tree is symmetric i.e
    // mirror image of itself
    boolean isSymmetric()
    {
        // check if tree is mirror of itself
        return isMirror(root, root);
    }

    // Driver code
    public static void main(String args[])
    {
        SymmetricTree tree = new SymmetricTree();
        tree.root = new sNode(1);
        tree.root.left = new sNode(2);
        tree.root.right = new sNode(2);
        tree.root.left.left = new sNode(3);
        tree.root.left.right = new sNode(4);
        tree.root.right.left = new sNode(4);
        tree.root.right.right = new sNode(3);
        boolean output = tree.isSymmetric();
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");
    }
}


