public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length <= 2) return A.length;
        
        int j = 1;        
        int count = 1;
        for(int i = 1; i < A.length; ++i) {
            if(A[i] == A[i - 1]) {
                ++count;
                
                if(count <= 2) {
                    if(i != j && A[j] != A[i]) {
                        A[j] = A[i];
                    }
                    ++j;
                } 
            } else {
                count = 1;
                if(i != j && A[j] != A[i]) {
                    A[j] = A[i];
                }
                ++j;
            }
        }
        
        return j;
    }
}