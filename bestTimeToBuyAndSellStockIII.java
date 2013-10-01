public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length < 2) return 0; 
        
        int low = prices[0];
        int profit = 0;
        
        int[] dp1 = new int[prices.length];
        dp1[0] = 0;
        for(int i = 1; i < prices.length; ++i) {
            profit = Math.max(prices[i] - low, profit);
            dp1[i] = profit;
            low = Math.min(low, prices[i]);
        }
        
        int[] dp2 = new int[prices.length];
        dp2[dp2.length - 1] = 0;
        profit = 0;
        int high = prices[prices.length - 1];
        for(int i = dp2.length - 1; i >= 0; --i) {
            profit = Math.max(high - prices[i], profit);
            dp2[i] = profit;
            high = Math.max(high, prices[i]);
        }
        
        profit = 0;
        for(int i = 0; i < prices.length; ++i) {
            profit = Math.max(profit, dp1[i] + dp2[i]);
        }
        
        return profit;
    }
}