/**Dictionary implemented by unsorted array-based list*/
class UALDictionary<Key, E> implements Dictionary<Key,E>{
	
	private static final int defaultSize = 10;
	private AList<KVPair<Key, E>> list;   //to store dictionary type data, represented by Key-value pair
	
	public UALDictionary()
	{	this(defaultSize);	}
	
	public UALDictionary(int initSize)
	{
		list = new AList<KVPair<Key, E>>(initSize);
	}
	
	public void clear()
	{
		list.clear();
	}
	
	public void insert(Key kval, E eval)
	{
		KVPair<Key, E> temp = new KVPair<Key,E>(kval,eval);
		list.append(temp);
	}
	
	/**Use sequential search to find the element to remove*/
	public E remove(Key kval)
	{
		E temp = find(kval);
		if(temp != null)
			list.remove();       //curr points at the found value position
		return temp;
	}
	
	/**Remove the last element*/
	public E removeAny()
	{
		if(size() != 0)
		{
			list.moveToEnd();
			list.prev();
			KVPair<Key,E> temp = list.remove();
			return temp.value();
		}
		else
			return null;
	}
	
	public E find(Key kval)
	{
		for(list.moveToStart(); list.currPos() < list.size(); list.next())
		{
			KVPair<Key,E> temp = list.getValue();
			if(kval == temp.key())
				return temp.value();
		}
		return null;
	}
	
	public int size()
	{
		return list.size();
	}
	
}