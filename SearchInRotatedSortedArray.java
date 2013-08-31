public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(A == null || A.length == 0) {
            return -1;
        }
        
        int i = 0;
        int j = A.length - 1;
        
        while( i <= j) {
            int mid = i + ( j - i) / 2;
            int val = A[mid];
            
            if(val == target) {
                return mid;
            
            } else if(val < target) {
                
                if(A[mid] > A[j]) {
                    i = mid + 1;
                } else {
                    if(A[j] == target) {
                        return j;
                    } else if(A[j] > target) {
                        i = mid + 1;
                    } else {
                        
                        j = mid - 1;
                    }
                }
                
            } else {
                if(A[mid] < A[i]) {
                    j = mid - 1;
                } else {

                    if(A[i] == target) {
                        return i;
                    } else if(A[i] > target) {
                        i = mid + 1;
                    } else {
                        
                        j = mid - 1;
                    }

                }
            }
            
            
        }
        return -1;
        
    }
}