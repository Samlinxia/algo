class TreeTraversal {
	/**
	http://blog.csdn.net/linhuanmars/article/details/38510167
	*/

	/**
	Pre-order traversal
	*/
	
	/*Method 1. Recursion*/
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }
    
    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
	
	/*Method 2:  Iteratiion*/
	
	
	
	/**
		Inorder traversal
	*/
	
	/*Method 1 : Recursion*/
	
	
	/*Method 2 : Iteration*/
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode inNode = stack.pop();
                res.add(inNode.val);
                p = inNode.right;
            }
        }
        return res;
    }
	
		/*Method 3 : morris inorder traversal
		咋一看可能会觉得时间复杂度是O(nlogn)，因为每次找前驱是需要logn，总共n个结点。
		但是如果仔细分析会发现整个过程中每条边最多只走2次，一次是为了定位到某个节点，
		另一次是为了寻找上面某个节点的前驱节点，而n个结点的二叉树中有n-1条边，
		所以时间复杂度是O(2*n)=O(n)，仍然是一个线性算法。空间复杂度的话我们分析过了，
		只是两个辅助指针，所以是O(1)。*/
		
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left != null) {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) { // find rightmost node
                    pre = pre.right;
                }
                
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else if (pre.right == cur) {
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            } else {
                res.add(cur.val);
                cur = cur.right;
            }
        }
        
        return res;
    }
	
	/**
		Post-order	traversal
	*/
	
	/*Method 1 : Recursion*/
	
	
	/*Method 2 : Iteration
	分析：
	1）如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点），那么就把当前结点移到右结点继续循环；
	2）如果栈顶元素右结点是空或者已经访问过，那么说明栈顶元素的左右子树都访问完毕，应该访问自己继续回溯了。
	3）只把当前节点push进stack（不需要push右结点），因为右结点可以通过cur.right访问到
	4) 维护一个prev 指针，判断是否已经访问过右结点(prev与cur.right相等时表示之前访问过)
	*/
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;  //not the cur ptr prev, it's the post-order output res prev, which indicate which node last output to res
        TreeNode cur = root;
        
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode inNode = stack.peek();
                if (inNode.right != null && inNode.right != prev) {
                    cur = inNode.right;
                } else {
                    res.add(inNode.val);
                    prev = stack.pop();
                }
            }
        }
        
        return res;
    }
	
	/**
		Level-order traversal
	*/
	
	
}