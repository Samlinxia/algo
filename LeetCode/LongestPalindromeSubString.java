/**
http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
*/

class LongestPalindromeSubString {
	/**Method 1 : Brute force.  O(N^3)
	*/
	
	
	/**Method 2: Dynamic programming solution, O(N2) time and O(N2) space
		we first initialize the one and two letters palindromes, 
		and work our way up finding all three letters palindromes, and so on.
		Brute force from subArray size 1,2..len
	*/
	public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] isPaldm = new boolean[len][len];
        int longestStart = 0;
        int endIndex = 0;
        
        for (int i = 0; i < len; i++) {
            isPaldm[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPaldm[i][i + 1] = true;
                longestStart = i;
                endIndex = i + 1;
            }
        }
        
        for (int size = 3; size <= len; size++) {
            for (int i = 0; i <= len - size; i++) {
                int j = size + i - 1;
                if (s.charAt(i) == s.charAt(j) && isPaldm[i+1][j-1]) {
                    isPaldm[i][j] = true;
                    longestStart = i;
                    endIndex = j;
                }
            }
            
        }
        return s.substring(longestStart, endIndex + 1);
    }
	
	/**Method 2* : DP.  Don't need to initialize, change the iterate order implement rolling array
	to re-use
	*/
	public String longestPalindrome(String s) {
		int len = s.length();
		boolean[][] isPal = new boolean[len][len];
		//use len&stPos to denote result.  Avoid repeat substring operation, which takes O(n) time
		int maxLen = 0;
		//init to -1 to indicate whether has pal
		int stPos = -1;
		
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 1 
						|| isPal[i + 1][j - 1])) {
					isPal[i][j] = true;
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						stPos = i;
					}
				}
			}
		}
		return s.substring(stPos, stPos + maxLen);
	}
	
	
	/**Method 3 : A simpler & tricky approach, O(N^2) time and O(1) space
		Utilize palindrome characteristics
		Verify whether is palindrome takes O(N) time, iterate N item takes overall O(N^2)
	*/
	public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int maxLen = 0;
        int longestStart = -1;
        
        for (int i = 0; i < s.length(); i++) {
            int len = expandCenter(s, i, i);
            if (len > maxLen) {
                maxLen = len;
                longestStart = i - (maxLen / 2);
            }
            
            len = expandCenter(s, i - 1, i);
            if (len > maxLen) {
                maxLen = len;
                longestStart = i - (maxLen / 2);
            }
        }
        return s.substring(longestStart, longestStart + maxLen);
    }
    
    private static int expandCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }		
		
}