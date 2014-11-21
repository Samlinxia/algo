/**
Remove duplicate from sorted array & list
*/

class RemoveDuplicate {

	/**
	Given a sorted array, remove the duplicates in place such that updates A so that if x appears m times in A, it 
appears exactly min(k,m) times in A. (k = 1,2,3...)The update to A should be in one pass, and no additional storage may be allocated.
	Do not allocate extra space for another array, you must do this in place with constant memory.
	*/
	
	/**
		m = 2.  if x duplicates m times, can only appear min(2, m).
		Wrong method.  Will get wrong when:
		Input:	[1,1,1,2,2,3]
		Output:	[1,1,2,3]
		Expected:	[1,1,2,2,3]
		不可以比较i 和 i-1 i-2，会覆盖掉之前的数值，导致后面的比较不准
	*/
	public int removeDuplicates(int[] A) {
		if (A == null) {
            return 0;
        }
		if (A.length <= 2) {
			return A.length;
		}
		int writePtr = 1;
		for (int i = 2; i < A.length; i++) {
			if (A[i] == A[i - 1] && A[i] == A[i - 2]) {
				continue;
			} else {
				A[++writePtr] = A[i];
			}
		}
		
		return writePtr + 1;
	}
	
	/** read pointer compare to write pointer
		cur - read pointer
		prev - write pointer
		i 和 writePtr，writePtr - 1比较，正确
	*/
	public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
		if (A.length <= 2) {
			return A.length;
		}
        int prev = 1; // point to previous
		int curr = 2; // point to current
 
		while (curr < A.length) {
			if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
				curr++;
			} else {
				prev++;
				A[prev] = A[curr];
				curr++;
			}
		}
 
		return prev + 1;
    }
	
	/** Method 2 加个Count Check
	更general的解法，适用于x duplicates m次，最多出现k次情况,min(k, m)
	@param k the times that duplicates are allowed
	*/
	public int removeDuplicates(int[] A, int k) {
		if (A == null) {
            return 0;
        }
		if (A.length <= k) {
			return A.length;
		}
		int count = 1;
		int writePtr = k - 1; // write pointer point to last element in updated A
		for (int i = k; i < A.length; i++) {
			if (A[i] == A[writePtr]) {
				count ++;
				if (count <= k) {
					A[++writePtr] = A[i];
				}
			} else {
				count = 1;
				A[++writePtr] = A[i];
			}
		}
		return writePtr + 1;
	}
	
}