class Anagrams {

/**
CC150: 1.4: decide if two strings are anagrams or not

Method: 1. sort two string, two compare char by char use two ptrs respectively
			time: O(nlgn)  space: O(1)
	2. scan through one string to construct a HashMap<uniqueChar, wordFreqency>, then scan the 
		other str2 to minus the wordFreq.  If wordFreq < 0 or not equal 0 at the end, return false
		time: O(n)   space: O(n)
		because store char here, 
	
*/


/**
思路：用map<string, int>记录排序后的字符串以及首次出现的位置。

1. 从strs的第一个元素开始遍历，首先对元素进行排序得到s；

2. 在map里查找s；

3. 若不存在，将s以及该元素的下标存入map<string ,int>；

4. 若存在，首先将第一次出现s时的原始字符串存入结果res，即strs[map[s]]，并将map[s]设置为-1（防止下次再存），再将该字符串本身存入结果res；

5. 重复以上1-4步，直到遍历结束。
http://www.cnblogs.com/AnnieKim/archive/2013/04/25/3041982.html

*/
	public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        HashMap<String, Integer> anagram = new HashMap<String, Integer>(); //{sortedString : index of strs}
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!anagram.containsKey(sortedStr)) {
                anagram.put(sortedStr, i);
            } else {
                if (anagram.get(sortedStr) != -1) {
                    String s = strs[anagram.get(sortedStr)];
                    res.add(s);
                    anagram.put(sortedStr, -1);
                }
                res.add(strs[i]);
            }
            
        }
        
        return res;
    }
}