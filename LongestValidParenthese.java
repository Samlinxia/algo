class LongestValidParenthese {
	/*
	method 1 : dp
	http://blog.csdn.net/linhuanmars/article/details/20439613
	**/
	
	
	/*
	method 2 : greedy + stack
	**/
	
	
	
	/**用剩余栈的栈顶元素位置信息作为当前合法数据的判断依据是比较重要的技巧*/
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int startPos = 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    startPos = i + 1;
                    continue;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    maxLen = Math.max(maxLen, i - startPos + 1);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
	
}