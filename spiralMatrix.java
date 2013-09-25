public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int m = matrix.length;
        if(m == 0) return result;
        int n = matrix[0].length;
        
        for(int r = 0; r < (Math.min(m, n) + 1)/2; ++r) {
            
            for(int j = r; j <= n - r - 1; ++j) {
                result.add(matrix[r][j]);
            }
            
            for(int i = r + 1; i <= m - r - 1; ++i) {
                result.add(matrix[i][n - 1 - r]);
            }
            
            if(m - 1 - r > r) {
                for(int j = n - 2 - r; j > r; --j) {
                    result.add(matrix[m - 1 - r][j]);
                }
            }
            
            if(r < n - 1 - r) {
                for(int i = m - 1 - r; i > r; --i) {
                    result.add(matrix[i][r]);
                }
            }
        }
        
        return result;
    }
}