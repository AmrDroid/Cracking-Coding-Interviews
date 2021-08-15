package amazon;

class ssNode {
    int data;
    ssNode next;
    ssNode(int d)
    {
        data = d;
        next = null;
    }
}

class SwapKthNodeFromBeginningWithKthNodeFromEndinLinkedList {
    ssNode head;

    /* Utility function to insert
       a ssNode at the beginning */
    void push(int new_data) {
        ssNode new_ssNode = new ssNode(new_data);
        new_ssNode.next = head;
        head = new_ssNode;
    }

    /* Utility function for displaying linked list */
    void printList() {
        ssNode ssNode = head;
        while (ssNode != null) {
            System.out.print(ssNode.data + " ");
            ssNode = ssNode.next;
        }
        System.out.println("");
    }

    /* Utility function for calculating
       length of linked list */
    int countssNodes() {
        int count = 0;
        ssNode s = head;
        while (s != null) {
            count++;
            s = s.next;
        }
        return count;
    }

    /* Function for swapping kth ssNodes from
       both ends of linked list */
    void swapKth(int k) {
        // Count ssNodes in linked list
        int n = countssNodes();

        // Check if k is valid
        if (n < k)
            return;

        // If x (kth ssNode from start) and
        // y(kth ssNode from end) are same
        if (2 * k - 1 == n)
            return;

        // Find the kth ssNode from beginning of linked list.
        // We also find previous of kth ssNode because we need
        // to update next pointer of the previous.
        ssNode x = head;
        ssNode x_prev = null;
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }

        // Similarly, find the kth ssNode from end and its
        // previous. kth ssNode from end is (n-k+1)th ssNode
        // from beginning
        ssNode y = head;
        ssNode y_prev = null;
        for (int i = 1; i < n - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }

        // If x_prev exists, then new next of it will be y.
        // Consider the case when y->next is x, in this case,
        // x_prev and y are same. So the statement
        // "x_prev->next = y" creates a self loop. This self
        // loop will be broken when we change y->next.
        if (x_prev != null)
            x_prev.next = y;

        // Same thing applies to y_prev
        if (y_prev != null)
            y_prev.next = x;

        // Swap next pointers of x and y. These statements
        // also break self loop if x->next is y or y->next
        // is x
        ssNode temp = x.next;
        x.next = y.next;
        y.next = temp;

        // Change head pointers when k is 1 or n
        if (k == 1)
            head = y;

        if (k == n)
            head = x;
    }

    // Driver code to test above
    public static void main(String[] args) {
        SwapKthNodeFromBeginningWithKthNodeFromEndinLinkedList llist = new SwapKthNodeFromBeginningWithKthNodeFromEndinLinkedList();
        for (int i = 8; i >= 1; i--)
            llist.push(i);

        System.out.print("Original linked list: ");
        llist.printList();
        System.out.println("");

        for (int i = 1; i < 9; i++) {
            llist.swapKth(i);
            System.out.println("Modified List for k = " + i);
            llist.printList();
            System.out.println("");
        }
    }

}
