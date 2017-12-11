// Magician and Chocolates
public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> q = new PriorityQueue<>(B.size(), Collections.reverseOrder());
        for (int i = 0; i < B.size(); i++) {
            q.offer(B.get(i));
        }
        
        long ans = 0;
        for (int i = 0; i < A; i++) {
            int n = q.poll();
            ans += n;
            q.offer(n / 2);
        }
        
        return (int)(ans % (1000000007));
    }
}

// Distinct Numbers in Window
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        Map<Integer, Integer> m = new HashMap<>();
        int count = 0;
        int left = 0; // window left bound
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = A.get(i);
            int t = m.getOrDefault(num, 0) + 1;
            m.put(num, t);
            if (t == 1) {
                count++;
            }

            if (i - left + 1 == B) {
                ans.add(count);
                num = A.get(left++);
                t = m.getOrDefault(num, 0) - 1;

                if (t == 0) {
                    count--;
                }
                m.put(num, t);
            }
        }
        
        return ans;
    }
}

