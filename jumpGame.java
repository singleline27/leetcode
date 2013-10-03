public class Solution {
    public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = A.length;
        if(len <= 1) return true;
        
        int max = A[0];
        for(int i = 0; i < len; ++i) {
            if(i < max) {
                int nextMax = i + A[i];
                if(nextMax >= len - 1) return true;
                if(nextMax > max) { 
                    max = nextMax;
                }
            } else if(i == max) {
                if(A[max] == 0) return false;
                max += A[max];
                if(max >= len - 1) return true;
            }
        }
        return true;
    }
}