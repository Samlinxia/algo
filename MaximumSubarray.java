class MaximumSubarray {

// Version 1: Sliding Window
	
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0){
			return 0;
		}
		
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}

		return max;
	}

// Version 2: Prefix Sum

	
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0){
			return 0;
		}
		
		int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}

		return max;
	}
		
// Version 3: DP. Local Max & Global Max
	
	public int maxSubArray(int[] A) { 
		if (A == null || A.length == 0) {
			return 0;
		}
		int localMax = 0;
		int globalMax = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			localMax = Math.max(localMax + A[i], A[i]);
			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	}
	
	/** Problem 2.  Minimum Subarray.  LintCode
	
	*/
	//case 1, -1, -2, 1
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            throw new IllegalArgumentException();
        }
        int min = nums.get(0);
        int localMin = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            localMin = Math.min(localMin + nums.get(i),
                    nums.get(i));  
            min = Math.min(min, localMin);
            
            // (localMin,min): (1, 1), (-1, -1), (-3, -3), (-2, -3)
             
        }
        
        return min;
    }
	
	/**Problem 3. Maximum Subarray II.  LintCode
	
	*/
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null) {
            throw new NullPointerException();
        }
        int len = nums.size();
        if (len <= 1) {
            throw new IllegalArgumentException();
        }
        
        int[] leftMax = new int[len];
        leftMax[0] = nums.get(0);
        int localMax = nums.get(0);
        //left -> right
        for (int i = 1; i < len - 1; i++) {
            localMax = Math.max(localMax + nums.get(i), 
                    nums.get(i));
            leftMax[i] = Math.max(localMax, leftMax[i - 1]);
        }
        
        int res = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        localMax = 0;
        //right -> left
        for (int i = len - 1; i >= 1; i--) {
            localMax = Math.max(localMax + nums.get(i), 
                    nums.get(i));
            rightMax = Math.max(localMax, rightMax);
            res = Math.max(res, rightMax + leftMax[i - 1]);
        }
        
        //1, 3, -1, 2, -1, 2 -> 7
        //leftMax [1,4,3,5,4,6], right:
        return res;
    }
	
	/**Problem 4.  Maximum Subarray Difference.  LintCode
	
	*/
	public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null) {
            throw new NullPointerException();
        }
        int len = nums.size();
        if (len == 0) {
            throw new IllegalArgumentException();
        }
        int[] maxLeft = new int[len];
        int[] minLeft = new int[len];
        maxLeft[0] = nums.get(0);
        minLeft[0] = nums.get(0);
        int localMax = nums.get(0);
        int localMin = localMax;
        
        for (int i = 1; i < len - 1; i++) {
            localMax = Math.max(localMax + nums.get(i),
                    nums.get(i));
            localMin = Math.min(localMin + nums.get(i),
                    nums.get(i));
            maxLeft[i] = Math.max(localMax, maxLeft[i - 1]);
            minLeft[i] = Math.min(localMin, minLeft[i - 1]);
        }
        
        int res = Integer.MIN_VALUE;
        localMax = 0;
        localMin = 0;
        int maxRight = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;
        
        for (int i = len - 1; i >= 1; i--) {
            localMax = Math.max(localMax + nums.get(i), 
                    nums.get(i));
            localMin = Math.min(localMin + nums.get(i),
                    nums.get(i));
            maxRight = Math.max(maxRight, localMax);
            minRight = Math.min(minRight, localMin);
            res = Math.max(res, Math.max(Math.abs(minLeft[i - 1] - maxRight), 
                    Math.abs(maxLeft[i - 1] - minRight)));
        }
        return res;
    }
}