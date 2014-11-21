class RomanToInt {
    /*
I = 1;
V = 5;
X = 10;
L = 50;
C = 100;
D = 500;
M = 1000;
*/
	public static int romanToInt(String s) {
        int pre = 0;
        int cur = 0;
        int total = 0;
        total = charToInt(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            pre = charToInt(s.charAt(i - 1));
            cur = charToInt(s.charAt(i));
            if (cur <= pre) {
                total += cur;
            } else {
                total = total - 2 * pre + cur;
            }
        }
        return total;
    }
    
    public static int charToInt(char c) {  
        int data = 0;  
  
        switch (c) {  
            case 'I':  
                data = 1;  
                break;  
            case 'V':  
                data = 5;  
                break;  
            case 'X':  
                data = 10;  
                break;  
            case 'L':  
                data = 50;  
                break;  
            case 'C':  
                data = 100;  
                break;  
            case 'D':  
                data = 500;  
                break;  
            case 'M':  
                data = 1000;  
                break;  
        }  
  
        return data;  
    }  


    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romans.length; i++) {
            while (num >= values[i]) {
                sb.append(romans[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}

}