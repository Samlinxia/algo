package google;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {

  public StringSplit() {
	 // TODO Auto-generated constructor stub
  }

  public static List<String> split(String s) {
	 List<String> list = new ArrayList<>();
	 s = s.trim();
	 int len = s.length();
	 int i = 0;
	 int stPos = 0;
	 boolean hasQuot = false;
	 boolean hasChar = false;
	 while (i < len) {
		if (s.charAt(i) == ' ') {
		  if (!hasQuot && hasChar) {
			 list.add(s.substring(stPos, i));
			 hasChar = false;
			 stPos = i + 1;
		  } else if (!hasQuot && !hasChar) { //skip spaces
			 stPos = i + 1;
		  }
		} else if (s.charAt(i) == '"') {
		  if (hasQuot) {
			 list.add(s.substring(stPos, i + 1)); //output includes "
			 hasChar = false;
		  } 
		  stPos = i;
		  hasQuot = !hasQuot;
		} else {
		  hasChar = true;
		}
		i++;
	 }
	 return list;
  }
  
  public static List<String> split2(String s) {
	 List<String> list = new ArrayList<>();
	 StringBuilder sb = new StringBuilder();
	 boolean hasQuot = false;
	 
	 for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == ' ') {
		  if (!hasQuot && sb.length() != 0) {
			 list.add(sb.toString());  //output
			 sb.delete(0, sb.length()); // clear buffer
		  } else if (hasQuot){
			 sb.append(s.charAt(i));
		  }
		} else if (s.charAt(i) == '"') {
		  if (!hasQuot) {
			 sb.append(s.charAt(i));  // add '"'
		  } else {
			 sb.append(s.charAt(i));
			 list.add(sb.toString());  //output
			 sb.delete(0, sb.length());
		  }
		  hasQuot = !hasQuot;
		} else {
		  sb.append(s.charAt(i));
		}
	 }
	 // add remaining buffer to output
	 if (sb.length() != 0) {
		list.add(sb.toString());
	 }
	 return list;
  }

  public static void main(String[] args) {
	 String str = "\"dsafdsf adsf \" adsf abc e \"asdfads adsfa asdf\"ad  ";
	 List<String> res = StringSplit.split2(str);
	 for (String s : res) {
		System.out.println(s);
	 }
  }

}
