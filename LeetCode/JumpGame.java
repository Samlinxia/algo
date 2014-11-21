/**
Sequence DP
Can early return false once found f[i] is false
*/
class JumpGame {
/** JumpGame I - return whether can jump to last position
	
	Method 1.  DP
	state: f[i] - 
	Use extra f[i] space O(n) to record whether is possible from 0 to i
*/
public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;            
        }
        int len = A.length;
        boolean[] f = new boolean[len];
        f[0] = true;
        
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                if (f[j] && A[j] >= i - j) {
                    f[i] = true;
                    break;
                }
            }
            if (j < 0) {
                break;
            }
        }
        return f[len - 1];
    }
	
	/**
		Method 2.  Use flag to replace f[i].  Space: O(1).
		Can early return result:false once found f[i] is false.  So don't need keep
		track of previous f[], which are all always true.
	*/
	    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;            
        }
        int len = A.length;
        boolean flag = true;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                if (A[j] >= i - j) {
                    break;
                }
            }
            if (j < 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
	
	/** Method 3 : Greedy
		当i超出了可到达范围时，在可达到范围内选取最大的值。
		
	*/
	
	
	
	
	/** Jump Game II -> minimum step to reach last position
	
	Method 1 : DP
	*/
	public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int len = A.length;
        int[] f = new int[len];
        f[0] = 0;
        boolean flag = true;
        for (int i = 1; i < len; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (A[j] >= i - j) {
                    f[i] = f[j] + 1;
                    break;
                }
            }
            if (f[i] == Integer.MAX_VALUE) {
                flag = false;
                break;
            }
        }
        return flag ? f[len - 1] : -1;
    }
	
	/**Method 2: Greedy
	http://blog.csdn.net/linhuanmars/article/details/21356187
	*/
	public int jump(int[] A) {  
    if(A==null || A.length==0)  
        return 0;  
    int lastReach = 0;  
    int reach = 0;  
    int step = 0;  
    for(int i=0;i<=reach&&i<A.length;i++)  
    {  
        if(i>lastReach)  
        {  
            step++;  
            lastReach = reach;  
        }  
        reach = Math.max(reach,A[i]+i);  
    }  
    if(reach<A.length-1)  
        return 0;  
    return step;  
} 
}