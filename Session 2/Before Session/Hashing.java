// Points on the Straight Line
public class Solution {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int ans = 0;
        int n = a.size();
        for (int i = 0; i < n; i++) {
            int duplicate = 1;
            Map<javafx.util.Pair<Integer, Integer>, Integer> m = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int ix = a.get(i);
                int iy = b.get(i);
                int jx = a.get(j);
                int jy = b.get(j);
                int dx = jx - ix;
                int dy = jy - iy;
                if (ix == jx && iy == jy) {
                    ++duplicate;
                    continue;
                }
                int d = gcd(dx, dy);
                javafx.util.Pair<Integer, Integer> pair = new javafx.util.Pair<>(dx / d, dy / d);
                m.put(pair, m.getOrDefault(pair, 0) + 1);
            }
            ans = Math.max(ans, duplicate);
            for (Map.Entry<javafx.util.Pair<Integer, Integer>, Integer> e : m.entrySet()) {
                ans = Math.max(ans, e.getValue() + duplicate);
            }
        }
        return ans;
    }

    // Greatest common divisor
    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}

// 2 Sum
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
