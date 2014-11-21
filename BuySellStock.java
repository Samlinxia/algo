class BuySellStock {

	/**
	Best Time to Buy and Sell Stock I
	Method 1.  DP.  
	“第i个”, state: f[i] - max profit sell on i day, buy on j day. j < i
	“前i个”, function: f[i] = A[i] - min(A[0..i]])
				improvement: min variable keep track
	Ans: max(f[0..n-1])
			improvement: max variable keep track
	*/
	 public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[] f = new int[len];
        f[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            f[i] = prices[i] - min;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }
	/**
	Best Time to Buy and Sell Stock I
	Method 2. Improvement of method 1.  keep track with minPrice and maxProfit in 
	only two variable.
	*/
	public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = prices[i] - min > maxProfit ? prices[i] - min : maxProfit;
        }
        
        return maxProfit;
    }
	
	/**Best Time to Buy and Sell Stock II
			Greedy
	Method 1
	*/
	public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int buy = prices[0];
        int sell = 0;
        boolean isBuy = true;
        int profit = 0;
        int i = 1;
        for (;i < len; i++) {
            if (isBuy) {
                if (prices[i] <= prices[i - 1]) {
                    buy = prices[i];
                } else {
                    sell = prices[i];
                    isBuy = false;
                }
            } else {
                if (prices[i] >= prices[i - 1]) {
                    sell = prices[i];
                } else {
                    profit += sell - buy;
                    isBuy = true;
                    buy = prices[i];
                }
            }
        }
        if (!isBuy) {
            profit += sell - buy;
        }
        return profit;
    }
}