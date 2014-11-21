

//replace space with %20
class Chap15{

//use extra space
	public static char[] replaceSpace(char [] chars)
	{
		char[] newChars = new char[chars.length*3];
		for(int i=0, j=0; i<chars.length;i++)
		{
			if(chars[i] == ' ')
			{
				newChars[j++] = '%';
				newChars[j++] = '2';
				newChars[j++] = '0';
			}
			else
				newChars[j++] = chars[i];
		}
		return newChars;
	}
	
//not use extra space, instead use 2 pointers
	public static void replaceSpace2(char [] chars)
	{
		int spaceNum = 0, newLength, i = 0;
		for(i=0; i<chars.length; i++)
		{
			if(chars[i] == ' ')	
				++spaceNum;
		}
		newLength = chars.length + spaceNum*2;
		chars[newLength] = '\0';
		for(i=chars.length-1; i>=0; i--)
		{
			if(chars[i] == ' ')
				{
					chars[--newLength] = '0';
					chars[--newLength] = '2';
					chars[--newLength] = '%';
				}
			else
				chars[--newLength] = chars[i];
		}
		
	}
	
	public static void main(String[] args)
	{
		String[] str = {"abcdef","abc d e f"," ","  "};
		for(String x: str)
		{
			System.out.println(x);
			Chap15.replaceSpace2(x.toCharArray());
			System.out.println(x);
		}

	}
	
}