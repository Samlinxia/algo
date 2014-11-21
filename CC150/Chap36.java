/**sort a stack in ascending order; use push | pop | peek | isEmpty only*/


class Chap36{
	
	/*use an additional stack; Iterate until the original stack is empty and in each iteration, 
	pop an element from the original stack, 
	while the top element in the second stack is bigger than the removed element, 
	pop the second stack and push it to the original stack. 
	Now you can push the element you originally popped off the original stack to the second stack.*/
	public static AStack<Integer> sortStack(AStack<Integer> originalStack)
	{
		AStack<Integer> newStack;
		int temp;   //serve as bookmark&comparator, iterative compare to the stack element then insert to its right place
		while(!originalStack.isEmpty())
		{	
			temp = originalStack.pop();
			
			while(!newStack.isEmpty() && newStack.topValue()>temp)
			{
				originalStack.push(newStack.pop());
			}
			newStack.push(temp);
		}
		
		return newStack;
	}
	
	
	/*If there is no limitation on using other data structures, I would say the minimum heap. 
	whenever popping a element from stack, put into the heap. 
	When popping is done, taking element from the top of heap (minimum of the rest) 
	and pushing it into the stack. Repeating such process until heap is empty.
	For creating a heap, the average time is O(nlogn); 
	for deleting elements from heap and putting elements back in ascending order, 
	the average time is O(nlogn) too. Or use other sort */
	public static AStack<E> sortStack2(AStack<E> originalStack)
	{
		
	
	}
	
	
	//It can be done recursively using the same stack. O(n^2)
	
	public static void insert(E element, AStack<E> stack)
	{
		if(element > stack.topValue())
		{
			E top = stack.pop();
			Insert(element, stack);
			stack.push(top);
		}
		else
		{
			stack.push(element);
		}
	}


	public static void sortStack3<E>(AStack<E> stack)
	{
		if(!stack.isEmpty())
		{
			E top = stack.pop();
			sortStack3(stack);
			insert(top, stack);    
		}    
	}





}