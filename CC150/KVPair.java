/**Container class for a key-value pair.
	E is a record in Database contained in another class, e.g. Payroll, Person class*/
class KVPair<Key, E>
{
	private Key k;
	private E e;
	
	public KVPair()
	{	k = null;
		e = null;
	}
	
	public KVPair(Key kval, E eval)
	{
		k = kval;
		e = eval;
	}
	
	public Key key()	{	return k;	}
	public E value()	{	return e;	}
}