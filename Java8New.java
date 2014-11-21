import java.util.*;
class Java8New {

	public static void main(String[] args) {
	String[] words = new String[]{"zebar", "fuck", "apple", "banana", "orange", "water"};
	Arrays.sort(words, 
			(first, second) -> first.compareTo(second));	
	for (String s : words) {
		System.out.println(s);
	}
	}
}