class ConvertBTtoLL {

/**Convert Binary Search tree to Doubly linked list.  Do it in place*/ 
	public void convert(TreeNode root) {
		if (root == null) {
			return;
		}
		List<TreeNode> pre = new ArrayList<>();
		helper(root, pre);
		return pre.get(0);
	}
	//Method 1: implement by ref parameter. In java store it in array to point to same obj
	private static void helper(TreeNode root, List<TreeNode> pre) {
		if (root == null) {
			return;
		}
		helper(root.left, pre);
		if (pre.size() == 0) {
			pre.add(root); //pre[0] is new head of doublyLL to return
			pre.add(root); //pre[1] is pre listnode of cur node
		} else {
			root.left = pre.get(1);
			pre.get(1).right = root;
			pre.set(1, root);
		}
		helper(root.right, pre);
	}
	
	/*Method 2: Global variable*/
	private TreeNode pre = null;
	private TreeNode head = null;
	private static void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		if (pre == null) {
			head = root;
			pre = root;
		} else {
			pre.right = root;
			root.left = pre;
			pre = root;
		}
		helper(root.right);
	}
}