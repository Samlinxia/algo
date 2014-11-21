class LIS {

/**Problem 1.  LIS one-dimension*/

public int lis (int[] arr) {


}

/**Problem 2
Find the longest increasing number sequence in matrix.
[ 1, 2, 3, 4
  8, 7, 6, 5       ->  result is zig-zag sequence: [1, 2, 3..8], len = 8
  1, 1, 1, 1
]

Consideration : (fit into all int array, matrix, graph problem)
		1. Unique or Duplicate.  If unique number in matrix.  important.  
	so equal number situation no exist, and no possible to back to already visited cell since it's invlaid. meet the invariant: cur > lastVal
	recursion way will run into infinite dead loop. 
		vice versa, If duplicate allowed, need mark visited cell.  
		2. Positve or negative.  
		3. sort or unsorted
		
*/

	private int[][] matrix;
	private int mRows;
	private int mCols;
	public List<Integer> FindLISMatrix (int[][] matrix) {
		if (matrix == null) {
			throw new NullPointerException();
		}
		this.matrix = matrix;
		if (matrix.length == 0 || matrix[0].length == 0) {
			throw new IllegalArgumentException();
		}
		this.mRows = matrix.length;
		this.mCols = matrix[0].length;
		
		int[][] len = new int[][];
		int[] max = new int[3]; // 0->len, 1->row, 2->col
		for (int i = 0; i < mRows; i++) {
			for (int j = 0; j < mCols; j++) {
				getLength(i, j, matrix[i][j], len, max);
			}
		}		
		return printPath(len, max);
	}
	//recursion version check valid
	private static int getLength(int i, int j, int lastVal, int[][] f, int[] max) {
		if (!isValid(i, j, lastVal)) {
			return 0;
		} else if (f[i][j] != 0) {
			return f[i][j];
		}
		lastVal = matrix[i][j]; //update lastVal
		matrix[i][j] = -matrix[i][j]; //mark as visited
		
		int count = Math.max(getLength(i - 1, j, lastVal, f, max), 
				getLength(i + 1, j, lastVal, f, max),
				getLength(i, j + 1, lastVal, f, max),
				getLength(i, j - 1, lastVal, f, max));
		matrix[i][j] = -matrix[i][j]; //mark back unvisited
		f[i][j] = count + 1;
		if (f[i][j] > max[0]) {
			max[0] = f[i][j];
			max[1] = i;
			max[2] = j;
		}
		return f[i][j];
	}
	
	//iteration version check valid
	private int[][] offset = new int[][] {(1, 0), (-1, 0), (0, 1), (0, -1)};
	private static int getLength2(int i, int j, int lastVal, int[][] f, int[] max) {
		if (f[i][j] != 0) {
			return f[i][j];
		}
		lastVal = matrix[i][j];
		matrix[i][j] = -matrix[i][j];
		int count = 0;
		for (int k = 0; k < 4; k++) {
			int row = i + offset[k][0];
			int col = j + offset[k][1];
			if (!isValid(i, j, lastVal)) {
				continue;
			}
			count = Math.max(max, getLength2(row, col, lastVal, f, max));
		}
		matrix[i][j] = -matrix[i][j];
		f[i][j] = count + 1;
		if (f[i][j] > max[0]) {
			max[0] = f[i][j];
			max[1] = i;
			max[2] = j;
		}
		return f[i][j];
	}
	
	private static boolean isValid(int i, int j, int lastVal) {
		if (i >= 0 && i < mRows && j >= 0 && j < mCols 
				&& matrix[i][j] > 0 && matrix[i][j] > lastVal) {
			return true;
		}
		return false;
	}
	
	private List<Integer> printPath(int[][] len, int[] max) {
		List<Integer> res = new ArrayList<>();
		int row = max[1];
		int col = max[2];
		res.add(matrix[row][col]);
		for (int count = max[0] - 1; count >= 1; count--) {
			for (int j = 0; j < 4; j++) {
				int x = row + offset[j][0];
				int y = col + offset[j][0];
				if (x >= 0 && x < mRows && y >= 0 && y < mCols
						&& len[x][y] == count) {
					row = x;
					col = y;
					res.add(matrix[row][col]);
					break;
				}
			}
		}
		return res;
	}
}