public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        if(len == 0) return;
        
        for(int i = len - 2; i >= 0; --i) {
            int index = -1;
            int val = Integer.MAX_VALUE;
            for(int j = num.length - 1; j > i; --j) {
                
                if(num[i] < num[j] && num[j] < val) {
                    index = j;
                    val = num[j];
                }
                
                
            }
            if(index != -1) {
                swap(num, i, index);
                Arrays.sort(num, i + 1, num.length);
                return;
            }
        }
        
        for(int i = 0; i < len/2; ++i) {
            if(num[i] != num[len - 1 - i ])
                swap(num, i, len - 1 - i);
        }
        return;
        
    }
    
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}