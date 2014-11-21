import java.util.Arrays;


//decide two string anagrams
class Chap14{
	//sort and compare; String have no native method to sort, so have to convert to char array before sort it
	public static boolean anagram1(String s1, String s2)
	{
		char [] chars1 = s1.toCharArray();
		char [] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return chars1.equals(chars2);
	}
	
	//count the # of each char and compare, use 3 loops
	public static boolean anagram2(String s1, String s2)
	{
		if(s1.length() != s2.length())	return false;
		int [] letter = new int[256];
		int count, temp;
		for(count = 0; count < s1.length(); count++)
		{
			++letter[s1.charAt(count)];
		}
		for(count = 0; count<s2.length(); count++)
		{
			temp = s2.charAt(count);
			if(letter[temp] == 0)	return false;
			--letter[temp];
		}
		for(int i : letter)
		{
			if(letter[i] != 0)	return false;
		}
		return true;
	}
	
	//count #of each emerging char and record # of unique char, use 2 loops
	public static boolean anagram3(String s1, String s2)
	{
		if(s1.length() != s2.length())	
			return false;
		int [] letter = new int[256];
		int count, temp, num_unique_char=0;
		for(count = 0; count < s1.length(); count++)
		{
			temp = s1.charAt(count);
			if(letter[temp] == 0)	
				++num_unique_char;
			++letter[temp];
		}
		for(count = 0; count<s2.length(); count++)
		{
			temp = s2.charAt(count);
			if(letter[temp] == 0)	
				return false;
			--letter[temp];
			if(letter[temp] == 0)
			{	
				--num_unique_char;
				if(num_unique_char == 0)
					return true;
				
			}
		}
		return false;
	}
	
	public static void main(String []args){
		String [] s1 = {"abc","abababc"};
		String [] s2 = {"cba","abaaabbc"};
		for(int i=0; i<2; i++)
		System.out.println(Chap14.anagram3(s1[i],s2[i]));
	}

}