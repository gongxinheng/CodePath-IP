// Kth Smallest Element in the Array 
public class Solution {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
	    PriorityQueue<Integer> queue = new PriorityQueue<>(a);
	    int ret = 0;
	    for (int i = 0; i < k; i++) {
	        ret = queue.poll();
	    }
	    
	    return ret;
	}
}

// NUMRANGE
public class Solution {
	public int numRange(ArrayList<Integer> a, int b, int c) {
	    int ans = 0;
	    
	    int n = a.size();
	    for (int i = 0; i < n; i++) {
	        int sum = 0;
	        for (int j = i; j >= 0; j--) {
	            sum += a.get(j);
    	        if (sum >= b && sum <= c) {
                    ans++;
	            } else if (sum > c) {
	                break;
	            }
	        }
	    }
	    
	    return ans;
	}
}


