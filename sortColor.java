public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sort(A, 0, A.length - 1);
    }
    
    private void sort(int[] A, int start, int end) {
        if(start >= end) return;
        
        int index = partition(A, start, end);
        sort(A, start, index);
        sort(A, index + 1, end);
    }
    
    private int partition(int[] A, int start, int end) {
        int mid = (start + end) >>> 1;
        int pivot = A[mid];
        
        int i = start - 1;
        int j = end + 1;
        while(i < j) {
            ++i; while(A[i] < pivot) ++i;
            --j; while(A[j] > pivot) --j;
            if(i < j) {
                if(A[i] != A[j]) {
                    swap(A, i, j);
                }
            }
        }
        return j;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
}