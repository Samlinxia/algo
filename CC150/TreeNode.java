/**Common tree binary tree node used as practice*/
public class TreeNode{
	public int element;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data, TreeNode l, TreeNode r)
	{
		element = data;
		left = l;
		right = r;
	}
	
	public TreeNode(int data)
	{
		element = data;
		left = right = null;
	}

}