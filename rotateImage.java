public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        if(n == 0) return;
        
        int[][] result = new int[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                result[i][j] = matrix[i][j];
            }
        }
        
        for(int i = 0; i < n/2; ++i) {
            
            for(int j = i; j < n - 1 - i; ++j) {
                result[j][n-i-1] = matrix[i][j];
            }
            
            for(int j = i; j < n - 1 - i; ++j) {
                result[n-1-i][n-1-j] = matrix[j][n - 1 - i];
            }
            
            for(int j = n -1 - i; j >= i + 1; --j) {
                result[j][i] = matrix[n - 1 - i][j];
            }
            
            for(int j = n -1 - i; j >= i + 1; --j) {
                result[i][n-1-j] = matrix[j][i];
            }
        }
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                matrix[i][j] = result[i][j];
            }
        }

        
    }
}