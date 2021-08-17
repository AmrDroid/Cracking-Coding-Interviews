package amazon;

public class Subtract1FromNumberRepresentedLinkedList {

    // Linked list Node
    static class Node
    {
        int data;
        Node next;
    };

    // Function to create a new node with
// the given data
    static Node newNode(int data)
    {

        // Create a new node
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;

        // Return the created node
        return new_node;
    }

    // Recursive function to subtract 1
// from the linked list and update
// the node value accordingly
    static  int subtractOneUtil(Node head)
    {

        // Base Case
        if (head == null)
            return -1;

        // Recursively call for the next
        // node of the head
        int borrow = subtractOneUtil(
                head.next);

        // If there is a borrow
        if (borrow == -1)
        {

            // If the head data is 0, then
            // update it with 9 and return -1
            if (head.data == 0)
            {
                head.data = 9;
                return -1;
            }

            // Otherwise, decrement head's
            // data by 1 and return 0
            else
            {
                head.data = head.data - 1;
                return 0;
            }
        }

        // Otherwise, return 0
        else
        {
            return 0;
        }
    }

    // Function to subtract 1 from the given
// Linked List representation of number
    static Node subtractOne(Node head)
    {

        // Recursively subtract 1 from
        // the Linked List
        subtractOneUtil(head);

        // Increment the head pointer
        // if there are any leading zeros
        while (head != null && head.next != null &&
                head.data == 0)
        {
            head = head.next;
        }
        return head;
    }

    // Function to print a linked list
    static void printList(Node node)
    {

        // Iterate until node is null
        while (node != null)
        {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
    {
        Node head = newNode(1);
        head.next = newNode(0);
        head.next.next = newNode(0);
        head.next.next.next = newNode(0);

        System.out.print("List is ");
        printList(head);

        head = subtractOne(head);

        System.out.print("Resultant list is ");
        printList(head);
    }
}
