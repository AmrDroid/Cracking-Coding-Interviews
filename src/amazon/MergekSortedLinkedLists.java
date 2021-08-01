package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
public class MergekSortedLinkedLists {
    // function to merge k
    // sorted linked lists
    public static Node6 mergeKSortedLists(
            Node6 arr[], int k)
    {
        Node6 head = null, last = null;

        // priority_queue 'pq' implemeted
        // as min heap with the
        // help of 'compare' function
        PriorityQueue<Node6> pq
                = new PriorityQueue<>(
                new Comparator<Node6>() {
                    public int compare(Node6 a, Node6 b)
                    {
                        return a.data - b.data;
                    }
                });

        // push the head Node6s of all
        // the k lists in 'pq'
        for (int i = 0; i < k; i++)
            if (arr[i] != null)
                pq.add(arr[i]);

        // loop till 'pq' is not empty
        while (!pq.isEmpty()) {
            // get the top element of 'pq'
            Node6 top = pq.peek();
            pq.remove();

            // check if there is a Node6
            // next to the 'top' Node6
            // in the list of which 'top'
            // Node6 is a member
            if (top.next != null)
                // push the next Node6 in 'pq'
                pq.add(top.next);

            // if final merged list is empty
            if (head == null) {
                head = top;
                // points to the last Node6 so far of
                // the final merged list
                last = top;
            }
            else {
                // insert 'top' at the end
                // of the merged list so far
                last.next = top;

                // update the 'last' pointer
                last = top;
            }
        }
        // head Node6 of the required merged list
        return head;
    }

    // function to print the singly linked list
    public static void printList(Node6 head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Utility function to create a new Node6
    public Node6 push(int data)
    {
        Node6 newNode6 = new Node6(data);
        newNode6.next = null;
        return newNode6;
    }

    public static void main(String args[])
    {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head Node6s
        // of the linked lists
        Node6 arr[] = new Node6[k];

        arr[0] = new Node6(1);
        arr[0].next = new Node6(3);
        arr[0].next.next = new Node6(5);
        arr[0].next.next.next = new Node6(7);

        arr[1] = new Node6(2);
        arr[1].next = new Node6(4);
        arr[1].next.next = new Node6(6);
        arr[1].next.next.next = new Node6(8);

        arr[2] = new Node6(0);
        arr[2].next = new Node6(9);
        arr[2].next.next = new Node6(10);
        arr[2].next.next.next = new Node6(11);

        // Merge all lists
        Node6 head = mergeKSortedLists(arr, k);
        printList(head);
    }
}

class Node6 {
    int data;
    Node6 next;
    Node6(int data)
    {
        this.data = data;
        next = null;
    }
}
