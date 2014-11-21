/**The Dictionary abstract class*/
public interface Dictionary<Key,E>{

	/**Reinitialize dictionary*/
	public void clear();
	
	/**Insert a record*/
	public void insert(Key k, E e);
	
	public E remove(Key k);
	
	/**Remove and return an arbitrary record from dictionary.
	   @return thr recoed removed, or null if non exists.
	   Without the removeAny method, a dictionary user could not get a record
	   of the dictionary that he didn't know the key value for.*/
	public E removeAny();
	
	public E find(Key k);
	
	public int size();

}