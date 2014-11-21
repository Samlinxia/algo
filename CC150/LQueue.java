/**Linked queue implementation*/
class LQueue<E> implements Queue<E> {
	
	private LinkedNode<E> front;
	private LinkedNode<E> rear;
	int theSize;
	
	public LQueue()
	{
		init();
	}
	
	public LQueue(int initSize)     //ignore size
	{
		init();
	}
	
	public void init()
	{
		front = rear = new LinkedNode<E>();
		theSize = 0;
	}
	
	public void clear()
	{
		init();
	}
	
	public void enqueue(E x)
	{
		rear = rear.next = new LinkedNode<E>(x);   //为了front指针操作，要new head node
		theSize++;
	}
	
	public E dequeue()
	{
		if(size() != 0)
		{
			front.next = front.next.next;  		//fix front at head null node; set head.next to next.next to implement dequeue 
//front = front.next is to move front in every operation; if so, the node pointed by front is also the poped node
//though it's available for outer operation, it's illogical in reality.
			E temp = front.data;
			if(front.next == null)
				rear = front;         //last Object, reset rear to head node
			theSize--;
			return temp;
		}
		else
			return null;
	}
	
	public E frontValue()
	{
		if(size() != 0)
		{
			return front.next.data;
		}
		else
			return null;
	}
	
	public int size()
	{	return theSize;	}
	

}