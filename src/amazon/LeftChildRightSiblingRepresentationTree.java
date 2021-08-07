package amazon;

public class LeftChildRightSiblingRepresentationTree {
    // A Node to represent left child
    // right sibling representation.
    static class Node
    {
        char val;
        Node child;
        Node next;
        Node(char P)
        {
            val = P;
            child = null;
            next = null;
        }
    };

    // Traverses given n-ary tree to find K-th
    // child of P.
    static void printKthChild(Node root, char P, int k)
    {
        if (root == null)
            return;

        // If P is present at root itself
        if (root.val == P)
        {
            // Traverse children of root starting
            // from left child
            Node t = root.child;
            int i = 1;
            while (t != null && i < k)
            {
                t = t.next;
                i++;
            }
            if (t == null)
                System.out.print("Error : Does not exist\n");
            else
                System.out.print(t.val + " " + "\n");
            return;
        }
        printKthChild(root.child, P, k);
        printKthChild(root.next, P, k);
    }

    // Driver code
    public static void main(String[] args)
    {
        Node root = new Node('A');
        root.child = new Node('B');
        root.child.next = new Node('C');
        root.child.next.next = new Node('D');
        root.child.next.next.next = new Node('E');
        root.child.child = new Node('F');
        root.child.child.next = new Node('G');
        root.child.next.next.child = new Node('H');
        root.child.next.next.child.child = new Node('L');
        root.child.next.next.child.child.next = new Node('M');
        root.child.child.child = new Node('I');
        root.child.child.child.next = new Node('J');
        root.child.child.child.next.next = new Node('K');

        // Print F's 2nd child
        char P = 'F';
        System.out.print("F's second child is : ");
        printKthChild(root, P, 2);

        P = 'A';
        System.out.print("A's seventh child is : ");
        printKthChild(root, P, 7);
    }

}
