class Chap23{
	/*delete center node; use two pointer, one add 1, another add 2 per time, additional one used to delete*/
	public static boolean deleteNode(Node head)
	{
		if(head == null && head.next == null && head.next.next == null)	return false;
		Node front = head.next;
		Node back = head.next;
		Node prev = head;
		while(front != null && front.next != null)
		{
			front = front.next.next;
			back = back.next;
			prev = prev.next;
		}
		//delete the center node, back is the center node
		prev.next = back.next;
		return true;
	}
	
	
	/*删除指定的节点（这里的middle应该指的是除head和tail的节点），并且只给定要删除的节点*/
	public static boolean deleteNode2(Node n)
	{
		if(n != null && n.next != null)
			return false;
		Node temp = n.next;
		n.data = temp.data;
		n.next = temp.next;
		return true;
		
	}
	
	
	
}