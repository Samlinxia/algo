/**List ADT. Use method to iteration and operations instead of iterator in C++*/
public interface List<E>{

	public void clear();
	
	public void insert(E data);
	
	public void append(E data);
	
	/**Reomove and return the current element*/
	public E remove();
	
	public void moveToStart();
	
	public void moveToEnd();
	
	/**Move the current position one step left.*/
	public void prev();
	
	public void next();
	
	public int size();
	
	/**@return the position of current element*/
	public int currPos();
	
	/**Set current position*/
	public void moveToPos(int pos);
	
	public E getValue();
	

}