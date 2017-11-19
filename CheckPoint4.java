// SUBTRACT
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode subtract(ListNode a) {
	    if (a == null || a.next == null) return a;
	    ListNode slow = a;
	    ListNode fast = a;
	    while(fast != null && fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    boolean odd = false;
	    if (fast.next == null) {
	        odd = true;
	    }
	    
	    // Cut in half
	    ListNode mid = slow;
	    ListNode rightStart = mid.next;
	    rightStart = reverseList(rightStart);

	    fast = rightStart;
	    mid.next = null;
	    slow = a;
	   
	    while (fast != null) {
	        slow.val = fast.val - slow.val;
	        slow = slow.next;
	        fast = fast.next;
	    }
	    
      	mid.next = reverseList(rightStart);
	    
	    return a;
	}
	
	public ListNode reverseList(ListNode a) {
        if (a == null || a.next == null) return a;
        else {
            ListNode prev = a; 
            ListNode cur = a.next;
            ListNode next = cur.next;
            a.next = null;
            while (cur != null) {
                cur.next = prev;
                prev = cur;
                cur = next;
                if (next != null)next = next.next;
            }
            
            return prev;
        }
	}
}

// NEXTGREATER
public class Solution {
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    int n = a.size();
	    int j = 1;
	    for (int i = 0; i < n; i++) {
	        for (j = i + 1; j < n; j++) {
	            int nextGreater = a.get(j);
	            if (j > i && nextGreater > a.get(i)) {
	               a.set(i, nextGreater) ;
	               break;
	            }
	        }
	        if (j == n) {
	            a.set(i, -1);
	        }
	    }
	    
	    return a;
	}
}

