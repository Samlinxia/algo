import java.io.*;
import java.util.*;
/**
find the nth apperance of given char in an ordered string. string should be sorted in lower case before upper case
*/
public class findNthLetter {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        char res = '0';
        int len = args.length;
        if (len < 2) {
            return;
        }
        if (len == 3) {
			int k = 1;
			try {
				k = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				k = 1;
			}
            res = nthLetter(args[0], args[1].charAt(0), k);
        } else if (len == 2) {
            res = nthLetter(args[0], "a", Integer.parseInt(args[1]));
        }
       System.out.println(res);
    }
    
    public static char nthLetter(String str, char firstElem, int nth) {
		
        int len = str.length();
		char[] chars = str.toCharArray();
        Arrays.sort(chars, new Comparator<Character>(){
            @Override
            public int compare(Character a, Character b) {
                //Character a = (Character)c;
                //Character b = (Character)d;
                int res = Character.toLowerCase(a) - Character.toLowerCase(b);
                if (res == 0) { // lowerCase always before uppercase
                    return b.charValue() - a.charValue();
                } else {
                    return res;
                }
            }
        });
        int rotatePos = search(chars, firstElem);
		System.out.println(res);
        return Character.toLowerCase(chars[(rotatePos + nth) % len]);
    }
    
    
    /**
        Binary Search.  Find index of target in char array
    */
    public static int search(Character[] chars, char target) {
        int left = 0;
        int right = chars.length - 1;
        int index = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (chars[mid] == target) {
                right = mid;
            } else if (Character.toLowerCase(chars[mid]) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (chars[left] == target){
            index = left;
        } else if (chars[right] == target) {
            index = right;
        }
        return index;
    }
    
}
