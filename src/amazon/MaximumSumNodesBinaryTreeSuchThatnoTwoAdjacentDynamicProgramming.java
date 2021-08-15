package amazon;

public class MaximumSumNodesBinaryTreeSuchThatnoTwoAdjacentDynamicProgramming {
    public static Pair maxSumHelper(Node root)
    {
        if (root==null)
        {
            Pair sum=new Pair(0, 0);
            return sum;
        }
        Pair sum1 = maxSumHelper(root.left);
        Pair sum2 = maxSumHelper(root.right);
        Pair sum=new Pair(0,0);

        // This node is included (Left and right children
        // are not included)
        sum.first = sum1.second + sum2.second + root.data;

        // This node is excluded (Either left or right
        // child is included)
        sum.second = Math.max(sum1.first, sum1.second) +
                Math.max(sum2.first, sum2.second);

        return sum;
    }

    // Returns maximum sum from subset of nodes
    // of binary tree under given constraints
    public static int maxSum(Node root)
    {
        Pair res=maxSumHelper(root);
        return Math.max(res.first, res.second);
    }

    public static void main(String args[]) {
        Node root= new Node(10);
        root.left= new Node(1);
        root.left.left= new Node(2);
        root.left.left.left= new Node(1);
        root.left.right= new Node(3);
        root.left.right.left= new Node(4);
        root.left.right.right= new Node(5);
        System.out.print(maxSum(root));
    }


/* A binary tree node structure */
static class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
};

/* Pair class */
static class Pair
{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
}


