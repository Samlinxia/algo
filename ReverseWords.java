public class ReverseWords {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String[] res = s.split(" +");
        if (res.length == 0) {
            return "";
        }
		System.out.println(res.length);
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            sb.append(res[i]).append(" ");
        }
		System.out.println(sb.length());
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.length());
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String tc1 = "1 ";
		String res = ReverseWords.reverseWords(tc1);
		System.out.println(res+"end");
	}
}