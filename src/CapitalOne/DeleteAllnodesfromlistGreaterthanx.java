package CapitalOne;

// in a linked list
class dNode {

    int data;
    dNode next;

    public dNode(int data){
        this.data = data;
        this.next = null;
    }
}

//This is a utility class for linked list
class LLUtil{

    // This function creates a linked list from a
    // given array and returns head
    public dNode createLL(int[] arr){

        dNode head = new dNode(arr[0]);
        dNode temp = head;

        dNode newdNode = null;
        for(int i = 1; i < arr.length; i++){
            newdNode = new dNode(arr[i]);
            temp.next = newdNode;
            temp = temp.next;
        }
        return head;
    }

    //This function prints given linked list
    public void printLL(dNode head){

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }


}

class GFG {
    public static void main (String[] args) {

        int[] arr = {12,15,10,11,5,6,2,3};
        LLUtil llu = new LLUtil();
        dNode head = llu.createLL(arr);
        System.out.println("Given Linked List");
        llu.printLL(head);
        head = deletedNodesOnRightSide(head);
        System.out.println("Modified Linked List");
        llu.printLL(head);

    }

    //Main function
    public static dNode deletedNodesOnRightSide(dNode head){
        if(head == null || head.next == null) return head;
        dNode nextdNode = deletedNodesOnRightSide(head.next);

        if(nextdNode.data > head.data) return nextdNode;
        head.next = nextdNode;

        return head;
    }
}

