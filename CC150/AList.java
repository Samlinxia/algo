/**Array-based List implementation, like Vector in C++*/
class AList<E> implements List<E>{
	private static final int defaultSize = 10;
	private int capacity;
	private int theSize;
	private int curr;
	private E[] listArray;
	
	public AList()
	{	this(defaultSize);	}
	
	@SuppressWarnings("unchecked")
	public AList(int initSize)
	{
		capacity = initSize;
		theSize = curr = 0;
		listArray = (E[])new Object[initSize];
	}
	
	public void clear()
	{
		theSize = curr = 0;
	}
	
	/**Insert data at current position*/
	public void insert(E data)
	{
		if(theSize != capacity)
		{
			for(int i = theSize; i>curr; i--)
				listArray[i] = listArray[i-1];
			listArray[curr] = data;
			theSize++;
		}
		else
			System.out.println("capacity of list exceed");
	}
	
	public void append(E data)
	{
		if(theSize != capacity)
		{
			listArray[theSize++] = data;  //shift elements up to make room
		}
		else
			System.out.println("capacity of list exceed");
	}
	/**Remove the current value*/
	public E remove()
	{
		if(curr<0 || curr>= theSize)
			return null;
		E result = listArray[curr];
		for(int i=curr; i<theSize-1; i++)
		{
			listArray[i] = listArray[i+1];  //shift them down to cover
		}
		listArray[--theSize] = null;       //set the last element to null, leakage memory, size-1
		return result;
	}
	
	public void moveToStart()
	{
		curr = 0;
	}
	
	public void moveToEnd()
	{
		curr = theSize;    //the first invalid element position
	}
	
	/**Move the current position one step left.*/
	public void prev()
	{
		if(curr != 0)
			curr--;
	}
	
	public void next()
	{
		if(curr < theSize)
			curr++;
	}
	
	public int size()
	{
		return theSize;
	}
	
	/**@return the position of current element*/
	public int currPos()
	{
		return curr;
	}
	
	/**Set current position*/
	public void moveToPos(int pos)
	{
		if(pos >= 0 && pos < theSize)   //pos out of range check
			curr = pos;
	}
	
	public E getValue()
	{
		assert curr >= 0 && curr < theSize : "No current element!";
		return listArray[curr];
	}
	
	
}