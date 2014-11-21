class PalindromePartition {
	/**
		Palindrome partition I
	*/
	/**
		Method 1: DFS + isPalindrome routine(utilize palindrome feature)
	*/
	    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return Collections.<List<String>>emptyList();
        }
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        helper(s, res, tmp, 0);
        return res;
    }
    
    private static void helper(String s, List<List<String>> res,
            List<String> tmp, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }        
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (!isPal(sb.toString())) {
                continue;
            }
            tmp.add(sb.toString());
            helper(s, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
	
    // check whether s is pal.  two ptr move to middle
    private static boolean isPal(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
	
	/**
		Method 2: DP + DFS.  preprocess s to generate a isPal[][] dict 
		to determine whether s[i..j] is palindrome
	*/
	public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return Collections.<List<String>>emptyList();
        }
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        helper(s, getDict(s), res, tmp, 0);
        return res;
    }
    
    private static boolean[][] getDict(String s) {
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) 
                        || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;            
                }
            }
        }
        
        return isPal;
    }
    
    private static void helper(String s, boolean[][] isPal, List<List<String>> res,
            List<String> tmp, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }        
        
        for (int i = pos; i < s.length(); i++) {
            if (!isPal[pos][i]) {
                continue;
            }
            String pal = s.substring(pos, i + 1);
            tmp.add(pal);
            helper(s, isPal, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
	
	
	
	/**
		Palindrome partition II
		similar with Word Break I.  
		Difference is you have to preprocess to generate a dict
	*/
	/**
		method 1.  从左到右扫，
		http://yucoding.blogspot.com/2013/08/leetcode-question-133-palindrome.html
		f meaning: min[i] - min cut from s[0..i-1], substring exclude s[i]	
		transition: min[i] = min(min[j] + 1), 0 <= j < i
		init: min[0] = -1  
			means no cut, or cut before index 0.  
			s[0..i-1] entirely is pal, min[i] = 0.  
			to unify with transition function, set it to -1
		result: min[len]
	*/
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPal = getDict(s);
        int len = s.length();
        int[] min = new int[len + 1];
        min[0]  = -1;
        
        for (int i = 1; i <= len; i++) {
            //init min, or default will be 0
			min[i] = i - 1; // same as Work Break I: res[i] = false; but false is default value, so don't need to write
            for (int j = 0; j < i; j++) {
                if (isPal[j][i - 1]) {
                    min[i] = Math.min(min[i], min[j] + 1);
                }
            }
        }
        return min[len];
    }
    
    private static boolean[][] getDict(String s) {
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && ( j - i <= 1 ||
                        isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;            
                }
            }
        }
        return isPal;
    }

	
	/**
		method 2.  从右到左扫
		http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html
		D[i] - min cut from s[i...n]
		D[i] = min(D[i, j] + D[j+1,n]) 
		这是个二维的函数，实际写代码时维护比较麻烦。所以要转换成一维DP。如果每次，从i往右扫描，每找到一个回文就算一次DP的话，就可以转换为
D[i] = 区间[i,n]之间最小的cut数，n为字符串长度， 则,
D[i] = min(1+D[j+1] )    i<=j <n
		关键：
			1. f[len + 1], f[len + 1]为当j=len-1时，计算f[j+1]保留。
			实际意义为：s[i,len-1]整个为palindrome，min cut=0,i.e.f[i] = f[j+1] + 1 = f[len] + 1 = -1 + 1
			2. f[]初始化
			2. boolean[][] palindrome为了不用初始化，从右往左扫
	*/
	public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int[] cut = new int[len + 1];
        boolean[][] palindrome = new boolean[len][len];
        
        for (int i = len - 1; i >= 0; i--) {
            cut[i] = len - i - 1;
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 1 || palindrome[i+1][j-1])) {
                    palindrome[i][j] = true;
                    cut[i] = Math.min(cut[i], cut[j+1] + 1);
                }
            }
        }
        
        return cut[0];
    }
	
	/**
		method 2.  从右到左扫
		f[i] - min cut from s[0..i]
	*/
	public int minCut(String s) {
        
    }
	
}