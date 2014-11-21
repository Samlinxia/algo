/**Binary tree node implementation: Pointers to chilren
@Param E the data element
@Param Key the associated key for the record*/
public class BSTNode<Key,E> implements BinNode<E>{

	private Key key;
	private E element;
	private BSTNode<Key,E> left;
	private BSTNode<Key,E> right;

	public BSTNode()	{left = right = null;}
	public BSTNode(Key k, E val)
	{
		key = k;	element = val;
		left = right = null;
	}

	public BSTNode(Key k, E val, BSTNode<Key,E> l, BSTNode<Key,E> r)
	{
		key = k;	element = val;
		left = l;	right = r;
	}

	/**Get and set the key value*/
	public Key key()	{	return key;	}
	
	public void setKey(Key k)	{key = k;}

	/**Get and set the element*/
	public E element()	{	return element;	}
	
	public void setElement(E val)	{element = val;}

	/**Get and set the left child*/
	public BSTNode<Key,E> left()	{	return left;	}
	public void setLeft(BSTNode<Key,E> p)	{left = p;}
	
	/**Get and set the right child*/
	public BSTNode<Key,E> right()	{	return right;	}
	public void setRight(BSTNode<Key,E> p)	{right = p;}
	
	/**@Return True if a leaf node, false otherwise*/
	public boolean isLeaf()
	{
		return	(left == null) && (right == null);
	}




}