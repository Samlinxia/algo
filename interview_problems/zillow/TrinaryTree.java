/**
 * 
 */
package zillow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author XIA LIN
 * 
 */
public class TrinaryTree {

  private TreeNode root = null;
  // private int size = 0;
  private boolean isEmpty = true;

  public TrinaryTree() {

  }

  public TrinaryTree(TreeNode root) {
	 if (root == null) {
		return;
	 }
	 this.root = root;
  }

  /**
   * Insert a value into trinary tree
   * 
   * */
  public void insert(int val) {
	 if (root == null) {
		root = new TreeNode(val);
		return;
	 }
	 TreeNode cur = root;
	 while (cur != null) {
		if (cur.val < val) {
		  if (cur.right == null) {
			 cur.right = new TreeNode(val);
			 break;
		  }
		  cur = cur.right;
		} else if (cur.val > val) {
		  if (cur.left == null) {
			 cur.left = new TreeNode(val);
			 break;
		  }
		  cur = cur.left;
		} else {
		  if (cur.mid == null) {
			 cur.mid = new TreeNode(val);
			 break;
		  }
		  cur = cur.mid;
		}
	 }
  }

  /**
   * Delete a given value in tree. Return true if delete successfully, otherwise
   * false
   * 
   * @throws IllegalStateException
   *           if to deleted value not exists
   * */
  public boolean delete(int val) {
	 try {
		this.root = delete(root, val);
	 } catch (IllegalStateException e) {
		return false;
	 }
	 return true;
  }

  private TreeNode delete(TreeNode p, int val) {
	 if (p == null) {
		throw new IllegalStateException();
	 }
	 if (val < p.val) {
		p.left = delete(p.left, val);
	 } else if (val > p.val) {
		p.right = delete(p.right, val);
	 } else {
		if (p.mid == null) { // unique val to deleted
		  //single child or no child
		  if (p.left == null) {
			 return p.right;
		  } else if (p.right == null) {
			 return p.left;
		  }
		  // has 2 child. copy leftmost node in right subtree to p
		  p.val = getLeastVal(p.right);
		  // delete leftmost node in right subtree
		  p.right = delete(p.right, p.val);
		} else { // duplicate target. delete the deepest node in mid path
		  TreeNode next = p.mid;
		  TreeNode prev = p;
		  while (next != null && next.mid != null) {
			 next = next.mid;
			 prev = prev.mid;
		  }
		  prev.mid = null;
		}
	 }

	 return p;
  }

  /*
   * Get leftmost node's val
   */
  private int getLeastVal(TreeNode p) {
	 while (p.left != null) {
		p = p.left;
	 }
	 return p.val;
  }

  public boolean contains(int val) {
	 if (root == null) {
		return false;
	 }
	 TreeNode cur = root;
	 while (cur != null) {
		if (cur.val == val) {
		  return true;
		} else if (cur.val < val) {
		  cur = cur.right;
		} else {
		  cur = cur.left;
		}
	 }
	 return false;
  }

  public void printLevelorder() {
	 Queue<TreeNode> queue = new LinkedList<>();
	 queue.add(this.root);
	 int level = 0;
	 while (!queue.isEmpty()) {
		int size = queue.size();
		System.out.println("******level " + String.valueOf(level) + " ******");
		for (int i = 0; i < size; i++) {
		  TreeNode n = queue.poll();
		  System.out.print(String.valueOf(n.val) + " ");
		  if (n.left != null) {
			 queue.add(n.left);
		  }
		  if (n.mid != null) {
			 queue.add(n.mid);
		  }
		  if (n.right != null) {
			 queue.add(n.right);
		  }
		}
		level++;
		System.out.println();
	 }
  }

  // public boolean isEmpty() {
  // return isEmpty;
  // }

  // public int size() {
  //
  // }

  /**
   * TreeNode class Definition
   * */
  public class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode mid;
	 TreeNode right;

	 public TreeNode(int val) {
		this.val = val;
	 }

	 public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	 }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
	 TrinaryTree tree = new TrinaryTree();
	 tree.insert(3);
	 tree.insert(5);
	 tree.insert(1);
	 tree.insert(3);
	 tree.insert(3);
	 tree.insert(3);
	 tree.printLevelorder();
	 tree.delete(3);
	 tree.delete(5);
	 tree.printLevelorder();
  }

}
