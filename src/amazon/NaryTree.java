package amazon;

public class NaryTree {
//https://www.geeksforgeeks.org/left-child-right-sibling-representation-tree/
    // Maximum number of children
    static int N = 10;

    static class Node
    {
        char val;
        Node[] child = new Node[N];

        Node(char P)
        {
            val = P;
            for (int i = 0; i < N; i++)
                child[i] = null;
        }
    };

    // Traverses given n-ary tree to
    // find K-th child of P.
    static void printKthChild(Node root,
                              char P, int k)
    {
        // If P is current root
        if (root.val == P)
        {
            if (root.child[k - 1] == null)
                System.out.print("Error : Does not exist\n");
            else
                System.out.print(root.child[k - 1].val + "\n");
        }

        // If P lies in a subtree
        for (int i = 0; i < N; i++)
            if (root.child[i] != null)
                printKthChild(root.child[i], P, k);
    }

    // Driver code
    public static void main(String[] args)
    {
        Node root = new Node('A');
        root.child[0] = new Node('B');
        root.child[1] = new Node('C');
        root.child[2] = new Node('D');
        root.child[3] = new Node('E');
        root.child[0].child[0] = new Node('F');
        root.child[0].child[1] = new Node('G');
        root.child[2].child[0] = new Node('H');
        root.child[0].child[0].child[0] = new Node('I');
        root.child[0].child[0].child[1] = new Node('J');
        root.child[0].child[0].child[2] = new Node('K');
        root.child[2].child[0].child[0] = new Node('L');
        root.child[2].child[0].child[1] = new Node('M');

        // Print F's 2nd child
        char P = 'F';
        System.out.print("F's second child is : ");
        printKthChild(root, P, 2);

        P = 'A';
        System.out.print("A's seventh child is : ");
        printKthChild(root, P, 7);
    }
}
