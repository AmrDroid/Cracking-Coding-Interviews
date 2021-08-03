package amazon;
/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * O(n) runtime, O(1) space
 *
 * in order to get O(1) space, the key is that how to get the mapping from nodes in the given list to nodes in the new list without extra space
 * 1. copy and insert each node after original one
 * 2. now, for each original node, node.random.next and node.next.random are the same
 * 3. get the new list and restore the given list
 */

import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// copy and insert each node after original one
// O(n) runtime, O(1) space
class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        // copy and insert each node after original one
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            RandomListNode copy = new RandomListNode(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        // deal with random
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next; // note the key here
            cur = cur.next.next;
        }
        // get the new list and restore the given list
        RandomListNode dummy = new RandomListNode(0);
        cur = dummy;
        RandomListNode dummyCopy = new RandomListNode(0);
        RandomListNode curCopy = dummyCopy;
        boolean copy = false;
        while (head != null) {
            if (copy) {
                curCopy.next = head;
                curCopy = curCopy.next;
            } else {
                cur.next = head;
                cur = cur.next;
            }
            copy = !copy;
            head = head.next;
        }
        cur.next = null;
        return dummyCopy.next;
    }
}

// use a HashMap to store the mapping from nodes in the given list to nodes in the new list
// O(n) runtime, O(n) space
 class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        RandomListNode node = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (node != null) {
            RandomListNode copy = new RandomListNode(node.val);
            map.put(node, copy);
            cur.next = copy;
            cur = cur.next;
            node = node.next;
        }
        cur = dummy.next;
        node = head;
        while (node != null) {
            cur.random = node.random == null ? null : map.get(node.random);
            cur = cur.next;
            node = node.next;
        }
        return dummy.next;
    }
}
