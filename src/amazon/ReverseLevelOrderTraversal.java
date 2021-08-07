package amazon;
class reNode
{
    int data;
    reNode left, right;

    reNode(int item)
    {
        data = item;
        left = right;
    }
}

class ReverseLevelOrderTraversal
{
    reNode root;

    /* Function to print REVERSE level order traversal a tree*/
    void reverseLevelOrder(reNode reNode)
    {
        int h = height(reNode);
        int i;
        for (i = h; i >= 1; i--)
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
        {
            printGivenLevel(reNode, i);
        }
    }

    /* Print reNodes at a given level */
    void printGivenLevel(reNode reNode, int level)
    {
        if (reNode == null)
            return;
        if (level == 1)
            System.out.print(reNode.data + " ");
        else if (level > 1)
        {
            printGivenLevel(reNode.left, level - 1);
            printGivenLevel(reNode.right, level - 1);
        }
    }

    /* Compute the "height" of a tree -- the number of
     reNodes along the longest path from the root reNode
     down to the farthest leaf reNode.*/
    int height(reNode reNode)
    {
        if (reNode == null)
            return 0;
        else
        {
            /* compute the height of each subtree */
            int lheight = height(reNode.left);
            int rheight = height(reNode.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();

        // Let us create trees shown in above diagram
        tree.root = new reNode(1);
        tree.root.left = new reNode(2);
        tree.root.right = new reNode(3);
        tree.root.left.left = new reNode(4);
        tree.root.left.right = new reNode(5);

        System.out.println("Level Order traversal of binary tree is : ");
        tree.reverseLevelOrder(tree.root);
    }
}

