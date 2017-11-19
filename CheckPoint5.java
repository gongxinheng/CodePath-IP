// All Unique Permutations
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    HashSet<ArrayList<Integer>> ans = new HashSet<>();
	    int n = a.size();
        helper(ans, a, 0);
        
        return new ArrayList<ArrayList<Integer>>(ans);
	}
	
	private void helper(HashSet<ArrayList<Integer>> ans, ArrayList<Integer> cur, int i) {
	    int n = cur.size();
	    
	    if (i == n - 1) {
	        ans.add((ArrayList<Integer>)cur.clone());
	        return;
	    } else {
	        for (int j = i; j < n; j++) {
	            Collections.swap(cur, i, j);
	            helper(ans, cur, i + 1);
	            Collections.swap(cur, i, j);
	        }
	    }
	}
}

// Longest Consecutive Sequence
public class Solution {
	public int longestConsecutive(final List<Integer> a) {
	    if (a.isEmpty()) return 0;
	    TreeSet<Integer> ts = new TreeSet<>(a);

        Iterator<Integer> it = ts.iterator();
	    int last = it.next();
	    int curMax = 1;
	    int ans = 1;
	    while (it.hasNext()) {
	        int cur = it.next();
	        if (cur - last == 1) {
	            if (++curMax > ans) {
	                ans = curMax;
	            }
	        } else {
	            curMax = 1;
	        }
	        last = cur;
	    }
	    
	    return ans;
	}
}

