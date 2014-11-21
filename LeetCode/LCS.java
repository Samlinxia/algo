class LCS {
	public int lcs (int[] A) {
		if (A == null) {
			return 0;
		} 
		int len = A.length;
		if (len <= 1) {
			return len;
		}
		int[] f = new int[len];
		f[0] = 1;
		for (int i = 1; i < len; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] <= A[i]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		int max = 1;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, f[i]);
		}
		return max;
	}
}