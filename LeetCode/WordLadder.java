class WordLadder {

/**String is short & word dict size is large
	BFS. iterate all possible string by changing only one char at once.  Lookup set to check exist
	
	技巧：如果不想生成新的class，就用一个同样size的平行Data Structure来记录additional info*/
	
	
	


/**String is long & word dict size is small
	Use DFS search word dict to match*/
private int minLen = Integer.MAX_VALUE;
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || start.length() == 0 
                || end == null || end.length() == 0 
                || dict == null || dict.size() == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        int wordLen = start.length();
        for (String s : dict) {
            if (s.length() != wordLen) {
                return 0;
            }
            map.put(s, 0);
        }
        helper(start, end, map, 0);
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private void helper(String start, String end, Map<String, Integer> map, int len) {
        if (start == end) {
            minLen = Math.min(len, minLen);
            return;
        }
        
        for (String s : map.keySet()) {
            if (map.get(s) == 1 || !transferable(start, s)) {
                continue;
            }
            map.put(s, 1);
            helper(s, end, map, len + 1);
            map.put(s, 0);
        }
    }
    
    private boolean transferable (String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}