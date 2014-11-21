/**double linkedList node
  unlike c++ use pointer to implement operation directly, like it->next
  java encapsulate in function, like setNext(), getValue(), to implement operation */

class LinkedListNode<E>{
		public E data;
		public LinkedListNode<E> next;
		public LinkedListNode<E> prev;
		
		public LinkedListNode(E x, LinkedListNode<E> nextVal, LinkedListNode<E> preVal)
		{
			data = x;
			next = nextVal;
			prev = preVal;
		}
		
		public LinkedListNode(E x)
		{
			data = x;
			next = null;
			prev = null;
		}
		
		public LinkedListNode()
		{	
			data = null;
			next = null;
			prev = null;
		}
		//return next field
		public LinkedListNode<E> next()
		{return next;}
		//set next field
		public LinkedListNode<E> setNext(LinkedListNode<E> nextVal)
		{return next = nextVal;}
		//return data
		public E element() {return data;}
		
		//set element field
		public E setElement(E elem)
		{return data = elem;}
		
		public LinkedListNode<E> prev()
		{return prev;}
		
		public LinkedListNode<E> setPrev(LinkedListNode<E> prevVal)
		{return prev = prevVal;}
	}
	