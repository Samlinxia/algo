import java.io.*;
import java.util.*;
public class Find {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        char res = '0';
        int len = args.length;
        if (len < 2) {
            return;
        }
        if (len == 3) {
            res = nthLetter(args[0], args[1], args[2]);
        } else if (len == 2) {
            res = nthLetter(args[0], "a", args[1]);
        }
       
    }
    
    public static char nthLetter(String str, String firstElem, String nth) {
        int k = 1;
        try {
            k = Integer.parseInt(nth);
        } catch (NumberFormatException e) {
            k = 1;
        }
        str += firstElem;
        int len = str.length();
        Character[] arr = new Character[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Character(str.charAt(i));
        }
        Arrays.sort(arr, new Comparator<Character>(){
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
        int rotatePos = search(arr, firstElem.charAt(0));
        return Character.toLowerCase(arr[(rotatePos + k) % len]);
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
                index = mid;
                break;
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
        //find the first appearance
        while (index >= 1 && chars[index] == chars[index - 1]) {
            index--;
        }
        return index;
    }   
    
}