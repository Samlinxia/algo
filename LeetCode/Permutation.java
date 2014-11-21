class Permutation {

	/**Method 1. Use Visited array to record
		Need extra space: visited[] & List<> temp
		Advantage: same template as combination
	*/
	public List<List<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return Collections.<List<Integer>>emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        helper(num, res, tmp, visited);
        return res;
    }
    
    private static void helper(int[] num, List<List<Integer>> res, List<Integer> tmp,
            boolean[] visited) {
    
        if (num.length == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            tmp.add(num[i]);
            helper(num, res, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
	
	
	/**Method 2. Use swap to generate different start of sub-permute
		Don't need extra space visited[] & List<> temp
		Same thoughts from 'Next Permutation'
		http://blog.csdn.net/m6830098/article/details/17291259
	*/
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, num, 0);
        return res;
	}
    
    public void helper(List<List<Integer>> res, int[] num, int pos) {
        if (pos == num.length) {
            List<Integer> output = new ArrayList<Integer>();
            for (int a : num) {
                output.add(a);
            }
            res.add(output);
            return;
        }
        
        for (int i = pos; i < num.length; i++) {
            swap(num[pos], num[i]);
            helper(res, num, pos + 1);
            swap(num[pos], num[i]);
        }
    }
    
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
	
}