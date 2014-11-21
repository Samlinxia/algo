/**
 * Summary of arithmetic problem:
 *  1) overflow.  solve: coerce to bigger type. int -> long, float -> double
 *  2) sign.  solve: decide sign first
 *  key: 3) boundary condition.  how to decide terminate
 *  4) Special case, corner case.  eg -1, 0, divend < divisor, MAX_Int
 *  5) early return.  
 * 
 * solution: 根据Math本身性质，找到一般解法。
 * 优化解法：Binary Search, Bit operation(shift, ^, &, |), Divide & Conquer
 * 最后用Math验证解法正确性
 * 
 * 
 * Related solution problem: Sqrt(x)，Pow(x, n)
 * 
 * 
 * Divide Two Integer
 * 普通解法:比较直接的方法是用被除数一直减去除数，直到为0。这种方法的迭代次数是结果的大小，即比如结果为n, O(n)
 * 如果可以用乘的话，二分搜索倒是不错的解法。
 * 否则，只能寄希望于位符操作了:
 * http://blog.csdn.net/linhuanmars/article/details/20024907
 * 
 * 细节：
 *  1. 当divend == 0, early return, 没必要shift回原来位置，因为结果不会变
 *  2. abs(INT_MIN)的值居然还是INT_MIN
*/

class DivideTwoInt {
	public int divide(int dividend, int divisor) {
        
    }
}