/** Graph: Adjacency matrix*/
class GraphMatrix implements Graph {
	private int [][] matrix;	// The edge matrix
	private int numEdge;		//Number of edges
	public int[] mark;			//The mark array, also the number of vertex
	
	
	public GraphMatrix() {}
	public GraphMatrix(int n){
		init(n);
	}
	
	public void init(int n)
	{
		mark = new int[n];
		matrix = new int[n][n];
		numEdge = 0;
	}
	
	public int numbVertice()	{ return mark.length; }
	
	public int numbEdges()	{	return numEdge;}
	
	/**@return v's first neighbor*/
	public int firstNeighbor(int v)
	{
		for(int i = 0; i < numbVertice(); i++)
			if(matrix[v][i] != 0)
				return i;
		return numbVertice();	// No edge for this vertex
	}
	
	/**@return v's next neighbor after w */
	public int nextNeighbor(int v, int w)
	{
		for(int i = w+1; i < numbVertice(); i++)
			if(matrix[v][i] != 0)
				return i;
		return numbVertice(); 
	}
	
	/**Set the weight for an edge*/
	public void setEdge(int i, int j, int wght)
	{
		assert wght != 0 : "Cannot set weight to 0!";
		if(matrix[i][j] == 0)
			numEdge++;
		matrix[i][j] = wght;
	}
	
	/**Delete an edge*/
	public void delEdge(int i, int j)
	{
		if(matrix[i][j] != 0)
			numEdge--;
		matrix[i][j] = 0;
	}
	
	/**Determine if an edge is in thr graph*/
	public boolean isEdge(int i, int j)
	{
		return matrix[i][j] != 0;
	}
	
	/**@return an edge's weight*/
	public int weight(int i, int j)
	{
		return matrix[i][j];
	}
	
	/**Set the mark value for a vertex*/
	public void setMark(int i, int val)
	{
		mark[i] = val;
	}
	
	/**Get the mark value for a vertex*/
	public int getMark(int i)
	{
		return mark[i];
	}
	
}