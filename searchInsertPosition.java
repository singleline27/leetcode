public class Solution {
    public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int i = 0;
        int j = A.length - 1;
        while(i <= j) {
            int mid = (i + j) >>> 1;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] > target) {
                j = mid - 1; 
            } else {
                i = mid + 1;
            }
        }
        
        return i;
    }
}