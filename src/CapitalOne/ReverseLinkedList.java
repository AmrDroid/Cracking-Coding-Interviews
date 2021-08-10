package CapitalOne;

import java.util.Stack;

public class ReverseLinkedList {
    static class Node
    {

        int data;
        Node next;
    };
    static Node head = null;
    // Function to reverse the
// linked list
    static void reverseLL()
    {

        // Create a stack "s"
        // of Node type
        Stack<Node> s = new Stack<>();
        Node temp = head;
        while (temp.next != null)
        {

            // Push all the nodes
            // in to stack
            s.add(temp);
            temp = temp.next;
        }
        head = temp;

        while (!s.isEmpty())
        {

            // Store the top value of
            // stack in list
            temp.next = s.peek();

            // Pop the value from stack
            s.pop();

            // update the next pointer in the
            // in the list
            temp = temp.next;
        }
        temp.next = null;
    }

    // Function to Display
// the elements in List
    static void printlist(Node temp)
    {
        while (temp != null)
        {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
    }

    // Program to insert back of the
// linked list
    static void insert_back( int value)
    {

        // we have used insertion at back method
        // to enter values in the list.(eg:
        // head.1.2.3.4.Null)
        Node temp = new Node();
        temp.data = value;
        temp.next = null;

        // If *head equals to null
        if (head == null)
        {
            head = temp;
            return;
        }
        else
        {
            Node last_node = head;
            while (last_node.next != null)
            {
                last_node = last_node.next;
            }
            last_node.next = temp;
            return;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        insert_back( 1);
        insert_back( 2);
        insert_back(3);
        insert_back( 4);
        System.out.print("Given linked list\n");
        printlist(head);
        reverseLL();
        System.out.print("\nReversed linked list\n");
        printlist(head);
    }

}
