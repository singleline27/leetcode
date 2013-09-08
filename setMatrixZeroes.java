public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; ++i) {
            boolean found = false;
            
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    found = true;
                    break;
                }
            }
            
            if(found) {
                for(int j = 0; j < n; ++j) {
                    if(matrix[i][j] == 0) {
                        matrix[i][j] = Integer.MIN_VALUE/2;
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        for(int j = 0; j < n; ++j) {
            boolean found = false;
            
            for(int i = 0; i < m; ++i) {
                if(matrix[i][j] == Integer.MIN_VALUE/2) {
                    found = true;
                    break;
                }
            }
            
            if(found) {
                for(int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}