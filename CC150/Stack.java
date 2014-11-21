/** Stack ADT*/
public interface Stack<E>{
	
	public void clear();
	
	public void push(E data);
	
	public E pop();
	
	public E topValue();
	
	public int size();
}