package amazon.done;

import java.util.Stack;

class zNode
{
    int data;
    zNode leftChild;
    zNode rightChild;
    zNode(int data)
    {
        this.data = data;
    }
}

class ZigZagTreeTraversal {
    zNode rootzNode;

    // function to print the
// zigzag traversal
    void printZigZagTraversal() {

        // if null then return
        if (rootzNode == null) {
            return;
        }

        // declare two stacks
        Stack<zNode> currentLevel = new Stack<>();
        Stack<zNode> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootzNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            zNode zNode = currentLevel.pop();

            // print the data in it
            System.out.print(zNode.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (zNode.leftChild != null) {
                    nextLevel.push(zNode.leftChild);
                }

                if (zNode.rightChild != null) {
                    nextLevel.push(zNode.rightChild);
                }
            }
            else {
                if (zNode.rightChild != null) {
                    nextLevel.push(zNode.rightChild);
                }

                if (zNode.leftChild != null) {
                    nextLevel.push(zNode.leftChild);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<zNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }


    // driver program to test the above function
    public static void main(String[] args)
    {
        ZigZagTreeTraversal tree = new ZigZagTreeTraversal();
        tree.rootzNode = new zNode(1);
        tree.rootzNode.leftChild = new zNode(2);
        tree.rootzNode.rightChild = new zNode(3);
        tree.rootzNode.leftChild.leftChild = new zNode(7);
        tree.rootzNode.leftChild.rightChild = new zNode(6);
        tree.rootzNode.rightChild.leftChild = new zNode(5);
        tree.rootzNode.rightChild.rightChild = new zNode(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}
