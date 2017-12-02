// PRETTYPRINT:
public class Solution {
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	    int n = a * 2 - 1;
	    for (int i = 0; i < n; i++) {
	        ret.add(new ArrayList<Integer>(Collections.nCopies(n, 0)));
	    }
	    
	    for (int i = 0; i < a; i++) {
	        int cur = a - i;
	        for (int j = i; j < n - i; j++) {
	            ret.get(i).set(j, cur);
	            ret.get(j).set(i, cur);
	            ret.get(n - i - 1).set(j, cur);
	            ret.get(j).set(n - i - 1, cur);
	        }
	    }
	    
	    return ret;
	}
}


