/**Array-based Stack implementation*/
class AStack<E> implements Stack<E>{

	private static final int defaultSize = 10;
	
	private int maxSize; //also known as capacity
	private int top;     //indicate the top of stack(1st void value) as well as the size of stack
	private E[] listArray;
	
	AStack()
	{this(defaultSize);}
	
	@SuppressWarnings("unchecked")
	AStack(int size)
	{
		maxSize = size;
		top = 0;
		//Create listArray. Specially, in java can't new E[] directly using generic para
		listArray = (E[])new Object[size];   
	}
	
	public void clear()
	{
		while(top != 0)
			pop();
		top = 0;
	}
	
	public void push(E data)
	{
		if(maxSize != top)
			listArray[top++] = data;
		else
			System.out.println("Stack is full!");
	}
	
	public E pop()
	{
		if(top != 0)
		{
			E result = listArray[--top];
			listArray[top] = null;         //memory leak process
			return result;
		}
		else
			System.out.println("Stack is full!");
			return null;
	}
	
	public E topValue()
	{
		if(top != 0)
			return listArray[top-1];
		else
			System.out.println("Stack is full!");
			return null;
	}
	
	public int size()
	{
		return top;
	}

	public boolean isEmpty()
	{
		if(size() == 0)
			return true;
		return false;
	}

}