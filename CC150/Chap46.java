/*Design an algorithm and write code to find 
the first common ancestor of two TreeNodes in a binary tree.
 Avoid storing additional TreeNodes in a element structure. 
NOTE: This is not necessarily a binary search tree.*/
class Chap46{
	public TreeNode firstCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2)
	{
		if(t1 == null || t2 == null)
			return null;
		int count = 0;
		if(root == null)
			return null;
		int result = checkChild(root.left,t1,t2, count);  // check one side can know the other side
		if(count == 0)  // objective t1 & t2 is 
			return firstCommonAncestor(root.right, t1, t2);
		else if(count == 1)
			return root;
		else  // count == 2 condition
			return firstCommonAncestor(root.left, t1, t2); 
			
	}
	
	/*Check how many objective TreeNode: t1, t2 located in this branch*/
	public int checkChild(TreeNode root, TreeNode t1, TreeNode t2, int count)
	{
		if(root == null)
			return 0;
		if(root.element == t1.element || root.element == t2.element)
			return ++count;
		return (checkChild(root.left, t1, t2, count) + checkChild(root.right, t1, t2, count));
				
	}

	
}