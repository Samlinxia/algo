public class SingleLinkedList{
	private Node head = null;
	private Node curr;    //use reference to iterate instead of iterator(pointer) in C++
	private int theSize;
	
	public SingleLinkedList()
	{ 
		curr = head = new Node(); 
		theSize = 0;
	}
	public void add(int d)
	{
		Node n = new Node(d);
		curr = curr.next = n;
		theSize++;
	}
	public void addNodeToList(Node n)
	{
		curr = curr.next = n;
		theSize++;
	}
	
	public Node getHead()
	{return head;}
	
	public int size()
	{
		return theSize;
	}
}