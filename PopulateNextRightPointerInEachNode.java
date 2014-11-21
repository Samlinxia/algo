class PopulateNextRightPointerInEachNode {
	
  //Definition for binary tree with next pointer.
  public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
  /**Method 1. BFS, i.e. level-order traversal in tree
	Time : O(n); Space: O(n)
  */
  public void connect(TreeLinkNode root) {
	if (root == null) {
		return;
	}
	Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	queue.add(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		TreeLinkNode sibling;
		for (int i = 0; i < size; i++) {
			TreeLinkNode node = queue.remove();
			if (sibling != null) {
				sibling.next = node;
			}
			sibling = node;
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
  }

	/**Method 2. Recursion-version BFS
		if recursion not count space, space is O(1)
		For perfect tree only
		Easy transfer to iteration-version BFS
	*/
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null || root.right == null) {
			return;
		}
		TreeLinkNode inode = root;
		TreeLinkNode sibling = null;
		while (inode != null) {
			if (inode.next != null) {
				sibling = inode.next.left;
			} else {
				sibling = null;
			}
			inode.left.next = inode.right;
			inode.right.next = sibling;
			inode = inode.next;
		}
		connect(root.left);
    }
	
	/**Method 3.  Iterative-version BFS. 
	Best method.  Solve perfect tree only
	这道题本质是树的层序遍历，只是队列改成用结点自带的链表结点来维护.
	*/
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode nextStart = root.left;
		while (root != null && nextStart != null) {
			TreeLinkNode parent = root;
			while (parent != null) {
				parent.left.next = parent.right;
				if (parent.next != null) {
					parent.right.next = parent.next.left;
				}
				parent = parent.next;
			}
			root = nextStart;
			nextStart = root.left;
		}
    }
	
	/**Method 3 extended.  Solve all tree.
	keys:  1. Find the fist child node in next level :
				1) used as 'next level traversal parentNode start point', used for assign to parent Node
				2) used as 'ChildNode start pointer' to iterate level by level.
		(in perfect tree, next level start node will always be curNode.left)
	
	*/
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		while (root != null) {
			TreeLinkNode parent = root;
			TreeLinkNode nextStart = null;  //new parent node
			TreeLinkNode prev = null;  // iterate through level by level
			while (parent != null) {
				if (parent.left != null) {
					if (prev == null) {
						prev = parent.left;
						nextStart = parent.left;
					} else {
						prev.next = parent.left;
						prev = prev.next;
					}
				}
				if (parent.right != null) {
					if (prev == null) {
						prev = parent.right;
						nextStart = parent.right;
					} else {
						prev.next = parent.right;
						prev = prev.next;
					}
				}
				parent = parent.next;
			}
			root = nextStart;
		}
	}
	
	
	/**Method 4. Extended preorder traversal.  
		Make full use of parent's nextright pointer.  
		if recursion not count space, space is O(1)
		Elegant than method 2
		Only works for perfect or complete binary tree
	*/
	public void connect(TreeLinkNode root) {
		if (root.left == null || root.right == null) {
			return;
		}
		root.left.next = root.right;
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
    }
}