//adds the two nodes and returns the sum as a linked list
class Chap24{
	/**recursion, in order to output a result linkedlist, pass a list as parameter,
	coz recursion method fix to return a node everytime; or just print out the node every time got the sum value*/
	public static Node addList(SingleLinkedList sll, Node n1, Node n2, int carry)
	{
		if(n1 == null && n2 == null) 
		{	
			//这个容易忽略，最高位carry的进位和溢出问题
			if(carry == 1)
			{
				Node result = new Node(1);
				return result;
			}
			else
				return null;
		}
		Node result = new Node();
		int sum = carry;
		if(n1 != null)	
			sum = n1.data;
		if(n2 != null)
			sum += n2.data;
		result.data = sum % 10;
		
		sll.addNodeToList(result);
		
		Node nextNode = addList(sll,
								(n1 != null) ? n1.next : null,
								(n2 != null) ? n2.next : null,
								(sum >= 10) ? 1 : 0);
		result.next = nextNode;
		return result;
	}	
	
	
	static void printList(SingleLinkedList sll)
	{
		Node temp = sll.getHead().next;
		while (temp != null)  
        {
            System.out.print(temp.data + "  ");  
		 	temp = temp.next;
        }
		System.out.println();
	}

	
	public static void main(String[] args)
	{
		SingleLinkedList sll = new SingleLinkedList();
		SingleLinkedList sll2 = new SingleLinkedList();
		SingleLinkedList result = new SingleLinkedList();
		for(int i=0;i<10;i++)
		sll.add(i);
		sll.add(4);sll.add(11);sll.add(16);sll.add(2);sll.add(9);
		sll2.add(4);sll2.add(11);sll2.add(16);sll2.add(2);sll2.add(9);
		addList(result, sll.getHead().next, sll2.getHead().next,0);
		printList(sll);
		printList(sll2);
		printList(result);
	}
} 