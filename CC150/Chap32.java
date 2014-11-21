/**design a stack which, in addition to push and pop, 
also has a function min which returns the minimum element? Push, 
pop and min should all operate in O(1) time.*/
class Chap32{
//use additional stack to store min element
	public class StackWithMin extends AStack<Integer>{
		private AStack<Integer> minStack;   //extra stack to store min value

		
		public StackWithMin(int initSize)
		{
			super(initSize);
			minStack = new AStack<Integer>(initSize);
		}
		
		public StackWithMin()
		{
			super();
			minStack = new AStack<Integer>();
		}
		
		@Override
		public void clear()
		{
			super.clear();
			minStack.clear();
		}
		

		public void push(int data)
		{
			super.push(data);
			if(data < min())
				minStack.push(data);
		}
		

		public Integer pop()
		{
			Integer result = super.pop();
			if(result == min())
				minStack.pop();
			return result;
		}
		
		public int min()
		{
			if(!minStack.isEmpty())
				return minStack.topValue();
			else
				return 0;
		}
		
	
	}
	
	
}