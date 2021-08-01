package amazon;

import java.util.*;

/* Link list Nod */
class Nod {
    int data;
    Nod next;

    Nod(int d) {
        data = d;
        next = null;
    }
}

class MergeLists {
    Nod head;

    /* Method to insert a Nod at
       the end of the linked list */
    public void addToTheLast(Nod Nod) {
        if (head == null) {
            head = Nod;
        } else {
            Nod temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = Nod;
        }
    }

    /* Method to print linked list */
    void printList() {
        Nod temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    // Driver Code
    public static void main(String args[]) {
    /* Let us create two sorted linked
       lists to test the methods
       Created lists:
           llist1: 5->10->15,
           llist2: 2->3->20
    */
        MergeLists llist1 = new MergeLists();
        MergeLists llist2 = new MergeLists();

        // Nod head1 = new Nod(5);
        llist1.addToTheLast(new Nod(5));
        llist1.addToTheLast(new Nod(10));
        llist1.addToTheLast(new Nod(15));

        // Nod head2 = new Nod(2);
        llist2.addToTheLast(new Nod(2));
        llist2.addToTheLast(new Nod(3));
        llist2.addToTheLast(new Nod(20));


        llist1.head = new MergeLists().sortedMerge(llist1.head,
                llist2.head);
        llist1.printList();

    }

    /* Takes two lists sorted in
    increasing order, and splices
    their Nods together to make
    one big sorted list which is
    returned. */
    Nod sortedMerge(Nod headA, Nod headB) {

    /* a dummy first Nod to
       hang the result on */
        Nod dummyNod = new Nod(0);

    /* tail points to the
    last result Nod */
        Nod tail = dummyNod;
        while (true) {

        /* if either list runs out,
        use the other list */
            if (headA == null) {
                tail.next = headB;
                break;
            }
            if (headB == null) {
                tail.next = headA;
                break;
            }

        /* Compare the data of the two
        lists whichever lists' data is
        smaller, append it into tail and
        advance the head to the next Nod
        */
            if (headA.data <= headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }

            /* Advance the tail */
            tail = tail.next;
        }
        return dummyNod.next;
    }
}
