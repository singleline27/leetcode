public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; ++i) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            dp[i] = 1;
        }
        
        for(int i = 1; i < m; ++i) {
            for(int j =0; j < n; ++j) {
                if(obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if(j >= 1){
                    dp[j] += dp[j - 1];
                } 
            }
        }
        
        return dp[n-1];
    }
}
