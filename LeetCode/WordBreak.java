class WordBreak {
/**
	Word Break I
	

*/
	/**Method 1 : DFS. naive way O(2^n)*/
	public boolean wordBreak(String s, Set<String> dict) {
             return wordBreakHelper(s, dict, 0);
    }
 
    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()) 
            return true;
		//could also iterate s to match with dict set	
        for(String a: dict){
            int len = a.length();
            int end = start+len;
 
            //end index should be <= string length
            if(end > s.length()) 
                continue;
 
            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }
 
        return false;
    }
	
	/**Method 2 : DP.  
	when has "determine whether, return true/false" key word, consider DP
	time: O(n^2), space: O(n^2)
	
	*/
	public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] f = new boolean[len];
        
        for (int i = 0; i < len; i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                f[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j + 1, i + 1))) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[len - 1];
    }
	
	
	
/**
	Word Break II

*/
/**Method 1 Brute Force.  */
	private int maxLen = -1;
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        String temp = "";
        calMaxInt(dict);
        helper(s, dict, res, temp, 0);
        return res;
    }
    
    public void calMaxInt(Set<String> dict) {
        for (String s : dict) {
            maxLen = Math.max(maxLen, s.length());
        }
    }
    
    /*DFS.  special point: store tmp output as String type.  
	Because requirement needs generate String type, so if store in list as usual, 
	it needs deep copy and reconstruct answer again when output to res set, which is waste time.
	*/
    public void helper(String s, Set<String> dict, List<String> res, String temp, int pos) {
        if (pos == s.length()) {
            res.add(temp);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            if (i - pos + 1> maxLen) { //backtrack
                break;
            }
            sb.append(s.charAt(i));
            if (!dict.contains(sb.toString())) {
                continue;
            }
            String item = temp.length() > 0 ? temp + " " +sb.toString() : sb.toString();
            helper(s, dict, res, item, i + 1);
        }
    }
	
	/**Method 2
	http://www.binglu.me/leetcode-word-break-and-word-break-ii/
	*/
	 public List<String> wordBreak(String s, Set<String> dict) {
        int length = s.length();
        
        //create the word ending character's index list for each character
        ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>(length);
        for(int i = 0;i<length;i++)
            record.add(new ArrayList<Integer>());
 
        //each character can be the ending character of some word
        for(int end=length;end>=0;end--){
		
            if(end < length && record.get(end).isEmpty())
                continue;
            
            //find the starting character for the current ending character
            for(int runner = end-1;runner >= 0;runner--){
                if(dict.contains(s.substring(runner,end)))
                    record.get(runner).add(end);    //add current end to start character's list
            }
        }
        
        ArrayList<String> solutionSet = new ArrayList<String>();
        buildSolution(record,0,s,"",solutionSet);
        
        return solutionSet;
    }
 
    void buildSolution(ArrayList<ArrayList<Integer>> record, int current, String s, 
                String solution, ArrayList<String> solutionSet){
        
        //iterate on current character's word ending list
        for(Integer end : record.get(current)){
 
            String sub=s.substring(current,end);
            /*
                since the loop may have many iterations, we should keep the reference
                of "solution", rather than writing as "solution += ..."
            */
            String newSolution = solution+(current==0 ? sub : " "+sub);
            
            if(end == s.length()) 
                solutionSet.add(newSolution);
            else 
                buildSolution(record,end,s,newSolution,solutionSet);
        }
    }
}