
public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0) return 0;
        int maxSum = A[0];
        int curSum = maxSum;
        
        for(int i = 1; i < A.length; ++i) {
            int cur = A[i];
            if(curSum > 0) {
                curSum += cur;
                
                
            } else {
                curSum = cur;
            }
            
            if(curSum > maxSum) {
                maxSum = curSum;
            }
        }
        
        return maxSum;
    }
}