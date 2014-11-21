package DataStructure;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/**
 * http://algs4.cs.princeton.edu/34hash/
 * http://www.docjar.com/html/api/java/util/Hashtable.java.html
 * */
public class HashTable <K, V> implements Map<K, V> {
  private Entry<K,V>[] table;
  private int count; 
  //the table is rehash when its size exceeds this threshold, (capacity * loadFactor)
  private int threshold;
  private float loadFactor;
  
  
  public HashTable(int initialCapacity, float loadFactor) {
	 if (initialCapacity < 0) {
		throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
	 }
	 if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
		throw new IllegalArgumentException("Illegal load: " + loadFactor);
	 }
	 if (initialCapacity == 0) {
		initialCapacity = 1;
	 }
	 this.loadFactor = loadFactor;
	 table = new Entry[initialCapacity];
	 this.threshold = (int) (initialCapacity * loadFactor);
  }
  
  public HashTable(int initialCapacity) {
	  this(initialCapacity, 0.75f);
  }
  
  public HashTable() {
	  this(11, 0.75f);
  }
  

  @Override
  public int size() {
	 return count;
  }

  @Override
  public boolean isEmpty() {
	 return count == 0;
  }
  

  @Override
  public synchronized boolean containsKey(Object key) {
	 if (key == null) {
		throw new NullPointerException();
	 }
	 Entry<K,V>[] tab = table;
	 int hash = key.hashCode();
	 int index = (hash & 0x7FFFFFFF) % tab.length;
	 for (Entry<K, V> e = tab[index]; e != null; e = e.next) {
		if (hash == e.hash && key.equals(e.key)) {
		  return true;
		}
	 }
	 return false;
  }

  @Override
  public boolean containsValue(Object value) {
	 if (value == null) {
		throw new NullPointerException();
	 }
	 Entry<K, V>[] tab = table;
	 for (int i = 0; i < tab.length; i++) {
		for (Entry<K,V> e = tab[i]; e != null; e = e.next) {
		  if (e.value.equals(value)) {
			 return true;
		  }
		}
	 }
	 return false;
  }

  @Override
  public V get(Object key) {
	 if (key == null) {
		throw new NullPointerException();
	 }
	 Entry<K,V>[] tab = table;
	 int hash = key.hashCode();
	 int index = (hash & 0x7FFFFFFF) % tab.length;
	 for (Entry<K,V> e = tab[index]; e != null; e = e.next) {
		if ((e.hash == hash) && (e.key.equals(key))) {
		  return e.value;
		}
	 }
	 return null;
  }

  @Override
  public V put(K key, V value) {
	 if (value == null) {
		throw new NullPointerException();
	 }
	 Entry<K,V>[] tab = table;
	 int hash = key.hashCode();
	 int index = (hash & 0x7FFFFFFF) % tab.length;
	 for (Entry<K,V> e = tab[index]; e != null; e = e.next) {
		if (e.hash == hash && e.key.equals(key)) {
		  V old = e.value;
		  e.value = value;
		  return old;
		}
	 }
	 if (count >= threshold) {
		//resize backing array, need recompute index for current query (key,value) pair
		rehash();
		tab = table;
		index = (hash & 0x7FFFFFFF) % tab.length;
	 }
	 //create new Entry & insert head of collision list
	 Entry<K,V> e = tab[index];
	 tab[index] = new Entry<K,V>(hash, key, value, e);
	 count++;
	 return null;
  }
  
  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
  public void rehash() {
	 Entry<K,V>[] oldMap = table;
	 int oldCapacity = table.length;
	 
	 //overflow-conscious
	 int newCapacity = (oldCapacity << 1) + 1;
	 if (newCapacity - MAX_ARRAY_SIZE > 0) {
		if (oldCapacity == MAX_ARRAY_SIZE) {
		  return;
		}
		newCapacity = MAX_ARRAY_SIZE;
	 }
	 
	 Entry[] newMap = new Entry[newCapacity];
	 
	 threshold = (int) (newCapacity * loadFactor);
	 table = newMap;
	 
	 for (int i = oldCapacity; i-- > 0; ) {
		for (Entry<K,V> e = oldMap[i]; e != null;) {
		  Entry<K,V> old = e;
		  e = e.next;
		  
		  int index = (old.hash & 0x7FFFFFFF) % newCapacity;
		  old.next = newMap[index];
		  newMap[index] = old;
		}
	 }
  }

  @Override
  public V remove(Object key) {
	 // TODO Auto-generated method stub
	 return null;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
	 // TODO Auto-generated method stub
	 
  }

  @Override
  public void clear() {
	 // TODO Auto-generated method stub
	 
  }

  @Override
  public Set<K> keySet() {
	 // TODO Auto-generated method stub
	 return null;
  }

  @Override
  public Collection<V> values() {
	 // TODO Auto-generated method stub
	 return null;
  }

  @Override
  public Set<java.util.Map.Entry<K, V>> entrySet() {
	 // TODO Auto-generated method stub
	 return null;
  }
  
  /**HashTable Collision linked-list
   * */
  public class Entry <K, V> {
	 int hash;
	 K key;
	 V value;
	 Entry<K, V> next;
	 
	 public Entry (int hash, K key, V value, Entry<K, V> next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	 }
  }
}