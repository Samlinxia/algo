class FindMissingNumber {
	/**  Two similar problem:
	1) leetcode FirstMissingPositive
	2) Find the Missing Number
You are given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list. 
Write an efficient code to find the missing integer.
	3) find missing and repeating number at same time

http://www.geeksforgeeks.org/find-the-missing-number/
	
	explanation:  
	1. All methods can solved 1,2 problems as long as a slightly variation
	2. method 1,2 can also solve problem 3.
	2. Method 1~5 restriction:
		1)needs to know range
		2)not allow invalid number
	3. XOR is best solution solve problem 2.
	4. Method 6 don't need range and invalid number is allowed.  which is best solve problem 1.
	*/
	
	/** Method 1  Use extra count array(counting sort)
	Once value range is given(the range is not large), seriously consider count array. A huge hint!
	Use array index to represent value -> save space than HashMap
	Of course, could use HashMap, HashSet, BitMap also.
	space: O(n), time: O(n)
	*/
	private int findMissingAndRepeat(int[] arr, int n) {
		int[] count = new int[n + 1];
		int sum = 0, j = 0;
		int repeatNum = 0;
		int missNum = 0;
		int[] missNumArr;  // can also find multiple missing number
		for (int i = 0; i < arr.length; i++) {
			if (count[arr[i]] == 1) {
				repeatNum = arr[i];
			} 
			count[arr[i]]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (count[arr[i]] == 0) {
				missNum = arr[i]; // missNumArr[j++] = arr[i];
			}
		}
		return missNum;  //missNumArr
	}
	
	/** Method 2  Use elements as index and mark the visited places
	No extra count arry, use in-place arr as count array.  
	First scan, Flip array value to negative marked as visited.  Already neg value is repeating element
	Second scan, find first positive value, which is the missing element.
	Analysis:  improvement of method 1.  use in-place modification to 
	space: O(1)
	*/
	private int findMissingAndRepeat2(int[] arr, int n) {
		int sum = 0;
		int missNum = 0;
		for (int i = 0; i < arr.length; i++) {
			
		}
	}
	
	
	/** Method 3 Bloom Filter
	Once data is large, HashMap would be huge and waste space.  Seriously consider Bloom Filter for 
	For large data set(memory can't hold all data)problem, consider:
		1. BitMap
		2. Bloom Filter
		4. store on disk.  External sort & n-way merge
		3. distributed HashMap stored in different machine
	*/
	
	
	
	/**  Method 4   Maths
	1. Get the sum of numbers 
       total = n*(n+1)/2
	2  Subtract all the numbers from sum and
	   you will get the missing number.
	*/
	private int findMissingNum3(int[] arr, int n) {
		long sum = n * (n + 1) / 2;
		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
		}
		return sum;
	}
	
	/**  method  5  XOR
	 1) XOR all the array elements, let the result of XOR be X1.
	2) XOR all numbers from 1 to n, let XOR be X2.
	3) XOR of X1 and X2 gives the missing number.
	*/
	private int findMissingNum4(int[] arr, int n) {
		int sum = 0;
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			sum ^= arr[i];
		}
		// use value range
		for (int i = 1; i <= n; i++) {
			sum ^= i;
		}
		//or use index
		for (int i = 0; i < n; i++) {
			sum ^= arr[i];
			sum ^= (i + 1);
		}
		return sum;
	}
	
	/** Leetcode 原题 FirstMissingPositive.  no range given
		Method 6  coutingSort-like putting value into array of equal index
		Array can be: [1, 3, 7], so output should be 2.  So XOR & sum method doesn't work
		Basic idea: first missing positive starts from 1, which matches index-0
			Scan through array once to match all items as much as possible.  
			Then scan second time to find the first one that value-index pair not match.
	*/
	
	public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        int i = 0;
        while (i < A.length) {
            if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        
        return A.length + 1;
    }
    
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	
}