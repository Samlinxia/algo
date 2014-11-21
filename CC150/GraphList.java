/**Ajacency list graph implementation*/
class GraphList implements Graph{
	private AList<Integer>[] vertex;		//The vertex list
	private int numEdge;		    //Number of edges
	public int[] mark;			//The mark array
	
	public GraphList()	{}
	public GraphList(int n)
	{	init(n); }
	
	public void init(int n)
	{
		mark = new int[n];
		vertex = new AList<Integer>[n];
		for(int i = 0; i < n; i++)
			vertex[i] = new AList<Integer>();
		numEdge = 0;
	}
	
	public int numbVertice()
	{
		return mark.length;		//# of vertices
	}
	
	public int numbEdges()
	{
		return numEdge;			//# of edges
	}
	
	public int firstNeighbor(int v)
	{
		if(vertex[v].length == 0)
			return mark.length;   //no neighbor
		vertex[v].moveToStart();
		Edge it = vertex[v].getValue();
		return it.vertex();
	}
	
	
	public int nextNeighbor(int v, int w)
	{
		
	}
	
	public void setEdge(int i, int j, int wght)
	

	public void delEdge(int i, int j);
	

	public boolean isEdge(int i, int j);
	

	public int weight(int i, int j);
	

	public void setMark(int v, int val);
	

	public int getMark(int v);
}