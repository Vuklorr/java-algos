package com.algos.twopointers;

/**
 * Remove Duplicates from Sorted List II.
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */

public class Task5 {

    public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode current = res;
        int num;

        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                current.next = head.next;
            } else {
                current = current.next;
            }

            head = head.next;
        }
        return res.next;
    }
}
