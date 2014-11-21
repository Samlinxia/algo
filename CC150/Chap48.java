/*You are given a binary tree in which each node contains a value. 
Design an algorithm to print all paths which sum up to that value. 
Note that it can be any path in the tree - it does not have to start at the root.*/

import java.util.ArrayList;

class Chap48{
	
	/**@param TreeNode to be recursively traverse
	   @param sum the number to be sum up, invariant
	   @param buffer the sum of path from current node to root, copy in every level
	   @param level indicate the level of tree, increment*/
	public void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level)
	{
		if(head == null) return;
		int temp = sum;
		for(int i = level; i >= 0; i--)
		{
			temp -= buffer.get(i);
			if(temp == 0)
				print(buffer, i, level);
		}
		
		// copy new buffer at every level so that buffer only contains
		//value from current node back to the root.
		ArrayList<Integer> c1 = (ArrayList<Integer>)buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>)buffer.clone();
		//preorder traverse
		findSum(head.left, sum, c1, level+1);
		findSum(head.right, sum, c2, level+1);
	}
	
	private void print(ArrayList<Integer> buffer, int level, int i2)
	{
		for(int i = level; i <= i2; i++)
		{
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}

}