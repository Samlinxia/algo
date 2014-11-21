
/** Inorder DFS.  recursion
*/
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        inorder(root, res);        
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
	
	/** DFS.  Iteration + Stack space
	
	*/
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> output = new Stack<TreeNode>();
        TreeNode post = root.left; //post pointer
        output.push(root);
        while (!output.isEmpty() || post != null) {
            if (post != null) {
                output.push(post);
                post = post.left;
            } else {
                TreeNode node = output.pop();
                res.add(node.val);
                post = node.right;
            }
        }
        return res;
    }
	 
	/*Do in-order traversal without stack
	1. By adding a parent pointer to the data structure, this allows us to return to a node’s parent (Credits to my friend who provided this solution to me). To determine when to print a node’s value, we would have to determine when it’s returned from. If it’s returned from its left child, then you would print its value then traverse to its right child, on the other hand if it’s returned from its right child, you would traverse up one level to its parent.
	2. By using a Threaded Binary Tree. Read the article: Threaded Binary Tree on Wikipedia for more information.
	http://en.wikipedia.org/wiki/Threaded_binary_tree
	*/
	
	/**Morris algo -> threaded binary tree
	*/
	