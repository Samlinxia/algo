/**Graph ADT*/
/*The number of vertices is fixed when the graph is created, 
	but the edges can be added and removed.
	It also supports a mark array to aid graph traversal algorithms*/
public interface Graph{   
	/**Initialize the graph*/
	public void init(int n);
	/**@return The number of vertices*/
	public int numbVertice();
	/**@return The current number of edges*/
	public int numbEdges();
	
	/**@return v's first neighbor*/
	public int firstNeighbor(int v);
	
	/**@return v's next neighbor after w*/
	public int nextNeighbor(int v, int w);
	
	/**Set the weight for an edge
		@param i, j The vertice
		@param wght Edge weight*/
	public void setEdge(int i, int j, int wght);
	
	/**Delete and edge
		@param i,j The vertice*/
	public void delEdge(int i, int j);
	
	/**Determine if an edge is in the graph
		@param i,j The vertice
		@param true if edge i,j has non-zero weight*/
	public boolean isEdge(int i, int j);
	
	/**@return The weight of edge i,j, or zero
		@param i,j The vertice*/
	public int weight(int i, int j);
	
	/**Set the mark value for a vertex
		@param v the Vertex
		@param val The value to set*/
	public void setMark(int v, int val);
	
	/**Get the mark value for a vertex
		@param v The vertex
		@return The value of the mark*/
	public int getMark(int v);

}