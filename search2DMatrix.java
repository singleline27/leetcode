public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = n -1;
        
        while(true) {
            int val = matrix[i][j];
            
            if(val == target) return true;
            
            if(val > target) {
                --j;
                if(j < 0) return false;
            } else {
                ++i;
                
                if(i >= m) return false;
            }
        }
    }
}