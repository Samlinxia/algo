/**Max-heap implemented with array*/
class MaxHeap<E extends Comparable<? super E>>{
	
	private E[] heap;  //Pointer to the heap array
	private int capacity;	//Maximum size of heap
	private int theSize;  // Number of objects in heap

	/**constructor supporting preloading of heap content
	@param pointer to array, number of element, capacity of element*/
	public MaxHeap(E[] h, int num, int max)
	{
		heap = h;
		capacity = max;
		theSize = num;
		buildHeap();
	}
	
	/**Insert element into heap
		first put value at the back of heap(array), 
		then siftUp level by level until to its correct place*/
	public void insert(E data)
	{
		assert theSize < capacity : "Heap is full";
		int curr = theSize++;
		heap[curr] = data;   //start at end of heap
		while(heap[curr].compareTo(heap[parentPos(curr)]) > 0 && curr >= 0 )
		{
			DSutil.swap(heap, curr, parentPos(curr));    //swap value if data greater than its parent 
			curr = parentPos(curr);		//relocate pointer to trace inputed data
		}
	}
	
	/**Heapify contents of heap
		given an abitrary array, convert it to heap through exchange their position
		as long as satisfy the property of heap, partial order*/
	public void buildHeap()
	{
		for(int i = theSize/2 - 1; i >= 0; i--)
		{
			siftdown(i);      /*start with the first parent node, 
		    consecutively sift down all parents to corret position*/
		}
	}
	
	/**Put one element in its downwards correct place 
	@param pos position of element*/
	public void siftdown(int pos)
	{
	assert (pos >=0) && (pos < theSize) : "Illegal heap position";
		while(!isLeaf(pos)){
				
		int curr = leftChildPos(pos);	//get the leftChild of inputed parent node
		/*compare two children if have two, then move pointer point to bigger one */
		
		if(heap[curr+1] != null && heap[curr].compareTo(heap[curr+1]) < 0)
		{
			curr++;	//point to bigger one
		}
		//compare parent to child, return if parent is bigger
		if(heap[curr].compareTo( heap[parentPos(curr)] ) < 0)
			return;
		DSutil.swap(heap, pos, curr);
		pos = curr;  //pos, parameter, could reassignment, just used as local variable
		}
	}
	
	/**Remove and return maximum value
		siftup remaining elements*/
	public E removeMax()
	{
		assert theSize > 0 : "removing from empty heap";
		if(theSize == 1)	//the last and only one element
		{
			return heap[--theSize];
		}
		E temp = heap[0];
		DSutil.swap(heap, 0, --theSize);   //swap maximum with last value
		siftdown(0);	//put new root value in correct place downwards
		return temp;  
	}
	
	/**Remove and return element at specified position
		difficulty is to maintain the complete tree strucutrue after remove
		arbitrary speicified element*/
	public E remove(int pos)
	{
		assert (pos >=0) && (pos < theSize) : "Illegal heap position";
		if(pos == theSize-1)		//the last element
			--theSize;		//need not swap and siftdown
		else
		{
			DSutil.swap(heap, pos, --theSize);
			siftdown(pos);
		}
		return heap[theSize];	//return the specified value temporarily put in the last place
	}
	
	/**Get the maximum value, the root*/
	public E peek()
	{
		return heap[0];
	}
	
	/**@return current size of the heap*/
	public int size()
	{
		return theSize;
	}
	
	/*try some cases to find the relationship between parent and leaf node*/
	public boolean isLeaf(int pos)
	{
		return (pos >= theSize / 2) && (pos < theSize );
	}
	
	/**@return left child object*/
	public E left(int pos)
	{
		return heap[pos * 2 + 1];
	}
	
	/**@return right child object*/
	public E right(int pos)
	{
		return heap[pos * 2 + 2];
	}
	
	public E parent(int pos)
	{
		return heap[(pos - 1) / 2];
	}
	
	/*------------------------------------private method----------------------------*/
	/**@return position for left child*/
	private int leftChildPos(int pos)
	{
		return pos * 2 + 1;
	}
	
	/**@return position for right child*/
	private int rightChildPos(int pos)
	{
		return pos * 2 + 2;
	}
	
	/**@return position for parent]*/
	private int parentPos(int pos)
	{
		return (pos - 1) / 2; 
	}
}
