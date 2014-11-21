/*You have two very large binary trees: T1, with millions of nodes, and T2, 
with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.*/

class Chap47{
//--------------------------Method 1-------------------------------------
	/**Use cache to store nodes in list.  Preorder and inorder traversal can decide 
	an unique tree.  So traverse each tree two time and store nodes as List. 
	check four String.  
	traverse TreeNodes and store nodes in list consume 4*n; 
	Use java inner method to check subStirng. i.e.  string1.contains(string2) 
	It will throw a NullPointerException if String2 is null. 
	I would check that String2 is not null before trying the comparison*/	
	public boolean containsTree1(TreeNode t1, TreeNode t2)
	{
		
		return true;
	}
	
	
	
	
	
//---------------------------Method 2------------------------------------
	/**Don't use cache, use recursion instead.  Brutal force traverse large tree
		and check subtree node*/
	public boolean containsTree(TreeNode t1, TreeNode t2)
	{
		if(t2 == null)
			return true;	//empty tree is always subtree
		return isSubTree(t1, t2);
	}
	
	private boolean isSubTree(TreeNode t1, TreeNode t2)
	{
	//preorder traverse t1.
		if(t1 == null)	return false;  //Big tree empty & subtree still not found
	    if(t1.data == t2.data)   //find the equal root.
		{	
			if(matchTree(t1, t2))    //call matchTree() to check whether is subtree
				return true;	    
/*Notes: Can't use return matchTree(t1,t2) here.  cos it will return false then t1 will no longer track
 this path.  use this conditional flow limit to return true only.*/
		}
		/*preorder traverse large tree, as long as one branch of tree is found matched subtree,
		the final result return true.  So use || here*/
		return (isSubTree(t1.left, t2) || isSubTree(t1.right, t2));
/*Notes: 
	1. Write recursive function in return type could search in the tail and return the deepest, final result.
	2. Use dual operator ||, && to: 
		1)simplify the traversal code 
		e.g. traditional traversal code like:  
			preorder(t1.left, t2);
			preorder(t1.rigght, t2);
		2) combine the return result to give a logical result according to reality*/
		
	}
	
	/*Check if t2 is subtree of t1 starting at the root of t1, t2*/
	private boolean matchTree(TreeNode t1, TreeNode t2)
	{
	    if(t1 == null && t2 == null)
			return true;    // both t1 and t2 are null, nothing left in the subtree
		if(t1 == null || t2 == null)
			return false;	// one of TreeNode is null, not match
	    if(t1.data != t2.data)
			return false; 
		return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
	}
	
	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
	}
	
	
}