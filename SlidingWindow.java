/**
Minimum window that S contains T's char

S = zxyaaabcd
T = abcd

*/
class SlidingWindow {
	public String minWinSize (String S, String T) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : T.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		
		int count = 0;
		int minLen = Integer.MAX_VALUE; //S may not contains T's anagram
		int minst = -1; 
		int left = 0;
		
		for (int i = 0; i < S.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				continue;
			}
			map.put(c, map.get(c) - 1);
			if (map.get(c) >= 0) { // map[c] == 0 is a match
				count++;
			}
			if (count == T.length()) {
				
				while (minSt < i && count == T.length()) { //when count == lenT, it's still match in window
					char lc = S.charAt(left);
					if (map.containsKey(left)) {
						map.put(lc, map.get(lc) + 1);
						if (map.get(lc) > 0) {
							count--;
						}
					}
					left++;
				}
				left--;
				if (i - left + 1 < minLen) {
					minSt = left;
					minLeft = i - left + 1;
				}
			}
		}
		return minSt == -1 ? "" : S.substring(minSt, minSt + minLen);
	}
}