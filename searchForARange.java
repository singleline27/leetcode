public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) {
            return new int[] {-1, -1};
        }
        
        int i = 0;
        int j = A.length - 1;
        
        while( i <= j ) {
        
            int mid = i + (j - i) / 2;
            int val = A[mid];
            
            if(val == target) {
                return findRange(A, mid);
                
            } else if(val < target){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
            
            
        
        } 
        
        return new int[] {-1, -1};
        
        
    }
    
    private int[] findRange(int[] A, int index) {
        
        int val = A[index];
        
        int lower = index;
        while(lower >= 1 && A[lower - 1] == val) {
            --lower;
        }
        
        int upper = index;
        while(upper < A.length - 1 && A[upper + 1] == val) {
            ++upper;
        }
        
        return new int[]{lower, upper};
        
    }
}