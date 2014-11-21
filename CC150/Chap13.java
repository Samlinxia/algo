

//remove the deplicated char in string;  
//coz String is immutable, so transfer to char[] or StringBuffer to deal with
class Chap13{
//No extra space; two pointer brutal force
public static void removeDuplicates(char [] str)
{
	if(str.length <2) return;
	if(str == null) return;
	int j, tail=1;
	for(int i=1; i<str.length; i++)
	{
		for(j=0; j<tail; j++)
		{
			if(str[i] == str[j])
				break;
		}
		if(j==tail)
		{
			str[tail++] = str[i];
			
		}
	}
	str[tail] = '\0';	
}

//use StringBuffer
public static void removeDuplicates2(StringBuffer str)
{
	if(str.length()<1 || str == null)
		return;
	int j, tail=1;
	for(int i=1; i<str.length(); i++)
	{
		for(j=0; j<tail; j++)
		{
			if(str.charAt(i) == str.charAt(j))	break;
		}
		if(j == tail)
		{
			str.setCharAt(tail++,str.charAt(i));
		}
	}
	str.setLength(tail);
}

public static void main(String [] agrs){
	
	String s = "abcdabfgjkeab";
	char [] c = s.toCharArray();
	StringBuffer sb = new StringBuffer(s);
	Chap13.removeDuplicates(c);
	Chap13.removeDuplicates2(sb);
	System.out.println(sb);
}

}