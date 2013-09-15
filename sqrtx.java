public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0) return 0;
        if(x == 1) return 1;
        
        long low = 2;
        long high = x/2 + 1;
        
        long curr;
        
        while(low <= high) {
            curr = low + (high - low) /2;
            long sq = curr * curr;
            if(sq == x) return (int)curr;
            
            if(sq > x) {
                high = curr - 1;
            } else {
                low = curr + 1;
            }
            
        }
        
        return (int)high;
    }
}