package amazon;
import java.io.*;
import java.lang.*;
import java.util.*;

// node1 Class
class node1 {
    int data;
    node1 next;
    node1(int key)
    {
        this.data = key;
        next = null;
    }
}
public class MergeSortLinkedLists {

    static node1 mergeSort(node1 head)
    {
        if (head.next == null)
            return head;

        node1 mid = findMid(head);
        node1 head2 = mid.next;
        mid.next = null;
        node1 newHead1 = mergeSort(head);
        node1 newHead2 = mergeSort(head2);
        node1 finalHead = merge(newHead1, newHead2);

        return finalHead;
    }

    // Function to merge two linked lists
    static node1 merge(node1 head1, node1 head2)
    {
        node1 merged = new node1(-1);
        node1 temp = merged;

        // While head1 is not null and head2
        // is not null
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // While head1 is not null
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // While head2 is not null
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    // Find mid using The Tortoise and The Hare approach
    static node1 findMid(node1 head)
    {
        node1 slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to print list
    static void printList(node1 head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        node1 head = new node1(7);
        node1 temp = head;
        temp.next = new node1(10);
        temp = temp.next;
        temp.next = new node1(5);
        temp = temp.next;
        temp.next = new node1(20);
        temp = temp.next;
        temp.next = new node1(3);
        temp = temp.next;
        temp.next = new node1(2);
        temp = temp.next;

        // Apply merge Sort
        head = mergeSort(head);
        System.out.print("\nSorted Linked List is: \n");
        printList(head);
    }

}
