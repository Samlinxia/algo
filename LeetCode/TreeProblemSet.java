class TreeProblemSet {
/**
Binary Tree high-frequency problem set
http://blog.sina.com.cn/s/blog_eb52001d0102v1si.html
*/



/**
CC150 4.8
You are given a binary tree in which each node contains a value Design an algorithm 
to print all paths which sum up to that value Note that it can be any path in the tree 
- it does not have to start at the root

If start from root, just DFS from root recursively visit all nodes, and sum along the nodes to check
whether equals to target.  In this way, no parameter, except result set, need to passed to helper()
*/

/*Analysis:  different from normal combination sum, this path can start from any nodes. so we need
extra space to keep track along visited nodes, and sum up nodes in path start from cur node to check
with target*/

	public List<List<Integer>> findSum(TreeNode root, int target) {


	}

	private static void helper(TreeNode root, int target, List<List<Integer>> res, List<Integer> path) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			sum += path.get(i);
			if (sum == target) {
				printSum(res, path, i); //print subPath(i - n-1) to result in reverse order
			}
		}
		helper(root.left, target, res, path);
		helper(root.right, target, res, path);
		path.remove(path.size() - 1);
	}

}