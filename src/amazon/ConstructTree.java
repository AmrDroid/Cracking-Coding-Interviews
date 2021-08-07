package amazon;

class coNode {
    char data;
    coNode left, right;

    coNode(char item)
    {
        data = item;
        left = right = null;
    }
}

class ConstructTree {
    coNode root;
    static int preIndex = 0;

    /* Recursive function to construct binary of size len from
       Inorder traversal in[] and Preorder traversal pre[].
       Initial values of inStrt and inEnd should be 0 and len -1.
       The function doesn't do any error checking for cases where
       inorder and preorder do not form a tree */
    coNode buildTree(char in[], char pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;

        /* Pick current coNode from Preorder traversal using preIndex
           and increment preIndex */
        coNode tcoNode = new coNode(pre[preIndex++]);

        /* If this coNode has no children then return */
        if (inStrt == inEnd)
            return tcoNode;

        /* Else find the index of this coNode in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tcoNode.data);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tcoNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tcoNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tcoNode;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
    int search(char arr[], int strt, int end, char value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(coNode coNode)
    {
        if (coNode == null)
            return;

        /* first recur on left child */
        printInorder(coNode.left);

        /* then print the data of coNode */
        System.out.print(coNode.data + " ");

        /* now recur on right child */
        printInorder(coNode.right);
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        ConstructTree tree = new ConstructTree();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        coNode root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}

