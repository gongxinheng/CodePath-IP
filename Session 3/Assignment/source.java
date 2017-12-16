// Identical Binary Trees
public class Solution {
    public int isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return 1;
        else if (a == null || b == null) return 0;
        else if (a.val == b.val) {
            return (isSameTree(a.left, b.left) == 1 && isSameTree(a.right, b.right) == 1) ? 1 : 0;
        }
        else {
            return 0;
        }
    }
}

// Balanced Binary Tree
public class Solution {
    public int isBalanced(TreeNode a) {
        if (a == null) return 1;
        return (Math.abs(getHeight(a.left) - getHeight(a.right)) <= 1
                && isBalanced(a.left) == 1
                && isBalanced(a.right) == 1) ? 1 : 0;
    }

    public int getHeight(TreeNode a) {
        if (a == null) return 0;
        return 1 + Math.max(getHeight(a.left), getHeight(a.right));
    }
}

// Rotated Sorted Array Search
public class Solution {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        if (a.size() == 0) return -1;

        int left = 0;
        int right = a.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a.get(mid) == b) {
                return mid;
            }

            // Ascending ?
            if (a.get(left) <= a.get(mid)) {
                if (a.get(mid) >= b && a.get(left) <= b) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (b <= a.get(mid) || b >= a.get(left)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return a.get(left) == b ? left : -1;
    }
}
