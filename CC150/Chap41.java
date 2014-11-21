/**Implement a function to check if a tree is balanced.*/
class Chap41{
	//The height of a tree is one more than the depth of the deepest node in the tree.
	
	/**Caculate the height of tree. As well as calculate the Max Deep*/
	public static int maxDepth(TreeNode root)
	{
		if(root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
	
	}
	
	/**Caculate the min height of tree*/
	public static int minDepth(TreeNode root)
	{
		if(root == null)
			return 0;
		return Math.min(minDepth(root.left), minDepth(root.right)) +1;
	
	}
	
	
	public static boolean isBalanced(TreeNode root)
	{
		if(maxDepth(root) - minDepth(root) <= 1)
			return true;
		return false;
	}

}