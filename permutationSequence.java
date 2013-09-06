public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int base = 1;
        for(int i = 2; i <= n - 1; ++i) {
            base *= i;
        }
        
        int[] value = new int[n];
        for(int i = 0; i < n; ++i) {
            value[i] = i + 1;
        }
        
        int curr = k - 1;
        
        for(int i = 0; i < value.length; ++i) {
            int seq = curr/base;
            int remain = curr % base;
            
            if(seq != 0) {
                int tmp = value[i];
                value[i] = value[i + seq];
                value[i + seq] = tmp;
                Arrays.sort(value, i + 1, value.length);
            }
            
            if(remain == 0) break;
            
            curr = remain;
            
            if(n - 1 != i)
                base /= (n - 1 - i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i: value) {
            sb.append(i);
        }
        
        return sb.toString();
        
    }
}