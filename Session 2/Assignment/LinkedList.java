// Remove Duplicates from Sorted List
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

// List Cycle
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    if (a == null || a.next == null || a.next == a) return a;
	    // slow & fast pointers
	    ListNode s = a;
	    ListNode f = a.next;
	    ListNode nInCircle = null;
	    // find a node in circle (fast meets slow)
	    while (f != null) {
	        if (f == s || (f != null && f.next == s)) {
	            nInCircle = s;
	            break;
	        } else {
	            if (f.next == null) return null;
	            s = s.next;
	            f = f.next.next;
	        }
	    }
	    if (nInCircle == null) return null;
	    
	    // determine the size of the circle
	    f = nInCircle.next;
	    int size = 1;
	    while (f != nInCircle) {
	        size++;
	        f = f.next;
	    }
	    
	    f = a;
	    s = a;
	    for (int i = 0; i < size; i++) {
	        f = f.next;
	    }
	    
	    while (f != s) {
	        f = f.next;
	        s = s.next;
	    }
	    
	    return f;
	}
}

// Swap List Nodes in pairs
public class Solution {
	public ListNode swapPairs(ListNode a) {
	    if (a == null) return null;
	    ListNode first = a;
	    ListNode second = a.next;
	    ListNode head = second == null ? a : second;
	    while (second != null) {
	        ListNode next = second.next;
	        first.next = (next != null && next.next != null) ? next.next : next;
	        second.next = first;
	        first = next;
	        if (first != null) {
	            second = first.next;
	        } else {
	            break;
	        }
	    }
	    return head;
	}
}
