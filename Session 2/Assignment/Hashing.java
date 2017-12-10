// Two Sum
public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
	    ArrayList<Integer> ans = new ArrayList<>();
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    for (int i = 0; i < a.size(); i++) {
	        int num = a.get(i);
	        List<Integer> idxQueue = map.get(b - num);
	        if (idxQueue != null) {
	            ans.add(idxQueue.get(0) + 1);
	            ans.add(i + 1);
	            return ans;
	        }
	        
	        idxQueue = map.get(num);
	        if (idxQueue == null) {
	            idxQueue = new ArrayList<>();
	        }
	        idxQueue.add(i);
	        map.put(num, idxQueue);
	    }
	    return ans;
	}
}

// Anagrams
public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    // key: reverse string, value: original index
	    Map<String, Integer> m = new HashMap<>();
	    int n = a.size();
	    for (int i = 0; i < n; i++) {
	        String s = a.get(i);
	        char[] ca = s.toCharArray();
	        Arrays.sort(ca);
	        String ts = new String(ca);
	        Integer idx = m.get(ts);
	        if (idx != null) {
	            ans.get(idx).add(i + 1);
	        } else {
	            int addIdx = ans.size();
	            m.put(ts, addIdx);
	            ans.add(new ArrayList(Arrays.asList(i + 1)));
	        }
	    }
	    
	    return ans;
	}
}

// Longest Substring Without Repeat
public class Solution {
	public int lengthOfLongestSubstring(String a) {
	    int ans = 0, count = 0;
	    Map<Character, Integer> m = new HashMap<>();
	    int n = a.length();
	    int l = 0;
	    for (int i = 0; i < n; i++) {
	        char c = a.charAt(i);
	        int tc = m.getOrDefault(c, 0) + 1;
	        m.put(c, tc);
	        
	        if (tc == 1) {
	            count++;
	            if (count > ans) {
	                ans = count;
	            }
	        } else {
	            for (int j = l; j < n; j++) {
	                c = a.charAt(j);
	                tc = m.getOrDefault(c, 0) - 1;
	                if (tc == 0) {
	                    m.put(c, 0);
	                    count--;
	                }
	                else {
	                    // in this case tc should be always 1, meaning found the repeated
	                    l = j + 1;
	                    m.put(c, 1);
	                    break;
	                }
	            }
	        }
	    }
	    
	    return ans;
	}
}


