/**Linked-based Stack implementation*/
class LStack<E> implements Stack<E>{
	
	private LinkedNode<E> top;  //point to the 1st valid element; no need head and toppest void node
	private int theSize;
	public LStack()
	{
		top = null;
		theSize = 0;
	}
	
	public LStack(int initSize)
	{
		this();  		//call constructor
	}
	
	public void clear()
	{
		top = null;
		theSize = 0;
	}
	
	public void push(E x)
	{
		top = new LinkedNode<E>(x,top);
		theSize++;
	}
	
	public E pop()
	{
		if(top != null)
		{
			E temp = top.data;
			top = top.next;
			theSize--;
			return temp;
		}
		else
		{
			System.out.println("Stack is empty");
			return null;
		}
	}
	
	public E topValue()
	{
		return top.data;
	}
	
	public int size()
	{
		return theSize;
	}
}