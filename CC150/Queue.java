/**Queue ADT*/
public interface Queue<E>{

	public void clear();

	public void enqueue(E x);
	
	public E dequeue();
	
	public E frontValue();
	
	public int size();

}