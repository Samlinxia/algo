/**find the nth to last element of a singly linked list  */

class Chap22{
	public static Node nthToLast(Node head, int n)
	{
		if(head == null || n < 1)
			return null;
		Node front = head;
		Node back = head;
		int i = 0;
		while(i < n)
		{
			if(front == null)
				return null;  //list has node less than n
			front = front.next;
			i++;
		}
		while(front.next != null)
		{
			front = front.next;
			back = back.next;
		}
		return back;	
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
		for(int i=0;i<10;i++)
		sll.add(i);
		sll.add(4);sll.add(11);sll.add(16);sll.add(2);sll.add(9);
		System.out.println(Chap22.nthToLast(sll.getHead(),7).data);
		printList(sll);
	}
}