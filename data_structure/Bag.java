package data_structure;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
  Node first;
  
  
  public Bag() {
	 // TODO Auto-generated constructor stub
  }
  
  public void add(Item item) {
	 Node oldFirst = first;
	 first = new Node(item);
	 first.next = oldFirst;
  }

  class Node {
	 Item item;
	 Node next;
	 public Node(Item item) {
		this.item = item;
	 }
  }

  @Override
  public Iterator<Item> iterator() {
	 return new ListIterator();
  }
  
  private class ListIterator implements Iterator<Item> {
	 private Node cur = first;
	 @Override
    public boolean hasNext() {
	   return cur != null;
    }

	 @Override
    public Item next() {
		Item item = cur.item;
		cur = cur.next;
	   return item;
    }

	 @Override
    public void remove() {
	   throw new UnsupportedOperationException();
    }
	 
  }
}
