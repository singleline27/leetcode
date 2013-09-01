public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0; 
        
        int value = A[0];
        int index = 0;
        
        for(int i = 1; i < A.length; ++i) {
            if(A[i] != value) {
                A[++index] = A[i];
                value = A[i];
            }    
        }
        
        return index + 1;
    }
}