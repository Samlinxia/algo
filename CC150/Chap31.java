/**use a single array to implement three stacks*/
/*array element define as StackNode, which store the value and previous index;
  use 3 pointer to point to the forehead element of particular stack
  use an additional indexBuffer stack to implement free list, used to store deleted element index:	
  For every insertion, we would delete an entry from the free list. 
  In case of deletion, we would simply add the index of the free cell to the free list
*/

class Chap31{
	private static final int defaultStackSize = 300;
	
	private int arrayCapacity;
	private StackNode[] arrayStack;
	private int lastIndex, nextIndex; //nextIndex indicate the headmost free index, say next index of the headmost pointer     
	private AStack<Integer> indexBuffer;          //store deletedIndex using stack ADT
	private int[] stackPointer = {-1,-1,-1};   
	private int[] theStackSize = {0,0,0};              //indicate the size of each stack
	

	@SuppressWarnings("unchecked")
	public Chap31(int initStackSize)
	{
		arrayCapacity = initStackSize * 3;
		arrayStack = new StackNode[arrayCapacity];
		indexBuffer = new AStack(initStackSize * 2);
		lastIndex = -1;
		nextIndex = 0;
	}
	
	public Chap31()
	{
		this(defaultStackSize);
	}
	
	public void push(int stackNum, int value)
	{
	//push data only when array is not full
		if(stackSize(stackNum) != arrayCapacity)
		{
			lastIndex = stackPointer[stackNum];
		//extract free index from indexBuffer
			if(!indexBuffer.isEmpty())              
				stackPointer[stackNum] = indexBuffer.pop();
		//push data to headmost free position
			else
				stackPointer[stackNum] = nextIndex++;
			arrayStack[stackPointer[stackNum]].data = value;
			arrayStack[stackPointer[stackNum]].prev = lastIndex;
			theStackSize[stackNum]++;
		}
		else
		{
			System.out.println("Stack is full!");
		}
	}
	
	
	public int pop(int stackNum)
	{
		assert stackSize(stackNum) != 0 : "Stack is empty";
			lastIndex = stackPointer[stackNum];
			stackPointer[stackNum] = arrayStack[stackPointer[stackNum]].prev;
		//decide to put the deleted Index to indexBuffer or decrement nextIndex
			if(lastIndex + 1== nextIndex)
				nextIndex--;
			else
				indexBuffer.push(lastIndex);
			int temp = arrayStack[lastIndex].data;
			arrayStack[lastIndex] = null;
			theStackSize[stackNum]--;
			return temp;
		
		
	}
	
	public int topValue(int stackNum)
	{
		return arrayStack[stackPointer[stackNum]].data;
	}
	
	public int Arraysize()
	{
		return arrayCapacity;
	}
	
	public int stackSize(int stackNum)
	{
		return theStackSize[stackNum];
	}
	
	public class StackNode{
	
		public int data;
		public int prev;
		
		public StackNode(int d, int p)
		{
			data = d;
			prev = p;
		}
	}
}