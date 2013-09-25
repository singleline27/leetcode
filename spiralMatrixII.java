public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        int[][] result = new int[n][n];
        
        int num = 0;
        for(int r = 0; r < (n + 1)/2; ++r) {
            
            for(int j = r; j <= n - r - 1; ++j) {
                result[r][j] = ++num;
            }
            
            for(int i = r + 1; i <= n - r - 1; ++i) {
                result[i][n - 1 - r] = ++num;
            }
            
            if(n - 1 - r > r) {
                for(int j = n - 2 - r; j > r; --j) {
                    result[n - 1 - r][j] = ++num;
                }
            }
            
            if(r < n - 1 - r) {
                for(int i = n - 1 - r; i > r; --i) {
                    result[i][r] = ++num;
                }
            }
        }
        
        return result;
    }
}