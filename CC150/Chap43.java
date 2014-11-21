/**Given a sorted (increasing order) array, 
write an algorithm to create a binary tree with minimal height.*/
class Chap43{
	
	public static TreeNode addToTree(int[] arr, int start, int end)
	{
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = addToTree(arr, start, mid-1);
		n.right = addToTree(arr, mid+1, end);
		return n;
	}
	
	public static TreeNode createMinimalBST(int[] arr)
	{
		return addToTree(arr, 0, arr.length - 1);
		
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode root = createMinimalBST(arr);
		printTree(root);
	
	}
	
	//preorder print out element
	private static void printTree(TreeNode root)
	{	
		if(root == null)
			return;
		System.out.println(root.element);
		printTree(root.left);
		printTree(root.right);

	}
}