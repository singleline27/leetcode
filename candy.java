public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = ratings.length;
        if(len == 0) return 0;
        
        int[] dp = new int[len];
        for(int i = 1; i < len; ++i) {
            if(ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } 
        }

        int curr = 0;
        for(int i = len - 2; i >= 0; --i) {
            if(ratings[i] > ratings[i + 1]) {
                ++curr;
            } else {
                curr = 0;
            }
            dp[i] = Math.max(curr, dp[i]);
        }
        
        int sum = 0;
        for(int i = 0; i < len; ++i) {
            sum += dp[i] + 1;
        }
        return sum;
        
    }
}