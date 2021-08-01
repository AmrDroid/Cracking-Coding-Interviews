package amazon;

import java.util.Stack;
import java.util.Vector;

public class CTRLZ {
   static void WRITE(Stack<Character> Undo,
               char X)
    {
        // Push an element to
        // the top of stack
        Undo.push(X);
    }

    // Function to perform
// "UNDO" operation
   static void UNDO(Stack<Character> Undo,
              Stack<Character> Redo)
    {
        // Stores top element
        // of the stack
        char X = Undo.pop();

        // Erase top element
        // of the stack
        Undo.pop();

        // Push an element to
        // the top of stack
        Redo.push(X);
    }

    // Function to perform
// "REDO" operation
   static void REDO(Stack<Character> Undo,
              Stack<Character> Redo)
    {
        // Stores the top element
        // of the stack
        char X = Redo.pop();

        // Erase the top element
        // of the stack
        Redo.pop();

        // Push an element to
        // the top of the stack
        Undo.push(X);
    }

    // Function to perform
// "READ" operation
 static    void READ(Stack<Character> Undo)
    {
        // Store elements of stack
        // in reverse order
        Stack<Character> revOrder=new Stack<>();

        // Traverse Undo stack
        while (!Undo.empty()) {
            // Push an element to
            // the top of stack
            revOrder.push(Undo.pop());

            // Erase top element
            // of stack
            Undo.pop();
        }

        while (!revOrder.empty()) {
            // Print the top element
            // of the stack
            System.out.println( revOrder.pop());
            Undo.push(revOrder.pop());

            // Erase the top element
            // of the stack
            revOrder.pop();
        }

        System.out.println("  ");
    }

    // Function to perform the
// queries on the document
   static void QUERY(Vector<String> Q)
    {
        // Stores the history of all
        // the queries that have been
        // processed on the document
        Stack<Character> Undo = new Stack<>();

        // Stores the elements
        // of REDO query
        Stack<Character> Redo=new Stack<>();

        // Stores total count
        // of queries
        int N = Q.size();

        // Traverse all the query
        for (int i = 0; i < N; i++) {
            if (Q.get(i) == "UNDO") {
                UNDO(Undo, Redo);
            }
            else if (Q.get(i) == "REDO") {
                REDO(Undo, Redo);
            }
            else if (Q.get(i) == "READ") {
                READ(Undo);
            }
//            else {
//                WRITE(Undo, Q[i][6]);
//            }
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        Vector<String> Q =new Vector<>();
        Q.add("WRITE A");
        Q.add("WRITE B");
        Q.add("WRITE C");
        Q.add("UNDO");
        Q.add("READ");
        Q.add("READ");
        Q.add("READ");
        QUERY(Q);
    }

}
