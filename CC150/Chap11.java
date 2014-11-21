
import java.util.Set;
import java.util.HashSet;

//decide whether have duplicate char
class Chap11{

//use hashtable
public static boolean isUniqueChar1(String str)
{
	Set<Character> set = new HashSet<Character>();
	for(int i=0; i<str.length(); i++)
	{
		if(set.contains(str.charAt(i)))
			return false;
		set.add(str.charAt(i));
	}
	return true;

}

//use extra space
public static boolean isUniqueChar2(String str)
{
	boolean [] char_set = new boolean[256];
	for(int i=0; i<str.length(); i++)
	{
		int val = str.charAt(i);   //coercely convert to ASCII code
		if(char_set[val])
			return false;
		char_set[val] = true;
	}
	return true;
}


//don't use extra space, use bit manipulation
public static boolean isUniqueChar3(String str){
	
	int checker = 0;
	int val;
	for(int i=0; i<str.length(); i++)
	{
		val = str.charAt(i) - 'a';
		if((checker & (1<<val)) > 0)	return false;
		checker |= (1<<val);
	}
	return true;
}

//Quick sort then check the next position, sort need extra space
public static void isUniqueChar4(String str){

}

//Bruital force, use two pointer, O(time)=n*n
public static void isUniqueChar5(String str){

}


public static void main(String []args)
{
	String [] s = {"abc","abca","asdfqer;"};
	for(String x: s){
	System.out.println(Chap11.isUniqueChar3(x));
	}
}

}