class Fibonacci {

	/**Method 1 : Recursion DP(memorized search)
		Method 2 : Iteration DP
	**/
	
	private int[] arr = null;
	public int fibonacci(int nth) {
		if (nth <= 0) {
			return -1;
		} else if (nth == 1) {
			return 0;
		} else if (nth == 2) {
			return 1;
		}
		arr = new int[nth];
		arr[0] = 0;
		arr[1] = 1;
		//method 1 Recursion
		f(nth - 1);
		
		//method 2 Iteration
		for (int i = 2; i < nth; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[nth - 1];
	}
	
	
	private int f(int n) {
	if (arr[n] != 0) {
		return arr[n];
	} else if (n == 0) {
		return 0;
	}
	arr[n] = f(n - 1) + f(n - 2);
	return arr[n]
	}
	
	
}