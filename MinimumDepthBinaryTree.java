
public calss Solution {
/*
DFS & Recursion 
*/
	public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return getMin(root);
    }
    
    public int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ld = getMin(root.left);
        int rd = getMin(root.right);
        return 1 + Math.min(ld, rd);
    }
	
/**
BFS & one queue
*/
	if (root == null) {
        return 0;
    }
    int depth = 1;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
        int count = queue.size();
        for (int i = 0; i < count; i++) {
            TreeNode node = queue.remove();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        depth++;
        
    }
    
    return depth;
    }

}