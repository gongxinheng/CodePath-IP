// Length of Last Word
public class Solution {
    public int lengthOfLastWord(final String a) {
        int n = a.length();
        if (n < 1) return n;

        int last = n - 1;
        while (last >= 0 && a.charAt(last) == ' ') {
            last--;
        }
        for (int i = last; i >= 0; i--) {
            if (a.charAt(i) == ' ') {
                return last - i;
            }
        }

        return last + 1;
    }
}

// Reverse the String
public class Solution {
    public String reverseWords(String a) {
        if (a.length() < 2) return a;
        StringBuilder ans = new StringBuilder(a);
        String[] strArr = ans.reverse().toString().split(" ");
        ans.setLength(0);
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder sb = new StringBuilder(strArr[i]);
            ans.append(sb.reverse().toString());
            if (i != strArr.length - 1) {
                ans.append(' ');
            }
        }

        return ans.toString();
    }
}

// Implement StrStr
public class Solution {
    public int strStr(final String haystack, final String needle) {
        if (haystack.isEmpty() || needle.isEmpty()) return -1;
        int n = haystack.length();
        char first = needle.charAt(0);
        int i = 0;
        while (i < n) {
            if (haystack.charAt(i) == first) {
                boolean found = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (i + j >= n || haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) return i;
            }
            i++;
        }

        return -1;
    }
}
