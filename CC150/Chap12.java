//reverse c-style string
class Chap12{
public static void reverse1(String str){
	int end = 0;
	char temp;
	
	char [] charArray = str.toCharArray();
	System.out.println(charArray);
	for(int i=0;i<charArray.length/2;i++)
	{
		temp = charArray[i];
		charArray[i] = str.charAt((str.length()-i-1));
		charArray[charArray.length-i-1] = temp;
	}
	str = charArray.toString();
	System.out.println(str);
	
	/*
	for(int i=0;i<str.length()/2;i++)
	{
		temp = str.charAt(i);
		str[i] = str.charAt(str.length()-i-1);
		str[str.length()-i-1] = temp;
	}
	*/
}

/**
 * Reverse For Loop: Char Array
 */
public String reverse2(String s) {
    char[] reverseStringArray = new char[s.length()];
    for (int i = s.length() - 1, j = 0; i != -1; i--, j++) {
        reverseStringArray[j] = s.charAt(i);
    }
    return new String(reverseStringArray);
} 


public String reverse4(String s) {
    if (s.length() <= 1) { 
        return s;
    }
    return reverse4(s.substring(1, s.length())) + s.charAt(0);
} 


public String reverse3(String s) {
    String reverseStringVariable = "";
    for (int i = s.length() - 1; i != -1; i--) {
        reverseStringVariable += s.charAt(i);
    }
    return reverseStringVariable;
} 


public String reverse5(String s) {
    return new StringBuffer(s).reverse().toString();
} 



public static void main(String [] args){
	String s = new String("abcdefg");
	Chap12 c = new Chap12();
	c.fun()
	Chap12.reverse1(s);
	System.out.println(s);
}

}