package google;

public class StringSerialize {
  private static final char separator = '+';
  public StringSerialize() {
	 // TODO Auto-generated constructor stub
  }
  
  /**compress format: 
   * 	header: number of items. 
   * 	contents: each item store as tuple.
   * tuple{len of char, separator, chars}
   * @param arr
   * @return
   */
  public static String serialize(String[] arr) {
	 if (arr == null || arr.length == 0) {
		return "";
	 }
	 StringBuilder sb = new StringBuilder();
	 sb.append(arr.length).append(separator);
	 for (String s : arr) {
		int len = s.length();
		sb.append(len).append(separator).append(s);
	 }
	 return sb.toString();
  }

  public static String[] deserialize(String s) {
	 if (s == null || s.length() == 0) {
		return new String[0];
	 }
	 int i = 0; 
	 while (i < s.length() && s.charAt(i) != separator) {
		i++;
	 }
	 int num;
	 try {
		num = Integer.parseInt(s.substring(0, i));
	 } catch (NumberFormatException e){
		num = 1000;
	 }
	 String[] res = new String[num];
	 int count = 0;
	 i++;
	 while (i < s.length()) {
		//get the len of single string item
		int stPos = i;
		while (s.charAt(i) != separator) {
		  i++;
		}
		int len = Integer.parseInt(s.substring(stPos, i));
		i++;
		res[count++] = s.substring(i, i + len);
		i += len;
	 }
	 return res;
  }
  public static void main(String[] args) {
	 String[] str = new String[]{"adf", "123", "+++", "+assam"};
	 String s = StringSerialize.serialize(str);
	 System.out.println(s);
	 String[] res = StringSerialize.deserialize(s);
	 for (String ss : res) {
		System.out.println(ss);
	 }
  }
}
