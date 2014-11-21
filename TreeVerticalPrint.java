public TreeVerticalPrint {
/**Print a binary tree by vertical level order like   1 2 4 3 5 print : 3 2 1 5 4 */

/**Method 1.
	DoublyLinkedList + ArrayList + HashMap
	DoublyLinkedList, represent the level, use Deque
	ArrayList, store Nodes in different level
	HashMap, achieve O(1) access time in LinkedList and evaluate whether exists
*/


/**Method 2.
	TreeMap + ArrayList
	TreeMap, key is sorted by natural ordering.  log(n) insertiong time.
After complete traversal the tree, Iterate the map's keys set to print it, which is already in order
Advantage: simple to use and straight-forward

p.s. LinkedMashMap, key sorted by insertiong order
*/
	public void printVertical(TreeNode root) {
		if (root == null) {
			return;
		}
		Map<Integer, List<TreeNode>> map = new TreeMap<>();
		helper(root, 0, map);
		//print tree vertical
		for (List<TreeNode> nodes : map.keySet()) {
			for (TreeNode n : nodes) {
				System.out.print(String.valueOf(n.val) + " ");
			}
		}
	}
	
	private void helper(TreeNode root, int level, Map<Integer, List<TreeNode>> map) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(level)) {
			List<TreeNode> list = new ArrayList<>();
			list.add(root);
			map.put(level, list);
		} else {
			map.get(level).add(root);
		}
		
		helper(root.left, level - 1, map);
		helper(root.right, level + 1, map);
	}

/**Method 2.
	HashMap + ArrayList + sort
*/


}