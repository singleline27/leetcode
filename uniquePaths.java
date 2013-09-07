public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] dp = new int[n];
        for(int i = 0; i < n; ++i) {
            dp[i] = 1;
        }
        
        for(int i = 1; i < m; ++i) {
            for(int j =1; j < n; ++j) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n-1];
        
    }
}