// Add One To Number
public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    ArrayList<Integer> ans = a;
	    int size = a.size();
	    boolean carry = true;
	    int lastExtraZero = -1;
	    for (int i = size - 1; i >=0; i--) {
	        boolean end = false;
	        int cur = ans.get(i);
	        if (carry) {
	            if (cur == 9) {
	                ans.set(i, 0);
	            } else {
	                ans.set(i, cur + 1);
	                carry = false;
	            }
	        } else {
	            for (int j = 0; j <= size; j++) {
	                if (ans.get(j) == 0) {
	                    lastExtraZero = j;
	                } else {
	                    end = true;
	                    break;
	                }
	            }
	        }
	        if (end) break;
	    }
	    // No chance to have extra zero
	    if (carry) {
	        ans.add(0, 1);
	    }
	    else if (lastExtraZero >= 0) {
	        return new ArrayList<Integer>(ans.subList(lastExtraZero + 1, ans.size()));
	    }
	    
	    return ans;
	}
}

// Max Non Negative SubArray
public class Solution {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    if (a.isEmpty()) return new ArrayList<>();
	    
	    long sum = 0, maxSum = 0;
	    int start = 0;
	    int maxStart = 0, maxEnd = 0;
	    for (int i = 0; i < a.size(); i++) {
	        if (a.get(i) >= 0) {
	            sum += a.get(i);
    	        if (sum > maxSum) {
    	            // Replace global max
    	            maxStart = start;
    	            maxEnd = i + 1;
    	            maxSum = sum;
    	        } else if (sum == maxSum) {
    	            // Replace global max
    	            int size = i - start + 1;
    	            if (start == maxStart) {
    	                maxEnd = i + 1;
    	            }
    	            else if (maxEnd - maxStart < size) {
        	            maxStart = start;
    	                maxEnd = i + 1;
    	            }
    	        }
	        } else {
	            sum = 0;
	            start = i + 1;
	        }
	    }
	    
	    return new ArrayList<Integer>(a.subList(maxStart, maxEnd));
	}
}

// Pascal Triangle
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<>(a);
	    for (int i = 1; i <= a; i++) {
	        ArrayList newList = new ArrayList<Integer>(Collections.nCopies(i, 1));
	        ans.add(newList);
	        if (i > 2) {
	            ArrayList<Integer> preList = ans.get(i - 2);
    	        for (int j = 1; j < i; j++) {
    	            int newVal = j == i - 1 ? preList.get(j - 1) : preList.get(j) + preList.get(j - 1);
	                newList.set(j, newVal);
	            }
	        }
	    }
	    
	    return ans;
	}
}

