/**Array-based Queue implementation*/
class AQueue<E> implements Queue<E>{

	private static final int defaultSize = 10;

	private E[] listArray;
	private int maxSize;
	private int front;
	private int rear;
	
	public AQueue()
	{
		this(defaultSize);
	}
	
	@SuppressWarnings("unchecked")
	public AQueue(int initSize)
	{
		maxSize = initSize + 1;
		listArray = (E[]) new Object[maxSize];   //此句产生warning
		front = 0;
		rear = 0;
	}
	
	public void clear()
	{
		front = 1;
		rear = 0;
	}
	
	public void enqueue(E x)
	{
		if(size() != maxSize-1)
			listArray[(++rear) % maxSize] = x;
		else
			System.out.println("Queue is full!");
	}
	
	public E dequeue()
	{
		if(size() != 0)	
		{
			E temp = listArray[front];
			return listArray[(++front) % maxSize];
		}
		else
		{
			System.out.println("Queue is empty!");
			return null;
		}
	}
	
	public E frontValue()
	{
		if(size() != 0)	
			return listArray[front];
		else
		{
			System.out.println("Queue is empty!");
			return null;
		}
	}
	
	public int size()
	{
		return (rear + maxSize -front + 1) % maxSize;
	}
	
	public boolean isEmpty()
	{
		if(size() == 0)
			return true;
		return false;
	}

}