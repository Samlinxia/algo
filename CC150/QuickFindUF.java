public class QuickFindUF{
	private int[] id;
	public QuickFindUF(int N)
	{
		id = new int[N];
		for(int i = 0; i < N; i++)
		{
			id[i] = i;
		}
	}
//check whether point p and q are connected(in same component)
	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}

//change all enries with id[p] to id[q]
	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++)
		{
			if(id[i] == qid)  id[i] = qid;
		}
	}
}