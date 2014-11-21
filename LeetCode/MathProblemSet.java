class MathProblemSet {

/** CC150
19.3  Write an algorithm which computes the number of trailing zeros in n factorial
*/


/** CC150
20.4  Write a method to count the number of 2s between 0 and n
http://hawstein.com/posts/20.4.html
*/
 public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        int i = 1;
        
        while (n / i > 0) {
            int digit = n % (i * 10) / i;
            if (digit > k) { //round up
                count += (n / (i * 10) + 1) * i;
            } else if (digit < k) { // round down
                count += (n / (i * 10)) * i;
            } else { // round down + remainers
                count += (n / (i * 10)) * i + (n % i) + 1; 
            }
            i *= 10;
        }
        
        return count;
    }

/** LC  Permutation Sequence

*/

/**************************************************************************************
	Maths problem can be solved in a couple of ways:
	1. divide and conquer
		1) iteration version
		2) recursion version
	2. Bit operation.
		view number as binary format

*/

/**LC  Add, Minus, Multiply, Divide two integers without +, -, * /
http://swiyu.wordpress.com/2012/10/21/add-minus-multiply-divide-two-integers-without/
*/


/** LC Sqrt, pow, log2 problem
http://swiyu.wordpress.com/2012/11/04/sqrt-and-pow/
*/

/** Pow

*/
public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (x == 0) {
            return x;
        }
        
        if (n < 0) {
            if(x>=1.0/Double.MAX_VALUE||x<=1.0/-Double.MAX_VALUE) {
                x = 1.0 / x;
            } else {
                return Double.MAX_VALUE;
            }
            n = -n;
            // n = n & (0x7FFFFFFF);
        }
        
        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            n >>= 1;
            x *= x;
        }
        return res;
    }


/** Bit Operation
	
*/
public int sqrt(int x) {
	
	
}

/**  Bianry Search
return int.  round down sqrt*/
public int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        } else if (x <= 1) {
            return x;
        }
        
        long l = 1; 
        long r = x / 2 + 1;
        
        while (l + 1 < r) {
            long m = l + (r - l) / 2;
            long num = m * m;
            if (num < x) {
                l = m;
            } else if (num > x) {
                r = m;
            } else {
                return (int) m;
            }
        }
        return (int)l;
    }

/*return approximate double.  squeeze approximate*/
	public double sqrt(int x) {
		
	}
	
	
	
/** LC Divide two numbers without using /, *
	
	consideration: 1)sign
		2) overflow.  when dividend or divisor == Integer.MIN_VALUE
		3) corner case.  divisor == 0
*/
	/*method 1.  */
	public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        } else if (dividend == 0) {
            return 0;
        }
        boolean isNeg = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
        long dven = Math.abs((long) dividend);
        long dsor = Math.abs((long) divisor);
        
        int res = 0;
        while (dven >= dsor) {
            long k = dsor;
            int multiple = 1;
            while ((dven >> 1) >= k) {
                k <<= 1;
                multiple <<= 1;
            }
            res |= multiple;
            dven -= k;
        }
		/*
		wihle (dven >= dsor) {
			int shift = 0;
			while ((dven >> 1) >= (dsor << shift)) {
				shift++;
			}
			res |= (1 << shift);
			dven -= (dsor << shift);
		}
		*/
        return isNeg ? -res : res;
    }
	
	/*Method 2.  Shift divisor to leftmost first once, 
	and then calculate the multiples while shift back to right*/
	public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        } else if (dividend == 0) {
            return 0;
        }
        boolean isNeg = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
        long dven = Math.abs((long) dividend);
        long dsor = Math.abs((long) divisor);
        
        int shift = 0;
        while ((dven >> 1) >= dsor) {
            dsor <<= 1;
            shift++;
        }
        int res = 0;
        while (shift >= 0) {
            if (dven >= dsor) {
                res |= (1 << shift);
                dven -= dsor;
            }
            dsor >>= 1;
            shift--;
        }
        return isNeg ? -res : res;
    }

	/*Method 3.  Binary Search.  use multiply sign to */	
}