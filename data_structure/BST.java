package data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Val> {
  private Node root;
  private int size;

  private class Node {
	 Key k;
	 Val v;
	 Node left, right;
	 int N; // # of nodes in subtree rooted here

	 public Node(Key k, Val v, int n) {
		this.k = k;
		this.v = v;
		this.N = n;
	 }

	 public Node(Key k, Val v) {
		this.k = k;
		this.v = v;
	 }
  }

  public BST() {
  }

  public int size() {
	 return size(root);
  }

  private int size(Node root) {
	 return root.N;
  }

  public boolean contains(Key k) {
	 return contains(root, k);
  }
  
  private boolean contains(Node root, Key k) {
	 if (root == null) {
		return false;
	 }
	 int cmp = k.compareTo(root.k);
	 if (cmp < 0) {
		return contains(root.left, k);
	 } else if (cmp > 0) {
		return contains(root.right, k);
	 }
	 return true;
  }

  public Val get(Key k) {
	 return get(root, k);
  }

  private Val get(Node root, Key k) {
	 if (root == null) {
		return null;
	 }
	 int cmp = k.compareTo(root.k);
	 if (cmp > 0) {
		return get(root.right, k);
	 } else if (cmp < 0) {
		return get(root.left, k);
	 } else {
		return root.v;
	 }
  }

  /**
   * If key exist in the BST, update its value; otherwise, add new node
   * 
   * */
  public void put(Key k, Val v) {
	 put(root, k, v);
  }

  private Node put(Node root, Key k, Val v) {
	 if (root == null) {
		return new Node(k, v);
	 }
	 int cmp = k.compareTo(root.k);
	 if (cmp > 0) {
		root.right = put(root.right, k, v);
	 } else if (cmp < 0) {
		root.left = put(root.left, k, v);
	 } else {
		root.v = v;
	 }
	 return root;
  }

  /** Order-based operations */

  public Key min() {
	 return min(root).k;
  }

  private Node min(Node root) {
	 if (root.left == null) {
		return root;
	 }
	 return min(root.left);
  }

  public Key max() {
	 return max(root).k;
  }

  private Node max(Node root) {
	 if (root.right == null) {
		return root;
	 }
	 return max(root.right);
  }

  public Key floor(Key target) {
	 Node x = floor(root, target);
	 return x == null ? null : x.k;
  }

  private Node floor(Node root, Key target) {
	 if (root == null) {
		return null;
	 }
	 int cmp = target.compareTo(root.k);
	 if (cmp == 0) {
		return root;
	 } else if (cmp < 0) {
		return floor(root.left, target);
	 } else {
		Node right = floor(root.right, target);
		return right == null ? root : right;
	 }
  }
  
  public Key ceiling(Key k) {
	 Node x = ceiling(root, k);
	 return x == null ? null : x.k;
  }
  
  private Node ceiling(Node root, Key k) {
	 return null;
  }
  
  /**Selection
   * @return the Node Key containing key of rank k.
   * view the BST as increasing sequence, return the rank NO.k Node
   * */
  public Key select(int k) {
	 return select(root, k).k;
  }
  
  private Node select(Node root, int k) {
	 if (root == null) {
		return null;
	 }
	 int size = size(root.left);
	 if (size > k) {
		return select(root.left, k);
	 } else if (size < k) {
		return select(root.right, k - size - 1);
	 }
	 return root;
  }
  
  /**Rank. Inverse method of Select()
   * @return the rank of given Key*/
  public int rank(Key k) {
	 return rank(root, k);
  }

  private int rank(Node root, Key k) {
	 return 0;
  }
  
  /** Deletion node 
   * */
  public boolean delete(Key k) {
	 root = delete(root, k);
	 return root == null ? false : true;
  }

  private Node delete(Node root, Key k) {
	 if (root == null) { // k not found
		return null;
	 }
	 int cmp = k.compareTo(root.k);
	 if (cmp < 0) {
		root.left = delete(root.left, k);
	 } else if (cmp > 0) {
		root.right = delete(root.right, k);
	 } else {
		// find the key
		if (root.left == null) { // no child && only right child
		  return root.right;
		} else if (root.right == null) { // only left child
		  return root.left;
		}
		// two child
		Node newRoot = min(root.right);
		newRoot.left = root.left;
		newRoot.right = deleteMin(root.right);
		root = newRoot;
	 }
	 return root;
  }

  public void deleteMin() {
	 root = deleteMin(root);
  }

  private Node deleteMin(Node root) {
	 if (root.left == null) {
		return root.right;
	 }
	 root.left = deleteMin(root.left);
	 return root;
  }
  
  /**Range query.
   * @return the keys in a given range
   * */
  public Iterable<Key> keys() {
	 return keys(min(), max());
  }
  
  public Iterable<Key> keys(Key lo, Key hi) {
	 Queue<Key> queue = new LinkedList<>();
	 keys(root, lo, hi, queue);
	 return queue;
  }
  
  private void keys(Node root, Key lo, Key hi, Queue<Key> queue) {
	 if (root == null) {
		return;
	 }
	 int cmplo = lo.compareTo(root.k);
	 int cmphi = hi.compareTo(root.k);
	 if (cmplo < 0) { //recursively find the left bound
		keys(root.left, lo, hi, queue);
	 }
	 if (cmplo <= 0 && cmphi <= 0) { //current key in the range
		queue.add(root.k);
	 }
	 if (cmphi > 0) { //find right bound
		keys(root.right, lo, hi, queue);
	 }
  }
}