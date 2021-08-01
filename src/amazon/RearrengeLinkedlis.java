package amazon;

class Nodee {
    int data;
    Nodee next;

    // Function to create newNodee in a linkedlist
    Nodee(int key)
    {
        data = key;
        next = null;
    }
}
class RearrengeLinkedlis {

    Nodee left = null;

    // Function to print the list
    void printlist(Nodee head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    // Function to rearrange
    void rearrange(Nodee head)
    {

        if (head != null) {
            left = head;
            reorderListUtil(left);
        }
    }

    void reorderListUtil(Nodee right)
    {

        if (right == null) {
            return;
        }

        reorderListUtil(right.next);

        // we set left = null, when we reach stop condition,
        // so no processing required after that
        if (left == null) {
            return;
        }

        // Stop condition: odd case : left = right, even
        // case : left.next = right
        if (left != right && left.next != right) {
            Nodee temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
        else { // stop condition , set null to left nodes
            if (left.next == right) {
                left.next.next = null; // even case
                left = null;
            }
            else {
                left.next = null; // odd case
                left = null;
            }
        }
    }

    // Drivers Code
    public static void main(String[] args)
    {

        Nodee head = new Nodee(1);
        head.next = new Nodee(2);
        head.next.next = new Nodee(3);
        head.next.next.next = new Nodee(4);
        head.next.next.next.next = new Nodee(5);

        RearrengeLinkedlis gfg = new RearrengeLinkedlis();

        // Print original list
        gfg.printlist(head);

        // Modify the list
        gfg.rearrange(head);

        // Print modified list
        gfg.printlist(head);
    }
}

