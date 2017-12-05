// Remove Duplicates from Sorted List
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode a) {
        if (a == null || a.next == null) return a;

        ListNode cur = a;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return a;
    }
}

// Insertion Sort List
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode cur = a;
        // Current disordered node
        ListNode dNode = null;
        while (cur.next != null) {
            if (cur.next.val < cur.val) {
                dNode = cur.next;
                cur.next = cur.next.next;
                ListNode left = a, right = left.next;
                if (dNode.val < a.val) {
                    dNode.next = a;
                    a = dNode;
                } else {
                    while (dNode.val > left.next.val) {
                        left = left.next;
                        right = left.next;
                    }
                    left.next = dNode;
                    dNode.next = right;
                }
            } else {
                cur = cur.next;
            }
        }

        return a;
    }
}
