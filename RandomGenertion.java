class RandomGenertion {
/** CC150.
19.10 Write  a  method  to  generate  a random  number  between  1  and  7,  given  a  method 
that  generates  a  random  number  between  1  and  5  (i e ,  implement  rand7()  using 
rand5())

Analysis: 1. http://hawstein.com/posts/19.10.html
		2.Rejection Sampling: http://leetcode.com/2010/11/rejection-sampling.html
*/

	public int rand7() {
		int maxIndex = (25 / 7) * 7;
		int x;
		int y;
		int index;
		do {
			row = rand5();
			col = rand5();
			index = col + (row - 1) * 5;
		} while (index > maxIndex)
		
		return 1 + (index - 1) % 7;
	}

}