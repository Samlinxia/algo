/**Given a circular linked list, implement an algorithm which returns node at the beginning of the loop*/
class Chap25{
	public static Node findLoop(Node head)
	{
		if(head == null)	return null;
		
		Node fast = head;
		Node slow = head;
		
		// finding meeting point
		while(fast != null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)	break;
		}
		//error check; there is no loop before meeting
		if(fast == null)	return null;
			
		//set a pointer to the head which has the same distance to start looping point as the meeting point	
		slow = head;
		while(fast != slow)
		{
			fast = fast.next;
			slow = slow.next;
		}
		//now fast and slow points at the start of loop
		return fast;
			
	}
}