public class Solution {
    public int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        str = str.trim();
        int len = str.length();
        if(len == 0) return 0;
        char first = str.charAt(0);
        int i = 0;
        int sign = 1;
        switch(first) {
            case '+':
                ++i;
                break;
            case '-':
                ++i;
                sign = -1;
                break;
            default:
                if(!Character.isDigit(first)) return 0;
                break;
        }
        
        while(i < len && Character.isDigit(str.charAt(i))) {
            if(str.charAt(i) != '0') {
                break;
            }
            ++i;
        }
        if(!Character.isDigit(str.charAt(i))) return 0;
        
        int j = i;
        while(j < len) {
            if(!Character.isDigit(str.charAt(j))) break;
            ++j;
        }
        str = str.substring(i, j);
        String maxStr = Integer.toString(Integer.MAX_VALUE);
        if(str.length() > maxStr.length() || (str.length() == maxStr.length() && str.compareTo(maxStr) > 0)) 
            return (sign > 0)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        
        int ret = 0;
        for(int k = 0; k < str.length(); ++k) {
            int val = Character.getNumericValue(str.charAt(k));
            ret = 10 * ret + val;
        }
        
        return ret * sign;
    }
}