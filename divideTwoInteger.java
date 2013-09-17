public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(divisor == 0 || dividend == 0) return 0;
        if(divisor == 1) return dividend;
        
        if(divisor > 0 && dividend < 0 || divisor <0 && dividend >0) 
            return -divide(Math.abs(dividend), Math.abs(divisor));
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        long remain = dividend;
        long result = 0;
        
        while(remain >= divisor) {
            
            int curr = divisor;
            int count = 1;
            while( curr << 1 <= dividend) {
                curr = curr << 1;
                count = count << 1;
            }
            remain -= curr;
            result += count;
        }
        
        return result;
    }
}

public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(divisor == 0 || dividend == 0) return 0;
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        long result = 0;
        
        while(a >= b) {
            long c = b;
            for(int i = 0; a >= c; ++i) {
                a -= c;
                c <<= 1;
                result += (1 << i);
            }
        }
        
        if(((dividend ^ divisor) >> 31) != 0) {
            result = -result;
        }
        
        return (int)result;
    }
}