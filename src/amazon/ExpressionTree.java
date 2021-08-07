package amazon;

import java.util.Stack;

class exNode {

    char value;
    exNode left, right;

    exNode(char item) {
        value = item;
        left = right = null;
    }
}

class ExpressionTree {

    // A utility function to check if 'c'
    // is an operator

    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    // Utility function to do inorder traversal
    void inorder(exNode t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }

    // Returns root of constructed tree for given
    // postfix expression
    exNode constructTree(char postfix[]) {
        Stack<exNode> st = new Stack<exNode>();
        exNode t, t1, t2;

        // Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {

            // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                t = new exNode(postfix[i]);
                st.push(t);
            } else // operator
            {
                t = new exNode(postfix[i]);

                // Pop two top exNodes
                // Store top
                t1 = st.pop();      // Remove top
                t2 = st.pop();

                //  make them children
                t.right = t1;
                t.left = t2;

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
            }
        }

        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }

    public static void main(String args[]) {

        ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        exNode root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);

    }
}

