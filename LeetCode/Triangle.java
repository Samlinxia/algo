/**
	DP warmming-up problem.
	Comprehend the recursion & DP & Iteration deeply
*/
class Triangle {
	int minSum = Integer.MAX_VALUE;
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return Integer.MAX_VALUE;
		}
		// method 1.  x - row, y - col
		Integer minSum = Integer.MAX_VALUE;
		dfs(triangle, 0, 0, 0, minSum);
		return minSum;
		// method 2
		return dfs(triangle, 0, 0);
		//method 3 & 4
		List<List<Integer>> f = new ArrayList<List<Integer>>(triangle.size() - 1);
		for (int i = 0; i < triangle.size() - 1; i++) {
			f.add(new ArrayList<Integer>());
		}
		return dfs(triangle);
    }
	
	/**Method 1  Top-down Recursion
		
	*/
	private void dfs(List<List<Integer>> triangle, int x, int y, int sum) {
		if (x == triangle.size() - 1) {
			sum += triangle.get(x).get(y);
			minSum = Math.min(minSum, sum);
			return;
		}
		dfs(triangle, x + 1, y , sum + triangle.get(x).get(y));
		dfs(triangle, x + 1, y + 1, sum + triangle.get(x).get(y));
	}
	
	
	/** Method 2  Bottom-up Recursion
	
	*/
	private int dfs(List<List<Integer>> triangle, int x, int y) {
		if (x == triangle.size() - 1) {
			return triangle.get(x).get(y);
		}
		return Math.min(dfs(triangle, x + 1, y),
				dfs(triangle, x + 1, y + 1))
				+ triangle.get(x).get(y);
	}
	
	/** Method 3  DP. Bottom-up Recursion + Memorized space
	
	*/
	private int dfs(List<List<Integer>> triangle, int x, int y, List<List<Integer>> f) {
		if (x == triangle.size() - 1) {
			return triangle.get(x).get(y);
		}
		if (f.get(x).size() - 1 >= y) {
			return f.get(x).get(y);
		}
		int sum = Math.min(dfs(triangle, x + 1, y, f),
				dfs(triangle, x + 1, y + 1, f))
				+ triangle.get(x).get(y);
		f.get(x).add(sum);
		return sum;
	}
	/** Method 4  DP.  Bottom-up Iteration.  (Best!)
	
	*/
	 public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
			return 0;
		}
        int rowSize = triangle.size();
        if (rowSize == 1) {
            return triangle.get(0).get(0);
        }
		List<List<Integer>> f = new ArrayList<List<Integer>>(rowSize - 1);
		for (int i = 0; i < rowSize - 1; i++) {
			f.add(new ArrayList<Integer>());
		}
		
		for (int col = rowSize - 2; col >= 0; col--) {
			Integer sum = Math.min(triangle.get(rowSize - 1).get(col), 
						triangle.get(rowSize - 1).get(col + 1))
						+ triangle.get(rowSize - 2).get(col);
			f.get(rowSize - 2).add(0, sum);
		}
		
		for (int row = rowSize - 3; row >= 0; row--) {
			for (int col = row; col >= 0; col--) {
				Integer sum = Math.min(f.get(row + 1).get(col),
							f.get(row + 1).get(col + 1))
							+ triangle.get(row).get(col);
				f.get(row).add(0, sum);
			}
		}
		return f.get(0).get(0);
    }
	
}