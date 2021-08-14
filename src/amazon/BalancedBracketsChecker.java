package amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BalancedBracketsChecker {

    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            char x = stack.pop();
            switch (ch) {
                case ')': {
                    if (x == '[' || x == '{') return false;
                    break;
                }
                case ']': {
                    if (x == '(' || x == '{') return false;
                    break;
                }
                case '}': {
                    if (x == '[' || x == '(') return false;
                    break;
                }
            }
        }
        return stack.isEmpty();
    }

    // Driver code
    public static void main(String[] args) {
        String expr = "([{}])";

        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

}
