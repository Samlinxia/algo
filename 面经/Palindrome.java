
public class Palindrome {

  public Palindrome() {
	 
	 
  }
  
  public static String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
        return "";
    }
    int maxLen = 0;
    int stPos = -1;
    
    for (int i = 0; i < s.length(); i++) {
        //odd
        int len = expandCenter(s, i, i);
        if (len > maxLen) {
            maxLen = len;
//            System.out.println(maxLen);
            stPos = i - (len / 2);
        }
        //even
        len = expandCenter(s, i - 1, i);
        if (len > maxLen) {
            maxLen = len;
            System.out.println(maxLen);
            stPos = i - (len / 2);
        }
    }
//    System.out.println(stPos);
//    System.out.println(maxLen);
    return s.substring(stPos, stPos + maxLen);
  }
  
  private static int expandCenter(String s, int l, int r) {
      if (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
          l--;
          r++;
      }
      return r - l - 1;
  }
  
  public static void main(String[] args) {
	 String s = "ccc";
	 String res = longestPalindrome(s);
	 System.out.println(res);
  }
}
