import java.util.*;
/**Provide all sort methods*/
class SortCollection{
	//--------------------------------------n^2 time sort--------------------------
	public static void insertSort(int[] array)
	{
		for(int i=1; i<array.length; i++)
		{
			for(int j=i; j >= 0 && array[j] < array[j-1]; j--)
				DSutil.swap(array, j, j-1);
		}
	}
	
	public static void bubbleSort(int[] array)
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			for(int j = array.length - 1; j > i; j--)
			{
				if(array[j] < array[j-1])
					DSutil.swap(array, j, j-1);
			}
		}
	}
	
	public static void selectSort(int[] array)
	{
		int index;
		for(int i = 0; i < array.length; i++)
		{	
			index = i;
			for(int j = array.length; j >= i; j--)
			{
				if(array[j] < array[index])
					index = j;
			}
			DSutil.swap(array, i, index);
		}
	}
	
	//------------------------------------------nlogn time sort------------------------
	/**Shell sort*/
	public static void shellSort(int[] array)
	{
		for(int i = array.length; i >= 2; i /= 2)   //For each increment, i is incr
		{
			for(int j = 0; j<i; j++)  //sort each sublist
				insSort(array, j, i);
		}
		insSort(array, 0, 1);  //call once regular insert sort
	}
	// modified insert sort
	public static void insSort(int[] array, int start, int incr)
	{
		for(int i = start + incr; i < array.length; i += incr)
			for(int j = i; j > 0 && array[j] < array[j-incr]; j -= incr)
				DSutil.swap(array, j, j-incr);
	}
	
	/*----------------------------Merge Sort-----------------------------------
		1.Divide the unsorted list into two sublists of about half the size 
		2.Sort each of the two sublists 
		3.Merge the two sorted sublists back into one sorted list. 
	*/
	 /**
     * Mergesort algorithm.
     * @param a an array of Comparable items.
     */
	public static void mergeSort(int[] array)
	{
		int[] tmpArray = new int[array.length];
		mergeSort(array, tmpArray, 0, array.length - 1);
			
	}
	
	 /**
     * Internal method that makes recursive calls.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
	public static void mergeSort(int[] array, int[] tmpArray, int left, int right)
	{
		if(left == right)
			return;
		int mid = (left + right) / 2;
		mergeSort(array, tmpArray, left, mid);
		mergeSort(array, tmpArray, mid+1, right);
		merge(array, tmpArray, left, mid+1, right);
	}
	
	 /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
	public static void merge(int[] array,int[] tmpArray,int leftPos,int rightPos,int rightEnd)
	{
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightPos - leftPos + 1;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd)
		{
			if(array[leftPos] < array[rightPos])
				tmpArray[tmpPos++] = array[leftPos++];
			else
				tmpArray[tmpPos++] = array[rightPos++];
		}	
			//copy rest of first half
		while(leftPos <= leftEnd)
			tmpArray[tmpPos++] = array[leftPos++];		
			//copy rest of second half
		while(rightPos <= rightEnd)
			tmpArray[tmpPos++] = array[rightPos++];
		//copy temp back to array
		for(int i = 0; i < numElements; i++, rightEnd--)
			array[rightEnd] = tmpArray[rightEnd];
	}
	
	/*------------------------------Quick sort-------------------------
	If the array contains only one element or zero elements then the array is sorted. 
	If the array contains more then one element then: 
		1.Select an element from the array. This element is called the "pivot element". For example select the element in the middle of the array. 
		2.All elements which are smaller then the pivot element are placed in one array and all elements which are larger are placed in another array. 
		3.Sort both arrays by recursively applying Quicksort to them. 
		4.Combine the arrays 
	Quicksort can be implemented to sort "in-place". This means that the sorting takes place in the array and that no additional array need to be created. 
	*/
	
	/**Quick Sort*/
	public static void quickSort(int[] array)
	{
		if(array.length <2) return;
		quickSort(array, 0, array.length - 1);	
	}
	
	public static void quickSort(int[] array, int left, int right)
	{
		int pivotIndex = findPivot(array, left, right);  //Pick a pivot
		DSutil.swap(array, pivotIndex, right);   //Stick pivot at end
		// k will be the first position of right subarray
		int k = partition(array, left - 1, right, array[right]);
		DSutil.swap(array, k, right);   //Put pivot in place
		if((k - left) > 1)		
			quickSort(array, left, k - 1);	//Sort left partition. distance to two end is at least 2, guarantee the smallest subarray has 2 element
		if((right - k) > 1)		
			quickSort(array, k + 1, right);	//Sort right partition
	}
	//simply pick the middle element index
	public static int findPivot(int[] array, int left, int right)
	{
		return (left + right) / 2;
	}
	//partition elements to two sides of pivot
	public static int partition(int[] array, int l, int r, int pivot)  //initially l and r are outside bounds
	{
		do{
			while(array[++l] < array[pivot]);  //find the next element greater pivot
			while(array[--r] > array[pivot] && r != 0)
			DSutil.swap(array, l, r);
		}
		while( l < r);    //stop when they cross
		DSutil.swap(array, l, r);	//reverse last wasted swap
		return l;	//return first position in right partition
	}
	/*--------------------------------Heap Sort--------------------------------
	
	
	
	*/
	public static void heapsort(int[] array)
	{	
	//convert int array to Integer array
		Integer[] heapArray = new Integer[array.length];
		for(int i = 0; i < array.length; i++)
		{
			heapArray[i] = new Integer(array[i]);
		}
	//load array data into MaxHeap
		MaxHeap<Integer> heap = new MaxHeap<Integer>(heapArray, array.length, array.length);
		for(int i = array.length - 1; i >= 0; i--)
			array[i] = heap.removeMax();
	}
	
	
	//-------------------------------Linear time sorting--------------------
	/*
	perform best when sorting 0~100 integers
	*/
	public static void countingSort(int[] array)
	{
		ArrayList<Integer> arrayTemp = new ArrayList<Integer>();
		int[] outputArray = new int[array.length];
		for(int i = 0; i < array.length; i++)
			arrayTemp.add(array[i], arrayTemp.get(array[i]) + 1);  //counts the number of each element in array
		//consecutively add arrayTemp to get the index of element of sorted array
		for(int i = 0; i < arrayTemp.size(); i++)
		{
			arrayTemp.set(i, arrayTemp.get(i-1) + 1);
		}
		//iterate arrayTemp downward, set elements to the sorted list and stored in outputArray
		for(int i = array.length - 1; i >= 0; i--)
		{
			outputArray[arrayTemp.get(array[i]) - 1] = array[i];
			arrayTemp.set(array[i], arrayTemp.get(array[i]) - 1);
		}
		//copy from output array to original array
		for(int i = 0; i < array.length; i++)
		{
			array[i] = outputArray[i];
		}
		
	}
	/*Bucket sort, or bin sort, is a sorting algorithm that works by partitioning an array 
	into a number of buckets. Each bucket is then sorted individually, either using a different
	sorting algorithm, or by recursively applying the bucket sorting algorithm.
	Bucket sort works as follows:
	1.Set up an array of initially empty "buckets."
	2.Scatter: Go over the original array, putting each object in its bucket. 
	3.Sort each non-empty bucket.
	4.Gather: Visit the buckets in order and put all elements back into the original array.
	
	Difference:
	Binsort: key values are used to assign records to bins, that's determine the position of record.
	Limitation: it works only for a permutation of numbers from 0 to n-1. records with key value i will
	be placed in bin B[i]
	
	Bucketsort: A further generalizaiotn to Binsort. Each bin is associated with not just one key, but
	rather a range of key values. Bucketsort assigns records to bins and then rely on other sorting 
	technique to sort the records within each bin.  Its expense will be relatively cheap when each bin
	is put only a small number of records and then a "cleanup sort" is performed.
	*/
	//use LinkedList array, elements in the same LinkedList have same values
	@SuppressWarnings("unchecked")
	public static void binSort(int[] array)
	{
	//iterate array to find the MaxKey
		int maxKey = array[0];
		for(int x : array)
		{
			if(x > maxKey)
				maxKey = x;
		}
	//construct a MaxKey size array of linkedList reference
		LinkedList<Integer>[] tempArray = new LinkedList[maxKey];
		Integer item;
	//iterate tempArray, initialize LinkedList of each reference
		for(int i=0; i < maxKey; i++)
		{
			tempArray[i] = new LinkedList<Integer>();
		}
	//load value from original array to temp array
		for(int i = 0; i < maxKey; i++)
		{
			tempArray[array[i]].add(array[i]);
		}
	//load	elements from temp array to output
		int index = 0;	//index of output array
		for(int i = 0; i < maxKey; i++)
		{
			ListIterator itr = tempArray[i].listIterator();
			while(itr.hasNext())
			{
				array[index++] = (int)itr.next(); //return the next element and cast from Integer to int, start from head node
			}
		}
			
	}
	/**Bucket Sort*/
	/*whereas counting sort assumes that input consists of integer in a small range, bucket sort 
	  assumes that input is generated by a random process that distributes elements uniformly and 
	  independently over the interval [0,1).  requires auxiliary array of linked list, use 
	  insertion sort respectively in each bucket*/
	@SuppressWarnings("unchecked")
	public static void bucketSort(int[] array)
	{
		int maxDigit = 2;		//set by command line
	//initialize temp array to be stored
		LinkedList<Integer>[] buckets = new LinkedList[10];
		for(int i = 0; i < 10; i++)
			buckets[i] = new LinkedList<Integer>();
	//assign element of array to buckets
		for(int i = 0; i < array.length; i++)
		{
			buckets[getBucket(array[i], maxDigit)].add(array[i]);  
		}
	//sort each buckets	with insertion sort
		for(int i = 0; i < 10; i++)
		{
			insertionSort(buckets[i]);
		}
	//linear output each sorted buckets
		int index = 0;
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < buckets[i].size(); j++)
				array[index++] = buckets[i].get(j);
		}
	}
	
	//assign record to according buckets
	private static int getBucket(int number, int maxDigit)
	{
		return number / (10 ^ (maxDigit-1));
	}
	//insertion sort for LinkedList
	public static void insertionSort(LinkedList<Integer> listArray)
	{
		for(int i = 1; i < listArray.size(); i++)
		{
			for(int j = i; j >= 0 && listArray.get(j) < listArray.get(j-1); j--)
			{
			//swap two value
				Integer temp = listArray.get(j-1);
				listArray.set(j-1, listArray.get(j));
				listArray.set(j, temp);
			}
		}
	}
	/**Radix Sort*/
	/*
	1.Take the least significant digit (or group of bits, both being examples of radices) of each key.
	2.Group the keys based on that digit, each key is dropped into one level of buckets using bucket sort
	3.Repeat the grouping process with each more significant digit.
	*/
	public static void radixSort(int[] array)
	{
		
	}
	
	//Reference 1, @param data array must be positive integer
	/*public static void radixSort (int [ ] data) 
	{
		boolean flag = true;
		int divisor = 1;
		Queue [ ] buckets = new Queue[10];
		for (int i = 0; i < 10; i++)
			buckets[i] = new LinkedList();
		while (flag) 
		{
			flag = false;
				// first copy the values into buckets
			for (int i = 0; i < data.length; i++) {
				int hashIndex = (data[i] / divisor) % 10;
				if (hashIndex > 0) flag = true;
				buckets[hashIndex].addLast(new Integer(data[i]));
			}
				// then copy the values back into vector
			divisor *= 10;
			int i = 0;
			for (int j = 0; j < 10; j++) {
				while (! buckets[j].isEmpty()) {
					Integer ival = (Integer) buckets[j].getFirst();
					buckets[j].removeFirst();
					data[i++] = ival.intValue();
				}
			}
		}
	}
	*/


}