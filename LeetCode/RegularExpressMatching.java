class RegularExpressMatching {
/**
test case 够多，一步步思考：根据test case改变策略
http://leetcode.com/2011/09/regular-expression-matching.html

Recursion + DP方法：
http://www.cnblogs.com/jdflyfly/p/3810681.html
http://blog.csdn.net/linhuanmars/article/details/21145563
*/
	/**Method 1 : Brute Force*/
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return helper(s, p, 0, 0);
    }
    
    public boolean helper(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        // case 1: p.charAt(j + 1) != '*'，并且j已经在最后一位，就不可能出现case2，所以两条件归并在一起
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (i == s.length() || 
                    (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')) {
                return false;
            }
            return helper(s, p, i + 1, j + 1);
        }
        // case 2: p.charAt(j + 1) == '*'.  try all possible combination of s&p: (i,j+2),(i+1,j+2),...,(i+k,j+2) 
        while (i < s.length() && 
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            if (helper(s, p, i, j + 2)) {
                return true;
            }
            i++;
        }
        /*skip match part to continue recursion.  
		means: '*' match longest repeating char in s,
		eg. in s=aaaab, p= a*b, aaaa matches a*, i&j both jump */
        return helper(s, p, i, j + 2);
    }
	
	/**
		Method 2: advanced version brute force. (more explicit, readable)
		key point: 
			1. whenever there's a match, recursion to keep on decide.(don't use iteration here)
			2. '*' is key: differentiate in two situation: 
					1)next is '*'  2)no '*' in next position
			3. '.' is trival
			4. needn't consider consecutive '*' situation
	*/
	public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }
    
    public static boolean match (String s, int si, String p, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }
        //1st case: p[pi + 1] is not '*' or last index(which has no possible has '*' follows)
        if (pi == p.length() - 1 || p.charAt(pi + 1) != '*') {
            if (!matchFirst(s, si, p, pi)) {
                return false;
            } else {
                return match(s, si + 1, p, pi + 1);
            }
        } else { // 2nd case: p[pi + 1] is '*'
            //try '*' match 0 times of preceding char
            if (match(s, si, p, pi + 2)) {
                return true;
            }
			//try '*' match 1,2,3...n times
            for (int i = si; matchFirst(s, si, p, pi); i++) {                         
                if (match(s, i + 1, p, pi + 2)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private static boolean matchFirst(String s, int si, String p, int pi) {
        if (si < s.length() && pi < p.length() && 
                (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
            return true;
        }
        return false;
    }
	
	/**Method 3: DP.  Iteration bottom-up
	http://www.cnblogs.com/jdflyfly/p/3810681.html
	*/
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new NullPointerException();
        }
        int lenS = s.length();
        int lenP = p.length();
        if (lenS == 0 && lenP == 0) {
            return true;
        } else if (lenP == 0) {
            return false;
        }
        
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lenP; i++) { //s="", iterate p[0..lenP-1]
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = matchFirst(s, i - 1, p, j - 1) ? dp[i - 1][j - 1] : false;
                } else {
                    if (!matchFirst(s, i - 1, p, j - 2)) { //try '*' match 0 times preceding char
                        dp[i][j] = dp[i][j - 2];
                    } else { //S[i] == P[j-1], P[j] == '*'.  try '*' match 0, and 1 more time of preceding char
                        dp[i][j] = dp[i][j - 2] | dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[lenS][lenP];
    }
	
}