class WildcardMatching {
	/**
	Method 1: Brute Force
		'*' can be multiple times.  so Time Limit Exceed
		can use backtracking : 
		cut the duplcate cases when multiple '*' appear, only remember the last '*'
	*/
	public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }
    
    private static boolean match(String s, int si, String p, int pi) {
        int sLen = s.length();
        int pLen = p.length();
        if (pi == pLen) {
            return si == sLen;
        }
        if (si == sLen) {
            if (p.charAt(pi) == '*' && pi == pLen - 1) {
                return true;
            } else {
                return false;
            }
        }
        
        if (p.charAt(pi) != '*') { //case 1 : p[pi] is not '*'
            if (!matchFirst(s, si, p, pi)) {
                return false;
            } else {
                return match(s, si + 1, p, pi + 1);
            }
        } else {  // case 2: p[pi] is '*'
            if (pi == pLen - 1) {
                return true;
            }
            
            for (int i = si; i < sLen; i++) {
                if (!matchFirst(s, i, p, pi + 1)) {
                    continue;
                }
                if (match(s, i + 1, p, pi + 2)) {
                    return true;
                }
            }
            
            return false;
        }
    }
    
    private static boolean matchFirst(String s, int si, String p, int pi) {
        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	Method 2: DP
	*/
	
	
	
	/**Method 3: Greedy  Recommend
	http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
	https://github.com/benyl/leetcode/blob/master/Wildcard%20Matching.cc
	*/
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();
        if (sLen == 0 && pLen == 0) {
            return true;
        } else if (pLen == 0) {
            return false;
        }
        
        int pMtchSt = -1;
        int sMtchSt = -1;
        int pi = 0;
        int si = 0;
		/**how to decide s or p stop in if condition:  when si == sLen there is no possibility match so far except '*' follows; 
			but when p == pLen, there are multiple possibility that still can matched, which can reset the pi, si pointer and try match again.
        */
		while (si < sLen) {
			// case 1: char match
            if (pi < pLen && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')) {
                pi++;
                si++;
            } else if (pi < pLen && p.charAt(pi) == '*') { // case 2: p[pi] == '*'
                pMtchSt = pi++;
                sMtchSt = si;
            } 
			/* combine case 3 & 4, because both cases do same workflow
				case 3: p == pLen
				case 4: char doesn't match & p[pi] != '*'
			*/
			else { 
				if (pMtchSt != -1) {  //there is a '*' before, so reset pi and increment si to try another match possibility(try '*' match one more char in S)
					pi = pMtchSt + 1;
					si = ++sMtchSt;
				} else { //no '*' before
					return false;
				}
			}
        }
        //tailing '*'
        while (pi < pLen && p.charAt(pi) == '*') {
            pi++;
        }
        
        return pi == pLen ? true : false;
    }
	
}