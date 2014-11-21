/** Double Linked List implementation*/
public class LList<E> implements List<E>{
	private LinkedListNode<E> head;
	private LinkedListNode<E> tail;
	private LinkedListNode<E> curr;
	private int theSize;
	
	public LList()
	{
		theSize = 0;
		curr = head = new LinkedListNode<E>();
		tail = new LinkedListNode<E>();
		head.next = tail;
		tail.prev = head;
	}
	
	public LList(int initSize)
	{
		this();
	}
	
	public void clear()
	{
		head.next().setPrev(null);
		head.setNext(null);
		tail.prev().setNext(null);
		tail.setPrev(null);
		curr = head;
		theSize = 0;
	}
	
	/**@return the value of first element*/
	public E front()
	{
		return head.next.data;
	}
	
	/**@return the value of last element*/
	public E back()
	{
		return tail.prev.data;
	}
	
	public void addFront(E data)
	{
		head.next.next.prev = head.next = new LinkedListNode<E>(data, head.next, head);
		theSize++;
	}
	

	/**Append element to list*/
	public void append(E data)
	{
		tail.prev = tail.prev.next = new LinkedListNode<E>(data, tail.prev, tail);
		theSize++;
	}
	
	public E deleteFront()
	{
		if(!isEmpty())
		{
			LinkedListNode<E> temp = head.next;
			head.next = temp.next;
			temp.next.prev = head;
			temp.next = temp.prev = null;
			theSize--;
			return temp.data;
		}
		return null;
	
	}
	
	public E deleteBack()
	{
		if(!isEmpty())
		{
			LinkedListNode<E> temp = tail.prev;
			tail.prev = temp.prev;
			temp.prev.next = tail;
			temp.next = temp.prev = null;
			theSize--;
			return temp.data;
		}
		return null;
	
	}
	
	
	/**Remove and return current element, increment curr point to next element*/
	public E remove()
	{
		if(!isEmpty())
		{
			LinkedListNode<E> temp = curr;
			curr = curr.next;   //increment curr
			temp.prev.next = curr;
			curr.prev = temp.prev;
			temp.next = temp.prev = null;
			theSize--;
			return temp.data;
		}
		return null;
	}
	
	
	/**Insert element to current position*/
	public void insert(E data)
	{
		curr.next.next.prev = curr.next = new LinkedListNode<E>(data, curr.next, curr);
		theSize++;
	}
	
	/**set curr point to first element*/
	public void moveToStart()
	{
		curr = head.next;
	}
	
	public void moveToEnd()
	{
		curr = tail.prev;
	}
	
	public void prev()
	{
		curr = curr.prev;
	}
	
	public void next()
	{
		curr = curr.next;
	}
	
	public int currPos()
	{
		assert !isEmpty() : "List is empty";
		LinkedListNode<E> temp = head.next;
		int i= 0;
		while(temp.equals(curr))
		{
			i++;
		}
		return i;
	}
	
	public void moveToPos(int pos)
	{
		if(!isEmpty())
		{
			int i = 0;
			curr = head.next;
			while(i < pos)
			{
				curr = curr.next;
			}
		}
	}
	
	/**@return the value of current position element*/
	public E getValue()
	{
		return curr.data;
	}
	
	public int size()
	{
		return theSize;
	}
	
	public boolean isEmpty()
	{
		if(size() == 0)
			return true;
		return false;
	}
	

}