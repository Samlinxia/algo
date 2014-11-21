public class QuickUnionUF{
	private int[] id;
//set id of each object to itself
	public QuickUnionUF(int N)
	{
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
//chase parent pointers untile reach the root
	private int root(int i)
	{
		while(i != id[i])
			i = id[i];     //index is identical to entry indicates it's the root
		return i;
	}
	
//check if p and q have same root
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
//change root of p to point to root of q
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
/**Improvement 1. Weighted quick-union
*
*/

	private int[] arrSize;   //count the size of each tree
	public QuickUnionUF(int N, int improveMethodIndex)
	{
		id = new int[N];
		arrSize = new int[N];
		for(int i = 0; i < N; i++)
		{
			id[i] = i;
			arrSize[i] = 0;
		}
	}
	public void unionImprove(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if(arrSize[i] > arrSize[j])
		{	
			id[j] = i;
			arrSize[j] += arrSize[i];
		}
		else
		{	
			id[i] = j;
			arrSize[i] += arrSize[j];
		}
	}
	
/**Improvement 2, path compression
*
*/
	private int rootImprove(int p)
	{
		while(i != id[i])
		{
			id[i] = id[id[i]];  //consecutively set node point to its parent.
			i = id[i];
		}
		return i;
	}

	
	
}