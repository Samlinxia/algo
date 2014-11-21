/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

/** Recursion
*/



/** Iteration + Stack
*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)   {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                res.add(temp.val);
            } else {
                continue;
            }
            stack.push(temp.right);
            stack.push(temp.left);
        }
        
        return res;
    }
	
	/** Morris 
	*/
}