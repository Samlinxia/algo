package data_structure;

/**http://code.google.com/p/guava-libraries/wiki/NewCollectionTypesExplained
 * 
 * Multiset, aka Bag, is set allows members to appear more than once.  
 * In contrast to tuples, the order of elements is irrelevant: 
 * The multisets {a, a, b} and {a, b, a} are equal
 * 
 * Application:  When you need a ADT that 0)store item multiple times 
 * 1)order-irrelevant 2) iterate entire ADT
 *  
 * Implementation:  	
 * 1) acts like set that you don't care ordering.
 * 2) acts like ArrayList that support add() to a bag and iterate it
 * 3) acts like HashMap, with elements count
 * 4) provide Iterator to iterate through. 
 * 
 * Abstract Multiset:
 * http://code.google.com/p/guava-libraries/source/browse/guava/src/com/google/common/collect/AbstractMultiset.java
 * 
 * Map-based Multiset:
 * http://code.google.com/p/guava-libraries/source/browse/guava/src/com/google/common/collect/AbstractMapBasedMultiset.java
 * */

public class Multiset {

  public Multiset() {
	 // TODO Auto-generated constructor stub
  }

}
