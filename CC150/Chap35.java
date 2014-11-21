/**Implement a MyQueue class which implements a queue using two stacks.*/
/*We push the new elements onto s1, 
and peek and pop from s2. When s2 is empty, 
we’ll transfer all the elements from s1 onto s2, in reverse order
keep element sit in S2 unless is empty*/
class Chap35{

	class stackQueue<E>
	{
		private int stackSize;
		private AStack<E> sq1;  	//data pushed in
		private AStack<E> sq2;  	//data poped out
	
		public stackQueue(int initSize)
		{
			stackSize = initSize/2;
			sq1 = new AStack<E>(stackSize);
			sq2 = new AStack<E>(stackSize);
		}
		
		public stackQueue()
		{
			sq1 = new AStack<E>();
			sq2 = new AStack<E>();
		}
		
		public void enqueue(E data)
		{
			sq1.push(data);
		}
		
		public E dequeue()
		{
			if(!sq2.isEmpty())
			{
				while(!sq1.isEmpty())
				{
					sq2.push(sq1.pop());
				}
			}
			return sq2.pop();
		}
		
		public E frontValue()
		{
			if(!sq2.isEmpty())
			{
				while(!sq1.isEmpty())
				{
					sq2.push(sq1.pop());
				}
			}
			return sq2.topValue();
		}
		
		public void clear()
		{
			sq1.clear();
			sq2.clear();
		}
		
		public int size()
		{
			return sq1.size()+sq2.size();
		}
	
	
	}
	
}