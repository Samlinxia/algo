import java.util.*;

class FindKth {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
	
	/**Method 1:
	Quicksort partitioning
	*/
	public int kthSmallestElement(int[] arr, int k) {
		if (arr == null || arr.length < k || k < 1) {
			return Integer.MIN_VALUE;
		}
		int res = findKthSmall(arr, k, 0, arr.length - 1);
		return res;
	}
	
	private int findKthSmall(int[] arr, int k, int lo, int hi) {
		int pivot = lo;
		int left = lo + 1;
		int right = hi;
		while (left < right) {
			while ( left < arr.length && arr[left] <= arr[pivot]) {
				left++;
			}
			while (right > pivot && arr[right] > arr[pivot]) {
				right--;
			}
			if (left < right) {
				swap(arr, left, right);
			}
		}
		swap(arr, pivot, right);
		if (right == k - 1) {
			return arr[right];
		} else if (right > k - 1) {
			return findKthSmall(arr, k, lo, right - 1);
		} else {
			return findKthSmall(arr, k, right + 1, hi);
		}
	}
	
	
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (numbers == null || k < 1 || numbers.size() < k ) {
            return Integer.MIN_VALUE;
        }
        int res = findKth(k, numbers, 0, numbers.size() - 1);
        return res;
    }
	
     
    private int findKth(int k, ArrayList<Integer> numbers, int lo, int hi) {
        int pivot = lo;
        int left = lo + 1;
        int right = hi;
        while (left < right) {
            while (left < numbers.size() && numbers.get(left) <= numbers.get(pivot)) {
                left++;
            }
            while (right > pivot && numbers.get(right) > numbers.get(pivot)) {
                right--;
            }
            if (left < right) {
                swap(numbers, left, right);
            }
        }
        swap(numbers, pivot, right);
        int key = numbers.size() - k;
        if (right == key) {
            return numbers.get(right);
        } else if (right > key) {
            return findKth(k, numbers, lo, right - 1);
        } else {
            return findKth(k, numbers, right + 1, hi);
        }
    }
    
    private void swap(ArrayList<Integer> numbers, int left, int right) {
        int temp = numbers.get(left);
        numbers.set(left, numbers.get(right));
        numbers.set(right, temp);
    }
	
	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	/**Method 2
	MinHeap maintain K element
	*/
	public int findKth(int[] nums, int k) {
		if (nums == null || k < 1 || k > nums.length) {
			return Integer.MIN_VALUE;
		}
		Queue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
		
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		
		int i = 0;
		while (i < k) {
			heap.add(nums[i]);
		}
		while (i < nums.length) {
			int min = heap.peek();
			if (min < nums[i]) {
				heap.remove();
				heap.add(nums[i]);
			}
			i++;
		}
		return heap.remove();
	}
	
	/**
	Find kth element in two sorted array A & B with size m & n respectively. 
	http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
	*/
	private double findKthInTwoArray(int[] A, int m, int[] B, int n, int k) {
		if (A == null || A.length == 0 || B == null || B.length == 0
				|| k < A.length + B.length) {
			return Integer.MIN_VALUE;
		}
		int len = A.length + B.length;
		if (len % 2 == 0) {
			return (findKth() + findKth()) / 2.0;
		} else {
			return findKth();
		}
	}
	
	
	
	public static void main(String[] arg) {
		int[] arr = new int[]{ 3, 6, 4, 7, 7, 7, 2, 5, 1, 8, 9, 10};
		FindKth obj = new FindKth();
		int res = obj.kthSmallestElement(arr, 2);
		System.out.println(res);
		res = obj.kthSmallestElement(arr, 8);
		System.out.println(res);
		res = obj.kthSmallestElement(arr, 7);
		System.out.println(res);
		res = obj.kthSmallestElement(arr, 10);
		System.out.println(res);
	}
}
