public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = getDepth(root.left);
        if (ld == -1) {
            return -1;
        }
        int rd = getDepth(root.right);
        if (rd == -1) {
            return -1;
        }
        if (Math.abs(ld - rd) > 1) {
            return -1;
        }
        return 1 + Math.max(ld, rd);
    }
}