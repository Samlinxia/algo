class RotatedSortedArray {
	
/**
	Find minimum in rotted sorted array II. All unique int
	
*/
	/**
        similar with 'Search target in rotated array II'.  when A[l] == A[m], increment l
        Compared that problem needs to check A[m] == target in each loop. Indeed it has already check A[l] == target, since A[l] == A[m].  This problem needs to update every global min while doing BS, or l++ would loose result in test case: [10, 1, 10, 10, 10]
    */
    public int findMin(int[] A) {
        if (A == null || A.length == 0) {
			return Integer.MIN_VALUE;
		}
		int len = A.length;
		int l = 0;
		int r = len - 1;
		int min = A[l];
		
		while (l + 1 < r) {
			int m = l + (r - l) / 2;
			if (A[m] > A[l]) {
				min = Math.min(A[l], min);
				l = m;
			} else if (A[m] < A[l]){
				min = Math.min(A[m], min);
				r = m;
			} else {
			    l++;
			}
		}
		return Math.min(min, Math.min(A[l], A[r]));
    }
	
	/*Method 2: improved version
	http://www.cnblogs.com/yuzhangcmu/p/4049117.html
	*/
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        
        int len = num.length;
        if (len == 1) {
            return num[0];
        } else if (len == 2) {
            return Math.min(num[0], num[1]);
        }
        
        int left = 0;
        int right = len - 1;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            // In this case, the array is sorted.
            // 这一句很重要，因为我们移除一些元素后，可能会使整个数组变得有序...
            if (num[left] < num[right]) {
                return num[left];
            }
            
            // left side is sorted. CUT the left side.
            if (num[mid] > num[left]) {
                left = mid;
            // left side is unsorted, right side is sorted. CUT the right side.
            } else if (num[mid] < num[left]) {
                right = mid;
            } else {
                left++;
            }
        }
        
        return Math.min(num[left], num[right]);        
    }

	
/**
	Find minimum in rotted sorted array II. duplicates allowed	
*/
	public int finMin(int[] A) {
		if (A == null || A.length == 0) {
			return Integer.MIN_VALUE;
		}
		int len = A.length;
		
		int l = 0;
		int r = len - 1;
		while (l + 1 < r) {
			int m = l + (r - l) / 2;
			if (A[m] > A[l]) {
				l = m;
			} else if (A[m] < A[r]){
				r = m;
			} else if (A[m] == A[l]) {
				l++;
			} else if (A[m] == A[r]) {
				r--;
			}
		}
		return Math.min(A[l], A[r]);
	}
	
	/** LC
		Search target in rotated sorted array
	
	*/
	
	
}