public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        
        for(int i = 1; i < m; ++i) {
            dp[0] += grid[i][0];
            
            for(int j = 1; j < n; ++j) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        
        return dp[n - 1];
    }
}