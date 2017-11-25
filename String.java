// Longest Common Prefix
public class Solution {
	public String longestCommonPrefix(ArrayList<String> a) {
	    if (a == null || a.isEmpty()) return "";
	    
	    String cmp = a.get(0);
	    StringBuilder ans = new StringBuilder();
	    int n = a.size();
	    int m = cmp.length();
	    
	    for (int i = 0; i < m; i++) {
	        char cur = cmp.charAt(i); 
	        
	        for (int j = 1; j < n; j++) {
	            if (i >= a.get(j).length() || a.get(j).charAt(i) != cur) {
	                return ans.toString();
	            }
	        }
	        ans.append(cur);
	    }
	    
	    return ans.toString();
	}
}

// Multiply Strings
public class Solution {
	public String multiply(String a, String b) {
	    if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
	        return "";
	    }
	    
	    if (a.equals("0") || b.equals("0")) return "0";
	    
	    int n = a.length();
	    int m = b.length();
	    StringBuilder ans = new StringBuilder();
	    
	    String s1 = new StringBuilder(a).reverse().toString();
	    String s2 = new StringBuilder(b).reverse().toString();

	    int carry = 0;
	    for (int i = 0; i < n; i++) {
	        int offset = i;
     	    // Backwards
    	    for (int j = 0; j < m; j++) {
    	        int s1n = Character.getNumericValue(s1.charAt(i));
    	        int s2n = Character.getNumericValue(s2.charAt(j));
    	        if (s1n == 0) {
    	            ans.append('0');
    	            break;
    	        }
    	        int mul = s1n * s2n;
    	        mul += carry;
    	        carry = mul / 10;
    	        int pos = offset + j;
    	        if (pos >= 0 && pos < ans.length()) {
    	            int pSum = mul % 10 + Character.getNumericValue(ans.charAt(pos));
    	            ans.setCharAt(pos, (char)((int)'0' + pSum % 10));
    	            if (pSum >= 10) carry++;
    	        } else {
    	            ans.append(mul % 10);
    	        }
    	    }
            if (carry > 0) {
                ans.append(carry);
                carry = 0;
            }
	    }
	    
	    return ans.reverse().toString().replaceFirst("^0*", "");
	}
}

