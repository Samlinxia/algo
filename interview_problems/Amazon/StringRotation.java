public class StringRotation {
  
  public StringRotation() {
	 String s1 = "abcabc";
	 String s2 = "cabcab";
	 String s3 = "abcbac";
	 System.out.println(isRotate(s1, s2));
	 System.out.println(isRotate(s1, s3));
  }
  
  public static boolean isRotate(String s1, String s2) {
	 if (s1.length() != s2.length()) {
		return false;
	 }
	 String s = s1 + s1;
	 return strStr(s, s2);
  }
  
  private static boolean strStr(String haystack, String needle) {
	 int lenH = haystack.length();
	 int lenN = needle.length();
	 
	 //i < lenH - lenN + 1;
	 //对吗？两个长度不是一样的吗
	 for (int i = 0; i < lenH - lenN + 1; i++) {
		if (haystack.charAt(i) != needle.charAt(0)) {
		  continue;
		}
		int j;
		for (j = 1; j < lenN; j++) {
		  if (haystack.charAt(i + j) != needle.charAt(j)) {
			 break;
		  }
		}
		if (j == lenN) {
		  return true;
		}
	 }
	 return false;
  }
  
  public static void main(String[] args) {
	 StringRotation sr = new StringRotation();
  }
}