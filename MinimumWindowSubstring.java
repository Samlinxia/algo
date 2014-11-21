class MinimumWindowSubstring {

/**
	corner case:
	1. source: "ABCD", target: "A"  single number
	2. source: "A", target: "B".  no match -> ""
	3. minLen == SourceLen, source: "A", target: "A"
	
	error: 1. left ptr points to critical pivot that just makes the window not match with target
		2. no consider no match situation
*/

public String minWindow(String source, String target) {
        // write your code
        if (source == null || target == null) {
            throw new NullPointerException();
        }
        int len = source.length();
        int lenT = target.length();
        if (len == 0 || lenT == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : target.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        int count = 0; //decide whether a match with target
        int stPos = -1;
        int minLen = len + 1;
        int left = 0;
        for (int i = 0; i < len; i++) {
            char c = source.charAt(i);
            if (!map.containsKey(c)) {
                continue;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) >= 0) {
                count++;
            }
            if (count == lenT) { //move left ptr to sqeeze window
                
                while (left <= i && count == lenT) {
                    char tc = source.charAt(left);
                    if (map.containsKey(tc)) {
                        map.put(tc, map.get(tc) + 1);
                        if (map.get(tc) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
                
                if (i - left + 2 < minLen) {
                    minLen = i - left + 2;
                    stPos = left - 1;
                }
            }
        }
        return stPos == -1 ? "" : source.substring(stPos, stPos + minLen);
    }
}