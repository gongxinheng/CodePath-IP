// Preorder Traversal
public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    ArrayList<Integer> ans = new ArrayList<>();
	    if (a == null) return ans;
	    
	    preorder(ans, a);
	    
	    return ans;
	}
	
	public void preorder(ArrayList<Integer> res, TreeNode a) {
	    if (a == null) return;
	    res.add(a.val);
	    preorder(res, a.left);
	    preorder(res, a.right);
	}
}

// Max Depth of Binary Tree
public class Solution {
	public int maxDepth(TreeNode a) {
	    if (a == null) return 0;
	    return Math.max(maxDepth(a.left), maxDepth(a.right)) + 1;
	}
}
