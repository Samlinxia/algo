//remove duplicates from an unsorted linked list
import java.util.HashSet;


class Chap21{
//use buffer, could use hashtable or hashset
//pass head node as parameter instead of whole linkkedList. 
//In c++, pass parameter by iterator, which indeed is a pointer plus some encapsulated method
	public static void removeDuplicates(Node n)
	{
		HashSet<Node> hs = new HashSet<Node>();
		Node previous = null;
		while(n != null)
		{
			if(hs.contains(n))
				previous.next = n.next;
			else
			{
				hs.add(n);
				previous = n;
			}
			n = n.next;
		}
		
	}
	
//use two pointer instead of buffer, brutal force
	public static void removeDuplicates2(Node head)
	{
		Node n = head.next;
		while(n != null)
		{
			Node it = head.next;
			while(it!=n)
			{
				if(it.data == n.data)
					break;
				it=it.next;
			}
			if( it != n)
			{
				while(it.next != n)
				{
					it=it.next;
				}
				it.next = n.next;
			}	
			n = n.next;
		}
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
		Chap21.removeDuplicates2(sll.getHead());
		printList(sll);
	}
}