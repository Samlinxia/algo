/**Binray Search Tree implementation for Dictionary ADT*/
class BST<Key extends Comparable<? super Key>, E> implements Dictionary<Key, E>{
		
	private BSTNode<Key,E>	root;
	private int nodeCount;	//Number of nodes in the BST
	
	/**Construct tree with the root node*/
	public BST(BSTNode<Key,E> n)
	{
		root = n;
		nodeCount = 1;
	}
	
	public BST()
	{	root = null;	
		nodeCount = 0;	
	}
	
	public void clear()
	{	
		root = null;	
		nodeCount = 0;	
	}
	
	public void insert(Key k, E e)
	{
		root = insertHelp(root, k, e);
		nodeCount++;
	}
	
	public E remove(Key k)
	{
		E temp = findHelp(root, k);   //First find it
		if(temp != null)
		{	
			root = removeHelp(root,k);   //now remove it
			nodeCount--;
		}
		return temp;
	}
	
	/**Remove and return the rootnode from the dictionary
		@return the record removed, null if tree is empty*/
	public E removeAny()
	{
		if(root == null)	return null;
		E temp = root.element();
		root = removeHelp(root, root.key());
		nodeCount--;
		return temp;
	}
	
	public E find(Key k)
	{
		return findHelp(root, k);
	}
	
	public BSTNode<Key,E> getRoot()
	{
		return root;
	}
	
	//---------------------------4 kinds of traversal----------------
	public void preorder(BSTNode<Key,E> root)
	{
		if(root == null)
			return;
		visitTree(root.element());     //do whatever you specified, here simply print out
		preorder(root.left());
		preorder(root.right());
	}
	
	public void inorder(BSTNode<Key,E> root)
	{
		if(root == null)
			return;
		inorder(root.left());
		visitTree(root.element());
		inorder(root.right());
	}
	
	public void postorder(BSTNode<Key,E> root)
	{
		if(root == null)
			return;
		postorder(root.left());
		postorder(root.right());
		visitTree(root.element());
	}
	
	public void bfsTraversal(BSTNode<Key,E> root)
	{
		if(root == null)
			return;
		AQueue<BSTNode<Key,E>> queue = new AQueue<BSTNode<Key,E>>();
		queue.enqueue(root);
		BSTNode<Key,E> visitNode;
		while(!queue.isEmpty())
		{
			visitNode = queue.dequeue();
			/*add code to visit 
			the node here*/
			visitTree(visitNode.element());
			/*If there is a left child, add it for later processing.*/
			if(visitNode.left() != null)
				queue.enqueue(visitNode.left());
			/*If there is a right child, add it for later processing.*/		
			if(visitNode.right() != null)
				queue.enqueue(visitNode.right());
		}
	}
	
	
	//----------------------------private helper methods-----------------------
	
	/**@return the current subtree, modified to contain the new item*/
	private BSTNode<Key,E> insertHelp(BSTNode<Key,E> rt, Key k, E e)
	{
		if(rt == null)	return new BSTNode<Key,E>();
		if(rt.key().compareTo(k) > 0)
			rt.setLeft(insertHelp(rt.left(), k, e));
		else
			rt.setRight(insertHelp(rt.right(), k, e));
		return rt;
	}
	
	/**Remove the node with minimum key value.
		move down the left link until there is no left link to follow, called S
		remove S simply change the parent of S point to right child of S*/
	private BSTNode<Key,E> deleteMin(BSTNode<Key,E> rt)
	{
		if(rt.left() == null)
			return rt.right();
		else
			rt.setLeft(deleteMin(rt.left()));
		return rt;
	}
	
	/**@Return the minimum node in the subtree*/
	private BSTNode<Key,E> getMin(BSTNode<Key,E> rt)
	{
		if(rt.left() == null)
			return rt;
		else
			return getMin(rt.left());    //insightful code! Directly return the function to maintain unchanged
		
	}
	
	/**Remove a node with key value k
		@return the tree with the node removed*/
	private BSTNode<Key,E> removeHelp(BSTNode<Key,E> rt, Key k)
	{
		if(rt == null)	return null;  //if root is null, return null
		if(rt.key().compareTo(k) > 0)
			rt.setLeft(removeHelp(rt.left(),k));
		else if(rt.key().compareTo(k) < 0)
			rt.setRight(removeHelp(rt.right(),k));
		else  // found
		{
			if(rt.isLeaf())  //rt is Leaf
				return null;
			//only one child
			else if(rt.left() == null)
				return rt.right();
			else if(rt.right() == null)
				return rt.left();
			else	//have two child, find the least node greater than removed node
			{
				BSTNode<Key,E> temp = getMin(rt.right());
				rt.setElement(temp.element());
				rt.setKey(temp.key());
				rt.setRight(deleteMin(rt.right()));
			}
		
		}
		return rt;
			
	}
	
	
	
	private E findHelp(BSTNode<Key, E> rt, Key k)
	{
		if(rt == null)	return null;
		if(rt.key().compareTo(k) == 0)
			return rt.element();
		else if(rt.key().compareTo(k) > 0)
			return findHelp(rt.left(),k);     //return directly without change the original found element
		else
			return findHelp(rt.right(),k);
		
	}
	
	/**inorder traversal on BST to print the node value in ascending order*/
	
	public int size()
	{
		return nodeCount;
	}
	
	private void visitTree(E e)
	{
		System.out.println(e.toString());
	}
}