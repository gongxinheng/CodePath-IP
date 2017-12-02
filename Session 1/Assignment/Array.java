// Merge Overlapping Intervals
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;

        LinkedList<Interval> ans = new LinkedList();
        intervals.sort((lhs, rhs) -> lhs.start - rhs.start);
        Interval last = new Interval(intervals.get(0).start, intervals.get(0).end);
        ans.add(last);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (last.end < current.start) {
                last = new Interval(current.start, current.end);
                ans.add(last);
            } else {
                last.end = Math.max(last.end, current.end);
            }
        }

        return new ArrayList<Interval>(ans);
    }
}

// Wave ArrayBookmark Suggest Edit
public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        if (a.size() < 2) return a;

        Collections.sort(a);
        for (int i = 1; i < a.size(); i+=2) {
            Collections.swap(a, i, i-1);
        }

        return a;
    }
}

// Kth Row of Pascal's TriangleBookmark Suggest Edit
public class Solution {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> ans = new ArrayList<Integer>(Collections.nCopies(a + 1, 1));
        for (int r = 2; r <= a; r++) {
            int last = 1;
            ans.set(r, 1);
            for (int c = 1; c < r; c++) {
                int cur = ans.get(c);
                ans.set(c, last + ans.get(c));
                last = cur;
            }
        }
        return ans;
    }
}
