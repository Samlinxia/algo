/**generic Linked Node*/
class LinkedNode<E>{
	public E data;
	public LinkedNode<E> next;
	
	public LinkedNode(E x, LinkedNode<E> p)
	{
		data = x;
		next = p;
	}
	
	public LinkedNode(E x)
	{
		data = x;
		next = null;
	}
	
	public LinkedNode()
	{}
}