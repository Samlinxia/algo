/*Write an algorithm to find the 'next' node (e.g., 
in-order successor) of a given node in a binary search 
tree where each node has a link to its parent.*/
/**1. If X has a right child, then the successor must be on the right side of X (because of the order in which we visit nodes). Specifically, the left-most child must be the first node visited in that subtree.
2. Else, we go to X’s parent (call it P).
2.a. If X was a left child (P.left = X), then P is the successor of X
2.b. If X was a right child (P.right = X), then we have fully visited P, so we call successor(P).*/

class Chap45{
	
	public Node inorderSucc(Node x)
	{
		if(x == null)	return null;
		//1st condition x has right child
		else if(x.rightChild != null)
			return findLeftmostNode(x.rightChild);
		/*2nd condition: x don't has right child, 
		that's only has left child or no child at all */
		else{
			if(x.parent.leftChild == x)  //2a) x as left child of its successor
				return x.parent;
			else if(x.parent.rightChild == x)  //2b)  x as right child of its successor
				return findFirstLeftParent(x.parent);
			else
				return null;   // 2c) x as the root node that has no rightChild, think as a LinkedList
			
		}
	}
	
	public Node findLeftmostNode(Node x)
	{
		if(x.leftChild == null)		return x;
		return	findLeftmostNode(x.leftChild);
	}
	
	public Node findFirstLeftParent(Node x)
	{
		Node par = x.parent;
		//the last element of tree
		while( par.parent!= null && par.rightChild == x)
			x = x.parent;
		return par;
	}
	
	class Node{
		int data;
		Node leftChild;
		Node rightChild;
		Node parent;
	}


}