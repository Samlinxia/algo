/** Post-order DFS.  Recursion
*/
 public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        postTraversal(root, res);
        return res;
    }
    
    public void postTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postTraversal(root.left, res);
        postTraversal(root.right, res);
        res.add(root.val);
    }
	
	/** Iteration & Stack
	*/
	
