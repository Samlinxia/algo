class Node{
	Node next = null;
	int data;
	public Node(){data = 0;}
	public Node(int d){data=d;}	
	public Node(int d, Node n){data = d;	next = n;}
}