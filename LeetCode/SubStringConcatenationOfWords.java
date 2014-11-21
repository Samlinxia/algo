public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (L == null || L.length == 0) {
            return res;
        }
        
        int strLen = L[0].length();
        int strNum = L.length;
        int winSize = strLen * strNum;
        if (winSize < S.length()) {
            return res;
        }
        
        HashMap<String, Integer> mapExpect = new HashMap<String, Integer>();
        for(int i = 0; i < strNum; i++) {
            if (mapExpect.containsKey(L[i])) {
                mapExpect.put(L[i], mapExpect.get(L[i]) + 1);
            } else {
                mapExpect.put(L[i], 1);
            }
        }
        
        for (int i = 0; i <= S.length() - winSize; i++) {
            boolean flag = true;
            HashMap<String, Integer> mapTemp = new HashMap<String, Integer>();
            for (int j = i; j < i + winSize; j += strLen) {
                String word = S.substring(j, j + strLen);
                if ( !mapExpect.containsKey(word) ) {
                    flag = false;
                    break;
                } else {
                    if (mapTemp.containsKey(word)) {
                        mapTemp.put(word, mapTemp.get(word) + 1);
                    } else {
                        mapTemp.put(word, 1);
                    }
                }
                if (mapTemp.get(word) > mapExpect.get(word)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                res.add(i);
            }
        }
        
        return res;
    }
}