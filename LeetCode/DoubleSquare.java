import java.io.*;

class DoubleSquare {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		int res = 0;
        int x = 0;
        try {
            x = Integer.parseInt(args[0]);
        } catch(NumberFormatException e) {
            x = 0;
        }
        res = countDoubleSquare(x);
       // System.out.println(res);
    }
    public static int countDoubleSquare(int x) {
        int left = 0;
        int right = (int) Math.sqrt(x);
		System.out.println(right);
		//int right = x / 2;
        int count = 0;
        while (left <= right) {
            //int sum = left * left + right * right;
			int sum = (left^2) + (right^2);
			System.out.println(sum);
            if (sum > x) {
                right--;
            } else if (sum < x) {
                left++;
            } else {
                count++;
                left++;
                right--;
            }
        }
		System.out.println(count);
		return count;
    }
    
   
}